package restAssured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class DeleteRequest {

	@Test
	public void DeleteUser() {

		RestAssured.given()

				.delete("https://reqres.in/api/users/2")

				.then().statusCode(204).log().all();

	}

}
