package com.restassured.User;

import static io.restassured.RestAssured.given;


import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.baseURI;


public class UserLogin {
	@Test
	public void UserRelated() {
		JSONObject req = new JSONObject();
		  req.put("username","arjun");
		  req.put("password","Allu");
		  baseURI = "http://localhost:9999/user";
		  given().body(req.toJSONString()).header("Content-Type","application/json")
		  .contentType(ContentType.JSON).
		  when().post("/login").then().statusCode(200).log().all();
	}
}
	


