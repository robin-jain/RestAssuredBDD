Feature:API get request

  @SmokeTest
  Scenario: Verify one author of Post
    Given Perform get operation for "/posts"
    Then I should see the author name as "typicode"

  @SmokeTest
  Scenario: Verify one author of Post1
    Given Perform get operation for "/posts"
    Then I should see the author name as "typicode"