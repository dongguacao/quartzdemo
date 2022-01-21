package com.lidong.quartzdemo.config;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * @author caolidong
 * @date 2022/1/12
 */
@Configuration
@MapperScan(basePackages = {"com.lidong.quartzdemo.mapper"},annotationClass = Mapper.class,sqlSessionFactoryRef = "mySqlSessionFactory")
public class MybatisConfig {

    @Bean("mySqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("myDataSource")DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().
                getResources("classpath*:/mapper/*.xml"));
//        sqlSessionFactoryBean.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
//        sqlSessionFactoryBean.setConfiguration();  可以复写configuration.xml文件
        return sqlSessionFactoryBean.getObject();
    }
}
