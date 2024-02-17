package endpoints;

import java.io.File;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.SetBaseAuth;
import org.json.simple.JSONObject;
import static io.restassured.RestAssured.given;

public class UserApis {
	
	public static Response postRequest(JSONObject jsondata) {
		
		
		Response response = given()
				.spec(SetBaseAuth.basicAuthentication())
				.contentType("application/json")
				.accept("application/json")
				.body(jsondata)
				.when()
				.post(GivenPaths.NEWUSERCREATION);
		return response;
	}
	
	public static Response getRequestbyId(Integer userid) {
		Response response = given()
				.spec(SetBaseAuth.basicAuthentication())
				.pathParam("userid",userid)
				.when()
				.get(GivenPaths.GETUSERBYID);
		return response;
	}
	
	public static Response getRequestbyName(String username) {
		Response response = given()
				.spec(SetBaseAuth.basicAuthentication())
				.pathParam("username",username)
				.when()
				.get(GivenPaths.GETUSERBYNAME);
		return response;
	}
	
	public static Response getRequestallUsers() {
		Response response = given()
				.spec(SetBaseAuth.basicAuthentication())
				.when()
				.get(GivenPaths.GETALLUSERS);
		return response;
	}
	public static Response putRequest(JSONObject jsondata,Integer userid) {
		Response response = given()
				.spec(SetBaseAuth.basicAuthentication())
				.contentType("application/json")
				.accept("application/json")
				.pathParam("userid", userid)
				.body(jsondata)
				.when()
				.put(GivenPaths.PUTUSERID);
		return response;
	}
	public static Response deleteRequestbyId(Integer userid) {
		Response response = given()
				.spec(SetBaseAuth.basicAuthentication())
				.pathParam("userid", userid)
				.when()
				.delete(GivenPaths.DELETEBYID);
		return response;
	}
		
	public static Response deleteRequestbyName(String username) {
		Response response = given()
				.spec(SetBaseAuth.basicAuthentication())
				.pathParam("username", username)
				.when()
				.delete(GivenPaths.DELETEBYNAME);
		return response;
	}

}
