*** Settings ***

Resource            ../lib/index.robot

*** Testcases ***

Index To User List
    Open Browser To Index Page
    Click Element    xpath=//*[@id="users-link"]
    Wait Until Page Contains Element    xpath=//h1[@id="userlist-title"]

Close
    Close Browser
