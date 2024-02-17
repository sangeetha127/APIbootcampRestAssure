package tests;

import java.time.LocalDateTime;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import endpoints.GivenPaths;
import endpoints.UserApis;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import utilities.CreateTempJsonFile;

public class PutScenarios {

	Response response;
	
	
	@Test(priority=3)
	public void putUserbyId()
	{
		//extract data for put		
		for (Object propobj : PostScenarios.givendataobj) {
			
			JSONObject scenario = (JSONObject)propobj;
			// Get the scenario name
			String scenarioName = (String) scenario.get("scenarioname");
			// Filter based on scenario name
			if ("Putbyuserid".equals(scenarioName)) {
				JSONArray givendata = (JSONArray) scenario.get("data");
				for (Object d : givendata) {
					JSONObject postData = (JSONObject) d;
					
					// Make POST request using RestAssured
					response = UserApis.putRequest(postData,PostScenarios.userid1);		
					response.then().log().all();
					Assert.assertEquals(response.getStatusCode(),200);
					if (response.getStatusCode()==200) {
						JsonPath js = new JsonPath(response.asString());
						System.out.println("put response addressid " +js.get("userAddress.addressId"));
						System.out.println("put response lastmodtime " +js.get("last_mod_time"));
						
						Assert.assertEquals(GetScenarios.addressid, js.get("userAddress.addressId"));
						Assert.assertNotEquals(GetScenarios.lastmodtime,js.get("last_mod_time"));
					}
					}
				}
			}
	}
	
}
