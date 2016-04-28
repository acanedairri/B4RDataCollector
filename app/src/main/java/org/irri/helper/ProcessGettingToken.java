package org.irri.helper;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;

/**
 * Created by ACañeda on 2015-11-23.
 */
public class ProcessGettingToken {
    static InputStream is = null;
    static JSONObject jObj = null;
    static String json = "";

    public String gettoken(String address, String token) throws UnsupportedEncodingException {
        // Making HTTP request
        HttpURLConnection con = null;
        BufferedReader reader = null;

        String postParam = "client_id=pocketapp@breeding4rice.irri.org&redirect_uri=http://localhost/callback&client_secret=777q382Jf4&response_type=code&grant_type=authorization_code&code=" + token;
        String urlAddress = URLDecoder.decode(address, "UTF-8");
        try {
            try {
                URL url = new URL(urlAddress);
                con = (HttpURLConnection) url.openConnection();
      /*          int s = con.getResponseCode();*/
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
}
