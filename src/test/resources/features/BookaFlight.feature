Feature: Book a flight ticket
  
	@uitest
  Scenario: Search flights between two cities
    Given search page is having from port and to port with Search button
    When select fromport "Portland" and toport "New York"
    When I click search button
    When I select by flight number "234"
    When I enter name as "Kishan"
    When I enter address as "Pundi"
    When I enter city as "Vizag"
    When I enter state as "Andhra Pradesh"
    When I enter zip code as "12345"
    When I enter card number as "1234 1234 1234 1234"
    When I enter name on card as "Kishan Sanapala"
    When I click Purchase Flight button
    Then I see flight is booked
    
    
    @apitest
  Scenario: API test- Verify the youtube id in get response
    Given base uri "https://api.spacexdata.com/v4/launches/latest"
    When method "get"
    Then check youtubeid is "xpl_JnG7rcg" in response