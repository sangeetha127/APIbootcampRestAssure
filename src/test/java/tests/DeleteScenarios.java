package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import endpoints.UserApis;
import io.restassured.response.Response;

public class DeleteScenarios {
Response response;
		
	@Test(priority=4)
	public void deleteUserById()
	{
		System.out.println(" delete userid "+PostScenarios.userid1);
		response = UserApis.deleteRequestbyId(PostScenarios.userid1);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);
	}
	
	@Test(priority=5)
	public void deleteUserByName( ) {
		System.out.println(" delete username "+PostScenarios.username2);
		response = UserApis.deleteRequestbyName(PostScenarios.username2);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);
	}
}
