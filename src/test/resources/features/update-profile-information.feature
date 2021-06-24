# Author: Hader Pelaez - jhpelaezn@gmail.com
# encoding: utf-8

Feature: Update profile information
  As a user
  I want to update my information
  To maintain updated my information

	@wappiTest
  Scenario Outline: update profile successfully
    Given that the user is in personal information window
    When the user update his information with the values '<name>' '<lastName>' '<birthDate>' '<country>' '<sex>'
    Then the user should see the message '<message>'

    Examples: 
      | name   | lastName | birthDate  | country  | sex       | message 															 |
      | Pepito | Perez    | 12/12/1992 | Colombia | Masculino | Tu información se guardó correctamente |
