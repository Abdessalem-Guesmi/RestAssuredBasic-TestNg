package apiTest;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class TestApiUsers {

	@Test(groups = { "E2E" }, priority = 1)
	public void testGetUsers() {
		baseURI = "http://localhost:3000/";
		given().headers("content-type", "application/json").contentType("Content-Type: application/json; charset=utf-8")
				.get("users").then().statusCode(200).log().all();

	}

	@Test(groups = { "E2E" }, priority = 2)
	public void testAddUser() {
		JSONObject user = new JSONObject();

		user.put("lname", "abdessalem");
		user.put("fname", "Guesmi");
		user.put("departmentId", 2);
		baseURI = "http://localhost:3000/";
		given().headers("Content-Type", "Application/Json").contentType(ContentType.JSON).body(user.toJSONString())
				.when().post("users").then().statusCode(201).log().all();

	}

	@Test(groups = { "E2E" }, priority = 3)
	public void testPutUser() {
		JSONObject user = new JSONObject();

		user.put("lname", "Guesmi");
		user.put("fname", "Abdessalem");
		user.put("departmentId", 2);
		baseURI = "http://localhost:3000/";
		given().headers("Content-Type", "Application/Json").contentType(ContentType.JSON).body(user.toJSONString())
				.when().patch("users/4").then().statusCode(200).log().all();

	}

	@Test(groups = { "E2E" }, priority = 4)
	public void testPatchUser() {
		JSONObject user = new JSONObject();

		user.put("lname", "Guesmi");
		user.put("fname", "Abdou");
		user.put("departmentId", 1);
		baseURI = "http://localhost:3000/";
		given().headers("Content-Type", "Application/Json").contentType(ContentType.JSON).body(user.toJSONString())
				.when().put("users/4").then().statusCode(200).log().all();

	}

	@Test(groups = { "E2E" }, priority = 5)
	public void testDeleteUser() {

		baseURI = "http://localhost:3000/";
		given().delete("users/5").then().statusCode(200).log().all();

	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("i'm after Method, i will executed after each method");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("i'm after Method, i will executed  before each method");
	}
}
