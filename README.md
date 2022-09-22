1- Cloning...
```sh
$ git clone http://github.com/dmoutinho/hello-spring-boot-war
```

2- Building
```sh
$ mvn clean install
```

3- Deploying Tomcat 8.5.39
```sh
$ cp \hello-spring-boot-war\target\hello-spring-boot-war-1.0.war \Tomcat8.5.39\webapps
$ \Tomcat8.5.39\bin\catalina.bat run
```

4- Accessing
```sh
$ http://localhost:8080/hello-spring-boot-war-1.0/news/1
```

5- Changing **Get Method**: com.dmoutinho.hellospringbootwar.HelloICPController
```sh
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
```
