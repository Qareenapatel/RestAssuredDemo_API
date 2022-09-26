package restAssured;

import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import com.google.gson.Gson;

import io.restassured.RestAssured;

public class PutRequest_Update {

	
	@Test
	public void UpdateUser() {
		
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("name", "Raghav");
		map.put("job", "Teacher");
		
		System.out.println(map);
		
		Gson gson = new Gson();
		String requestData = gson.toJson(map);
		
		System.out.println(requestData);
		
		RestAssured.
				given().
				headers("content-Type", "application/json;charset=utf-8").
			body(requestData)
			.put("https://reqres.in/api/users/2")
			
				
				.then().statusCode(200).body("name", equalTo("Raghav")).
				and()
				.body("job", equalTo("Teacher")).log().all();
		
			
	

	}

}
