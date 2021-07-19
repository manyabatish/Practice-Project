package com.todolist;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.todolist.constants.SwaggerConstants;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication(scanBasePackages = "com.todolist.*")
public class TodoListProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoListProjectApplication.class, args);
	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
				.securityContexts(Arrays.asList(securityContext())).securitySchemes(Arrays.asList(apiKey())).select()
				.apis(RequestHandlerSelectors.any()).paths(PathSelectors.any()).build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title(SwaggerConstants.DASHBOARD_TITLE)
				.description(SwaggerConstants.DASHBOARD_DESCRIPTION)
				.termsOfServiceUrl(SwaggerConstants.DASHBOARD_USING_URL).version(SwaggerConstants.DASHBOARD_VERSION)
				.build();
	}

	private ApiKey apiKey() {
		return new ApiKey(SwaggerConstants.API_KEY_NAME, SwaggerConstants.API_AUTHORIZATION_KEY,
				SwaggerConstants.API_AUTHORIZATION_PASS);
	}

	private SecurityContext securityContext() {
		return SecurityContext.builder().securityReferences(defaultAuth()).build();
	}

	private List<SecurityReference> defaultAuth() {
		AuthorizationScope authorizationScope = new AuthorizationScope(SwaggerConstants.API_AUTHORIZATION_SCOPE,
				SwaggerConstants.DASHBOARD_DESCRIPTION);
		AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
		authorizationScopes[0] = authorizationScope;
		return Arrays.asList(new SecurityReference("JWT", authorizationScopes));
	}

}
