Feature: Application Login 

Scenario: Home page default login 
	Given User is on landing page 
	When User login into application with username "Admin" and password "admin123" 
	Then Home page is populated 
	And Cards are displayed 
	
Scenario: Home page default login 
	Given User is on landing page 
	When User login into application with username "Invalid" and password "Invalid" 
	Then Error message is populated 
	
