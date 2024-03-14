package TestScripts;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AddCategoryTest {
	@Test
	public void addcategoryTest() {
		SoftAssert soft = new SoftAssert();
		home.clickCoursesTab();
		home.clickCategoryLink();
		soft.assertTrue(category.getPageHeader().contains("category"));
		category.clickNewButton();
		jutil.pause(2000);
		soft.assertEquals(addCategory.getPageHeader(), "Add New Category");
		
		Map<String>map = excel.readFromExcel("sheet1","Add Category");
		addCategory.setName(map.get("Name"));
		addCategory.clickSave();
		
		soft.assertTrue(course.getSuccessAlertMessage().contains("Category Added Successfully"));
		course.deleteCourse(Web,map.get("Name"));
		soft.assertTrue(course.getSuccessAlertMessage().contains("Category Deleted SuccessFully"));
		if (course.getSuccessAlertMessage().contains("Category Deleted SuccessFully"))
			excel.updateTestStatus("Sheet1","Add Category","Pass", IConstantPath.EXXEL_PATH);
		else
			excel.updateTestStatus("Sheet1","Add Category","Fail", IConstantPath.EXXEL_PATH);
			
			soft.assertAll();
	}
	
	
	 
	

}
