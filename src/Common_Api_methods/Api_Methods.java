package Common_Api_methods;

import static io.restassured.RestAssured.given;
import io.restassured.path.json.JsonPath;
import io.restassured.RestAssured;

public class Api_Methods {
	
	public static int ResponseStatusCode(String BaseURI,String Resourse,String RequestBody) {
		
		RestAssured.baseURI = BaseURI;
		
		int statuscode=given().header("Content-Type","application/json").body(RequestBody).
				when().post(Resourse).then().extract().statusCode();
		return statuscode;
	}

	public static String  ResponseBody(String BaseURI,String Resourse,String RequestBody) {
		
		RestAssured.baseURI = BaseURI;
		
		String ResponseBody=given().header("Content-Type","application/json").body(RequestBody).
				when().post(Resourse).then().extract().response().asPrettyString();
		
		return ResponseBody;
}

}