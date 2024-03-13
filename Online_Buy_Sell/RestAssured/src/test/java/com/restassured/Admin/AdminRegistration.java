package com.restassured.Admin;
import static io.restassured.RestAssured.given;


import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.baseURI;


public class AdminRegistration {
	@Test
	public void AdminRelated() {
		JSONObject req = new JSONObject();
		  req.put("username","sijjhu");
		  req.put("password","Allu");
		  baseURI = "http://localhost:9999/admin";
		  given().body(req.toJSONString()).header("Content-Type","application/json")
		  .contentType(ContentType.JSON).
		  when().post("/register").then().statusCode(200).log().all();
	}
}
	


