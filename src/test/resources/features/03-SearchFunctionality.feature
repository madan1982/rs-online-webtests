Feature: Search functionality
  @search
  Scenario: search from home screen and select top categories from search results

    #Launch Home page and accept cookies
    Given customer opened homepage
    And customer accept cookies by clicking on Ok I understand
    #Search for item choose one of top categories from search results
    When customer search for temperature and click search icon
    And customer selects top category temperature-probes
    #Apply filters
    And customer applies main filter Brand and sub filter Hanna Instruments and close sub filter popup
    And customer applies main filter Probe Type and sub filter Penetration and close sub filter popup
    And customer clicks on Apply Filters on main screen
    #print results
    Then print search results


  Scenario: search from home screen and select category from search hint

    #Launch Home page and accept cookies
    Given customer opened homepage
    And customer accept cookies by clicking on Ok I understand
    #Search for item choose one of categories from search hint results
    When customer search for printer and do NOT click on search Icon
    And customer selects search hint category Portable Printers & Thermal Printers
    #Apply filters
    And customer applies main filter Printer Type and sub filter Thermal and do NOT Close filter pop-up
    And customer clicks on Apply Filters on sub category filter pop-up
    #print results
    Then print search results


  Scenario: search from home screen and select category from side menu

    #Launch Home page and accept cookies
    Given customer opened homepage
    And customer accept cookies by clicking on Ok I understand
    #Search for item choose one of categories of search results from side menu
    When customer search for 3D and click search icon
    And customer selects product category 3D Printing Parts & Accessories from side menu of search results
    #Apply filters
    And customer applies main filter Nozzle Material and sub filter Brass and do NOT Close filter pop-up
    And customer clicks on Apply Filters on sub category filter pop-up
    #print results
    Then print search results



