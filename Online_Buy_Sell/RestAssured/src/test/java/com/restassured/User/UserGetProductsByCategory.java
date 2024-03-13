package com.restassured.User;



import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class UserGetProductsByCategory {
  @Test
  public void UserRelated() {
	  baseURI="http://localhost:9999/user/products/byCategory";
	  given().get("/nn").then().statusCode(200).log().all();
  }
}
