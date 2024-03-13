package com.restassured.User;


import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class UserGetByProductId {
  @Test
  public void UserRelated() {
	  baseURI="http://localhost:9999/user/products";
	  given().get("/6").then().statusCode(200).log().all();
  }
}
