package com.dmoutinho.hellospringbootwar.model;

import org.apache.camel.spring.SpringRouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class NewsBuilder  extends SpringRouteBuilder  {
	
	public News getNews() {
		return null;
	}

	@Override
	public void configure() throws Exception {
	    System.out.println("=================================== Antes =======");
//		from("timer:foo")
//	    .to("log:bar");
		from("direct:hello").to("stream:out");
	    System.out.println("============================ Depois =======");
	}

}