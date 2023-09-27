package com.munindra.springboot.myfirstwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {

	//"say-hello" => "Hello! what are you learning today?"
	
	//say-Hello
	// http://localhost:8080/say-Hello
	@RequestMapping("say-Hello")
	@ResponseBody 
	public String sayHello() {
		return "Hello! what are you learning today?";
	}
	@RequestMapping("say-Hello-html")
	@ResponseBody 
	public String sayHelloHtml() {
		StringBuffer sb = 	new StringBuffer();
		
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title>My First HTML Page</title>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("My first html page with body");
		sb.append("</body>");
		sb.append("</html>");
		return sb.toString();
	}
	//jsp
	
	//sayHello.jsp
	//"say-Hello-jsp" => sayHello.jsp
	@RequestMapping("say-Hello-jsp")
	//@ResponseBody 
	public String sayHelloJsp() {
		return "sayHello";
	}
}
 