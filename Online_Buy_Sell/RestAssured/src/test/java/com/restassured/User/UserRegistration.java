package com.restassured.User;

import static io.restassured.RestAssured.given;


import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.baseURI;


public class UserRegistration {
	@Test
	public void UserRelated() {
		JSONObject req = new JSONObject();
		  req.put("username","araajun");
		  req.put("password","Allu");
		  req.put("contactid",3);
		  req.put("contactnumber",987543229);
		  baseURI = "http://localhost:9999/user";
		  given().body(req.toJSONString()).header("Content-Type","application/json")
		  .contentType(ContentType.JSON).
		  when().post("/register").then().statusCode(200).log().all();
	}
}
	


