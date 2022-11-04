package com.example.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@PropertySources({ 
	@PropertySource("classpath:foo.properties"), 
	@PropertySource("classpath:bar.properties") 
	})
public class PropertiesWithJavaConfig {
	// ...
	
	@Value( "${jdbc.url}" )
	private String jdbcUrl;
	
	Optional<String> lt = null;
	
	public void test() {
		
	}
}