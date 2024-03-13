package com.restassured.User;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import org.json.simple.JSONObject;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.baseURI;



public class UserAbleToUpdateProductInCart {
	@Test
	public void UserRelated() {
		JSONObject obj = new JSONObject();
		  baseURI = "http://localhost:9999/user/cart/update";
		  obj.put( "quantity",333);
		  
		  given().contentType(ContentType.JSON).when().body(obj.toJSONString())
		  .put("/21")
		  .then().statusCode(200).log().all();
	  
		
		
		
		
	}

	

}
