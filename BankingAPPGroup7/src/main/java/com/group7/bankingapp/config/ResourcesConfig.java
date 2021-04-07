package com.group7.bankingapp.config;


import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class ResourcesConfig extends WebSecurityConfigurerAdapter
{
    private static final String[] CLASSPATH_RESOURCE_LOCATIONS =
    {
  		 "classpath:/resources/templates/",
        
    };

    public void addResourceHandlers(ResourceHandlerRegistry registry)
    {
        registry.addResourceHandler("/**")
		.addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS)
		.setCachePeriod(3000);
    }
}

