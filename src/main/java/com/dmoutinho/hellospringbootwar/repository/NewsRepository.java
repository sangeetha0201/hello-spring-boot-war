package com.dmoutinho.hellospringbootwar.repository;

import org.springframework.stereotype.Component;

import com.dmoutinho.hellospringbootwar.model.News;

@Component
public class NewsRepository {
	
	public News getById(String id) {
		News news = null;
		switch (id) {
			case "1":
	    		news = new News("Title 1","Content 1");
				break;
			case "2":
				news = new News("Title 2","Content 2");
				break;
			default:
				break;
		}
		return news;
	}
	
}