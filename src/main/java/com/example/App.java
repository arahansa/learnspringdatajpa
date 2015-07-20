package com.example;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller
public class App {

	public static final String returnPath="redirect:/";
	public static final String index="index";
	
    @RequestMapping("/")
    public String home() {
        return App.index;
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(App.class, customizeArgs(args));
    }
    
    // reference link
    // https://github.com/sbcoba/spring-camp-2015-sample/blob/master/spring-camp-env-boot-yaml-sample/src/main/java/com/springcamp/env/SampleProfileApplication.java
    private static String[] customizeArgs(String[] args) {
        List<String> argList = new ArrayList<String>(Arrays.asList(args));
	    argList.add("--spring.config.location=" +
                "classpath:db-config.yml");
		String[] mergeArgs = argList.toArray(new String[]{});
        return mergeArgs;
    }
    
    
    // To get SessionFactory in Spring
    // https://mdeinum.wordpress.com/2015/07/01/spring-framework-hidden-gems/
    @Bean
    public HibernateJpaSessionFactoryBean sessionFactory(EntityManagerFactory  emf){
    	HibernateJpaSessionFactoryBean jssfb = new HibernateJpaSessionFactoryBean();
    	jssfb.setEntityManagerFactory(emf);
        return jssfb;
    }
    
    //message
    private static final String MESSAGE_SOURCE_BASE_NAME = "locale";
	
    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename(MESSAGE_SOURCE_BASE_NAME);
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setUseCodeAsDefaultMessage(true);
        return messageSource;
    }

    @Bean
    public PropertySourcesPlaceholderConfigurer propertyPlaceHolderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}