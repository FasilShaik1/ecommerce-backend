package com.restassured.Admin;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import org.json.simple.JSONObject;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.baseURI;


public class AdminUpdateProduct {
	@Test
	public void UpdateProduct() {
		JSONObject obj = new JSONObject();
		  baseURI = "http://localhost:9999/admin/product";
		  obj.put("name","bagbbbs");
		  obj.put("description","college");
		  obj.put("price",1000.0);
		  obj.put("category","element");
		  
		  given().contentType(ContentType.JSON).when().body(obj.toJSONString())
		  .put("/6")
		  .then().statusCode(200).log().all();
	  
		
		
		
		
	}

}
