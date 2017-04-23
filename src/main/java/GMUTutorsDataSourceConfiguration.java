import org.hibernate.dialect.SQLServer2012Dialect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy;
import org.springframework.cache.CacheManager;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by Andrew on 4/22/2017.
 */
@Configuration
@EnableJpaRepositories(
        entityManagerFactoryRef = "gmuTutorsEntityManagerFactory",
        transactionManagerRef = "gmuTutorsTransactionManager",
        basePackages = "repository"
)
public class GMUTutorsDataSourceConfiguration {
    final static Logger log = LoggerFactory.getLogger(GMUTutorsDataSourceConfiguration.class);

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.tutors")
    public DataSource tutorDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @Primary
    LocalContainerEntityManagerFactoryBean gmuTutorsEntityManagerFactory(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(tutorDataSource())
                .persistenceUnit("gmuTutors")
                .properties(new HashMap<String, Object>() {
                    {
                        put("hibernate.physical_naming_strategy", SpringPhysicalNamingStrategy.class.getName());
                        put("hibernate.implicit_naming_strategy", SpringPhysicalNamingStrategy.class.getName());
                        put("hibernate.dialect", SQLServer2012Dialect.class.getName());
                    }
                })
                .build();
    }

    @Bean
    public CacheManager cacheManager(){
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        cacheManager.setCaches(Arrays.asList()); //todo: TBD
        return cacheManager;
    }
}
