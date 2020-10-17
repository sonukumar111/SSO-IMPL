package net.javaguides.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.extras.springsecurity5.dialect.SpringSecurityDialect;

public class WebConfig implements WebMvcConfigurer {
	
	@Bean
    public SpringSecurityDialect securityDialect() {
         return new SpringSecurityDialect();
    }
	
	@Override
    public void addViewControllers(ViewControllerRegistry registry)
    {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/login").setViewName("login");
        //registry.addViewController("/home").setViewName("userhome");
        registry.addViewController("/admin").setViewName("admin");
        //registry.addViewController("/403").setViewName("403");   
    }

}
