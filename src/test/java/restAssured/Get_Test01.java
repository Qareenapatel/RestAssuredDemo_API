package restAssured;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

import static io.restassured.matcher.ResponseAwareMatcher.*;
import static org.hamcrest.Matchers.*;

import org.hamcrest.Matcher;

public class Get_Test01 {

	@Test
	public void test_01() {

		Response response = get("https://reqres.in/api/users?page=2");

		System.out.println(response.getStatusCode());
		System.out.println(response.getBody().asString());
		System.out.println(response.asString());
		System.out.println(response.getStatusLine());
		System.out.println(response.getHeader("content-Type"));
		System.out.println(response.getTime());

		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);

	}

	@Test
	public void getAllUsers() {
		given().headers("content-Type", "application/json;charset=utf-8").get("https://reqres.in/api/users?page=2")
				.then().statusCode(200).body("data.id[0]", equalTo(7)).and()
				.body("data.first_name[0]", equalTo("Michael"))
				.log().all();
		

	}

}
