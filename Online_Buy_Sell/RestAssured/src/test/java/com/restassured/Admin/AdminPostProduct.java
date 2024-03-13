package com.restassured.Admin;


import static io.restassured.RestAssured.given;


import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.baseURI;

public class AdminPostProduct{
	
	@Test
	public void AdminRelated() {
		JSONObject req = new JSONObject();
		  req.put("name","bags");
		  req.put("description","school bags");
		  req.put("price",100);
		  req.put("category","school items");
		  baseURI = "http://localhost:9999/admin";
		  given().body(req.toJSONString()).header("Content-Type","application/json")
		  .contentType(ContentType.JSON).
		  when().post("/product").then().statusCode(200).log().all();
	}
}