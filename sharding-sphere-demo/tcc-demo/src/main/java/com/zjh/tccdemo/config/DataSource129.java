package com.zjh.tccdemo.config;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * @author zhaojh
 * @date 2020/11/9 16:07
 */
@Configuration
@MapperScan(value = "com.zjh.tccdemo.db129.dao",sqlSessionFactoryRef = "sqlSessionFactoryBean129")
public class DataSource129 {

    @Bean("db129")
    public DataSource dataSource129() {
        MysqlDataSource mysqlDataSource = new MysqlDataSource();
        mysqlDataSource.setUser("root");
        mysqlDataSource.setPassword("Zjh072144.0");
        mysqlDataSource.setUrl("jdbc:mysql://192.168.120.129:3306/xa_129?serverTimezone=Asia/Shanghai&useSSL=false");
        return mysqlDataSource;
    }

    @Bean("sqlSessionFactoryBean129")
    public SqlSessionFactoryBean sqlSessionFactoryBean(@Qualifier("db129") DataSource dataSource) throws IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resourcePatternResolver.getResources("mybatis/db129/*.xml"));
        return sqlSessionFactoryBean;
    }

    @Bean("tm129")
    public PlatformTransactionManager platformTransactionManager(@Qualifier("db129") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

}
