package com.antilob;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan (basePackages = {"com.antilob.engine.controller","com.antilob.engine.database","com.antilob.engine.service"})
public class AppConfig {

}
