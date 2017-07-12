package com.github.q9029.aikatsustars.controller.constant;

/**
 * Controllerで使用するURIの定数クラス.
 */
public class RequestURI {

	private RequestURI() {}

	public static final String INDEX = "/";
	public static final String SIGNIN = "/signin";
	public static final String SIGNOUT = "/signout";
	public static final String CALLBACK = "/callback";
	public static final String CARDLIST = "/cardlist";
	public static final String SEARCH = "/search";
	public static final String PRIVACYPOLICY = "/privacypolicy";
	public static final String TERMS = "/terms";

	public static final String JOB_HEALTHCHECK = "/job/healthcheck";

	public static final String JOB_CLEAN_ACCOUNTS = "/job/clean/accounts";

	public static final String JOB_RELOAD_SYSTEM_SETTINGS = "/job/reload/system_settings";
	public static final String JOB_RELOAD_VOLUMES = "/job/reload/volumes";
	public static final String JOB_RELOAD_BRANDS = "/job/reload/brands";
	public static final String JOB_RELOAD_RARE_TYPES = "/job/reload/rare_types";
}
