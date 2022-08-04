package com.musinsa.config.database;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@MapperScan(value="com.musinsa", sqlSessionFactoryRef="mariadbSqlSessionFactory")
@EnableTransactionManagement
public class MariadbDatabaseConfig {
	@Bean(name = "mariadbDataSource", destroyMethod = "close")
	@ConfigurationProperties(prefix = "spring.mariadb.datasource")
	public DataSource mariadbDataSource() {
        return DataSourceBuilder.create().build();
	}
	
    @Bean(name = "mariadbSqlSessionFactory")
    public SqlSessionFactory mariadbSqlSessionFactory(@Qualifier("mariadbDataSource") DataSource mariadbDataSource, ApplicationContext applicationContext) throws Exception {

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(mariadbDataSource);
        sqlSessionFactoryBean.setConfigLocation(applicationContext.getResource("classpath:mapper/mybatis-config.xml"));
        sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:mapper/mariadb/**/*.xml"));        
        return sqlSessionFactoryBean.getObject();
    } 

    @Bean(name = "mariadbSqlSessionTemplate")
    public SqlSessionTemplate mariadbSqlSessionTemplate(SqlSessionFactory mariadbSqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(mariadbSqlSessionFactory);
    }
}
