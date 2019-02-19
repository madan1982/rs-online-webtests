Feature: E2E journey to checkout
  @checkout @existingCustomer
  Scenario: Select Brand from Our Brands, select final category, view product, aad to basket and check out from view basket

    #Launch Home page and accept cookies
    Given customer opened homepage
    And customer accept cookies by clicking on Ok I understand

    #Login into site and verify greeting message
    When customer will login with username autotest816 and password password123
    And verify customer is logged in by checking customers name which should be displayed As Alex

    #If customer have items in basket, delete them
    And check customer basket and empty basket if there are items

    #select brand and select product category (should give finalProduct category, sub product category and main product category)
    And customer selects Fluke from Our Brands
    And customer clicks product link clamp-meters with in electrical-test-equipment for test-measurement

    #Add products after navigating to product page, add more products by clicking on Our brands again
    And customer click on each product 765-6984 and click Add to basket
    And customer selects Panasonic from Our Brands
    And customer clicks product link leaded-inductors with in inductors for passive-components
    And customer click on each product 110-1296 and click Add to basket

    #When there are no products to add - click on view basket
    And customer clicks on view basket to checkout

    #verify products are added in summary screen and continue to checkout
    And customer verifies all added products 765-6984,110-1296 displayed in basket summary screen
    And customer clicks on Checkout securely
    And verify customer has delivery address and continue to payment

    Then customer should see Payment screen

