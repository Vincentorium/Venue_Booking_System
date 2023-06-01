<%@ taglib prefix="test" uri="/test/" %>
<!DOCTYPE html>
<html lang="en">
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Online Complaint System</title>


    <link href="css\styles.css" rel="stylesheet">
    <link href="css\login.css" rel="stylesheet">
    <link href="css\confirmationCode.css" rel="stylesheet">
    <link href="css\confirmationCode.css" rel="stylesheet">
    <link href="css\signUp.css" rel="stylesheet">
    <link href="css\header.css" rel="stylesheet">
    <link href="css\searchForm.css" rel="stylesheet">
    <link href="css\complaint.css" rel="stylesheet">
    <link href="css\switch.css" rel="stylesheet">
    <link href="css\applyFrom.css" rel="stylesheet">


    <script defer src="js\signUp.js"></script>
    <script defer src="js\logIn.js"></script>
    <script defer src="js\resetPW.js"></script>

    <script src="./js/lib/jquery-3.6.0.min.js"></script>
    <script src="./js/lib/jquery.canvasjs.min.js"></script>
    <script src="./js/lib/jquery.cookie.min-1.4.1.js"></script>


    <script src="https://cdn.staticfile.org/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
    <%--
      <script src="https://canvasjs.com/assets/script/jquery-1.11.1.min.js"></script>
      --%>
    <script src="./canvasjs/jquery.canvasjs.min.js"></script>


    <script defer src=" js\resetPW.js"></script>

    <script defer src="js\switch.js"></script>
    <script defer src="js\searchFunc.js"></script>
    <script defer src="js\searchFunc_Switch.js"></script>
    <script defer src="js\searchFuncTable.js"></script>


    <script defer src="js\getAllReports.js"></script>

    <script defer src="js\getReportsIntoInbox.js"></script>
    <script defer src="js\getReports.js"></script>
    <script defer src="js\handleGeneral.js"></script>

    <script defer src="js\handleReport.js"></script>
    <script defer src="js\demo.js"></script>
    <script defer src="js\logIn.js"></script>
    <script defer src="js\getReportsForTable.js"></script>
    <script defer src="js\modal.js"></script>
    <script defer src="js\insertReportStatus.js"></script>
    <script defer src="js\loadMainPage.js"></script>
    <script defer src="js\getRemarkForReport.js"></script>
    <script defer src="js\handleMail.js"></script>
    <script defer src="js\insertMail.js"></script>
    <script defer src="js\getMailRecords.js"></script>
    <script defer src="js\getMailContent.js"></script>
    <script defer src="js\handleBook.js"></script>

    <script defer src="js\handleBooking.js"></script>
    <script defer src="js\bookingFunction.js"></script>
    <script defer src="js\handleForm.js"></script>
    <script defer src="js\bookingRecordTable.js"></script>


    <link href="css\index.css" rel="stylesheet">
    <link href="css\tableSheet.css" rel="stylesheet">
    <link href="css\complaintTable.css" rel="stylesheet">
    <link href="css\favBox.css" rel="stylesheet">
    <link href="css\demo.css" rel="stylesheet">
    <link href="css\mail.css" rel="stylesheet">


    <!--For Kylie project-->
    <script defer src="js\handleVenue.js"></script>

    <script defer src="js\handleForm.js"></script>
    <script defer src="js\getGeusts.js"></script>
    <script defer src="js\bookingForm.js"></script>
    <script defer src="js\handleBooking.js"></script>
    <script defer src="js\handleStatisticContent.js"></script>
    <script defer src="js\userHandler.js"></script>


    <link href="css\venuList.css" rel="stylesheet">


    <link href="css\bookingForm.css" rel="stylesheet">
    <link href="css\userHandler.css" rel="stylesheet">
    <link href="css\bookingFormRecords.css" rel="stylesheet">
    <link href="css\bookingForm.css" rel="stylesheet">
    <link href="css\statistic.css" rel="stylesheet">

    <link href="css\general.css" rel="stylesheet">
</head>

<body>


<div class="modalBox">

    <%--SOF Login form    --%>
    <div class="login_Container modalGeneral">
        <div class="loginForm_loginCtnTitle">
            <!--  <h2>IVE Airline</h2> <a class="close" data-close-button></a> -->
            <h3 class="boxTitle">User Account</h3>
            <img class="loginForm_closeIcon closeIcon close" src="./images/exit.png" data-close-button alt="">
        </div>
        <div class="loginCtnTitle confirmmsgBox">
            <h4>Congrat: You have make reservation,<br>and you can check it in the order list</h4>

        </div>


        <!-- <div class="login_page"  0459062 > -->
        <div id="loginForm_wrapper" class="loginForm_wrapper">

            <div class="login">

                <div class="loginInputBox">
                    <form id="loginForm_formDOM" class="loginForm_formDOM" method="POST">

                        <input type="text" class="login_username loginFormInput" name="username" placeholder="Account"
                              required>

                        <input type="password" class="login_password loginFormInput" name="password"
                               placeholder="Password"
                             required>
                        <div class="">
                            <input type="submit" class="loginForm_Button" value="Log In">

                        </div>
                    </form>

                </div>


            </div><!-- login end-->
        </div><!-- container1 end-->

        <!-- signup_page__________________________________ -->
        <div class="signup_page containerHide" id="container2">

            <div class="signup">


                <div class="login_indicatorBox emailIndicatorBox">
                    <h4 class="emailForPassword1stCTN_IndcatorMes signupHeader"> Sign Up </h4>
                </div>

                <form class="singUpForm">
                    <div class="signupBox">
                        <input type="text" id="sigupUsername" class="loginFormInput sigupUsername" name="username"
                               pattern="[A-Z0-9a-z]{1,10}" placeholder="account" title="only accept uppercase and lowercase letter, and
            number" required>
                        <!--  -->
                        <input type="password" id="password2" class="loginFormInput" name="password"
                               placeholder="password"
                               pattern="(?=.*[a-z_])(?=.*\d)(?=.*[^a-z0-9_])[\S]{8,}" title=" Must contain at least one number, one lowercase leterr, one uppercase letter, and a  special characters, and at least 8
            or more characters" required>
                        <!-- " -->
                        <input type="password" id="comfirm_password" class="loginFormInput" name="comfirm_password"
                               placeholder="confirm password" pattern="(?=.*[a-z_])(?=.*\d)(?=.*[^a-z0-9_])[\S]{8,}"
                               title=" Must contain at least one number, one lowercase
          leterr, one uppercase letter, and a special characters, and at least 8
          or more characters" required>
                        <!-- pattern="(?=.*[a-z_])(?=.*\d)(?=.*[^a-z0-9_])[\S]{8,}" -->
                        <input type="text" id="fullname" class="loginFormInput" name="fullname" placeholder="user name"
                               pattern="[A-Za-z]*" title="only accept uppercase and lowercase letter" required>

                        <!-- pattern="[A-Za-z]*" -->
                        <input type="email" id="email" class="loginFormInput" name="email" placeholder="enamil"
                               title="only accept email format" required>


                    </div>

                    <input type="submit" value="sign up" class="submit sumbitSignUp" data-modal-target="#modal"
                           data-default="reservationMsg">
                </form>
            </div><!-- signup end-->
        </div><!-- signup_page end-->

    </div>
    <%--EOF Login form    --%>
    <!-- SOF modal booking form Box-->
    <div class="modal modalGeneral " id="modal">


        <div class="reportsBoxForModal">
            <div class="loginCtnTitle">
                <!--  <h2>IVE Airline</h2> <a class="close" data-close-button></a> -->
                <h2 class="boxTitle">Booking Form</h2>


                <img class="closeIcon close" src="./images/exit.png" data-close-button alt="">
            </div>

            <!--SOF order ______________________________________________________ -->
            <div class="containerOrderList modalGeneral" id="containerOrderList">


                <hr>


                <div class="cmtContainer">
                    <div class="venue-form-apply-request-summary">

                        <!--SOF postContainer
                                            <label for="">Prices: $50 * 3 session</label>
                                            <table>
                                                <tr>
                                                    <th>campus1</th>
                                                    <th>campus2</th>
                                                </tr>
                                                <tr>
                                                    <td>session: 09~10</td>
                                                    <td>session: 11~12</td>
                                                </tr>
                                            </table>
                                    -->
                    </div>

                    <form action="" class="venBookingForm">
                        <div class="ven-apply-form-box">

                            <label for="venueDropDownList">Venues:</label>
                            <select class="venu-apply-input--campus" id="venueDropDownList">

                            </select>
                            <br><label for="">Date:</label>

                            <input class="venu-apply-input--date" type="date"  min="">

                            <fieldset class="venue-apply-form-sessionsSelected">
                                <legend>Timeslot Selected:</legend>
                                <div class="venue-apply-form-sessionsSelected-box">


                                </div>
                            </fieldset>

                            <%--
                            <br>
                            <fieldset class="venue-apply-form-sessionsSelected">
                                <legend>Template for guest invitation:</legend>


                                <div class="ven-apply-form-guestListInsideBox">

                                    <table class="guestForBookingBox"></table>

                                    <br>

                            </fieldset>
                                 --%>
                            <br>
                            <br>
                            <div class="venue-apply-form-submitButBox">
                                <div class="bookingForm_totalPrice">Total Price: $ 0.00</div>
                                <input type="button" class="btnGeneral bookingFormSubmit" value="Submit">


                            </div>
                        </div>
                    </form>
                    <!--SOF sideFunction-->
                    <div class="cmtHistory">

                        <br>

                        <!-- <div class="formTitle postSideFunction venu-apply-form-displayVnue"> Venu selected:venus lost focus
                            cause this window to resize
                            to a snap </div> -->

                        <details clas="venu-apply-form-displayVnue--details">
                            <summary class="formTitle postSideFunction venu-apply-form-displayVnue">Venue Info

                            </summary>
                            <div class="favElements favElement1 venu-apply-form-displayVnue--venusSelected"
                                 data-modal-target="#modal" data-default="orderList">
                                <div class="allPostPicBox">
                                    <img class="allPostPostImg" src="./images/campusLWL.jpg">

                                </div>
                                <div class="urgentBox main-container-infoBox-title">
                                    Tuen Mun - XX Park
                                </div>
                                <div class="allPostFuncRow">
                                    <span class="tagArea">Capacity</span>
                                    <span class="tagArea">Type</span>
                                    <span class="tagArea">feature</span>
                                </div>


                            </div>


                        </details>


                        <details clas="venu-apply-form-displayVnue--details" open>
                            <summary class="formTitle postSideFunction venu-apply-form-displayVnue ">

                                <span class="venu-apply-form-displayVnue--date"></span>
                                <span class="bookingform--timeslot--price"></span>
                            </summary>


                            <div class="venu-apply-form-disply-sessions">


                            </div>


                        </details>


                    </div>
                    <!--EOD sideFunction-->

                </div>
                <!--SOF postContainer-->


            </div>


            <!-- eof booking -->


        </div> <!-- EOF modal-->
    </div>
    <!-- EOF modal booking form Box-->
    <div class="venueListModal  modalGeneral   ">
        Venue list
        <div class="venueListModal_title">
            <!--  <h2>IVE Airline</h2> <a class="close" data-close-button></a> -->


            <img class="  closeIcon close" data-close-button src="./images/exit.png" data-close-button alt="">
        </div>


        <div class="venueListModal_box ">
            <div class="venueAddGuestBox">
                <input type="button" class="venuAddGuest--out btnGeneral" value="Add a new guest">
                <form action="" id="venueForm--addGuest" class="venueForm--addGuest demonHide">
                    <table>
                        <tr>

                            <td> name<input type="text" name="name"></td>
                            <td> email<input type="text" name="email"></td>
                        </tr>
                        <tr>

                            <td><input type="submit" class="btnGeneral venuAddGuest--in" value="Add"></td>
                            <td><input type="button" class="btnGeneral venuAddGuest--in venuAddGuest--in--cancel"
                                       value="Cancel">
                            </td>
                        </tr>

                    </table>


                </form>

            </div>
        </div>


        <form class="venueForm" id="venueForm" action="">

            <table id="mytable" class="mytable table table-bordered table-striped guestsFormTable">
                <thead>


                </tbody>

            </table>

        </form>
        <!--EO booking table elements -->
    </div>


    <div class="userMngtModal  modalGeneral   ">
        Guests
        <div class="userMngtModal_title">
            <!--  <h2>IVE Airline</h2> <a class="close" data-close-button></a> -->


            <img class="  closeIcon close" data-close-button src="./images/exit.png" data-close-button alt="">
        </div>


        <div class="userMngtModal_box ">
            <div class="userMngtBox">
                <input type="button" class="userMngt--out" value="add a new guest">
                <form action="" id="userMngtForm--addUser" class="userMngtForm--addUser demonHide">
                    <table>
                        <tr>

                            <td> name<input type="text" name="name"></td>
                            <td> email<input type="text" name="email"></td>
                        </tr>
                        <tr>

                            <td><input type="button" class="sendBtn userMngt--in" value="Add"></td>
                            <td><input type="button" class="sendBtn userMngt--in userMngt--in--cancel"
                                       value="Cancel">
                            </td>
                        </tr>

                    </table>


                </form>

            </div>
        </div>
        <form class="userMngtForm" id="userMngtForm" action="">

            <table id="mytable" class="mytable table table-bordered table-striped">
                <thead>
                <tr>

                    <th>#
                    </th>
                    <th>account</th>
                    <th>password</th>
                    <th>full name</th>
                    <th>email</th>
                    <th>BookingStatus</th>
                    <th>Bookings</th>
                </tr>
                </thead>
                <tbody>
                <tr>

                    <td>id</td>
                    <td>accountName1</td>
                    <td>ps</td>
                    <td>fullName</td>
                    <td>email@</td>
                    <td><input type="checkbox" name="id2" value="2">disable</td>
                    <td><input class="userMngt_displayUser" type="button" value="Booking Hisotry"></td>
                </tr>
                <tr>

                    <td>id</td>
                    <td>accountName1</td>
                    <td>ps</td>
                    <td>fullName</td>
                    <td>email@</td>
                    <td><input type="checkbox" class="userBookingRight" name="id2" value="2">disable</td>
                    <td><input class="userMngt_displayUser" type="button" value="Booking Hisotry"></td>
                </tr>
                <tr>
                    <td>id</td>
                    <td>accountName1</td>
                    <td>ps</td>
                    <td>fullName</td>
                    <td>email@</td>
                    <td><input class="userBookingRight" type="checkbox" name="id2" value="2">disable</td>
                    <td><input class="userMngt_displayUser" type="button" value="Booking Hisotry"></td>
                </tr>

                </tbody>

            </table>

            <input type="submit" class="sendBtn userMngtDeleteClickGuest" value="delete">
        </form>
        <!--EO booking table elements -->
    </div>


    <!-- SOF Booking-->
    <div class="bookingTableModal modalGeneral " data-modalname="bookingTableModal">
        <div class="loginCtnTitle">
            <!--  <h2>IVE Airline</h2> <a class="close" data-close-button></a> -->


            <img class="closeIcon close" src="./images/exit.png" data-close-button alt="">
        </div>
        <div class="tableContainer">

            <!-- <div class="mailModal-title">
              <img class="closeIcon close mail-List-Cglose" src="./images/exit.png" data-close-button alt="">


            </div> -->

            <!--BO booking table elements -->
            <div class="bookingTableBox">
                <div class="bookingTableTitle">
                    <span class="bookingRecord-search-label">User Name</span>

                    <select class="booking_records_search_userName">


                    </select>


                    <div class="switch-button "><span class="activeSwitch"></span>

                        <button class="switch-button-case left active-case"> Unapproved</button>
                        <button class="switch-button-case right demonSwitchRight">Others</button>
                    </div>


                </div>


                <div class="form-group">
                    <select name="state" id="maxRows" class="form-control" style="width:150px;">
                        <option value="5000">Show All</option>
                        <option value="5">5</option>
                        <option value="10">10</option>
                        <option value="15">15</option>
                        <option value="20">20</option>
                        <option value="50">50</option>
                        <option value="75">75</option>
                        <option value="100">100</option>
                    </select>

                </div>

                <table id="mytable" class="mytable table table-bordered table-striped">
                    <thead>
                    <tr>

                        <th>#</th>
                        <th class="bookingRecordTable_customCol  staffFun " >Name</th>
                        <th>Request Date</th>
                        <th>Status</th>
                        <th>Session Info</th>
                        <th>Booking Fee</th>
                        <th>Receipt</th>
                        <th class="booking-record-table-funcTH">Function</th>

                    </tr>
                    </thead>
                    <tbody class="bookingRecordTbdy">

                    </tbody>

                </table>


<%--                <div class=' pagination-container'>--%>
<%--                    <nav>--%>
<%--                        <ul class="pagination">--%>

<%--                            <li data-page="prev">--%>
<%--                                    <span>--%>
<%--                                        < <span class="sr-only">(current)--%>
<%--                                    </span>--%>
<%--                                    </span>--%>
<%--                            </li>--%>
<%--                            <!--  Here the JS Function Will Add the Rows -->--%>
<%--                    </nav>--%>
<%--                </div>--%>
                <div class="booking-record-text"></div>
            </div>

            <li data-page="next" id="prev">
                <span> > <span class="sr-only">(current)</span></span>
            </li>
            </ul>
            <!--EO booking table elements -->
        </div>
    </div>
    <!-- EOF Booking-->
</div>


</div>

<div class="homePageCTN">

    <div id="loginScreen">


        <div class="header_infoContainer">
            <div class="header_logImgWrapper">
                <img src="./images/iveIconTrans.png" width="200px" height="50px" alt="">
            </div>
            <div class="header_userInfoWrapper containerHide">


                <a data-modal-target="#modal" data-default="signUp" class="hearder__a header__singUp userName"
                   data-userid="">
                </a>

                （ <a data-modal-target="#modal" data-default="signIn"
                     class="hearder__a header__dept dept">
            </a>）
            </div>
        </div>


        <div id="header">


            <!--
          <span class="comLog"></span>
          <a id="homenTitle" class="header__home" href="index.html" onmouseout=" mouseOut(this)"> Home</a>

        -->
            <div class="header_comLog">

                <a id="menu2" class="">Venues Booking System</a>
            </div>
            <%--            <div class="headerFun">--%>


            <%--                <a id="header__createAccount" data-modal-target="#modal" data-default="createAccForOperator"--%>
            <%--                   class="header__createAccount adminFunLin">Create Account</a>--%>
            <%--            </div>--%>

            <div class="headerLoginOut">
                <div class="loginFunctionWrapper containerHide">
                    <a class="hearder__a   header__Venues  ">Venues</a>
                    <a class="hearder__a header_staffFuncLink header__statistic  ">Statistic</a>
                    <a data-modal-target="#bookingTableModal" data-default="bookingTableModal"
                       class="hearder__a   header__signIn   ">Booking Request Record</a>
                    <a data-modal-target=".venueListModal" data-default=".venueListModal"
                       class="hearder__a header_memberFuncLink  header__venueList">Guest Managment </a>


                    <%--                    <a data-modal-target=".userMngtModal" data-default=".userMngtModal"--%>
                    <%--                       class="hearder__a header__userMngt  mgntFunction boxHide">User--%>
                    <%--                        Management--%>
                    <%--                    </a>--%>


                    <a class="hearder__a  a_logOut">Log Out</a>

                </div>
                <div class="nonLoginFuncWrapper">
                    <%--                    demoLogOut--%>
                    <a class="hearder__a  a_logIn">Log In</a>
                </div>
            </div>


        </div>

    </div>

    <div class="NonLogin">
        <div>
            <a class="allPostTitle mailIconInsideRep" data-modal-target="#modal" data-default="tablePostTitle"
               data-idForMysql=1>
                <i class="fa fa-plus my-float" id="float">Book your venue </i>
            </a>

            <!-- SOF modal Mail Box-->
            <div class="mailModal modalGeneral ">
                <div class="mailModal-title">
                    <img class="closeIcon close mail-List-Close" src="./images/exit.png" data-close-button alt="">


                </div>
                <div class="mailbox-mainLayer">
                    <div class="mailbox-mainLayer-top">
                        <div class="mailBoxFilterTitle"> Mail</div>
                        <div class="mail-list-filter-Box">

                            <div>
                                User: <input type="text">
                                Keyword: <input type="text">
                            </div>
                            <button class="mailbox-filterButton">Search</button>
                        </div>
                    </div>

                    <div class="mail-record-box" id="mail-record-box">
                        <div class="mailModal-sideBar ">


                            <div class="mail-button mail-button-inbox mailbuttonHover">
                                Inbox
                            </div>
                            <div class="mail-button mail-button-sent">
                                Sent
                            </div>
                        </div>
                        <div class="maibox-list">
                            <div class=" ">

                                </h3>
                            </div>
                            <div id="mail-record-box-table" class="mail-record-box-table">


                            </div>


                            <div class=" complaintTableBottomFunc mail-reocrd-table-pagination">


                            </div>
                            <!-- <div class="mail-record-table-container">
                      <nav>
                        <ul class="mail-record-table-pagination"> </ul>

                      </nav> -->


                        </div>
                        <div class="mail-content-ctn">
                            <div class="mail-content"></div>

                        </div>


                    </div>
                </div>
            </div> <!-- EOF modal Mail Box-->


        </div>

        <div class="sideNavBar">

        </div>

        <!-- SOF Main page -->
        <div class="postContentBox">


            <!-- SearchBox __________________________________________-->
            <div class="SearchBox">

                <div class="searchFlight">

                    <!-- SOF dataBox Form -->
                    <div class="container" style="margin-top:35px">


                        <label class="collectionLabel" for="">Venues: </label>
                        <!-- SOF center page content-->

                        <div class="centerPageContent">

                            <div class="stat_container containerHide">
                                <div class="filterWrapper">

                                    <form id="mainPageForm" method="post" action="">

                                        <div class="stat_filterContainer">

                                            <div class="filter_date">


                                                <div class="filterBox">

                                                    <input id="filter__formInput"
                                                           class="filter__formInput filter__formInput--date filter__formInput--date_s"
                                                           required="required"
                                                           name="date_s_0" type="date">
                                                    <span class="fliter_placehoder">Start Date</span>
                                                </div>

                                                <div class="filterBox">
                                                    <input id="filter__formInput"
                                                           class="filter__formInput filter__formInput--date filter__formInput--date_e"
                                                           required="required"
                                                           name="date_e_0" type="date">

                                                    <span class="fliter_placehoder">End Date</span>
                                                </div>


                                                <input class="shouldBeHide" type="text">
                                                <input type="hidden" name="type" value="2">

                                            </div>


                                        </div>

                                        <div class="stat_searchButtonWrapper">
                                            <button class="searchIcon filterForm__searchBtn" data-search="stastic">
                                                <img src="./images/search.svg" width="50px" alt="button icon">

                                            </button>
                                        </div>
                                    </form>
                                </div>


                                <div class="stat_chartWrapper">
                                    <div class="stat_ErrMessage">
                                        No Relevant Data !
                                    </div>
                                    <div class="stat_SuccContent">
                                        <div class="stat_chartContainerLineTabl_wrapper">
                                            <div class="stat_chartContainerLineTable--barChart_title ">Booking Count and
                                                Revenue
                                            </div>
                                            <div id="stat_chartContainerLineTable--barChart"
                                                 class="stat_chartContainerLineTable--barChart"
                                                 style="height: 300px; width: 100%;">
                                            </div>
                                        </div>
                                        <br>
                                        <div class="stat_chartContainerLineTabl_wrapper">
                                            <div class="stat_chartContainerLineTable_title ">Daily Booking Count and
                                                Revenue
                                            </div>
                                            <div id="stat_chartContainerLineTable" class="stat_chartContainerLineTable"
                                                 style="height: 300px; width: 100%;">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!-- SOF campus info-->
                            </div>
                            <div class="favEleBox">

                                <div class="favElements favElement1" data-modal-target="#modal"
                                     data-default="orderList">
                                    <div class="allPostPicBox">
                                        <img class="allPostPostImg" src="./images/campusLWL.jpg">

                                    </div>
                                    <div class="urgentBox main-container-infoBox-title">
                                        Chai Wan
                                    </div>
                                    <div class="allPostFuncRow">
                                        <span class="tagArea">Capacity: 10</span>
                                        <span class="tagArea">Fee: $250 Per Hour</span>
                                    </div>


                                </div>


                                <div class="favElements favElement1" data-modal-target="#modal"
                                     data-default="orderList">
                                    <div class="allPostPicBox">
                                        <img class="allPostPostImg" src="./images/campusTsingYi.jpg">

                                    </div>
                                    <div class="urgentBox main-container-infoBox-title">
                                        Tsing Yi
                                    </div>
                                    <div class="allPostFuncRow">

                                        <span class="tagArea">Capacity: 15</span>
                                        <span class="tagArea">Fee: $400 Per Hour</span>
                                    </div>


                                </div>

                                <div class="favElements favElement2">
                                    <div class="allPostPicBox">
                                        <img class="allPostPostImg" src="./images/campusChaiWan.png">

                                    </div>
                                    <div class="urgentBox main-container-infoBox-title">
                                        Sha Tin
                                    </div>
                                    <div class="allPostFuncRow">

                                        <span class="tagArea">Capacity: 20</span>
                                        <span class="tagArea">Fee: $350 Per Hour</span>
                                    </div>


                                </div>
                                <div class="favElements favElement2">
                                    <div class="allPostPicBox">
                                        <img class="allPostPostImg" src="./images/campus2.jpg">

                                    </div>
                                    <div class="urgentBox main-container-infoBox-title">
                                        Tuen Mun
                                    </div>
                                    <div class="allPostFuncRow">
                                        <span class="tagArea">Capacity: 25</span>
                                        <span class="tagArea">Fee: $300 Per Hour</span>
                                    </div>


                                </div>


                                <!-- SOF list of under reivew -->
                                <div id="tableDIv" class="tableDIv allPostTableBox">


                                    <!--  <tbody class="forInsert">
                              </tbody> -->

                                    <!--
                                                                       <div class="forInsert Insert_UnGroup demonHide">


                                                                           <div class="allPostSpecificPost complaintPost1 session-checkIn-box">

                                                                               <div class="BookingTabel_bookingBox rowCTM3">

                                                                                   <span class="allPostStatusDptTitle">Session: 9:00 - 9:59</span>
                                                                                   <span class="allPostStatusDptTitle">No. of Participants: 4</span>

                                                                                   <div class="mngtFunction postMngtStatus session-checkIn-displayButton">

                                                                                       Diplay Participants
                                                                                   </div>
                                                                               </div>
                                                                               <div class=" rowCTM3 session-checkIn-tickBox">


                                                                                   <div class="session-checkIn-tickBox--innerBox">


                                                                                       <table>
                                                                                           <thead>
                                                                                               <tr>
                                                                                                   <th>#</th>
                                                                                                   <th>Name</th>
                                                                                                   <th>Email</th>
                                                                                               </tr>
                                                                                           </thead>
                                                                                           <tbody>
                                                                                               <tr>
                                                                                                   <td><input type="checkbox" name="" id=""></td>
                                                                                                   <td>Member_name</td>
                                                                                                   <td>Member_name@gmail.com</td>
                                                                                               </tr>
                                                                                               <tr>
                                                                                                   <td><input type="checkbox" name="" id=""></td>
                                                                                                   <td>Meow</td>
                                                                                                   <td>meow@gmail.com</td>
                                                                                               </tr>
                                                                                               <tr>
                                                                                                   <td><input type="checkbox" name="" id=""></td>
                                                                                                   <td>Moew</td>
                                                                                                   <td>moew@gmail.com</td>
                                                                                               </tr>
                                                                                               <tr>
                                                                                                   <td><input type="checkbox" name="" id=""></td>
                                                                                                   <td>Mweo</td>
                                                                                                   <td>Mweo@gmail.com</td>
                                                                                               </tr>
                                                                                           </tbody>
                                                                                       </table>


                                                                                   </div>
                                                                               </div>
                                                                           </div>


                                                                           <div class="allPostSpecificPost complaintPost1 session-checkIn-box">

                                                                               <div class="BookingTabel_bookingBox rowCTM3">

                                                                                   <span class="allPostStatusDptTitle">Session: 9:00 - 9:59</span>
                                                                                   <span class="allPostStatusDptTitle">No. of Participants: 4</span>

                                                                                   <div class="mngtFunction postMngtStatus session-checkIn-displayButton">

                                                                                       Diplay Participants
                                                                                   </div>
                                                                               </div>
                                                                               <div class=" rowCTM3 session-checkIn-tickBox">


                                                                                   <div class="session-checkIn-tickBox--innerBox">


                                                                                       <table>
                                                                                           <thead>
                                                                                               <tr>
                                                                                                   <th>#</th>
                                                                                                   <th>Name</th>
                                                                                                   <th>Email</th>
                                                                                               </tr>
                                                                                           </thead>
                                                                                           <tbody>
                                                                                               <tr>
                                                                                                   <td><input type="checkbox" name="" id=""></td>
                                                                                                   <td>Member_name</td>
                                                                                                   <td>Member_name@gmail.com</td>
                                                                                               </tr>
                                                                                               <tr>
                                                                                                   <td><input type="checkbox" name="" id=""></td>
                                                                                                   <td>Meow</td>
                                                                                                   <td>meow@gmail.com</td>
                                                                                               </tr>
                                                                                               <tr>
                                                                                                   <td><input type="checkbox" name="" id=""></td>
                                                                                                   <td>Moew</td>
                                                                                                   <td>moew@gmail.com</td>
                                                                                               </tr>
                                                                                               <tr>
                                                                                                   <td><input type="checkbox" name="" id=""></td>
                                                                                                   <td>Mweo</td>
                                                                                                   <td>Mweo@gmail.com</td>
                                                                                               </tr>
                                                                                           </tbody>
                                                                                       </table>


                                                                                   </div>
                                                                               </div>
                                                                           </div>


                                                                           <div class="allPostSpecificPost complaintPost1 session-checkIn-box">

                                                                               <div class="BookingTabel_bookingBox rowCTM3">

                                                                                   <span class="allPostStatusDptTitle">Session: 9:00 - 9:59</span>
                                                                                   <span class="allPostStatusDptTitle">No. of Participants: 4</span>

                                                                                   <div class="mngtFunction postMngtStatus session-checkIn-displayButton">

                                                                                       Diplay Participants
                                                                                   </div>
                                                                               </div>
                                                                               <div class=" rowCTM3 session-checkIn-tickBox">


                                                                                   <div class="session-checkIn-tickBox--innerBox">


                                                                                       <table>
                                                                                           <thead>
                                                                                               <tr>
                                                                                                   <th>#</th>
                                                                                                   <th>Name</th>
                                                                                                   <th>Email</th>
                                                                                               </tr>
                                                                                           </thead>
                                                                                           <tbody>
                                                                                               <tr>
                                                                                                   <td><input type="checkbox" name="" id=""></td>
                                                                                                   <td>Member_name</td>
                                                                                                   <td>Member_name@gmail.com</td>
                                                                                               </tr>
                                                                                               <tr>
                                                                                                   <td><input type="checkbox" name="" id=""></td>
                                                                                                   <td>Meow</td>
                                                                                                   <td>meow@gmail.com</td>
                                                                                               </tr>
                                                                                               <tr>
                                                                                                   <td><input type="checkbox" name="" id=""></td>
                                                                                                   <td>Moew</td>
                                                                                                   <td>moew@gmail.com</td>
                                                                                               </tr>
                                                                                               <tr>
                                                                                                   <td><input type="checkbox" name="" id=""></td>
                                                                                                   <td>Mweo</td>
                                                                                                   <td>Mweo@gmail.com</td>
                                                                                               </tr>
                                                                                           </tbody>
                                                                                       </table>


                                                                                   </div>
                                                                               </div>
                                                                           </div>
                                                                       </div>

                                                                        -->
                                </div>
                                <!--complaint start-->


                            </div><!-- EOF list of under reivew  -->


                        </div>
                        <!-- EOF center page content-->

                    </div>
                </div>
            </div>
            <!-- SearchBox -->


            <!-- SOF modal-->


            <!-- EOF Main page -->
        </div>


    </div><!-- homePageCTN -->

</body>