package tests;

import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import endpoints.UserApis;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import utilities.CreateTempJsonFile;

public class PostScenarios {

	Response response;

	public static Integer userid1;
	public static String username1;
	public static Integer userid2;
	public static String username2;
	public static JSONArray givendataobj;

	@Test(priority =0)
	public void postNewUserCreation() throws IOException, ParseException
	{
		givendataobj=CreateTempJsonFile.readdatafromjson();
		
		for (Object propobj : givendataobj) {
			
			JSONObject scenario = (JSONObject)propobj;
			// Get the scenario name
			String scenarioName = (String) scenario.get("scenarioname");
			// Filter based on scenario name
			if ("1Post new user creation".equals(scenarioName)) {
				JSONArray givendata = (JSONArray) scenario.get("data");
				for (Object d : givendata) {
					JSONObject postData = (JSONObject) d;
					// Make POST request using RestAssured
					response = UserApis.postRequest(postData);		
					response.then().log().all();
						
					if (response.getStatusCode()==201) {
						JsonPath js = new JsonPath(response.asString());
						if (js.getString("user_first_name").equals("APISquadone")) {
							userid1=js.getInt("user_id");
							username1=js.getString("user_first_name");
						}
						else
						{
							userid2=js.getInt("user_id");
							username2=js.getString("user_first_name");
						}
						Assert.assertEquals(response.getStatusCode(),201);
						Assert.assertEquals(response.header("Content-Type"),"application/json");
						//Schema Validation
						//response.then().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemasfiles/postjsonschema.json")).extract().response();		
					}
				}
			}
		}

	}

}
