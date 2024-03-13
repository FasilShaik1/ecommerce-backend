package com.restassured.User;
import static io.restassured.RestAssured.given;


import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.baseURI;


public class UserAbleToAddProductInCart {
	@Test
	public void UserRelated() {
		
			JSONObject req = new JSONObject();
		    JSONObject userObject = new JSONObject();
		    JSONObject productObject = new JSONObject();

		    userObject.put("id", 2); 
		    productObject.put("id", 6); 

		    req.put("user", userObject);
		    req.put("product", productObject);
		    req.put("quantity", 3000);
			  baseURI = "http://localhost:9999/user/user";
			  given().body(req.toJSONString()).header("Content-Type","application/json")
			  .contentType(ContentType.JSON).
			  when().post("/cart").then().statusCode(201).log().all();
	}

}
