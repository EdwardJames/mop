package com.xp.springboot.mop;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.DelayQueue;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import com.xp.springboot.mop.util.trade.IdGenerator;
@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan
//@ComponentScan(basePackages={"com.xp.springboot.mop"})
//@ImportResource("classpath:spring-config.xml")
//@MapperScan("com.xp.springboot.mop")
//@MapperScan(basePackages={"com.xp.springboot.mop.mapper"})
public class Application {
    private static Logger logger = Logger.getLogger(Application.class);
//    @Bean
//    @ConfigurationProperties(prefix="spring.datasource")
//    public DataSource dataSource(){
//        return new org.apache.tomcat.jdbc.pool.DataSource();
//    }
//    @Bean
//    public SqlSessionFactory sqlSessionFactoryBean() throws Exception{
//        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
//        sqlSessionFactoryBean.setDataSource(dataSource());
//        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:/mappings/*.xml"));
//        return sqlSessionFactoryBean.getObject();
//    }
//    
//    @Bean
//    public PlatformTransactionManager transactionManager(){
//        return new DataSourceTransactionManager(dataSource());
//    }
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
