package com.example.service.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.example.service.Greetings;

@SpringBootApplication
@ImportResource({"classpath:services.xml"})
@EnableScheduling
public class Application {

    @Autowired
    private ApplicationContext context;

    public static void main(String[] args){
        SpringApplication.run(Application.class,args);
    }

    @Scheduled(initialDelay = 1000, fixedRate = 10000)
    public String greetings(){
        Greetings greetingService = (Greetings)context.getBean("greetingService");
        String result = greetingService.say("Dubbo Docker");
        return result;
    }
}
