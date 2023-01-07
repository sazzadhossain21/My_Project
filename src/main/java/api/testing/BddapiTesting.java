package api.testing;

public class BddapiTesting {
//	String domin = "https://jsonplaceholder.typicode.com";
//	 @Test(priority =1)
//	public void GetMethodRestAssured() {
//		// Request object
//		RequestSpecification httpRequest = RestAssured.given();
//		// Response object
//		Response response = httpRequest.request(Method.GET, domin +"/posts");
//		// print response in console window
//		String responseBody = response.getBody().asString();
//		System.out.println("Response Body is:" + responseBody);
//
//		// validating headers
//		String contentType = response.header("Content-Type");// capture details of Content-Type header
//		System.out.println("Content Type is:" + contentType);
//		Assert.assertEquals(contentType, "application/json; charset=utf-8");
//
//		// success code validation
//		String title = response.jsonPath().get("[1].title");
//		Assert.assertEquals(title, "qui est esse");
//
//		String contentEncoding = response.header("Content-Encoding");// capture details of Content-Encoding header
//		System.out.println("Content Encoding is:" + contentEncoding);
//		Assert.assertEquals(contentEncoding, "gzip");
//
//	}
//
//	 @Test(priority =6)
//	public void GetMethodRestAssuredBDD() {
//		given().param("Content-Type", "application/json; charset=utf-8")
//		.when()
//		.get(domin+"/posts").
//		then().statusCode(200).statusLine("HTTP/1.1 200 OK")
//				.body("[1].title", equalTo("qui est esse"))
//				.header("Content-Encoding", "gzip").log().all();
//	}
}
