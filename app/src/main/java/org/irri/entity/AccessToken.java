package org.irri.entity;

/**
 * Created by ACañeda on 2015-11-16.
 */
public class AccessToken {

    /**
     * access_token : GHoDCUdQUDhRQCaBHECnRpZ5kowTLf08yalyfZu1
     * token_type : Bearer
     * expires_in : 5184000
     * refresh_token : 1zArEnhfhI7dEJxCKMZs1oIkpVmTqCPAPvP2IsJV
     */

    private String access_token;
    private String token_type;
    private int expires_in;
    private String refresh_token;

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public String getAccess_token() {
        return access_token;
    }

    public String getToken_type() {
        return token_type;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public String getRefresh_token() {
        return refresh_token;
    }
}
