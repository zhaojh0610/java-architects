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
@MapperScan(value = "com.zjh.tccdemo.db130.dao",sqlSessionFactoryRef = "sqlSessionFactoryBean130")
public class DataSource130 {

    @Bean("db130")
    public DataSource dataSource130() {
        MysqlDataSource mysqlDataSource = new MysqlDataSource();
        mysqlDataSource.setUser("root");
        mysqlDataSource.setPassword("Zjh072144.0");
        mysqlDataSource.setUrl("jdbc:mysql://192.168.120.130:3306/xa_130?serverTimezone=Asia/Shanghai&useSSL=false");
        return mysqlDataSource;
    }

    @Bean("sqlSessionFactoryBean130")
    public SqlSessionFactoryBean sqlSessionFactoryBean(@Qualifier("db130") DataSource dataSource) throws IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resourcePatternResolver.getResources("mybatis/db130/*.xml"));
        return sqlSessionFactoryBean;
    }

    @Bean("tm130")
    public PlatformTransactionManager platformTransactionManager(@Qualifier("db130") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
