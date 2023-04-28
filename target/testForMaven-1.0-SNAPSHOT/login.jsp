<%-- 
    Document   : login
    Created on : 27 Mar 2023, 11:49:40 am
    Author     : Vincent
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%><!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title> VTC </title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

    <script src="https://cdn.staticfile.org/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>

    <link rel="stylesheet" href="./css/logIn2.css">
    <link rel="stylesheet" href="./css/index.css">
    <script defer src="js\logIn.js"></script>

</head>

<body>



<div class="login_page">
    <div id="banner" class="Login_Form">
        <!-- <img src="./images/loginPage.png" /> -->
        <div class="loginLogo">VTC Venue Booking System</div>

    </div>
    <div id="container1" class="Login_Form">

        <form action="userController" method="POST">
        <div class="login">




            <input type="text" class="username" id="username" name="account" placeholder="Account"
                   title=" only accept letter ">
            <div class=" tab">
            </div>
            <input type="password" id="password" name="password" placeholder="Password"
                   title="Must contain at least one number, one lower case letter, one uppercase or special characters, and at least 8 or more characters">
            <div class="tab"></div>

            <div class="loginBtn">
                <input type="hidden" name="type" value=1>
                <input class="loginSubmit" type="submit" value="Sign In" class="submit" />
                <h5 ><a href="signup.jsp"></a> Sign Up</h5>
            </div>
            <!-- "   -->



        </div><!-- login end-->
        </form>
    </div><!-- container1 end-->
</div><!-- login_page end-->


<div class="signup_page" id="container2">

    <div class="signup">

    </div><!-- signup end-->
</div><!-- container2 end-->
</div><!-- signup_page end-->

<div id="copyright">

</div>
</body>

</html>