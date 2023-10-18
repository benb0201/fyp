package com.example.travelpal.destination;

import com.example.travelpal.client.Client;
import com.example.travelpal.client.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

import static java.time.Month.JANUARY;
import static java.time.Month.OCTOBER;

//@Configuration
//@PropertySource({ "classpath:persistence-multiple-db.properties" })
//@EnableJpaRepositories(
//        basePackages = "com.baeldung.multipledb.dao.product",
//        entityManagerFactoryRef = "destinationEntityManager",
//        transactionManagerRef = "destinationTransactionManager"
//)
//public class DestinationConfiguration {
//    @Autowired
//    private Environment env;
//
//    @Bean
//    @ConfigurationProperties(prefix="spring.datasource.destination")
//    public LocalContainerEntityManagerFactoryBean destinationEntityManager() {
//        LocalContainerEntityManagerFactoryBean em
//                = new LocalContainerEntityManagerFactoryBean();
//        em.setDataSource(destinationDataSource());
//        em.setPackagesToScan(
//                new String[] { "com.baeldung.multipledb.model.product" });
//
//        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//        em.setJpaVendorAdapter(vendorAdapter);
//        HashMap<String, Object> properties = new HashMap<>();
//        properties.put("hibernate.hbm2ddl.auto",
//                env.getProperty("hibernate.hbm2ddl.auto"));
//        properties.put("hibernate.dialect",
//                env.getProperty("hibernate.dialect"));
//        em.setJpaPropertyMap(properties);
//
//        return em;
//    }
//
//    @Bean
//    public DataSource destinationDataSource() {
//
//        DriverManagerDataSource dataSource
//                = new DriverManagerDataSource();
//        dataSource.setDriverClassName(
//                env.getProperty("jdbc.driverClassName"));
//        dataSource.setUrl(env.getProperty("destination.jdbc.url"));
//        dataSource.setUsername(env.getProperty("postgres"));
//        dataSource.setPassword(env.getProperty("postgres"));
//
//        return dataSource;
//    }
//
//    @Bean
//    public PlatformTransactionManager destinationTransactionManager() {
//
//        JpaTransactionManager transactionManager
//                = new JpaTransactionManager();
//        transactionManager.setEntityManagerFactory(
//                destinationEntityManager().getObject());
//        return transactionManager;
//    }
//}


@Configuration
public class DestinationConfig {

    @Bean
    CommandLineRunner commandLineRunner(DestinationRepository repository){
        return args -> {
            Destination destination1 = new Destination(
                    "Paris",
                    "Paris, France",
                    "The City of Love"
            );

            Destination destination2 = new Destination(
                    "New York City",
                    "New York, USA",
                    "The Big Apple"
            );

            repository.saveAll(
                    List.of(destination1 ,destination2)
            );
        };
    }
}
