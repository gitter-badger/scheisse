*** Settings ***

Library    Selenium2Library

*** Variables ***

${URL}=    http://matrix:8080/server-web-1.0-SNAPSHOT/faces/userList.xhtml

*** Keywords ***

Open Browser To User List Page
    Open Browser    ${URL}    Firefox

Is User List Page
    Wait Until Page Contains Element    xpath=//h1[@id="userlist-title"]

Check Elements
    Wait Until Page Contains Element    xpath=//ul[@id="users-list"]

User List
    Open Browser To User List Page
    Is User List Page
    Check Elements
