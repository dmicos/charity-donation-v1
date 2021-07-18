# Charity Donation

> This application allows you to give your old things to charity organizations.

## Table of Contents
* [Technologies Used](#technologies-used)
* [Features](#features)



## Technologies Used

- SpringBoot: Spring Data JPA, Spring Security, Spring Mail
- Thymeleaf - version 3.0
- MySQL - version 8.0.25
- Lombock - version 1.5
- JavaScript
- jQuery - version 3.4.1
- jQuery Validation - version 1.19
- ModelMapper - version 2.3.5
- Passay - version 1.5.0



## Features
Anonymous access allows anonymous users to gain access to pages:
- Main page
- List of organizations page
- Feedback page (allow to send email)
- Sign up
    - password and email validation
    - registration confirmation email
    - forgot password (user receives a password reset email)

Users access allows:
- access to donation form
- view and manage donations
- edit profile
- change password (generate a token and send an email to the user)

Admin access allows:
- manage lists of charities and description;
- manage users and change roles 
- view and manage donations

Other:
- Multilingual
- Load initial data with SQL script (resources/sql)