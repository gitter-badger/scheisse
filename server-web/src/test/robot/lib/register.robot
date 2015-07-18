*** Settings ***

Library    Selenium2Library

*** Variables ***

${URL}=    http://matrix:8080/server-web-1.0-SNAPSHOT/faces/register.xhtml

*** Keywords ***

Open Browser To Register Page
    Open Browser    ${URL}    Firefox

Is Register Page
    Wait Until Page Contains Element    xpath=//h1[@id="register-title"]

Check Elements
    Wait Until Page Contains Element    xpath=//div[@id="input-fields"]
    Wait Until Page Contains Element    xpath=(//div[@id="input-fields"]/input[@type="text"])[1]
    Wait Until Page Contains Element    xpath=(//div[@id="input-fields"]/input[@type="text"])[2]
    Wait Until Page Contains Element    xpath=//div[@id="input-fields"]/input[@type="password"]
    Wait Until Page Contains Element    xpath=//a[text()="registrieren"]

Register
    Open Browser To Register Page
    Is Register Page
    Check Elements
