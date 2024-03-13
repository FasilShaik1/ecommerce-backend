package com.restassured.User;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class UserContactNumberByContactId {
	@Test
	  public void UserRelated() {
		  baseURI = "http://localhost:9999/user/contactnumber";
		  given().get("/2").then().statusCode(200).log().all();
	  }
	

}


