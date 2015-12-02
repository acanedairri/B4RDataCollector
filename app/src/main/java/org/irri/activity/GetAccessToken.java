package org.irri.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;

import org.irri.constant.Authentication;
import org.irri.helper.ProcessGettingToken;
import org.json.JSONObject;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Hafiz Waleed Hussain on 12/6/2014.
 * GetAccessToken is used to get the AccessToken from any social network. If any exception occur. The activity will return result
 * cancel and print the exception stack trace.
 */
public class GetAccessToken extends AsyncTask<String, Void, String> {

    /**
     * _Callback is an interface.
     */
    private Callback _Callback;
    /**
     * _Activity is a reference of Calling activity.
     */
    private Activity _Activity;
    /**
     * _Dialog is a ProgressDialog which is used to shown in request processing
     */
    private ProgressDialog _Dialog;

    /**
     * One argument constructor.
     *
     * @param activity Calling activity take as an argument.
     */
    public GetAccessToken(Activity activity) {
        try {
            this._Callback = (Callback) activity;
            _Activity = activity;
            _Dialog = new ProgressDialog(activity);
            _Dialog.setTitle("Processing");
            _Dialog.setCancelable(false);
            _Dialog.setCanceledOnTouchOutside(false);
        } catch (ClassCastException e) {
            throw new UnsupportedOperationException("Implement GetAccessToken.Callback interface.");
        }
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        _Dialog.show();
    }

    @Override
    protected String doInBackground(String... params) {
        ProcessGettingToken jParser = new ProcessGettingToken();
        String json = null;
        try {
            json = jParser.gettoken("http://api.breeding4rice.irri.org/v1/authenticate/token", params[0]);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return json;
    }

    @Override
    protected void onPostExecute(String line) {
        super.onPostExecute(line);
        if (_Dialog != null && _Dialog.isShowing())
            //_Dialog.dismiss();
            _Callback.onComplete(line);

    }

    /**
     * This function is simply handle the exception if occur during Accessing Social Network
     * AccessToken.
     *
     * @param e
     */
    private void exceptionHandler(Exception e) {
        e.printStackTrace();
        if (_Dialog != null && _Dialog.isShowing())
            _Dialog.dismiss();
        _Activity.setResult(Activity.RESULT_CANCELED);
        _Activity.finish();
    }

    /**
     * Callback interface for GetAccessToken WebRequest.
     */
    public static interface Callback {
        void onComplete(String line);
    }
}
