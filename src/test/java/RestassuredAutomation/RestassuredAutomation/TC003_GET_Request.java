package RestassuredAutomation.RestassuredAutomation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC003_GET_Request {

	//Validate the Headers

	@Test
	void googleMapTest() 
	{
		//Define/Specify base URI by predefined class RestAssured.baseURI

		RestAssured.baseURI="http://maps.googleapis.com";

		//Send this URI as GET request by creating Request Object
		RequestSpecification httprequest = RestAssured.given();

		//After sending done,need Object for Response.
		//Create Response object by class Response using httprequest object
		//Pass parameter from URI too in (Method.Get,path parameter)
		Response response=httprequest.request(Method.GET,"/map/api/place/nearbysearch/xml?location=-33.8670522,151.1957362&radius=1500&type=supermarket&key=AIzaSyBjGCE3VpLU41gTqSTDmHm32HoELb4jy1s");

		//Now final request will be send to server and get the response (saved in var response which must be Response type)


		//Print response body only on console window
		String responseBody = response.getBody().asString(); 
		//response.getBody() will give response in JSON format and asString() will convert that in String

		//Response contains Response Code + Response Body + Status Code + Status Line + Time + Header

		System.out.println("Response Body is :" +responseBody);


		//*****Validation : Header part
		//Before write code,chk in POSTMAN ,what are the all headers are created for this API request
		//Imp Headers , need to validate every time are : Content Type , Content Encoding , Server , Content Length .


		//1. Capture details of headers:Content Type from response

		String contentType=response.header("Content-Type");
		System.out.println("Content Type is :" +contentType);
		//Now verify the value of Content Type
		Assert.assertEquals(contentType, "text/html; charset=UTF-8");

		//2. Capture details of headers:Content-Encoding from response

		String contentEncoding=response.header("Content-Encoding");
		System.out.println("Content Encoding is :" +contentEncoding);
		//Now verify the value of Content-Encoding
		Assert.assertEquals(contentEncoding, "gzip");
		
		//Similerly can Validate others like Expires , Servers , Vary , Content-Lenght , Server-Timing







	}











}
