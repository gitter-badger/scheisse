*** Settings ***

#Resource            ../CommonResource.robot
#Force Tags          MyTag
Library    Selenium2Library
Resource    ../lib/index.robot

#*** Variables ***


*** Testcases ***

Test Index
    Index

Close
    Close Browser
