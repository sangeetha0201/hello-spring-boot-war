package com.dmoutinho.hellospringbootwar.app;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dmoutinho.hellospringbootwar.service.NewsService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloSpringBootWarApplicationTests {

	@Test
	public void contextLoads() {
		try {
			
			NewsService newsService = new NewsService();
			
			System.err.println("==================> " + newsService.getById("test"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}