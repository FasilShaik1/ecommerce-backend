package com.restassured.Admin;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.when;

import org.testng.annotations.Test;

public class AdminDeleteProduct {
	@Test
	public void Deleteprouctbyid() {
		  baseURI = "http://localhost:9999/admin/product";
		  when()
		  .delete("/8").then().statusCode(200).log().all();
	  }

}
