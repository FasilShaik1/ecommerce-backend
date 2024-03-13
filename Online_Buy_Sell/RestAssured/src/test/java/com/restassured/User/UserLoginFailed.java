package com.restassured.User;

import static io.restassured.RestAssured.given;


import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.baseURI;


public class UserLoginFailed {
	@Test
	public void UserRelated() {
		JSONObject req = new JSONObject();
		  req.put("username","arjun");
		  req.put("password","Allus");
		  baseURI = "http://localhost:9999/user";
		  given().body(req.toJSONString()).header("Content-Type","application/json")
		  .contentType(ContentType.JSON).
		  when().post("/login").then().statusCode(401).log().all();
	}
}
	


