package com.zjh.xademo.config;

import com.atomikos.icatch.jta.UserTransactionImp;
import com.atomikos.icatch.jta.UserTransactionManager;
import com.mysql.cj.jdbc.MysqlXADataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.transaction.jta.JtaTransactionManager;

import javax.sql.DataSource;
import javax.transaction.UserTransaction;
import java.io.IOException;

/**
 * @author zhaojh
 * @date 2020/11/8 13:54
 */
@Configuration
@MapperScan(value = "com.zjh.xademo.db129.dao",sqlSessionFactoryRef = "sqlSessionFactoryBean129")
public class ConfigDb129 {

    @Bean("db129")
    public DataSource db129() {
        MysqlXADataSource mysqlXADataSource = new MysqlXADataSource();
        mysqlXADataSource.setUser("root");
        mysqlXADataSource.setPassword("Zjh072144.0");
        mysqlXADataSource.setUrl("jdbc:mysql://192.168.120.129:3306/xa_129?serverTimezone=Asia/Shanghai&ssl=true");
        AtomikosDataSourceBean atomikosDataSourceBean = new AtomikosDataSourceBean();
        atomikosDataSourceBean.setXaDataSource(mysqlXADataSource);
        return atomikosDataSourceBean;
    }

    @Bean("sqlSessionFactoryBean129")
    public SqlSessionFactoryBean sqlSessionFactoryBean(@Qualifier("db129") DataSource dataSource) throws IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        ResourcePatternResolver resourceResolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resourceResolver.getResources("mybatis/db129/*.xml"));
        return sqlSessionFactoryBean;
    }

//    @Bean("xaTransaction")
//    public JtaTransactionManager jtaTransactionManager() {
//        UserTransaction userTransaction = new UserTransactionImp();
//        UserTransactionManager userTransactionManager =new UserTransactionManager();
//        return new JtaTransactionManager(userTransaction, userTransactionManager);
//    }

    @Bean("xaTransaction")
    public JtaTransactionManager jtaTransactionManager(){
        UserTransaction userTransaction = new UserTransactionImp();
        UserTransactionManager userTransactionManager = new UserTransactionManager();

        return new JtaTransactionManager(userTransaction,userTransactionManager);
    }
}
