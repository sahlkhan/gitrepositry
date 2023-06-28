package Test_Classes;

import java.io.IOException;
import java.time.LocalDateTime;

import org.testng.Assert;
import org.testng.annotations.Test;

import Common_Api_methods.Api_Methods;
import RequestRepository.Post_Req_Repositry;
import io.restassured.path.json.JsonPath;

public class Post_TC1 {
	@Test
	public static void Extractor() throws IOException {
		int statuscode = Api_Methods.ResponseStatusCode(Post_Req_Repositry.BaseURI(),Post_Req_Repositry.Post_Resourse(),Post_Req_Repositry.Post_Reg_TC1());
		System.out.println( statuscode);
		String ResponseBody=Api_Methods.ResponseBody(Post_Req_Repositry.BaseURI(),Post_Req_Repositry.Post_Resourse(),Post_Req_Repositry.Post_Reg_TC1());
		//System.out.println( ResponseBody);
		
		JsonPath JspRequest = new JsonPath(Post_Req_Repositry.Post_Reg_TC1());
		String req_name=JspRequest.getString("name");
		String req_job=JspRequest.getString("job");
		LocalDateTime currentdate=LocalDateTime.now();
		String expecteddate=currentdate.toString().substring(0,9);
		JsonPath JspResponse =new JsonPath(ResponseBody);
		String res_name=JspResponse.getString("name");
		String res_job=JspResponse.getString("job");
		String res_createdAt=JspResponse.getString("createdAt");
		res_createdAt=res_createdAt.substring(0,9);
		System.out.println(res_name);
		System.out.println(res_job);
		//validate status body parameter
		Assert.assertEquals(res_name,req_name);
		Assert.assertEquals(res_job,req_job);
		Assert.assertEquals(res_createdAt,expecteddate);
	}
}

