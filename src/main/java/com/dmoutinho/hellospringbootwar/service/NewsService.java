package com.dmoutinho.hellospringbootwar.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import com.dmoutinho.hellospringbootwar.model.News;

@Component
public class NewsService {
	
	private String resource = "https://samples.openweathermap.org/data/2.5/weather?q=London&mode=xml&appid=b6907d289e10d714a6e88b30761fae22";
	
	private String get(String id) throws Exception {
		
		HttpURLConnection connection  = (HttpURLConnection) (new URL(this.resource)).openConnection();

		BufferedReader reader  = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		
		StringBuilder response = new StringBuilder();
		
		String line = reader.readLine();
		while ( line!=null ) {
			response.append(line);
			line = reader.readLine();
		}
		
		connection.disconnect();
	
		return response.toString();			
		
	}
	
	private Document getDocument(String xmlResponde) throws Exception {
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		factory.setNamespaceAware(true);
		
		DocumentBuilder builder;
		
		Document doc = null;
		
        builder = factory.newDocumentBuilder();
       
        doc = builder.parse(new InputSource(new StringReader(xmlResponde)));
		
 		return doc;
		
	}
	
	private News newsBuilder(String xmlResponde) throws Exception {
		
		Document doc = getDocument(xmlResponde);
      
	    XPath xpath = XPathFactory.newInstance().newXPath();
        
        XPathExpression expr = xpath.compile("/current/city/country");
        String title = (String) expr.evaluate(doc,XPathConstants.STRING);
        
        expr = xpath.compile("/current/city/country");
        String content = (String) expr.evaluate(doc,XPathConstants.STRING);
      
		return new News(title,content);
		
	}
	
	public News getById(String id) throws Exception {
		return this.newsBuilder(this.get(id));
	}
	
}