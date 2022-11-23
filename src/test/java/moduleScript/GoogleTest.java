package moduleScript;

import java.lang.reflect.Method;
import java.util.HashMap;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.BaseClass;
import Base.ExcelUtility;
//import pageFactory.LoginPage;

public class GoogleTest extends BaseClass {
	public static String search;


	@Test(dataProvider = "getdata", enabled = true, priority = 1)
	public void google(HashMap<String, String> google) throws Exception {
//		LoginPage loginPage = new LoginPage(driver);
		
		driver.get("https://www.google.co.in/");
		System.out.println("Title name is: " + driver.getTitle());
//		close();
	}

	@Test(dataProvider = "getdata", enabled = true, priority = 2)
	public void googleURL(HashMap<String, String> google) throws Exception {
//		LoginPage loginPage = new LoginPage(driver);
		driver.get("https://www.google.co.in/");
		System.out.println("URL name is: " + driver.getCurrentUrl());
//		close();
	}

	@DataProvider(name = "getdata")
	public static Object[][] gettestdata(Method m) throws Exception {
		String data;
		String testname;
		data = "files\\demotest.xlsx";
		testname = m.getName();
		System.out.println(testname);
		Object[][] testdata = ExcelUtility.getvalues(data, "Test", testname);
		HashMap<String, String> att_map = null;
		Object[][] testdataoutput = new Object[testdata.length - 1][1];
		for (int i = 1; i < testdata.length; i++) {
			att_map = new HashMap<>();
			for (int j = 0; j < testdata[i].length; j++) {
				if (testdata[i][j] == null) {
					att_map.put(testdata[0][j].toString(), "");
				} else {
					att_map.put(testdata[0][j].toString(), testdata[i][j].toString());
				}
			}
			testdataoutput[i - 1][0] = att_map;
			att_map = null;
		}
		return testdataoutput;
	}
}
