package RestassuredAutomation.RestassuredAutomation;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC004_GET_Request {
	
	@Test
	void getweatherDetails() 
	{
		//Define/Specify base URI by predefined class RestAssured.baseURI
		
		RestAssured.baseURI="http://maps.googleapis.com";
		
		//Send this URI as GET request by creating Request Object
		RequestSpecification httprequest = RestAssured.given();
		
		//After sending done,need Object for Response.
		//Create Response object by class Response using httprequest object
		//Pass parameter from URI too in (Method.Get,path parameter)
		Response response=httprequest.request(Method.GET,"/Hyderabad");
		
		//Now final request will be send to server and get the response (saved in var response which must be Response type)
		
	
		//Print response body only on console window
		String responseBody = response.getBody().asString(); 
		//response.getBody() will give response in JSON format and asString() will convert that in String
		
		//Response contains Response Code + Response Body + Status Code + Status Line + Time + Header
		
		System.out.println("Response Body is :" +responseBody);
	
	
	
	
	
	
	
	
	
	
	
	

}
