package test.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class DatabaseConfig {
	
	@Value("${mysql.driver.name}")
	String MYSQL_DRIVER_NAME;
	
	@Value("${mysql.url}")
	String MYSQL_URL;
	
	@Value("${mysql.username}")
	String MYSQL_USERNAME;
	
	@Value("${mysql.password}")
	String MYSQL_PASSWORD;
	
@Bean @Primary
public BasicDataSource dataSource() {
	BasicDataSource bean = new BasicDataSource();
	bean.setDriverClassName(MYSQL_DRIVER_NAME);
	bean.setUrl(MYSQL_URL);
	bean.setUsername(MYSQL_USERNAME);
	bean.setPassword(MYSQL_PASSWORD);
	return bean;
}
}
