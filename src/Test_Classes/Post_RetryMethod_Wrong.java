package Test_Classes;

import java.io.IOException;
import java.time.LocalDateTime;

import org.testng.Assert;
import org.testng.annotations.Test;

import Common_Api_methods.Api_Methods;
import RequestRepository.Post_Req_Repositry;
import io.restassured.path.json.JsonPath;

public class Post_RetryMethod_Wrong {
	@Test
	public static void Extractor() throws IOException {
		for(int i=0; i<5; i++)
		{
			int statuscode=Api_Methods.ResponseStatusCode(Post_Req_Repositry.BaseURI(),Post_Req_Repositry.Post_Resourse(),Post_Req_Repositry.Post_Reg_TC1());
			System.out.println(statuscode);
			if(statuscode==200)
			{
				String  ResponseBody =Api_Methods.ResponseBody(Post_Req_Repositry.BaseURI(), Post_Req_Repositry.Post_Resourse(),Post_Req_Repositry.Post_Reg_TC1());
				System.out.println(ResponseBody);
				
			//Validator RequestBody and ResponseBody
				
			    //Validate requestBody
				JsonPath JspRequest = new JsonPath(Post_Req_Repositry.Post_Reg_TC1());
				String req_name = JspRequest.getString("name");
				String req_job = JspRequest.getString("job");
				LocalDateTime currentdate = LocalDateTime.now();
				String expecteddate = currentdate.toString().substring(0,10);
			    //create a object  JsonPath to parse the ResponseBody
				JsonPath  JspResponse = new JsonPath(ResponseBody);
				String res_name = JspResponse.getString("name");
				String res_job =JspResponse.getString("job");
				String res_createdAt =JspResponse.getString("createdAt");
				res_createdAt = res_createdAt.substring(0,10);
			    //Validate ResponseBody
				Assert.assertEquals(res_name,req_name);
				Assert.assertEquals(res_job,req_job);
				Assert.assertEquals(res_createdAt,expecteddate);
				break;
		}
			else
			{
				System.out.println("statuscode is incorrect");
			}
	}
 }
}


