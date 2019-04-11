package com.dmoutinho.hellospringbootwar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class HelloSpringBootWarApplication {
	public static void main(String[] args) {
		SpringApplication.run(HelloSpringBootWarApplication.class, args);
	}
}

@RestController
@RequestMapping("/")
class HelloICPController {
    
	@GetMapping("/news/{id}")
	ResponseEntity<News> news(@PathVariable("id") String id) {
		ResponseEntity<News> responseEntity = null;
    	try {
    		switch (id) {
				case "1":
		    		responseEntity = new ResponseEntity<News>(new News("Title 1","Content 1"),HttpStatus.OK);
					break;
				case "2":
		    		responseEntity = new ResponseEntity<News>(new News("Title 2","Content 2"),HttpStatus.OK);
					break;
				default:
		    		responseEntity = new ResponseEntity<News>(HttpStatus.NOT_FOUND);
					break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
        return responseEntity;
    }
		
}

class News {
	private String title;
	private String content;
	public News(String title, String content) {
		super();
		this.title = title;
		this.content = content;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}