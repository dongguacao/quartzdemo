//package com.lidong.quartzdemo.config;
//
//import com.lidong.quartzdemo.pool.MyDataSource;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//
//import javax.sql.DataSource;
//
///**
// * @author caolidong
// * @date 2022/1/12
// */
//@Configuration
//public class DataSourceConfig {
//
//    @Bean(name = "myDataSource")
//    @Qualifier("myDataSource")
//    @Primary
//    public DataSource getDataSource(){
//        return new MyDataSource();
//    }
//}
