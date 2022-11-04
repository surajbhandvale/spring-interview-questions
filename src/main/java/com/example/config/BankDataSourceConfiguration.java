package com.example.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@EnableJpaRepositories(basePackages = "com.example.repository.bank",
    entityManagerFactoryRef = "bankEntityManagerFactory",
    transactionManagerRef = "bankTransactionManager")
public class BankDataSourceConfiguration {

    @Bean
    @ConfigurationProperties("spring.datasource.bank")
    public DataSourceProperties cardDatasourceProperties(){
        return new DataSourceProperties();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.bank.configuration")
    public DataSource cardDataSource() {
        return cardDatasourceProperties().initializeDataSourceBuilder()
                .type(HikariDataSource.class).build();
    }

    @Bean(name = "bankEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean bankEntityManagerFactory(
            EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(cardDataSource())
                .packages("com.javatodev.api.model.bank")
                .build();
    }

    @Bean
    public PlatformTransactionManager bankTransactionManager(
            final @Qualifier("bankEntityManagerFactory") LocalContainerEntityManagerFactoryBean bankEntityManagerFactory) {
        return new JpaTransactionManager(bankEntityManagerFactory.getObject());
    }
}
