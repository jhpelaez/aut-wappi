# Author: Hader Pelaez - jhpelaezn@gmail.com
# encoding: utf-8

Feature: Request an order with and without welcome coupon
  as a user
  I want to select a product
  To request an order

	@wappiTest
  Scenario Outline: request an order with welcome coupon
		Given that the user is in the wappi home page
		When the user do a request with the welcome coupon of the '<product>'
		Then the user should see the '<product>' in the order window 
		And the user should see the coupon state in 'Si'
		
		Examples:
			| product           |
			|	Aceite de Girasol |

	@wappiTest
  Scenario Outline: request an order without welcome coupon
    Given that the user is in the wappi home page
		When the user do a request without the welcome coupon of the '<product>'
		Then the user should see the '<product>' in the order window 
		And the user should see the coupon state in 'No'
		
		Examples:
			| product    |
			|	Pan tajado |
		
	@wappiTest	
	Scenario Outline: validate maximum number of coupon uses 
		Given that the user is in the wappi home page
		When the user do three request with the same coupon of the products '<product1>' '<product2>' '<product3>'
		Then the user should see the error in the order window with the '<message>'
		
		Examples:
			| product1   | product2          | product3          | message        |
			| Pan tajado | Aceite de Girasol | Aceite de Girasol | Cupón inválido |