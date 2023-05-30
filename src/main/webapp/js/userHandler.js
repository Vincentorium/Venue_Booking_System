$(document).ready(function () {


    $(".loginForm_closeIcon").click(function () {


        loginForm_CloseLoginForm()
    })
    $(" .a_logOut").click(function () {
        alert("Log Out Successfully")
        $(".nonLoginFuncWrapper").removeClass("containerHide")
        $(".loginFunctionWrapper").addClass("containerHide")
    })

    function loginForm_CloseLoginForm() {

        $(".login_Container").removeClass("active")


        $(".loginFormInput").val("")

    }

    $(".a_logIn").click(function () {


        $(".login_Container").addClass("active")

        $(".loginFormInput").val("")

    })


    $(".loginForm_formDOM").submit(function (event) {
        event.preventDefault(); //stop even go ?
        event.stopPropagation()
        let dataToController = $(this).serializeArray();
        dataToController.push({name: "type", value: "1"});

        $.ajax({
            url: "/userControllerTest",
            dataType: "json",
            type: 'POST',
            data: dataToController,
            success: function (rs) {

                console.log(rs);

                loginForm_CloseLoginForm()
                alert("Login Successfully, Welcome " + rs.userName)
                createCookieForUser(rs);
                loginCustomizeForUser(rs)
            },
            error: function (xhr, status, error) {
                if (xhr.readyState == 4) {
                    switch (xhr.responseText) {

                        case "No Result Found Exception":
                            alert("Wrong Account or Password!")
                            break

                    }
                }

            }

        });

    })

})


function createCookieForUser(rs) {


    userIDSession = rs.userID;


    userType = rs.roleTitle;


    usernmae = rs.userName;

    $.cookie('userName', usernmae, {expires: 7, path: '/'});
    $.cookie('userType', userType, {expires: 7, path: '/'});
    $.cookie('userID', userIDSession, {expires: 7, path: '/'});


}


function loginCustomizeForUser(rs) {


    $(".loginFormInput").val("")
    $(".nonLoginFuncWrapper").addClass("containerHide")
    $(".loginFunctionWrapper").removeClass("containerHide")

    $(".header__dept").html(rs.roleTitle)
    $(".header__singUp").html(rs.userName)
    $(".header__singUp").data("userid", rs.userId);

    userIDSession=rs.userId

    if (userType == "Member") {



        userDataForConfigure.memberIDForLoadBooking = rs.userId
        userDataForConfigure.bookingRecordSearchLeft = 1
        userDataForConfigure.bookingRecordSearchRight = 6

        $(".header_staffFuncLink, .booking_records_search_userName,.bookingRecord-search-label").addClass("containerHide")
        $(".header_memberFuncLink,.mailIconInsideRep").removeClass("containerHide")

    } else {

        userDataForConfigure.memberIDForLoadBooking = 1
        userDataForConfigure.bookingRecordSearchLeft = 3
        userDataForConfigure.bookingRecordSearchRight = 5

        $(".header_staffFuncLink,.booking_records_search_userName,.bookingRecord-search-label").removeClass("containerHide")
        $(".header_memberFuncLink,.mailIconInsideRep").addClass("containerHide")
    }

}
    