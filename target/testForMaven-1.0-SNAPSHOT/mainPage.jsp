<!DOCTYPE html>
<html lang="en">

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
    String username="Human";
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
                <h2 class="boxTitle">Complaint</h2>


                <img class="closeIcon close" src="./images/exit.png" data-close-button alt="">
            </div>

            <!--SOF order ______________________________________________________ -->
            <div class="containerOrderList modalGeneral" id="containerOrderList">


                <hr>

                <!--SOF postContainer-->

                <div class="cmtContainer">
                    <div class="venue-form-apply-request-summary">

                        Request:
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
                                <legend>Session selected:</legend>
                                <div class="venue-apply-form-sessionsSelected-box">

                                </div>
                            </fieldset>


                            <br>
                            <fieldset class="venue-apply-form-sessionsSelected">
                                <legend>Generate guest List:</legend>


                                <div class="ven-apply-form-guestListInsideBox">

                                    <table class="guestForBookingBox"></table>

                                    <br>
                                    <br>

                                    <br>

                                    <details clas="templateForInvation">
                                        <summary>Template for guest invatation</summary>
                                        <br><textarea name="" id="" cols="30" rows="10"></textarea>

                                </div>
                                </details>
                            </fieldset>
                            <br>
                            <br>
                            <input type="button" class="bookingFormSubmit" value="Submit">
                            <input type="button" value="Add another Request">


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
                                (resize, if venus is lost focus; and the picInsie auto rezies if add antoher request for
                                venue)
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
                            <summary class="formTitle postSideFunction venu-apply-form-displayVnue">Session:
                            </summary>


                            <div class="venu-apply-form-disply-sessions">
                                <div class="venu-apply-form-session1">
                                    09:00 ~ 09:59
                                </div>
                                <div class="venu-apply-form-session2">10:00 ~ 10:59 (已滿)</div>
                                <div class="venu-apply-form-session3">11:00 ~ 11:59</div>
                                <div class="venu-apply-form-session4">12:00 ~ 12:59</div>
                                <div class="venu-apply-form-session5">13:00 ~ 13:59</div>
                                <div class="venu-apply-form-session2">14:00 ~ 14:59</div>
                                <div class="venu-apply-form-session3">15:00 ~ 15:59</div>
                                <div class="venu-apply-form-session4">16:00 ~ 16:59</div>
                                <div class="venu-apply-form-session5">17:00 ~ 17:59</div>
                                <div class="venu-apply-form-session2">18:00 ~ 18:59</div>

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
        Test venue list
        <div class="venueListModal_title">
            <!--  <h2>IVE Airline</h2> <a class="close" data-close-button></a> -->


            <img class="  closeIcon close" data-close-button src="./images/exit.png" data-close-button alt="">
        </div>


        <div class="venueListModal_box ">
            <div class="venueAddGuestBox">
                <input type="button" class="venuAddGuest--out" value="add a new guest">
                <form action="" id="venueForm--addGuest" class="venueForm--addGuest demonHide">
                    <table>
                        <tr>

                            <td> name<input type="text" name="name"></td>
                            <td> email<input type="text" name="email"></td>
                        </tr>
                        <tr>

                            <td><input type="submit" class="sendBtn venuAddGuest--in" value="Add"></td>
                            <td><input type="button" class="sendBtn venuAddGuest--in venuAddGuest--in--cancel"
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
                <tr>

                    <th>#
                    </th>
                    <th>name</th>
                    <th>email</th>
                </tr>
                </thead>
                <tbody>
                <tr>

                    <td><input type="checkbox" name="id1" value="1"></td>
                    <td>a1</td>
                    <td>a2</td>

                </tr>
                <tr>

                    <td><input type="checkbox" name="id2" value="2"></td>
                    <td>b1</td>
                    <td>b2</td>

                </tr>
                <tr>
                    <td><input type="checkbox" name="id3" value="3"></td>
                    <td>c1</td>
                    <td>c2</td>

                </tr>

                </tbody>

            </table>

        </form>
        <!--EO booking table elements -->
    </div>
    <div class="userMngtModal  modalGeneral   ">
        Test venue list
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
                            <td><input type="button" class="sendBtn userMngt--in userMngt--in--cancel" value="Cancel">
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
                        <th>Venue</th>
                        <th>Session Date</th>
                        <th>Start Time</th>
                        <th>End Time</th>
                        <th>Gueset List</th>

                        <th>Price</th>

                        <th>Receipt</th>
                        <th>Notification</th>
                        <th>Status</th>
                        <th>Remark</th>
                        <th>Remark By Staff</th>
                        <th>Save</th>
                    </tr>
                    </thead>
                    <tbody class="bookingRecordTbdy">
                    <tr>
                        <td rowspan="2">1</td>
                        <td rowspan="2">10 mar 2023</td>
                        <td>Sha Tin</td>
                        <td>12 mar 2023</td>
                        <td>11:00</td>
                        <td>11:59</td>
                        <td>
                            <ol>
                                <li>meow</li>
                                <li>moew</li>
                                <li>mweo</li>
                            </ol>
                        </td>
                        <td>$200</td>
                        <td rowspan="2"><a href=""> 20230311-receipt</a>
                            <button>Delete</button>
                        </td>
                        <td>Notificaiton template</td>
                        <td><textarea class="bookingRecor--notification" name="" id="" cols="30"
                                      rows="10">remark</textarea>
                        </td>
                        <td><textarea class="bookingRemark bookingRemark--user" name="" id="" cols="30"
                                      rows="10">remark</textarea></td>
                        <td><textarea class="bookingRemark bookingRemark--staff" name="" id="" cols="30"
                                      rows="10">remark</textarea></td>
                        <td><input type="button" value="Save"></td>
                    </tr>
                    <tr>

                        <td>Tuen Mun</td>
                        <td>13 mar 2023</td>
                        <td>11:00</td>
                        <td>11:59</td>
                        <td>
                            <ol>
                                <li>meow</li>
                                <li>moew</li>
                                <li>mweo</li>
                            </ol>
                        </td>
                        <td>$300</td>

                        <td>pending</td>
                    </tr>
                    <tr>
                        <td rowspan="2">2</td>
                        <td rowspan="2">23 mar 2023</td>
                        <td>Sha Tin</td>
                        <td>24 mar 2023</td>
                        <td>11:00</td>
                        <td>11:59</td>
                        <td>
                            <ol>
                                <li>meow</li>
                                <li>moew</li>
                                <li>mweo</li>
                            </ol>
                        </td>
                        <td>$200</td>
                        <td rowspan="2">

                            <!--SO mailBoxFunctionInsideRep-->
                            <div class="maiBoxFunInsideRep">

                                <!--  image file and close button-->
                                <span class="file-input-Ctn file-input-Ctn-mail demonHide">
                      <input type="file" name="file-input" class="file-input file-input-mail file-input-mail-JS"
                             id="file-input">
                      <span class="file-input-cancel">X</span>
                    </span>

                                <!--  button and label and image-->
                                <div class="mailBoxFunctionInsideRep">
                                    <input type="text" class="mailTitleJS demonHide" value="Reply: '+data.title">
                                    <button class="sendBtn sendCmtBtnGP2 mailSubmitButton"
                                            data-submitctn=".mailSubmitBox"
                                            data-close-button>Upload
                                    </button>
                                    <div class="uploadForAttach">
                                        <label for="file-input">
                                            <img src="./images/attachIcon.png"/>
                                        </label>
                                    </div>
                                </div>
                            </div>

                            <!--EO mailBoxFunctionInsideRep-->

                        <td>pending</td>
                    </tr>
                    <tr>

                        <td>Sha Tin</td>
                        <td>26 mar 2023</td>
                        <td>11:00</td>
                        <td>11:59</td>
                        <td>
                            <ol>
                                <li>meow</li>
                                <li>moew</li>
                                <li>mweo</li>
                            </ol>
                        </td>
                        <td>$200</td>

                        <td>pending</td>
                    </tr>
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
            <a id="menu2" class=""></a>
            <div class="headerFun">


                <a id="menu2" class="header__myOrder   headerActive preLink" data-modal-target="#modal"
                   data-default="orderList">Booking List</a>


                <a id="menu2" class="header_Complaint headerActive preLink " href="indexOfComplaint.html">Complaint
                    List</a>
                <a id="menu2" class="headerActive searchFlightHeaderLink preLink adminFunLin">Search Flight
                </a>
                <a id="menu2" class="headerActive cmtManagement preLink adminFunLin">Complaint
                    Management</a>


                <a id="header__createAccount" data-modal-target="#modal" data-default="createAccForOperator"
                   class="header__createAccount adminFunLin">Create Account</a>
            </div>
            <div class="headerLoginOut">

                <a data-modal-target="#bookingTableModal" data-default="bookingTableModal"
                   class="hearder__a header__signIn  ">Booking Request Record</a>
                <a data-modal-target=".venueListModal" data-default=".venueListModal"
                   class="hearder__a header__venueList  ">venue booking </a>

                <a data-modal-target=".userMngtModal" data-default=".userMngtModal"
                   class="hearder__a header__userMngt  ">User
                    Management
                </a>

                <a data-modal-target="#mailRecord" data-default="mailRecord" class="hearder__a header__signIn  ">mail
                    Record</a>

                <a data-modal-target="#modal" data-default="signIn" class="hearder__a header__dept dept"><%= role %></a>

                <a data-modal-target="#modal" data-default="signUp" class="hearder__a header__singUp userName" data-userid="<%= userID %>" > <%= username %> </a>
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


                <!-- SOF complaintFuncBox-->
                <div class="complaintFuncBox">

                    <!-- SOF filter Form -->
                    <div class="filterForm">

                        <div class="filterFormFirstFlood">
                            <div class="filter_loc">


                                <div class="filterBox">
                                    <select class="filter__formInput filter__formInputFix inputHongKong" type="text"
                                            required="required"
                                            value="Hong Kong">
                                        <option value="YMT">Yau Ma Tei</option>
                                        <option value="TST">Tsim Sha Tsui</option>
                                        <option value="MK">Mong Kok</option>

                                    </select>
                                    <span class="  fliter_placehoderFix">Areas</span>

                                </div>

                                <div class="filterBox">


                                    <span class="filterBox__airlineIcon"></span>


                                    <select class="filter__formInput filter__formInput--locFrm" type="text"
                                            required="required"
                                            value="Hong Kong">
                                        <option value="YMT">Streets</option>
                                        <option value="TST"> Shanghai Street</option>
                                        <option value="MK"> Temple Street</option>
                                        <option value="YMT"> Public Square Street</option>
                                        <option value="TST"> Jade Street</option>


                                    </select>
                                    <span class="fliter_placehoder"> </span>


                                    <!hover change to click and float -->


                                </div>
                            </div>
                            <div class="filter_date">


                                <div class="filterBox">

                                    <input id="filter__formInput" class="filter__formInput filter__formInput--date"
                                           required="required"
                                           name="date" type="text" onfocus="(this.type='date')"
                                           onblur="if(!this.value)this.type='text'">
                                    <span class="fliter_placehoder">Start Date</span>
                                </div>

                                <div class="filterBox">

                                    <input list="Date" class="filter__formInput filter__formInput--time " type="text"
                                           required="required">

                                    <datalist id="Date">
                                        <option value="1:00"/>
                                        <option value="2:00"/>
                                        <option value="3:00"/>
                                        <option value="9:00"/>
                                        <option value="10:00"/>
                                        <option value="11:00"/>
                                        <option value="12:50"/>
                                        <option value="18:00"/>
                                        <option value="22:00"/>
                                    </datalist>
                                    <span class="fliter_placehoder">End Date</span>
                                </div>


                                <input class="shouldBeHide" type="text">

                            </div>


                        </div>


                        <div class="filterFormFirstFlood">
                            <div class="filter_date">


                                <div class="filterBox">

                                    <input list="Dated" class="filter__formInput filter__formInput--time inputSecFloor"
                                           type="text"
                                           required="required">

                                    <span class="fliter_placehoder fliter_placehoder_secFloor">keyword</span>
                                </div>


                                <input class="shouldBeHide" type="text">

                            </div>
                            <!--
                      <button type="button" class="filterForm__searchBtn"><img src="/images/search.jpg" alt=""> Search</button>
            --> <img class="searchIcon filterForm__searchBtn" src="./images/search.svg" alt="">
                        </div>


                    </div>
                    <!-- EOF filter Form -->


                    <!-- SOF 5 switch box -->
                    <div class="switchBox">
                        <!-- SOF 5 top box -->

                        <!-- EOF 5 top box -->

                        <!-- partial:index.partial.html -->
                        <div class="switch-button "><span class="activeSwitch"></span>

                            <button class="switch-button-case left active-case"> Inbox</button>
                            <button class="switch-button-case right demonSwitchRight">Case</button>
                        </div>

                    </div> <!-- EOF 5 switch box -->


                </div>
                <!-- EOF complaintFuncBox-->


                <div class="searchFlight">

                    <!-- SOF dataBox Form -->
                    <div class="container" style="margin-top:35px">


                        <label class="collectionLabel" for="">Ive venues: </label>
                        <div class="favEleBox">
                            <div class="favElements favElement1" data-modal-target="#modal" data-default="orderList">
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

                            <div class="favElements favElement2">
                                <div class="allPostPicBox">
                                    <img class="allPostPostImg" src="./images/campusTM.jpg">

                                </div>
                                <div class="urgentBox main-container-infoBox-title">
                                    Tuen Mun - XX Park
                                </div>
                                <div class="allPostFuncRow">

                                    <span class="tagArea">wild animal</span>
                                    <span class="tagArea">wild animal</span>
                                </div>


                            </div>
                            <div class="favElements favElement1" data-modal-target="#modal" data-default="orderList">
                                <div class="allPostPicBox">
                                    <img class="allPostPostImg" src="./images/campusTsingYi.jpg">

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

                            <div class="favElements favElement2">
                                <div class="allPostPicBox">
                                    <img class="allPostPostImg" src="./images/campusChaiWan.png">

                                </div>
                                <div class="urgentBox main-container-infoBox-title">
                                    Tuen Mun - venue
                                </div>
                                <div class="allPostFuncRow">

                                    <span class="tagArea">wild animal</span>
                                    <span class="tagArea">wild animal</span>
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