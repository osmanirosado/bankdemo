package com.example.bankdemo.db

import com.zaxxer.hikari.HikariDataSource
import jakarta.persistence.EntityManagerFactory
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.transaction.PlatformTransactionManager
import org.springframework.transaction.annotation.EnableTransactionManagement
import javax.sql.DataSource


@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
    entityManagerFactoryRef = "BankDemoEntityManagerFactory",
    basePackages = ["com.example.bankdemo.db.repositories"],
    transactionManagerRef = "BankDemoTransactionManager"
)
class BankDemoConfig {
    @Bean(name = ["BankDemoDataSourceProperties"])
    @ConfigurationProperties("spring.datasource.bank-demo")
    fun dataSourceProperties(): DataSourceProperties {
        return DataSourceProperties()
    }

    @Bean(name = ["BankDemoDataSource"])
    @ConfigurationProperties("spring.datasource.bank-demo.configuration")
    fun dataSource(@Qualifier("BankDemoDataSourceProperties") dataSourceProperties: DataSourceProperties): DataSource {
        return dataSourceProperties.initializeDataSourceBuilder().type(HikariDataSource::class.java).build()
    }

    @Bean(name = ["BankDemoEntityManagerFactory"])
    fun entityManagerFactory(
        builder: EntityManagerFactoryBuilder, @Qualifier("BankDemoDataSource") dataSource: DataSource?
    ): LocalContainerEntityManagerFactoryBean {
        val properties: Map<String, Any> = HashMap()
        return builder
            .dataSource(dataSource)
            .packages("com.example.bankdemo.db.entities")
            .persistenceUnit("bank-demo")
            .properties(properties)
            .build()
    }

    @Bean(name = ["BankDemoTransactionManager"])
    fun transactionManager(
        @Qualifier("BankDemoEntityManagerFactory") entityManagerFactory: EntityManagerFactory
    ): PlatformTransactionManager {
        return JpaTransactionManager(entityManagerFactory)
    }
}