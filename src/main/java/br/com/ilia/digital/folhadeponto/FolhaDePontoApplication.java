package br.com.ilia.digital.folhadeponto;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
public class FolhaDePontoApplication {

	@PostConstruct
	void started(){
		TimeZone.setDefault(TimeZone.getDefault());
	}

	@Configuration
	public class JacksonConfig {

		@Bean
		@Primary
		public ObjectMapper objectMapper(Jackson2ObjectMapperBuilder builder) {
			System.out.println("Config is starting.");
			ObjectMapper objectMapper = builder.createXmlMapper(false).build();
			objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
			return objectMapper;
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(FolhaDePontoApplication.class, args);
	}
}
