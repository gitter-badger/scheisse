*** Settings ***

Library    Selenium2Library

*** Variables ***

${URL}=    http://matrix:8080/server-web-1.0-SNAPSHOT/

*** Keywords ***

Open Browser To Index Page
    Open Browser    ${URL}    Firefox
    Wait Until Page Contains Element    xpath=//h1[@id="index-title"]

Go To Index Page
    Go To    ${URL}

Is Index Page
    Wait Until Page Contains Element    xpath=//h1[@id="index-title"]

Check Text Elements
    Wait Until Page Contains Element    xpath=//*[@id="users-link"]
    Wait Until Page Contains Element    xpath=//*[@id="register-link"]
    Wait Until Page Contains Element    xpath=//*[@id="items-link"]

Index
    Open Browser To Index Page
    Is Index Page
    Check Text Elements
