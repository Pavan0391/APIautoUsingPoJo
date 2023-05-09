package api.testCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;
import api.endPoints.UserEndPoints2;
import api.payloads.User;
import io.restassured.response.Response;

public class UserTests {
	
	Faker faker;
	User userPayload;
	
	public Logger logger;
	
	@BeforeClass
	public void setupData() {
		
		faker=new Faker();
		userPayload= new User();
		
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5, 10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		
		//logs
		logger=LogManager.getLogger(this.getClass());
		}
	
	@Test(priority=0)
	public void testPostUser() {
		logger.info("*******Creating User*********");
		Response response=UserEndPoints2.createUser(userPayload);
		response.then().log().all();
		logger.info("*******User Created*********");
	}
	
	@Test(priority=1)
	public void testGetUser() {
		logger.info("*******Reading User Info*********");
		Response response=UserEndPoints2.readUser(this.userPayload.getUsername());
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("*******User info displayed*********");
	}
	
	@Test(priority=2)
	public void testUpdateUser() {
		
		logger.info("*******Updating User*********");
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		
		Response response=UserEndPoints2.updateUser(this.userPayload.getUsername(),userPayload);
		Assert.assertEquals(response.getStatusCode(), 200);
		
		Response responseAfterUpdate=UserEndPoints2.updateUser(this.userPayload.getUsername(),userPayload);
		responseAfterUpdate.then().log().all();
		logger.info("*******User is Updated*********");
	}
	
	@Test(priority=3)
	public void testDeleteUser() {
		logger.info("*******Deleting User*********");
		Response response=UserEndPoints2.deleteUser(this.userPayload.getUsername());
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("*******User Deleted*********");
	}
	

}
