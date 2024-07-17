Feature: Registrarse en Para Bank
  @reto
  Scenario Outline: Registro exitoso
    Given El usuario quiere registrarse en el homepage
    When  El usuario llena los campos personales
      | firstName   | lastName   | address   | city   | state   | zip   | phone   | ssn |
      | <firstName> | <lastName> | <address> | <city> | <state> | <zip> | <phone> | <ssn> |
    *  El usuario llena los campos de la cuenta e intenta registrarse
      | username   | password   | confirmPassword   |
      | <username> | <password> | <confirmPassword> |
    Then El usuario deberia ver el mensaje "<mensaje>"
    * El nuevo usuario deberia poder loguearse
      | username   | password   |
      | <username> | <password> |

    Examples:
        | firstName  | lastName | address | city | state | zip | phone       | ssn | username | password | confirmPassword | mensaje |
        | Random6      | Random6      | 123 St  | NY   | NY    | 123 | 999878788   | 123 | Random6  | 213123   | 213123          | Your account was created successfully. You are now logged in. |


