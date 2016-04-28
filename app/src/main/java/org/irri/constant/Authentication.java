package org.irri.constant;

/**
 * Created by ACañeda on 2015-11-16.
 */
public class Authentication {

    public static String ACCESS_TOKEN_PARAMS="client_id=pocketapp@breeding4rice.irri.org&redirect_uri=http://localhost/callback/&client_secret=777q382Jf4&response_type=code&grant_type=authorization_code&code=";
    public static String CLIENT_ID="pocketapp@breeding4rice.irri.org";
    public static String REDIRECT_URI="http://localhost/callback";
    public static String CLIENT_SECRET="777q382Jf4";
    public static String RESPONSE_TYPE="code";

    /*
    http://api.breeding4rice.irri.org/v1/authenticate?client_id=pocketapp@breeding4rice.irri.org&redirect_uri=http://localhost/callback&client_secret=777q382Jf4&response_type=code

     */
    public static String LOGIN_URL="http://api.breeding4rice.irri.org/v1/authenticate?client_id=pocketapp@breeding4rice.irri.org&redirect_uri=http://localhost/callback&client_secret=777q382Jf4&response_type=code";


    public static String ACCESS_TOKEN_URL= "https://api.breeding4rice.irri.org/v1/authenticate/token?" +
            "client_id=pocketapp@breeding4rice.irri.org&" +
            "client_secret=777q382Jf4&" +
            "response_type=code&" +
            "redirect_uri=http://localhost/callback&" +
            "grant_type=authorization_code&" +
            "code=";

}
