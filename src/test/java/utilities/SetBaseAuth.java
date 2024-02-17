package utilities;

import endpoints.GivenPaths;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class SetBaseAuth {
	//public static RequestSpecification baseauth;
	
	public static RequestSpecification basicAuthentication()
	{
		return RestAssured.given().auth().basic(GivenPaths.USERNAME, GivenPaths.PASSWORD);
	}
	
	
}
