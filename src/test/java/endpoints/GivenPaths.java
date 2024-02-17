package endpoints;

import java.io.File;

public class GivenPaths {
	
	public static String jsonpath=".\\src/test/resources/Jsonfiles/userdata.json";
	public static File jsonfile = new File(jsonpath);
	public static String BASEURL="https://userapi-8877aadaae71.herokuapp.com/uap/";

	
	//basic auth
	public static String USERNAME="Numpy@gmail.com";
	public static String PASSWORD="tim123";
	//POST Endpoints
	public static String NEWUSERCREATION=BASEURL+"createusers";
	//GET Endpoints
	public static String GETALLUSERS=BASEURL+"users";
	public static String GETUSERBYID=BASEURL+"user/{userid}";
	public static String GETUSERBYNAME=BASEURL+"users/username/{username}";
	//PUT Endpoints
	public static String PUTUSERID=BASEURL+"updateuser/{userid}";
	//DELETE Endpoints
	public static String DELETEBYID=BASEURL+"deleteuser/{userid}";
	public static String DELETEBYNAME=BASEURL+"deleteuser/username/{username}";
	
	
	
}
