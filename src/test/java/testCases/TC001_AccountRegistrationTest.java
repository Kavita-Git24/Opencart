package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;


public class TC001_AccountRegistrationTest extends BaseClass{
	
	@Test
	public void verify_account_registration()
	{
		logger.info("***** Starting TC001_AccountRegistrationTest ******");
		try
		{
			HomePage hp=new HomePage(driver);
			
			hp.clickMyAccount();		
			logger.info("***** Clicked on MyAccount ******");
			
			hp.clickRegister();
			logger.info("***** Clicked on Register ******");
			
			AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
			/*regpage.setFirstName("John");
			regpage.setLastName("Smith");
			regpage.setEmail("abc45@gmail.com");
			regpage.setTelephone("123456789");
			regpage.setPassword("abc@123");
			regpage.setConfirmPassword("abc@123");*/
			logger.info("***** Providing customer details ******");
			regpage.setFirstName(randomeString().toUpperCase());
			regpage.setLastName(randomeString().toUpperCase());
			regpage.setEmail(randomeString()+"@gmail.com");
			regpage.setTelephone(randomeNumber());
			
			String password=randomeAlphaNumeric();
			regpage.setPassword(password);
			regpage.setConfirmPassword(password);
			regpage.setPrivatePolicy();
			regpage.clickContinue();		
			
			logger.info("***** Validating expected message ******");
			String confmsg=regpage.getConfirmationMsg();
			if(confmsg.equals("Your Account Has Been Created!"))
			{
				Assert.assertTrue(true);
				//System.out.println("Passed my test");
			}
			else
			{
				logger.error("Test failed");
				logger.debug("Debug logs...");
				Assert.assertFalse(false);
			}			
		}
		catch(Exception e)
		{			
			Assert.fail();
		}
		logger.info("***** Finished TC001_AccountRegistrationTest ******");
	}	
	
}
