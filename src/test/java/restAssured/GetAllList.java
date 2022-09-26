package restAssured;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


import org.testng.annotations.Test;



public class GetAllList {

		@Test
	public void getAllUsers() {
		given().headers("content-Type", "application/json;charset=utf-8").
		get("https://reqres.in/api/users?page=2")
				.then().
				statusCode(200).
				body("data.id[0]", equalTo(7)).
				body("data.first_name", hasItems("Michael","Lindsay"))
				.log().all();
		

	}

		
}
