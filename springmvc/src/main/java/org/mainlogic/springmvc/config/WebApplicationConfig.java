package org.mainlogic.springmvc.config;

import java.util.Properties;

import org.mainlogic.springmvc.error.ExtendedSimpleMappingExceptionResolver;
import org.mainlogic.springmvc.interceptor.CustomInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScans({ @ComponentScan(basePackages = "org.mainlogic.springmvc.controller"),
		@ComponentScan(basePackages = "org.mainlogic.springmvc.validate") })
public class WebApplicationConfig extends WebMvcConfigurerAdapter {
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		registry.addInterceptor(getCustomInterceptor());
		super.addInterceptors(registry);
	}

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		
		registry.viewResolver(getInternalResourceViewResolver());
		super.configureViewResolvers(registry);
	}
	
	@Bean
	public ExtendedSimpleMappingExceptionResolver getExceptionResolver() {

		ExtendedSimpleMappingExceptionResolver exresolver = new ExtendedSimpleMappingExceptionResolver();
		Properties props = new Properties();
		props.setProperty("JsonException", "jsonError");
		props.setProperty("Exception", "error");

		exresolver.setExceptionMappings(props);

		return exresolver;
	}

	@Bean
	public InternalResourceViewResolver getInternalResourceViewResolver() {

		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/jsp/");
		viewResolver.setSuffix(".jsp");

		return viewResolver;
	}

	@Bean
	public CustomInterceptor getCustomInterceptor() {

		return new CustomInterceptor();
	}

	@Bean
	public StandardServletMultipartResolver getStandardServletMultipartResolver() {

		return new StandardServletMultipartResolver();
	}

	@Bean
	public ResourceBundleMessageSource getResourceBundleMessageSource() {

		return new ResourceBundleMessageSource();
	}
}
