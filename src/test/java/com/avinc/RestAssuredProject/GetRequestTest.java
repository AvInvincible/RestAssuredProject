package com.avinc.RestAssuredProject;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRequestTest {
	
	@Test
	public void verifyWheaterDetails() {
		
		//Specify the base url
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		
		//Specify the request specifications
		RequestSpecification httpRequest = RestAssured.given();
		
		//Request the server with the request type and the baseURI
		Response response = httpRequest.request(Method.GET,"/Chandigarh");
		
		//Print the response body
		
		System.out.println("Response :" + response.getBody().asString());
		
		System.out.println("Response Status Code :" + response.getStatusCode());
		System.out.println("Response Status Line :" + response.getStatusLine());
		
		//Getting the header
		
		System.out.println("Response Header Server:" + response.header("Server"));
		System.out.println("Response Header Content-Encoding:" + response.header("Content-Encoding"));
		
		//Print all the header
		Headers allHeader = response.headers();
		for(Header head : allHeader)
			System.out.println(head.getName() +"  "+ head.getValue());
	}

}
