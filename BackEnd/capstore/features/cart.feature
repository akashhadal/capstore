Feature: Managing Cart Features 

Background: 
	Given User has loaded the Application in the browser 
	When User enter valid email and valid password 
	And click on login button 
	Then User should get navigated to User home page 
	
Scenario: User can add product into cart 
	Given User is on User Home Page 
	When User clicks On Product List 
	Then Product list should Display 
	When User Click on the product to be added 
	And Click on add to cart button 
	Then Required product should be added to the cart 
	
Scenario: User can View Product in cart 
	Given User is on User Home Page 
	When User clicks On Cart 
	Then Cart list should Display 
	
Scenario: User Can delete product from cart 
	Given User is on User Home Page 
	When User clicks on show all cart products button 
	Then It should show all cart products 
	When User clicks on remove button for a particular product 
	Then The product should get removed 
