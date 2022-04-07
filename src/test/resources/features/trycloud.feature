Feature: As a user, I should be able to remove files from favorites and upload a file directly

  @removeFav
  Scenario Outline: verify users to remove files to Favorites
    Given user enters "<username>" and "<password>" in the log in page
    When the user clicks the "Files" module
    When the users click action-icon from any file on the page to remove
    And  user choose the Remove from favorites option
    And user click the "Favorites" sub-module on the left side
    Then Verify that the file is removed from the Favorites sub-module’s table
    Examples:credentials
      | username | password    |
      | user7    | Userpass123 |
      | user37   | Userpass123 |
      | user67   | Userpass123 |

  @upload
  Scenario Outline: verify users to upload a file from Files
    Given user enters "<username>" and "<password>" in the log in page
    When the user clicks the "Files" module
    When the user clicks the add icon on the top
    And users uploads "<file>" with the upload file option
    Then verify the "<filenames>" is displayed on the page

    Examples:credentials
      | username | password    | file         | filenames |
      | user7    | Userpass123 | Untitled.png | Untitled  |
      | user37   | Userpass123 | example1.jpg | example1  |
      | user67   | Userpass123 | example3.png | example3  |