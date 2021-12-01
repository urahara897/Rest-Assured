package APITest;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import javafx.beans.binding.When;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class E_Commerce {
	
	public static String baseURL = "https://ecommerceservice.herokuapp.com";
	public String accessToken;
	public String id;
      
	@Test(priority = 0 , enabled = false)
	
	public void signup()
	{
		RestAssured.baseURI= baseURL;
		String requestBody =  "{\r\n"
				+ "	\"email\": \"mnop24@gmail.com\",\r\n"
				+ "	\"password\": \"dklf@1234\"\r\n"
				+ "}\r\n"
				+ "";
		
		Response response = given()
				.header("content-Type","application/json")
				.body(requestBody)
				
				.when()
				.post("/user/signup")
				
				.then()
				.assertThat().statusCode(201).and().contentType(ContentType.JSON)
				//To extract the response
				.extract().response();
				//output will be in string, have to convert to json
				String jsonresponse = response.asString();
				//convert from normal string to json
				JsonPath responsebody = new JsonPath(jsonresponse);
				System.out.println(responsebody.get("message"));
				
	}
	
	@Test(priority = 1)
	public void login()
	{
		
		RestAssured.baseURI= baseURL;
		String requestBody =  "{\r\n"
				+ "	\"email\": \"mnop24@gmail.com\",\r\n"
				+ "	\"password\": \"dklf@1234\"\r\n"
				+ "}\r\n"
				+ "";
		
		Response response = given()
				.header("content-Type","application/json")
				.body(requestBody)
				
				.when()
				.post("/user/login")
				
				.then()
				.assertThat().statusCode(200).and().contentType(ContentType.JSON)
				//To extract the response
				.extract().response();
				//output will be in string, have to convert to json
				String jsonresponse = response.asString();
				//convert from normal string to json
				JsonPath responsebody = new JsonPath(jsonresponse);
				System.out.println(responsebody.get("accessToken"));	
				accessToken = responsebody.get("accessToken");	
	}
	@Test(priority = 2)
	public void getusers()
	{
		RestAssured.baseURI= baseURL;
		
		Response response = given()
				.header("content-Type","application/json")
				.header("Authorization","bearer "+accessToken)
				
				.when()
				.get("/user")
				
				.then()
				.assertThat().statusCode(200).and().contentType(ContentType.JSON)
				//To extract the response
				.extract().response();
				//output will be in string, have to convert to json
				String jsonresponse = response.asString();
				//convert from normal string to json
				JsonPath responsebody = new JsonPath(jsonresponse);
				System.out.println(responsebody.get("users[150]._id"));
				id = responsebody.get("users[150]._id");
	}
	
	@Test(priority = 3)
	public void delete()
	{
		RestAssured.baseURI = baseURL;
		Response response = given()
				.header("content-Type","application/json")
				.header("Authorization","bearer "+accessToken)
				
				.when()
		        .delete("/user/"+id)
		       
		        .then()
		        .assertThat().statusCode(200).contentType(ContentType.JSON)
		        .extract().response();
		String jsonrespose = response.asString();
		JsonPath responsebody = new JsonPath(jsonrespose);
		System.out.println(responsebody.get("message"));
	}
}



