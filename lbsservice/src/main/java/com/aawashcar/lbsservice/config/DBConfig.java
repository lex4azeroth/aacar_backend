package com.aawashcar.lbsservice.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DBConfig {
	@Value("${spring.datasource.hikari.jdbc-url}")
	private String jdbcUrl;

	@Value("${spring.datasource.hikari.driver-class-name}")
	private String driverClassName;

	@Value("${spring.datasource.hikari.username}")
	private String userName;

	@Value("${spring.datasource.hikari.password}")
	private String password;

	@Value("${spring.datasource.hikari.connection-timeout}")
	private long connectionTimeout;

	@Value("${spring.datasource.hikari.idle-timeout}")
	private long idleTimeout;

	@Value("${spring.datasource.hikari.max-lifetime}")
	private long maxLifetime;

	@Value("${spring.datasource.hikari.connection-test-query}")
	private String testQuery;

	@Value("${spring.datasource.hikari.minimum-idle}")
	private int minimumIdle;

	@Value("${spring.datasource.hikari.maximum-pool-size}")
	private int maximumPoolSize;

	@Value("${spring.datasource.hikari.pool-name}")
	private String poolName;

	@Bean(name = "dataSource")
	@Primary
	public DataSource dataSource() {
		HikariConfig config = new HikariConfig();
		config.setJdbcUrl(jdbcUrl);
		config.setDriverClassName(driverClassName);
		config.setUsername(userName);
		config.setPassword(password);

		config.setConnectionTimeout(connectionTimeout);
		config.setIdleTimeout(idleTimeout);
		config.setMaxLifetime(maxLifetime);
		config.setConnectionTestQuery(testQuery);
		config.setMinimumIdle(minimumIdle);
		config.setMaximumPoolSize(maximumPoolSize);
		config.setPoolName(poolName);

		config.addDataSourceProperty("cachePrepStmts", true);
		config.addDataSourceProperty("prepStmtCacheSize", 150);
		config.addDataSourceProperty("prepStmtCacheSqlLimit", 2048);

		HikariDataSource dataSource = new HikariDataSource(config);
		return dataSource;
	}
}
