package com.xp.springboot.mop.config.monitor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RefreshScope
public class MonitorConfig {

    @Value("${monitor.limit}")
    private int limit;
    @Value("${monitor.alarmed}")
    private boolean alarmed;
    @Bean
    @RefreshScope
    public MonitorInterceptor monitorInterceptor() {
        MonitorInterceptor monitorInterceptor = new MonitorInterceptor();
        monitorInterceptor.setAlarmed(alarmed);
        Alarmer.defaultAlarmer().init(limit);
        return monitorInterceptor;
    }

}
