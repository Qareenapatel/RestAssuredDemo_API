package restAssured;

import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;
import java.util.Map;

import org.mozilla.javascript.ObjArray;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.gson.Gson;

import io.restassured.RestAssured;

public class DataDriven_RestAssured {

	@DataProvider(name="dataProvider")
	public Object[][] dataProvider(){
		
		Object[][] data = new Object[4][2];
		
		//FirstRow
		data[0][0] = "john";
		data[0][1] = "Software Tester";
		
		//SecondRow
				data[1][0] = "smith";
				data[1][1] = "Teacher";
				
				//ThirdRow
				data[2][0] = "mona";
				data[2][1] = "Qa Analyst";
				
				//FourthRow
				data[3][0] = "pathik";
				data[3][1] = "Business Analyst";
		
				return data;
	}
				
				
				//or
				
				/*return new Object[][] {
				 * {"john","Software Tester"},
				 * {"smith","Teacher"},
				 * {"mona","Qa Analyst"},
				 * {"pathik","Business Analyst"}}
				 */
		
	@Test(dataProvider="dataProvider")
	public void CreateUser(String name, String job) {
		
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("name", name);
		map.put("job", job);
		
		System.out.println(map);
		
		Gson gson = new Gson();
		String requestData = gson.toJson(map);
		
		System.out.println(requestData);
		
		RestAssured.
				given().
				headers("content-Type", "application/json;charset=utf-8").
			body(requestData)
			.post("https://reqres.in/api/users")
			
				
				.then().statusCode(201).body("name", equalTo(name)).
				and()
				.body("job", equalTo(job)).log().all();
		
			
	

	}
}
