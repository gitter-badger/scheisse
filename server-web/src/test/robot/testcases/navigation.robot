*** Settings ***

Resource            ../lib/index.robot
Resource            ../lib/itemList.robot
Resource            ../lib/register.robot
Resource            ../lib/userList.robot

*** Testcases ***

Index To User List
    Open Browser To Index Page
    Click Element    xpath=//*[@id="users-link"]
    Is User List Page

Index To Register
    Go To Index Page
    Click Element    xpath=//*[@id="register-link"]
    Is Register Page

Index To Item List
    Go To Index Page
    Click Element    xpath=//*[@id="items-link"]
    Is Item List Page

Close
    Close Browser
