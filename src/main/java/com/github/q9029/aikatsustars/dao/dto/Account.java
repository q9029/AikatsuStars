package com.github.q9029.aikatsustars.dao.dto;

import java.sql.Timestamp;

public class Account {

    /** ID. */
    private long id;

    /** NAME. */
    private String name;

    /** SCREEN_NAME. */
    private String screenName;

    /** ACCESS_TOKEN. */
    private String accessToken;

    /** ACCESS_TOKEN_SECRET. */
    private String accessTokenSecret;

    /** VALID. */
    private boolean valid;

    /** ADMINISTRATIVE. */
    private boolean administrative;

    /** REGIST_ACCOUNT_ID. */
    private long registAccountId;

    /** REGIST_TIME. */
    private Timestamp registTime;

    /** UPDATE_ACCOUNT_ID. */
    private long updateAccountId;

    /** UPDATE_TIME. */
    private Timestamp updateTime;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getScreenName() {
        return screenName;
    }
    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }
    public String getAccessToken() {
        return accessToken;
    }
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
    public String getAccessTokenSecret() {
        return accessTokenSecret;
    }
    public void setAccessTokenSecret(String accessTokenSecret) {
        this.accessTokenSecret = accessTokenSecret;
    }
    public boolean isValid() {
        return valid;
    }
    public void setValid(boolean valid) {
        this.valid = valid;
    }
    public boolean isAdministrative() {
        return administrative;
    }
    public void setAdministrative(boolean administrative) {
        this.administrative = administrative;
    }
    public long getRegistAccountId() {
        return registAccountId;
    }
    public void setRegistAccountId(long registAccountId) {
        this.registAccountId = registAccountId;
    }
    public Timestamp getRegistTime() {
        return registTime;
    }
    public void setRegistTime(Timestamp registTime) {
        this.registTime = registTime;
    }
    public long getUpdateAccountId() {
        return updateAccountId;
    }
    public void setUpdateAccountId(long updateAccountId) {
        this.updateAccountId = updateAccountId;
    }
    public Timestamp getUpdateTime() {
        return updateTime;
    }
    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }
}
