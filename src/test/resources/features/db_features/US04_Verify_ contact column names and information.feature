@DBUS04 @db

Feature:Verify contacts column names and information

  Scenario: Verify contact column names
    When user execute the query to get "SELECT * FROM contacts" column names
    Then user should get all column names from the "contacts" table with "SELECT * FROM contacts"
      | status     |
      | created_at |
      | id         |
      | email      |
      | first_name |
      | last_name  |
      | message    |


 Scenario Outline: TC02_user verify entered info appeared on database
   Then user verify entered information is formed on database "<email>", "<first_name>", "<last_name>", "<message>"
   And user close database
   Examples:
     | email            | first_name | last_name | message     |
     | mmerve@gmail.com | yyuksek    | yuksek    | Hello world |

     | isimsiz@gmail.com | Isimsiz    | Kahraman  | Hersey guzel olacak |

