package io.github.jihch.config;

import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "io.github.jihch.mapper.world", sqlSessionTemplateRef = "sqlSessionTemplateWorld")
public class DataSourceWorldConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.hikari.datasource-world")
    public DataSource dataSourceWorld() {
        return new HikariDataSource();
    }

    @Bean
    public SqlSessionFactory sqlSessionFactoryWorld(@Qualifier("dataSourceWorld") DataSource dataSource)
            throws Exception {
        MybatisSqlSessionFactoryBean bean = new MybatisSqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        return bean.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplateWorld(@Qualifier("sqlSessionFactoryWorld") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
