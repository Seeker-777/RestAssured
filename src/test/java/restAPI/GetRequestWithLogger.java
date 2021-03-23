package restAPI;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.Assert;

public class GetRequestWithLogger {
	
	
	static Logger logger = Logger.getLogger(GetRequestWithLogger.class);
	
	Response response;
	
	@BeforeTest
	public void setup() {
		
		PropertyConfigurator.configure("log4j.properties");
		logger.setLevel(Level.DEBUG);
		
		response = RestAssured.given()
							.baseUri("http://localhost:8088/employees")
							.when()
							.get();
	}
	
	@Test
	public void test1() {
		
		logger.info("********Inside CheckStatus*********");
		
		int statusCode = response.getStatusCode();
		
		logger.info("StatusCode ==>" + statusCode);
		
		Assert.assertEquals(statusCode, 200);
	}

}
