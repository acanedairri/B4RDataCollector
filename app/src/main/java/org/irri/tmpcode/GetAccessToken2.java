package org.irri.tmpcode;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;

import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.NameValuePair;
import cz.msebera.android.httpclient.client.ClientProtocolException;
import cz.msebera.android.httpclient.client.entity.UrlEncodedFormEntity;
import cz.msebera.android.httpclient.client.methods.HttpPost;
import cz.msebera.android.httpclient.impl.client.DefaultHttpClient;
import cz.msebera.android.httpclient.message.BasicNameValuePair;

/**
 * Created by ACañeda on 2015-11-19.
 */
public class GetAccessToken2 {

    static InputStream is = null;
    static JSONObject jObj = null;
    static String json = "";


    public GetAccessToken2() {
    }

    List<NameValuePair> params = new ArrayList<NameValuePair>();
    Map<String, String> mapn;
    DefaultHttpClient httpClient;
    HttpPost httpPost;

    public JSONObject gettoken3(String address, String token, String client_id, String client_secret, String redirect_uri, String grant_type) throws UnsupportedEncodingException {
        // Making HTTP request
        try {
            // DefaultHttpClient
            httpClient = new DefaultHttpClient();
            httpPost = new HttpPost("http://api.breeding4rice.irri.org/v1/authenticate/token");

            params.add(new BasicNameValuePair("client_id", "pocketapp@breeding4rice.irri.org"));
            params.add(new BasicNameValuePair("client_secret", "777q382Jf4"));
            params.add(new BasicNameValuePair("response_type", "code"));
            params.add(new BasicNameValuePair("redirect_uri", "http://localhost/callback"));
            params.add(new BasicNameValuePair("grant_type", "authorization_code"));
            params.add(new BasicNameValuePair("code", token));

            httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded");

            //Encoding POST data
            try {
                httpPost.setEntity(new UrlEncodedFormEntity(params));

            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            HttpResponse httpResponse = httpClient.execute(httpPost);
            HttpEntity httpEntity = httpResponse.getEntity();
            is = httpEntity.getContent();

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();

            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(
                        is, "iso-8859-1"), 8);
                StringBuilder sb = new StringBuilder();
                String line = null;
                while ((line = reader.readLine()) != null) {
                    sb.append(line + "n");
                }
                is.close();

                json = sb.toString();

            } catch (Exception e3) {
                e3.getMessage();

            }
            // Parse the String to a JSON Object
            try {
                jObj = new JSONObject(json);
                return jObj;
            } catch (JSONException e2) {

            }
            // Return JSON String


        }

        return null;
    }

    public String gettoken5(String address, String token, String client_id, String client_secret, String redirect_uri, String grant_type) throws UnsupportedEncodingException {
        // Making HTTP request
        HttpURLConnection con = null;
        BufferedReader reader = null;

        String postParam = "client_id=pocketapp@breeding4rice.irri.org&redirect_uri=http://localhost/callback&client_secret=777q382Jf4&response_type=code&grant_type=authorization_code&code=" + token;
        String urlAddress = URLDecoder.decode(address, "UTF-8");
        try {
            try {
                URL url = new URL(urlAddress);
                con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("POST");
                con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                con.setDoOutput(true);
                con.connect();


                PrintWriter out = new PrintWriter(con.getOutputStream());
                out.print(postParam);
                out.close();

                if (con.getResponseCode() == HttpURLConnection.HTTP_OK) {
                    is = con.getInputStream();// is is inputstream
                } else {
                    is = con.getErrorStream();
                }

                InputStream stream = con.getInputStream();
                reader = new BufferedReader(new InputStreamReader(stream));

                StringBuffer buffer = new StringBuffer();
                String line;

                while ((line = reader.readLine()) != null) {
                    buffer.append(line);
                }
                return buffer.toString();


            } catch (IOException e) {
                e.printStackTrace();
            }
        } finally {
            if (con != null) {
                con.disconnect();
            }
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        return null;

    }

    public String gettoken(String address, String token, String client_id, String client_secret, String redirect_uri, String grant_type) throws UnsupportedEncodingException {
        String tokenString;
        String postParam = "client_id=pocketapp@breeding4rice.irri.org&redirect_uri=http://localhost/callback/&client_secret=777q382Jf4&response_type=code&grant_type=authorization_code&code=" + token;
        tokenString = requestUrl(address, postParam);
        return tokenString;

    }

    public static String requestUrl(String url, String postParameters) {

        HttpURLConnection urlConnection = null;
        try {
            // create connection
            URL urlToRequest = new URL(url);
            urlConnection = (HttpURLConnection) urlToRequest.openConnection();
            urlConnection.setConnectTimeout(500000);
            urlConnection.setReadTimeout(50000);

            // handle POST parameters
            if (postParameters != null) {
                urlConnection.setDoOutput(true);
                urlConnection.setChunkedStreamingMode(0);
                urlConnection.setRequestMethod("POST");
                urlConnection.setFixedLengthStreamingMode(
                        postParameters.getBytes().length);
                urlConnection.setRequestProperty("Content-Type",
                        "application/x-www-form-urlencoded");

                //send the POST out
                PrintWriter out = new PrintWriter(urlConnection.getOutputStream());
                out.print(postParameters);
                out.close();
            }

            // handle issues
            int statusCode = urlConnection.getResponseCode();
            if (statusCode != HttpURLConnection.HTTP_OK) {
                // throw some exception
            }

            // read output (only for GET)
            if (postParameters != null) {
                return null;
            } else {
                InputStream in =
                        new BufferedInputStream(urlConnection.getInputStream());
                return getResponseText(in);
            }


        } catch (MalformedURLException e) {
            // handle invalid URL
        } catch (SocketTimeoutException e) {
            // hadle timeout
        } catch (IOException e) {
            // handle I/0
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }

        return null;
    }

    private static String getResponseText(InputStream in) throws IOException {
        BufferedReader reader = null;
        reader = new BufferedReader(new InputStreamReader(in));

        StringBuffer buffer = new StringBuffer();
        String line;

        while ((line = reader.readLine()) != null) {
            buffer.append(line);
        }
        return buffer.toString();
    }
}