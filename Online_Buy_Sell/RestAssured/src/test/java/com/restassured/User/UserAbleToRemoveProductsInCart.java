package com.restassured.User;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.when;
import org.testng.annotations.Test;

public class UserAbleToRemoveProductsInCart {
	@Test
	public void UserRelated() {
		  baseURI = "http://localhost:9999/user/cart/remove";
		  when()
		  .delete("/22").then().statusCode(200).log().all();
	  }


}
