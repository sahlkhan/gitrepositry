package RequestRepository;

import java.io.IOException;
import java.util.ArrayList;

import Common_Api_methods.Common_Utility_Method;

public class Post_Req_Repositry {

	public static String BaseURI() {
		String baseURI = "https://reqres.in/";
		return baseURI;
	}
	public static String Post_Resourse() {
		String Post_Resourse ="api/users";
		return Post_Resourse;
}
	public static String Post_Reg_TC1() throws IOException {
		ArrayList<String> Req_Data=Common_Utility_Method.ReadDataExcel("Post","TC1");
		//System.out.println("Req_Data");
		String Req_Name=Req_Data.get(1);
		String Req_job=Req_Data.get(2);
		String RequestBody = "{\r\n"
				+ "    \"name\": \""+Req_Name+"\",\r\n"
				+ "    \"job\": \""+Req_job+"\"\r\n"
				+ "}";
		return RequestBody;
	}
}