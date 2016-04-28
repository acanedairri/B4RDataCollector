package org.irri.activity;





import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.params.HttpParams;


import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import cz.msebera.android.httpclient.HttpVersion;
import cz.msebera.android.httpclient.client.HttpClient;
import cz.msebera.android.httpclient.conn.ClientConnectionManager;
import cz.msebera.android.httpclient.conn.scheme.PlainSocketFactory;
import cz.msebera.android.httpclient.conn.scheme.Scheme;
import cz.msebera.android.httpclient.conn.scheme.SchemeRegistry;
import cz.msebera.android.httpclient.conn.ssl.X509HostnameVerifier;
import cz.msebera.android.httpclient.impl.client.DefaultHttpClient;
import cz.msebera.android.httpclient.impl.conn.tsccm.ThreadSafeClientConnManager;
import cz.msebera.android.httpclient.params.BasicHttpParams;
import cz.msebera.android.httpclient.params.HttpProtocolParams;
import cz.msebera.android.httpclient.protocol.HTTP;


/**
 * Created by ACañeda on 2016-04-25.
 */
public class WebClientDevWrapper {

    public static HttpClient getNewHttpClient() {
        try {
            KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
            trustStore.load(null, null);

            MySSLSocketFactory sf = new MySSLSocketFactory(trustStore);
            sf.setHostnameVerifier((X509HostnameVerifier) SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);

            HttpParams params = (HttpParams) new BasicHttpParams();
            HttpProtocolParams.setVersion((cz.msebera.android.httpclient.params.HttpParams) params, HttpVersion.HTTP_1_1);
            HttpProtocolParams.setContentCharset((cz.msebera.android.httpclient.params.HttpParams) params, HTTP.UTF_8);

            SchemeRegistry registry = new SchemeRegistry();
            registry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
            registry.register(new Scheme("https", sf, 443));

            ClientConnectionManager ccm = new ThreadSafeClientConnManager((cz.msebera.android.httpclient.params.HttpParams) params, registry);

            return new DefaultHttpClient(ccm, (cz.msebera.android.httpclient.params.HttpParams) params);
        } catch (Exception e) {
            return new DefaultHttpClient();
        }
    }
}