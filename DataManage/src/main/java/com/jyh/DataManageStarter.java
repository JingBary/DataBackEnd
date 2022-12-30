package com.jyh;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@MapperScan("com.jyh.mapper")
@CrossOrigin
public class DataManageStarter {
    public static void main(String[] args) {
        SpringApplication.run(DataManageStarter.class,args);
    }

    /**
     * 以下代码是开始通过建立连接池进行数据库的链接
     * @return
     */
    @Bean//是用在方法级别的注解，主要在配置类里，返回的是一个对象
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSource dataSource() {

        return new org.apache.tomcat.jdbc.pool.DataSource();
    }

    @Bean
    public SqlSessionFactory sqlSessionFactoryBean() throws Exception {

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());

        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:/mapper/*.xml"));

        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    public PlatformTransactionManager transactionManager() {

        return new DataSourceTransactionManager(dataSource());
    }
}
