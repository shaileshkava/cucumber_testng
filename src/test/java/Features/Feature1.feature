Feature: This is Testng feature file
	Scenario: First scenario for testng runner
		Given Open applicatoin url
		When Enter message "this is test message"
		Then Verify entered message
		
	Scenario: Verify facebook login page title
		Given open facebook login page "https://www.fb.com"
		When verify page title "Facebook – log in or sign up"