---
name: "#Login Button Defect#"
about: Defect found when clicking on the login button
title: ''
labels: ''
assignees: mlivesey94

---

**Defect**
Login button doesn't send SQL query to database and cross reference username and password to make sure that the user has inputted the correct combination. Instead it just automatically logs in the user.

**To Reproduce**
Steps to reproduce the behaviour:
1. Go to 'LoginPage.html'
2. Select the username field and type in a username: 'matt'
3. Select the password field and type in a random password that should not be associated with user 'password'
4. Select the login button
5. This will log in the user without checking the correct combination.

**Expected behavior**
This should check that the combination is correct and then if there combination is incorrect it should throw an exception error or inform the user that the password and username is incorrect.


**Desktop (please complete the following information):**
 - OS: [e.g. iOS]
 - Browser [e.g. chrome, safari]
 - Version [e.g. 22]

**Smartphone (please complete the following information):**
 - Device: [e.g. iPhone6]
 - OS: [e.g. iOS8.1]
 - Browser [e.g. stock browser, safari]
 - Version [e.g. 22]

| Syntax | Description |
| ----------- | ----------- |
| Username| Incorrect Password | Correct Password |
| Matt | password | ChickenWings! |
| Andy | password | SweetSausage94! |
| Zak | p$ssW0rd! | ElvenScroll30! |

**Additional context**
Multiple accounts created and tested
