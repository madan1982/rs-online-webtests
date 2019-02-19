Feature: E2E journey to checkout
  @checkout @newCustomer
  Scenario Outline: Select main and sub product from All Products, Select final product, add and Guest checkout from basket icon

    #Launch Home page and accept cookies
    Given customer opened homepage
    And customer accept cookies by clicking on Ok I understand

    #select sub product category from main product and then final product
    When customer selects <mainProductCategory> and <subProductCategory> from All products menu
    And customer clicks on <finalProductCategory> with in <subProductCategory> for <mainProductCategory>

    #Add products from list of products displayed
    And customer adds <productsToAdd> to cart from list of products
    And customer clicks on shopping basket icon on top right corner of screen to checkout

    #verify products are added in summary screen
    And customer verifies all added products <productsToAdd> displayed in basket summary screen
    And customer clicks on Checkout securely

    #Choose Guest checkout
    And customer chooses Guest checkout after entering email address abc@test.com

    #Fill delivery details
    And customer fills in Delivery with Title Mr., FirstName Tom, SurName Bennett and ContactNumber 01908123123
    And fill address with Name Tom, TradingName AnyRepairs, AddressLine1 Dump Road, AddressLine2 Shoreditchplace, Town Northampton, County Northamptonshire and PostCode NN1 2ED and continue to payment

    Then customer should see Payment screen


    Examples:
    |mainProductCategory|subProductCategory|finalProductCategory|productsToAdd|
    |batteries       |rechargeable-batteries|aa-rechargeable-batteries|617-0773,769-8755,611-8674|
    |pneumatics-hydraulics-power-transmission|pneumatic-hydraulic-pressure-gauges|pressure-gauge-adaptors|257-8943|