<%@ taglib prefix="test" uri="/test/" %>
<!DOCTYPE html>
<html lang="en">
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

    <script src="https://cdn.staticfile.org/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>

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
    <script defer src="js\handleBookingRecord.js"></script>


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
    <script defer src="js\inserBooking.js"></script>
    <script defer src="js\handleBooking.js"></script>
    <link href="css\venuList.css" rel="stylesheet">
    <link href="css\general.css" rel="stylesheet">

    <link href="css\bookingForm.css" rel="stylesheet">
    <link href="css\tableBooking.css" rel="stylesheet">
    <link href="css\bookingForm.css" rel="stylesheet">

</head>

<body>

    <%
    String username="";
    String role= "";
    String userID= "";
      session = request.getSession(false);
    if (session != null && session.getAttribute("authenticated") != null) {
          username = (String) session.getAttribute("username");
 role=(String) session.getAttribute("roleTitle");
     userID=(String) session.getAttribute("userID");
    } else {
      request.getSession().invalidate();
        response.sendRedirect("login.jsp");
    }
%>



    <div class="modalBox">

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

                                <label for="venueDropDownList">Venus</label>
                                <select class="venu-apply-input--campus" id="venueDropDownList">
                                    <option value="1">Tuen Mun</option>
                                    <option value="2">Sha Tin</option>
                                    <option value="QY">Tsing Yi</option>
                                    <option value="LWL">Lee Wai Lee</option>
                                    <option value="CW">Chai Wan</option>
                                </select>
                                <br><label for="">date</label>

                                <input class="venu-apply-input--date" type="date">

                                <fieldset class="venue-apply-form-sessionsSelected">
                                    <legend>Timeslot selected:</legend>
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
                                <summary
                                    class="formTitle postSideFunction venu-apply-form-displayVnue venu-apply-form-displayVnue--date">
                                    Timeslot: 03-05-2023
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
        <div class="bookingTableModal modalGeneral ">
            <div class="loginCtnTitle">
                <!--  <h2>IVE Airline</h2> <a class="close" data-close-button></a> -->


                <img class="closeIcon close" src="./images/exit.png" data-close-button alt="">
            </div>
            <div class="tableContainer">

                <!-- <div class="mailModal-title">
                  <img class="closeIcon close mail-List-Close" src="./images/exit.png" data-close-button alt="">


                </div> -->

                <!--BO booking table elements -->
                <div class="bookingTableBox">
                    <div class="bookingTableTitle">
                        User Name<input type="text" class="booking_records_search_userName">

                        Booking Request Records</div>
                    <div class="switch-button "><span class="activeSwitch"></span>

                        <button class="switch-button-case left active-case"> Unapproved</button>
                        <button class="switch-button-case right demonSwitchRight">Others</button>
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
                                <th>Request Date</th>
                                <th>Status</th>
                                <th>Session Info</th>


                                <th>Receipt</th>


                                <th class="booking-record-table-funcTH">Function</th>
                            </tr>
                        </thead>
                        <tbody class="bookingRecordTbdy">

                        </tbody>

                    </table>


                    <div class=' pagination-container'>
                        <nav>
                            <ul class="pagination">

                                <li data-page="prev">
                                    <span>
                                        < <span class="sr-only">(current)
                                    </span>
                                    </span>
                                </li>
                                <!--  Here the JS Function Will Add the Rows -->
                        </nav>
                    </div>
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


            <div id="header">
                <span class="comLog"></span>

                <!--

              <a id="homenTitle" class="header__home" href="index.html" onmouseout=" mouseOut(this)"> Home</a>

            -->
                <a id="menu2" class="">VTC Venue Booking System</a>
                <div class="headerFun">




                    <a id="header__createAccount" data-modal-target="#modal" data-default="createAccForOperator"
                        class="header__createAccount adminFunLin">Create Account</a>
                </div>
                <div class="headerLoginOut">

                    <a data-modal-target="#bookingTableModal" data-default="bookingTableModal"
                        class="hearder__a header__signIn  memberFunction">Booking Request Record</a>
                    <a data-modal-target=".venueListModal" data-default=".venueListModal"
                        class="hearder__a header__venueList memberFunction ">Guest Managment </a>

                    <a data-modal-target=".userMngtModal" data-default=".userMngtModal"
                        class="hearder__a header__userMngt  mgntFunction boxHide">User
                        Management
                    </a>



                    <a data-modal-target="#modal" data-default="signUp" class="hearder__a header__singUp userName"
                        data-userid="<%= userID %>"> <%= username %> </a>

                    （ <a data-modal-target="#modal" data-default="signIn"
                        class="hearder__a header__dept dept"><%= role %></a>）

                    <a class="hearder__a demoLogOut">Log Out</a>
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


                            <label class="collectionLabel" for="">VTC venues: </label>
                            <div class="favEleBox">
                                <div class="favElements favElement1" data-modal-target="#modal"
                                    data-default="orderList">
                                    <div class="allPostPicBox">
                                        <img class="allPostPostImg" src="./images/campusLWL.jpg">

                                    </div>
                                    <div class="urgentBox main-container-infoBox-title">
                                        Chai Wan - Venue
                                    </div>
                                    <div class="allPostFuncRow">
                                        <span class="tagArea">Capacity: 10</span>
                                        <span class="tagArea">Fee: 300 per session</span>
                                    </div>


                                </div>

                                <div class="favElements favElement2">
                                    <div class="allPostPicBox">
                                        <img class="allPostPostImg" src="./images/campusTM.jpg">

                                    </div>
                                    <div class="urgentBox main-container-infoBox-title">
                                        Lee Wai Lee - Venue
                                    </div>
                                    <div class="allPostFuncRow">

                                        <span class="tagArea">Capacity: 12</span>
                                        <span class="tagArea">Fee: 350 per session</span>
                                    </div>


                                </div>
                                <div class="favElements favElement1" data-modal-target="#modal"
                                    data-default="orderList">
                                    <div class="allPostPicBox">
                                        <img class="allPostPostImg" src="./images/campusTsingYi.jpg">

                                    </div>
                                    <div class="urgentBox main-container-infoBox-title">
                                        Tsing Yi - venue
                                    </div>
                                    <div class="allPostFuncRow">

                                        <span class="tagArea">Capacity: 15</span>
                                        <span class="tagArea">Fee: 400 per session</span>
                                    </div>


                                </div>

                                <div class="favElements favElement2">
                                    <div class="allPostPicBox">
                                        <img class="allPostPostImg" src="./images/campusChaiWan.png">

                                    </div>
                                    <div class="urgentBox main-container-infoBox-title">
                                        Sha Tin - venue
                                    </div>
                                    <div class="allPostFuncRow">

                                        <span class="tagArea">Capacity: 20</span>
                                        <span class="tagArea">Fee: 450 per session</span>
                                    </div>


                                </div>
                                <div class="favElements favElement2">
                                    <div class="allPostPicBox">
                                        <img class="allPostPostImg" src="./images/campus2.jpg">

                                    </div>
                                    <div class="urgentBox main-container-infoBox-title">
                                        Tuen Mun - venue
                                    </div>
                                    <div class="allPostFuncRow">
                                        <span class="tagArea">Capacity: 25</span>
                                        <span class="tagArea">Fee: 500 per session</span>
                                    </div>


                                </div>



                                <!-- SOF list of under reivew -->
                                <div id="tableDIv" class="tableDIv allPostTableBox">


                                    <!--  <tbody class="forInsert">
                              </tbody> -->


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


                                </div>
                                <!--complaint start-->


                            </div><!-- EOF list of under reivew  -->

                            <!-- SOF complaintTable-->

                        </div>
                    </div>
                </div>
                <!-- SearchBox -->


                <!-- SOF modal-->


                <!-- EOF Main page -->
            </div>


        </div><!-- homePageCTN -->

</body>