package tests;

import java.time.LocalDateTime;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import endpoints.UserApis;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetScenarios {
	Response response;
	public static Integer addressid;
	public static String lastmodtime;

	@Test(priority =2)
	public void getUserById()
	{
		response = UserApis.getRequestbyId(PostScenarios.userid1);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);
		System.out.println("inside get response");
		JsonPath js = new JsonPath(response.asString());
		addressid=js.getInt("userAddress.addressId");
		lastmodtime=js.getString("last_mod_time");
		System.out.println("get response addressid " +addressid);
		System.out.println("get response lastmodtime " +lastmodtime);

	}
	@Test(priority=1)
	public void getAllUsers()
	{
		response = UserApis.getRequestallUsers();
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);
	}

}
