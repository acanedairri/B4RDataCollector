package org.irri.utility;

import android.util.Base64;
import android.util.Log;

import com.google.gson.Gson;
import com.loopj.android.http.HttpGet;
import com.loopj.android.http.MySSLSocketFactory;

import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.params.HttpParams;
import org.irri.activity.WebClientDevWrapper;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;

import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.HttpVersion;
import cz.msebera.android.httpclient.NameValuePair;
import cz.msebera.android.httpclient.client.ClientProtocolException;
import cz.msebera.android.httpclient.client.HttpClient;
import cz.msebera.android.httpclient.client.entity.UrlEncodedFormEntity;
import cz.msebera.android.httpclient.client.methods.HttpPost;
import cz.msebera.android.httpclient.client.methods.HttpPut;
import cz.msebera.android.httpclient.client.methods.HttpUriRequest;
import cz.msebera.android.httpclient.conn.ClientConnectionManager;
import cz.msebera.android.httpclient.conn.scheme.PlainSocketFactory;
import cz.msebera.android.httpclient.conn.scheme.Scheme;
import cz.msebera.android.httpclient.conn.scheme.SchemeRegistry;
import cz.msebera.android.httpclient.conn.scheme.SocketFactory;
import cz.msebera.android.httpclient.entity.ByteArrayEntity;
import cz.msebera.android.httpclient.entity.StringEntity;
import cz.msebera.android.httpclient.impl.client.DefaultHttpClient;
import cz.msebera.android.httpclient.impl.client.SystemDefaultHttpClient;
import cz.msebera.android.httpclient.impl.conn.tsccm.ThreadSafeClientConnManager;
import cz.msebera.android.httpclient.message.BasicHeader;
import cz.msebera.android.httpclient.message.BasicNameValuePair;
import cz.msebera.android.httpclient.params.BasicHttpParams;
import cz.msebera.android.httpclient.params.HttpProtocolParams;
import cz.msebera.android.httpclient.protocol.HTTP;

import static cz.msebera.android.httpclient.protocol.HTTP.UTF_8;


/**
 * Created by ACañeda on 2016-02-09.
 */
public class RestClient {

    private ArrayList<NameValuePair> params;
    private ArrayList<NameValuePair> headers;

    private String url;

    private int responseCode;
    private String message;

    private String response;
    private HttpURLConnection urlConnection;
    private URL urlPost;
    private HttpURLConnection conn;
    private int x;

    public String getResponse() {
        return response;
    }

    public String getErrorMessage() {
        return message;
    }

    public int getResponseCode() {
        return responseCode;
    }

    static InputStream is = null;

    public RestClient(String url) {
        this.url = url;
        params = new ArrayList<NameValuePair>();
        headers = new ArrayList<NameValuePair>();
    }

    public void AddParam(String name, String value) {
        params.add(new BasicNameValuePair(name, value));
    }

    public void AddHeader(String name, String value) {
        headers.add(new BasicNameValuePair(name, value));
    }

    public enum RequestMethod {
        GET,
        POST,
        PUT
    }

    public void Execute(RequestMethod method) throws Exception {


        switch (method) {

            case POST: {
                syncPost("POST");
                break;

            }
            case PUT: {
               /* HttpPut request = new HttpPut(url);
                StringEntity entity = new StringEntity(params.get(0).getValue(), HTTP.UTF_8);

                if (!params.isEmpty()) {
                    entity.setContentType("application/json");
                    request.setEntity(entity);


                }
                //add headers
                for (NameValuePair h : headers) {
                    request.addHeader(h.getName(), h.getValue());
                    //request.setHeader(h.getName(), h.getValue());
                }

                executeRequest(request, url);*/

                syncPost("PUT");
                break;
            }
        }
    }



    private void executeRequest(HttpUriRequest request,String url) throws IOException {
        HttpClient client = new DefaultHttpClient();

        HttpResponse httpResponse;

        try {

            httpResponse = client.execute(request);
            responseCode = httpResponse.getStatusLine().getStatusCode();
            message = httpResponse.getStatusLine().getReasonPhrase();

            HttpEntity entity = httpResponse.getEntity();

            if (entity != null) {

                InputStream instream = entity.getContent();
                response = convertStreamToString(instream);

                // Closing the input stream will trigger connection release
                instream.close();
            }

        } catch (ClientProtocolException e)  {
            client.getConnectionManager().shutdown();
            e.printStackTrace();
        } catch (IOException e) {
            client.getConnectionManager().shutdown();
            e.printStackTrace();
        }
    }

    private static String convertStreamToString(InputStream is) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }



    private void syncPost(String method) throws IOException, NoSuchAlgorithmException, KeyManagementException {
        String data = params.get(0).getValue();
        byte[] bodyData = data.getBytes();

        URL _url= new URL(url);
        HttpsURLConnection con=(HttpsURLConnection) _url.openConnection();

        SSLContext sc;
        sc = SSLContext.getInstance("TLS");
        sc.init(null, null, new java.security.SecureRandom());
        con.setSSLSocketFactory(sc.getSocketFactory());


        con.setDoOutput(true);
        con.setRequestMethod(method);
        con.setRequestProperty("Content-Type", "application/json");
        con.setChunkedStreamingMode(0);
        con.setUseCaches(false);
        con.setReadTimeout(10000);
        con.setConnectTimeout(10000);
        con.setRequestProperty("Content-Length", Integer.toString(bodyData.length));
        con.setRequestProperty("Host", "api.breeding4rice.irri.org");
        con.connect();

        try {

            DataOutputStream wr = new DataOutputStream(con.getOutputStream ());
            wr.writeBytes(data);
            wr.flush();
            wr.close();;

            String line;
            InputStream in;
            StringBuffer sb = new StringBuffer();
            int HttpResult =con.getResponseCode();


            if (HttpResult == 400 && HttpResult <= 499) {
                Log.e("TAG", "HTTPx Response: " + HttpResult + " - " + con.getResponseMessage());
                in = new BufferedInputStream(con.getErrorStream());
                String res=convertStreamToString(in);
                response=res;

            }
            else {
                in = new BufferedInputStream(con.getInputStream());
                response=convertStreamToString(in);
            }



        } finally {
                con.disconnect();
            }


    }
    private void writeStream(OutputStream out) throws IOException {
        String data = params.get(0).getValue();

        try {
            out.write(data.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        out.flush();
    }

}
