package Test_Classes;

import org.testng.Assert;
import org.testng.annotations.Test;

import Common_Api_methods.Api_Put_Methods;
import RequestRepository.Put_Req_Repositry;
import io.restassured.path.json.JsonPath;

public class Put_TC1 {
	@Test
	public static void Extractor() {
		int statuscode=Api_Put_Methods.ResponseStatusCode( Put_Req_Repositry.BaseURI(), Put_Req_Repositry.Put_Resourse(), Put_Req_Repositry.Put_Reg_TC1());
		System.out.println(statuscode);
		String ResponseBody=Api_Put_Methods.ResponseBody( Put_Req_Repositry.BaseURI(), Put_Req_Repositry.Put_Resourse(), Put_Req_Repositry.Put_Reg_TC1());
		System.out.println(ResponseBody);
		
		JsonPath JspResponse = new JsonPath(ResponseBody);
		String res_name=JspResponse.getString("name");
		String res_job=JspResponse.getString("job");
		String res_updatedAt=JspResponse.getString("updatedAt");
		System.out.println(res_name);
		System.out.println(res_job);
		res_updatedAt=res_updatedAt.substring(0,11);
		System.out.println(res_updatedAt);
		//validate the responseBody parameters
		Assert.assertEquals(res_name,"morpheus");
		Assert.assertEquals(res_job,"zion resident");
	}
	}