package com.hsl.library.controller.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

import com.hsl.library.model.config.SpringModelConfiguration;

// TODO: Auto-generated Javadoc
/**
 * The Class SpringControllerConfiguration.
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.hsl.library.controller")
@Import({ SpringModelConfiguration.class })
public class SpringControllerConfiguration {

	/**
	 * Mapping jackson json view.
	 * 
	 * @return the mapping jackson json view
	 */
	@Bean
	public MappingJacksonJsonView mappingJacksonJsonView() {
		return new MappingJacksonJsonView();
	}

	/**
	 * Bean que especifica los tipos de petición entre la vista y el
	 * controlador.
	 * 
	 * @return the content negotiating view resolver
	 */
	@Bean
	public ContentNegotiatingViewResolver contentNegotiatingViewResolver() {
		final ContentNegotiatingViewResolver contentNegotiatingViewResolver = new ContentNegotiatingViewResolver();
		contentNegotiatingViewResolver
				.setDefaultContentType(MediaType.APPLICATION_JSON);
		final ArrayList<View> defaultViews = new ArrayList<View>();
		defaultViews.add(mappingJacksonJsonView());
		contentNegotiatingViewResolver.setDefaultViews(defaultViews);
		return contentNegotiatingViewResolver;
	}
	
	@Bean
	public InternalResourceViewResolver internalResourceViewResolver (){
		InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
		internalResourceViewResolver.setPrefix("/WEB-INF/views/");
		internalResourceViewResolver.setSuffix(".jsp");
		return internalResourceViewResolver;
	}
}
