package com.xp.springboot.mop.config;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;

@Configuration
public class ApplicationConfig {
//    @Bean
//    @Primary
//    public EmbeddedServletContainerCustomizer containerCustomizer() {
//        return new EmbeddedServletContainerCustomizer() {
//            @Override
//            public void customize(ConfigurableEmbeddedServletContainer container) {
//                container.addErrorPages(new org.springframework.boot.web.servlet.ErrorPage(HttpStatus.NOT_FOUND, "/404"));
//                container.addErrorPages(new org.springframework.boot.web.servlet.ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/500"));                
//            }
//        };
//    }

}
