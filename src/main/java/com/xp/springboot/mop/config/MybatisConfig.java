package com.xp.springboot.mop.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
/**
 * 
* @ClassName: MybatisConfig 
* @Description: mybatis文件读取与mapper的扫描
* @author peng.xu
* @date 2017年11月23日 下午5:12:06 
*
 */
@Configuration
@MapperScan(basePackages = "com.xp.springboot.mop.mapper", sqlSessionFactoryRef = "sqlSessionFactory")
@AutoConfigureAfter(DataSource.class)
public class MybatisConfig {
    @Autowired
    private DataSource dataSource;

    @Bean("transactionManager")
    @Primary
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean("sqlSessionFactory")
    @Primary
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:mappings/*.xml"));
        sqlSessionFactoryBean.setTypeAliasesPackage("com.xp.springboot.mop.domain");
        return sqlSessionFactoryBean.getObject();
    }

}
