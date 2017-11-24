package com.xp.springboot.mop;



import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;

import com.xp.springboot.mop.util.trade.IdGenerator;
@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan
public class Application {
    private static Logger logger = Logger.getLogger(Application.class);
    @Bean
    public EmbeddedServletContainerCustomizer containerCustomizer() {
        return new EmbeddedServletContainerCustomizer() {
            @Override
            public void customize(ConfigurableEmbeddedServletContainer container) {
                container.addErrorPages(new org.springframework.boot.web.servlet.ErrorPage(HttpStatus.NOT_FOUND, "/404"));
                container.addErrorPages(new org.springframework.boot.web.servlet.ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/500"));                
            }
        };
    }
    public static void main(String[] args){
        System.out.println("交易订单号为:"+IdGenerator.generate());
        SpringApplication.run(Application.class, args);
    }
}
