package lilq.cn.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

//@EnableJpaRepositories("lilq.cn.dao")
@EnableJpaRepositories(basePackages={"lilq.cn.repository"})
public class Config {
    /**
     * 配置数据源
     * @return
     */
    @Bean("dataSource")
    public BasicDataSource dataSource(){
        BasicDataSource dataSource = new BasicDataSource();
//        dataSource.setDriverClassName("org.h2.Driver");
//        dataSource.setUrl("jdbc:h2:/~/book");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://lilq.cn:3306/quan");
        dataSource.setUsername("root");
        dataSource.setPassword("quan");
        dataSource.setInitialSize(5);
        return dataSource;
    }
    @Bean("jpaVendorAdapter")
    public JpaVendorAdapter jpaVendorAdapter(){
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setDatabase(Database.MYSQL);
//        adapter.setDatabase(Database.H2);
        adapter.setShowSql(true);
        adapter.setGenerateDdl(false);
//        adapter.setDatabasePlatform("org.hibernate.dialect.H2Dialect");
        adapter.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");
        return adapter;
    }

    /**
     * jpa
     */
    @Bean("entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean managerFactoryBean(DataSource dataSource,JpaVendorAdapter jpaVendorAdapter){
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setJpaVendorAdapter(jpaVendorAdapter);
        factoryBean.setPackagesToScan("lilq.cn.pojo");
        return factoryBean;
    }
    @Bean("transactionManager")
    public JpaTransactionManager getTransactionManager(LocalContainerEntityManagerFactoryBean entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory.getObject());
    }
}