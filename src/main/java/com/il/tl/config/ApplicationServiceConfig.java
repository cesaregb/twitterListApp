package com.il.tl.config;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import com.mkyong.rest.HelloWorldService;

public class ApplicationServiceConfig extends Application{
	
	@Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<Class<?>>();
        classes.add(HelloWorldService.class);
        return classes;
    }
	
}
