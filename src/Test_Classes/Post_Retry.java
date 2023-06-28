package Test_Classes;
import io.restassured.path.json.JsonPath;

import java.io.IOException;
import java.time.LocalDateTime;
import org.testng.Assert;
import org.testng.annotations.Test;

import Common_Api_methods.Api_Methods;
import Common_Api_methods.Common_Utility_Method;
import RequestRepository.Post_Req_Repositry;

public class Post_Retry {
	@Test (priority=2)

	public static void Extractor() throws IOException {
		System.out.println("Extractor method call");
		for(int i=0; i<5; i++)
		{
			int statuscode=Api_Methods.ResponseStatusCode(Post_Req_Repositry.BaseURI(),Post_Req_Repositry.Post_Resourse(),Post_Req_Repositry.Post_Reg_TC1());
			System.out.println(statuscode);
			if(statuscode==201)
			{
				String  ResponseBody =Api_Methods.ResponseBody(Post_Req_Repositry.BaseURI(), Post_Req_Repositry.Post_Resourse(),Post_Req_Repositry.Post_Reg_TC1());
				System.out.println(ResponseBody);
				
				
			//validator RequestBody and ResponseBody
				String RequestBody=Post_Req_Repositry.Post_Reg_TC1();
				Common_Utility_Method.Evidencecreator("Post_Evidence",ResponseBody,RequestBody,statuscode);
				//validator(ResponseBody,RequestBody);
				break;
		    }
			else
			{
				System.out.println("statuscode is incorrect");
			}
	    }
     }
	@Test (priority=1)
	public static void validator(String ResponseBody, String RequestBody) throws IOException {
		System.out.println("validator method call");
		//expected result
		JsonPath JspRequest = new JsonPath(Post_Req_Repositry.Post_Reg_TC1());
		String req_name = JspRequest.getString("name");
		String req_job = JspRequest.getString("job");
		
		LocalDateTime currentdate = LocalDateTime.now();
		String expecteddate = currentdate.toString().substring(0,12);
	    //create a object  JsonPath to parse the ResponseBody
		JsonPath  JspResponse = new JsonPath(ResponseBody);
		String res_name = JspResponse.getString("name");
		String res_job = JspResponse.getString("job");
		String res_createdAt = JspResponse.getString("createdAT");
		res_createdAt=res_createdAt.substring(0,12);
//Validate ResponseBody
		Assert.assertEquals(res_name,req_name);
		Assert.assertEquals(res_job,req_job);
		Assert.assertEquals(res_createdAt,expecteddate);
		
	}
}

	