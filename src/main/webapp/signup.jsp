<%-- 
    Document   : login
    Created on : 27 Mar 2023, 11:49:40 am
    Author     : Vincent
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%><!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title> VTC Venue Booking System - sign up page</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

    <script src="https://cdn.staticfile.org/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>

    <link rel="stylesheet" href="./css/logIn2.css">
    <link rel="stylesheet" href="./css/index.css">
    <script defer src="js\logIn.js"></script>

    <link rel="stylesheet" href="./css/venuList.css">

</head>

<body>





<form method="post" action="userController">
    <div class="signuppage">
        <h1>Create your account </h1>
    <table>
        <tr>
            <td>  <label>Account：</label></td>
            <td>  <input type="text" name="userAcc"><br></td>
        </tr>
        <tr>
            <td><label>Password：</label>
            </td>
            <td>
                <input type="password" id="passwordInput" pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[^\s]{5,12}$" required title="Please enter a password that contains one lowercase letter, one uppercase letter, and one digit, between 5 and 12 characters in length,and cannot contain spaces">
            </td>
        </tr>
        <tr>
            <td>  <label>Name：</label>
            </td>
            <td>   <input type="text" name="userName"><br>
            </td>
        </tr>
        <tr>
            <td>  <label>Email：</label>
            </td>
            <td> <input type="email" name="userEmail"><br>
            </td>
        </tr>
        <tr>
            <td>  <input type="hidden" name="type" value="2">
            </td>
            <td> <button type="submit">Create User</button>
            </td>
        </tr>
    </table>



     </div>
</form>
</body>

</html>
</body>

</html>