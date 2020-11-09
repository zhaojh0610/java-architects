package com.zjh.xademo.config;

import com.mysql.cj.jdbc.MysqlXADataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;


/**
 * @author zhaojh
 * @date 2020/11/8 13:54
 */
@Configuration
@MapperScan(value = "com.zjh.xademo.db130.dao",sqlSessionFactoryRef = "sqlSessionFactoryBean130")
public class ConfigDb130 {

    @Bean("db130")
    public DataSource db130() {
        MysqlXADataSource mysqlXADataSource = new MysqlXADataSource();
        mysqlXADataSource.setUser("root");
        mysqlXADataSource.setPassword("Zjh072144.0");
        mysqlXADataSource.setUrl("jdbc:mysql://192.168.120.130:3306/xa_130?serverTimezone=Asia/Shanghai");
        AtomikosDataSourceBean atomikosDataSourceBean = new AtomikosDataSourceBean();
        atomikosDataSourceBean.setXaDataSource(mysqlXADataSource);
        return atomikosDataSourceBean;
    }

    @Bean("sqlSessionFactoryBean130")
    public SqlSessionFactoryBean sqlSessionFactoryBean(@Qualifier("db130") DataSource dataSource) throws IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        ResourcePatternResolver resourceResolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resourceResolver.getResources("mybatis/db130/*.xml"));
        return sqlSessionFactoryBean;
    }
}
