package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.*;

public class OrderFlowTest extends BaseTest {

	@Test
	public void completeOrderFlow() {

		String confirmation = new LoginPage()
		        .enterUsername("standard_user")
		        .enterPassword("secret_sauce")
		        .clickLogin()
		        .selectFirstProduct()
		        .goToCart()
		        .clickCheckout()
		        .enterDetails("Ashwini", "Bangalore", "560001")
		        .finishOrder()
		        .getConfirmationText();
		
		System.out.println("Actual confirmation: " + confirmation);

	    Assert.assertTrue(
	            confirmation.contains("Thank you"),
	            "Order confirmation message mismatch"
	    );
	}}