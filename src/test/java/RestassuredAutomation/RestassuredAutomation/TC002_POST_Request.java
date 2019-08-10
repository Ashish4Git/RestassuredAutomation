package RestassuredAutomation.RestassuredAutomation;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC002_POST_Request {
	//*****************To send POST request,it should also include BODY(parameters) and Header*******************

	@Test
	void RegistrationSuccessful()
	{
		
		       //Define/Specify base URI by predefined class RestAssured.baseURI
		
				RestAssured.baseURI="http://restapi.demoqa.com/customer";
				
				//Send this URI as GET request by creating Request Object
				RequestSpecification httpRequest = RestAssured.given();
				
				
				
				//Create body i.e. Data by JSONObject class
				JSONObject requestParams = new JSONObject();
				
				//Request payload sending along with POST request	
				//Send request along with its body(in JSON form),to create new record in DB
				//Prepair data send to the server
				requestParams.put("FirstName","AshishXYZ");
				requestParams.put("LastName","XYZAshish");
				requestParams.put("UserName","AshishXYZ");
				requestParams.put("Password","AshishXYZxyz");
				requestParams.put("Email","AshishXYZ@gmail.com");
				
				//Need to add one Header for this body
				
				httpRequest.header("Content-Type","application/json");//attach above body data to the request
				
				//Header + payload need to attached with POST request
				
				httpRequest.body(requestParams.toJSONString());
				
				//Now send the POST request : Response object
				Response response = httpRequest.request(Method.POST,"/register");
																	
				//**************************************************
				//Print response body only on console window
				String responseBody = response.getBody().asString(); 
				//response.getBody() will give response in JSON format and asString() will convert that in String
				
				//Response contains Response Code + Response Body + Status Code + Status Line + Time + Header
				
				System.out.println("Response Body is :" +responseBody);
				
				
				/*Validation : Status code & Success Code(part of response body):
				By using response object as it contains all the info
				 */	
				
				//1.status code validation
				int statusCode=response.getStatusCode(); //INT
				//Capture the status code from response and store in var statusCode
				
				System.out.println("status code is :" +statusCode);
				Assert.assertEquals(statusCode, 201);//Pass above statusCode and expected one i.e. 200
				

				//2.Success Code validation
				String successCode=response.jsonPath().get("SuccessCode");//get value of SuccessCode,whereever it will be in json path and store that value
				Assert.assertEquals(successCode,"OPERATION_SUCCESS");
				
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
}
