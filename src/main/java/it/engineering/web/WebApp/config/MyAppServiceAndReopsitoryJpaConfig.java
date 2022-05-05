package it.engineering.web.WebApp.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(MyDatabaseJpaConfiguration.class)

@ComponentScan(basePackages = {
		"it.engineering.web.WebApp.repository",
		"it.engineering.web.WebApp.service"
})
public class MyAppServiceAndReopsitoryJpaConfig {

}
