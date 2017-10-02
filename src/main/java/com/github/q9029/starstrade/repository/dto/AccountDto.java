package com.github.q9029.starstrade.repository.dto;

import java.sql.Timestamp;

public class AccountDto {

	private Long id;
	private String name;
	private String screenName;
	private String accessToken;
	private String accessTokenSecret;
	private Timestamp currentlySignedInAt;
	private String message;
	private Integer goodEstimateCount;
	private Integer badEstimateCount;
	private Boolean administrative;
	private Boolean valid;
	private Timestamp createdAt;
	private Timestamp modifiedAt;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
	public Timestamp getCurrentlySignedInAt() {
		return currentlySignedInAt;
	}
	public void setCurrentlySignedInAt(Timestamp currentlySignedInAt) {
		this.currentlySignedInAt = currentlySignedInAt;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Integer getGoodEstimateCount() {
		return goodEstimateCount;
	}
	public void setGoodEstimateCount(Integer goodEstimateCount) {
		this.goodEstimateCount = goodEstimateCount;
	}
	public Integer getBadEstimateCount() {
		return badEstimateCount;
	}
	public void setBadEstimateCount(Integer badEstimateCount) {
		this.badEstimateCount = badEstimateCount;
	}
	public Boolean getAdministrative() {
		return administrative;
	}
	public void setAdministrative(Boolean administrative) {
		this.administrative = administrative;
	}
	public Boolean getValid() {
		return valid;
	}
	public void setValid(Boolean valid) {
		this.valid = valid;
	}
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	public Timestamp getModifiedAt() {
		return modifiedAt;
	}
	public void setModifiedAt(Timestamp modifiedAt) {
		this.modifiedAt = modifiedAt;
	}
}
