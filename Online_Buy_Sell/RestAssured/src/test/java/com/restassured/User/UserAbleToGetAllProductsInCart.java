package com.restassured.User;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;



public class UserAbleToGetAllProductsInCart {
	@Test
	  public void UserRelated() {
		  baseURI = "http://localhost:9999/user/cart";
		  given().get("/getAll").then().statusCode(200).log().all();
	  }
	

}
