package com.dmoutinho.hellospringbootwar.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dmoutinho.hellospringbootwar.model.News;
import com.dmoutinho.hellospringbootwar.repository.NewsRepository;

@Configuration
@ComponentScan("com.dmoutinho.hellospringbootwar")
@SpringBootApplication
public class HelloSpringBootWarApplication {
	public static void main(String[] args) {
		SpringApplication.run(HelloSpringBootWarApplication.class, args);
	}
}

@RestController
@RequestMapping("/")
class HelloICPController {
    
	@Autowired
	private NewsRepository newsRepository;
	
	@GetMapping("/news/{id}")
	ResponseEntity<News> news(@PathVariable("id") String id) {
    	News news = null;
    	HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
		try {
			news = this.newsRepository.getById(id);
			status = news==null ? HttpStatus.NOT_FOUND : HttpStatus.OK;
		} catch (Exception e) {
			e.printStackTrace();
		}
        return new ResponseEntity<>(news,status);
    }
		
}