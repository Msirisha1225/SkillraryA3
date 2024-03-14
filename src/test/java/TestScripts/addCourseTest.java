package TestScripts;

import java.util.Map;

import org.testng.asserts.SoftAssert;

public class addCourseTest {

	@Test
	public void addCourseTest() {
		SoftAssert soft = new SoftAssert();
		home.clickCoursesTab();
		home.clickCourseListLink();
		soft.assertTrue(course.getPageHeader().contains("Course List"));
		course.clickNewButton();
		soft.assertEquals(course.getPageHeader(), "Course List");
		Map<String, String> map = excel.readFromExcel("Sheet1", "Course List");
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
