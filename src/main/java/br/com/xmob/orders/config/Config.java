package br.com.xmob.orders.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

@Configuration
public class Config {

    @Bean
    public Random random(){
        return new Random();
    }

    @Bean
    public ReentrantLock reentrantLock(){
        return new ReentrantLock();
    }
}
