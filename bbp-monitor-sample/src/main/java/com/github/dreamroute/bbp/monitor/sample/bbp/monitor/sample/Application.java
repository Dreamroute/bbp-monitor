package com.github.dreamroute.bbp.monitor.sample.bbp.monitor.sample;

import config.A;
import config.B;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication(scanBasePackageClasses = {Application.class})
@SpringBootApplication(scanBasePackageClasses = {Application.class, A.class, B.class})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
