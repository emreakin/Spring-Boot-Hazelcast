package com.emreakin;

import com.emreakin.configuration.HazelcastMapProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({
        HazelcastMapProperties.class
})
public class SpringBootHazelcastApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootHazelcastApplication.class, args);
    }
}
