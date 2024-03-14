package test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@EnableCaching
@PropertySource("file:C:/Properties/application.properties")
public class Application{
public static void main(String[] args) {
	SpringApplication.run(Application.class,args);
}
}
