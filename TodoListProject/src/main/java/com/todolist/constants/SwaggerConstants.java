package com.todolist.constants;

import lombok.experimental.UtilityClass;

/**
 * Class for swagger constants.
 * 
 * @author manyabatish
 *
 */
@UtilityClass
public class SwaggerConstants {
	public static final String[] AUTH_WHITELIST = { "/v2/api-docs", "/swagger-resources", "/swagger-resources/**",
			"/configuration/ui", "/configuration/security", "/swagger-ui.html", "/webjars/**", "/v3/api-docs/**",
			"/swagger-ui/**" };

	public static final String DASHBOARD_TITLE = "To-do-List Project Rest API";
	public static final String DASHBOARD_DESCRIPTION = "Producing rest api's";
	public static final String DASHBOARD_USING_URL = "localhost";
	public static final String DASHBOARD_VERSION = "1.0";

	public static final String API_KEY_NAME = "JWT";
	public static final String API_AUTHORIZATION_PASS = "header";
	public static final String API_AUTHORIZATION_KEY = "Authorization";

	public static final String API_AUTHORIZATION_SCOPE = "global";
	public static final String API_AUTHORIZATION_DESCRIPTION = "everyone can use it";

}
