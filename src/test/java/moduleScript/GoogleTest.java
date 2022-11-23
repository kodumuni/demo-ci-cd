package moduleScript;

import java.lang.reflect.Method;
import java.util.HashMap;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.BaseClass;
import Base.ExcelUtility;
//import pageFactory.LoginPage;

public class GoogleTest extends BaseClass {
   @Test(enabled = true, priority = 1)
    public void google() throws Exception {
        driver.get("https://www.google.co.in/");
        System.out.println("Title name is: " + driver.getTitle());
    }
   @Test(enabled = true, priority = 2)
    public void googleURL() throws Exception {
        driver.get("https://www.google.co.in/");
        System.out.println("URL name is: " + driver.getCurrentUrl());
    }
}
