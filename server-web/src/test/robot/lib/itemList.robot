*** Settings ***

Library    Selenium2Library

*** Variables ***

${URL}=    http://matrix:8080/server-web-1.0-SNAPSHOT/faces/itemList.xhtml

*** Keywords ***

Open Browser To Item List Page
    Open Browser    ${URL}    Firefox

Is Item List Page
    Wait Until Page Contains Element    xpath=//h1[@id="itemlist-title"]

Check Elements
    Wait Until Page Contains Element    xpath=//table[@id="item-table"]
    Wait Until Page Contains Element    xpath=//th[@id="item-name-header"]
    Wait Until Page Contains Element    xpath=//th[@id="item-type-header"]

Item List
    Open Browser To Item List Page
    Is Item List Page
    Check Elements
