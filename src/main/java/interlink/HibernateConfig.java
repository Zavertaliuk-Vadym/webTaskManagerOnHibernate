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
    static final String DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";

    static final Properties hibernateProperties = new Properties() {
        {
            setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        }
    };

    private String dbUrl = "jdbc:mysql://localhost:3306/Task";

    private String dbUser = "root";

    private String dbPass = "school24";

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
