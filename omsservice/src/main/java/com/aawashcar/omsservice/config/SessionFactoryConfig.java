package com.aawashcar.omsservice.config;

import java.io.IOException;

import javax.sql.DataSource;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.aawashcar.omsservice.config.SessionFactoryConfig;

@Configuration
@EnableTransactionManagement
@MapperScan("com.aawashcar.omsservice.mappers")
public class SessionFactoryConfig {
	private static Logger logger = LogManager.getLogger(SessionFactoryConfig.class);

    @Autowired
    private DataSource dataSource;

    private String typeAliasPackage = "com.aawashcar.omsservice.entities";

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactoryBean createSqlSessionFactoryBean() {
        logger.info("createSqlSessionFactoryBean method");

        try {
            ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
            SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
            sqlSessionFactoryBean.setDataSource(dataSource);
            sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:com/aawashcar/omsservice/mappers/*.xml"));
            sqlSessionFactoryBean.setTypeAliasesPackage(typeAliasPackage);
            return sqlSessionFactoryBean;
        } catch (IOException ex) {
            logger.error("Error happens when getting config files." + ExceptionUtils.getMessage(ex));
        }
        return null;
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }
}
