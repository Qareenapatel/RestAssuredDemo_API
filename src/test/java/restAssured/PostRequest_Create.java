package restAssured;

import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import com.google.gson.Gson;

import io.restassured.RestAssured;

public class PostRequest_Create {

	
	@Test
	public void CreateUser() {
		
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("name", "Nikunj");
		map.put("job", "Qa Tester");
		
		System.out.println(map);
		
		Gson gson = new Gson();
		String requestData = gson.toJson(map);
		
		System.out.println(requestData);
		
		RestAssured.
				given().
				headers("content-Type", "application/json;charset=utf-8").
			body(requestData)
			.post("https://reqres.in/api/users")
			
				
				.then().statusCode(201).body("name", equalTo("Nikunj")).
				and()
				.body("job", equalTo("Qa Tester")).log().all();
		
			
	

	}

}
