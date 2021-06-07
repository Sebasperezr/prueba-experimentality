package com.perez.ptbackend;

import java.util.TimeZone;
import java.util.concurrent.Executor;
import javax.annotation.PostConstruct;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@SpringBootApplication
@EnableAsync
@EnableCaching(proxyTargetClass = true)
public class PtbackendApplication extends AsyncConfigurerSupport {


	public static void main(String[] args) {
		SpringApplication.run(PtbackendApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Override
	public Executor getAsyncExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(2);
		executor.setMaxPoolSize(20);
		executor.setQueueCapacity(500);
		executor.initialize();
		return executor;
	}


	@PostConstruct
	public void init() {

		TimeZone.setDefault(TimeZone.getTimeZone("GMT-5"));
	}
}
