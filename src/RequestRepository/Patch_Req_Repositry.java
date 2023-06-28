package RequestRepository;

public class Patch_Req_Repositry {
	public static String BaseURI() {
		String BaseURI="https://reqres.in/";
		return BaseURI;
	}
	public static String Patch_Resourse() {
		String Patch_Resource = "api/users/2";
		return Patch_Resource;
	}
	public static String Patch_Reg_TC1() {
		String RequestBody = "{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"zion resident\"\r\n"
				+ "}";
		return RequestBody;
	}
}

