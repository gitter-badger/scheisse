*** Settings ***

#Resource            ../CommonResource.robot
#Force Tags          MyTag
Library    Selenium2Library
Resource    ../lib/userList.robot

#*** Variables ***


*** Testcases ***

Test User List
    User List

Close
    Close Browser
