package TestScripts;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibraries.BaseClass;

public class AddUser extends BaseClass{
	@Test
	public void addUserTest() {
		SoftAssert soft = new SoftAssert();
		home.clickUserTab();
		soft.assertTrue(users.getPageHeader().contains("Users"));
		users.clickNewButton();
		soft.assertEquals(addUser.getPageHeader(), "Add New User");
		
		Map<String,String> map = excel.readFromExcel("Sheet1","Add User");
		addUser.setEmail(map.get("Email"));
		addUser.setPwd(map.get("Password"));
		addUser.setFirstName(map.get("Firstname"));
		addUser.setLastName(map.get("LastName"));
		addUser.setAddress(map.get("Address"));
		addUser.setContact(map.get("Contact Info"));
		addUser.uploadPhoto(map.get("Photo"));
		
		soft.assertTrue(users.getSuccessAlertMessage().contains("Success"));
		soft.assertAll();
		
	}
	

}
