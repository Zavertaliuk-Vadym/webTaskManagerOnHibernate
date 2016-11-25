package interlink;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:hibernate.properties")
public class HibernateConfig {

    static final Properties hibernateProperties = new Properties() {
        {
            setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
            setProperty("hibernate.hbm2ddl.auto", "update");
            setProperty("hibernate.show_sql", "false");
            setProperty("hibernate.current_session_context_class", "org.springframework.orm.hibernate4.SpringSessionContext");
        }
    };

    @Value("${db.driver}")
    private String DRIVER_CLASS_NAME;

    @Value("${db.url}")
    private String dbUrl;

    @Value("${db.username}")
    private String dbUser;

    @Value("${db.password}")
    private String dbPass;

//    @Value("${hibernate.dialect}")
//    private Properties hibernateProperties;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        final LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("interlink");
        sessionFactory.setHibernateProperties(hibernateProperties);
        return sessionFactory;
    }

    @Bean
    public HibernateTransactionManager transactionManager() {
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(sessionFactory().getObject());
        return txManager;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource(dbUrl, dbUser, dbPass);
        dataSource.setDriverClassName(DRIVER_CLASS_NAME);
        return dataSource;
    }
}
