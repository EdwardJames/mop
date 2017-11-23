package com.xp.springboot.mop.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
/**
 * 
* @ClassName: DataSourceConfig 
* @Description: 对于数据库数据源的支持
* @author peng.xu
* @date 2017年11月23日 下午5:12:01 
*
 */
@Configuration
public class DataSourceConfig {
    @Primary
    @Bean
    @ConfigurationProperties("spring.datasource.druid")
    public DataSource dataSource() {
        return new org.apache.tomcat.jdbc.pool.DataSource();
    }

}
