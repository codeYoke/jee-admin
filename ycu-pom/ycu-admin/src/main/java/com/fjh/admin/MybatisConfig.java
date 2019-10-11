package com.fjh.admin;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.fjh.admin.**.dao")//操作数据库的接口存放的路径
@EnableTransactionManagement
public class MybatisConfig {
    //数据源
    @Autowired
    private DataSource dataSource;

    //sqlSessionFactory
    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        //设置数据源
        sqlSessionFactoryBean.setDataSource(dataSource);
        //和数据库表相对应的实体类在哪个包，使用别名
        sqlSessionFactoryBean.setTypeAliasesPackage("com.fjh.admin.**.model");
        //映射文件所在路径
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath*:**/*Mapper.xml"));
        return sqlSessionFactoryBean.getObject();
    }
}
