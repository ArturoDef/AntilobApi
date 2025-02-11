package com.antilob.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class ApplicationProperties {
    @Autowired
    private Environment env;
    public void logApplicationProperties(){
        String ServerPort= env.getProperty("server.port");
        String server_servlet_context_path = env.getProperty("server.servlet.context-path");
        String spring_web_resources_static_locations = env.getProperty("spring.web.resources.static-locations");
        String apiServer  = env.getProperty("api.server");
        System.out.println("ServerPort: "+ServerPort);
        System.out.println("server_servlet_context_path: "+server_servlet_context_path);
        System.out.println("spring_web_resources_static_locations: "+spring_web_resources_static_locations);
        System.out.println("api.server: " + apiServer);
    }
}
