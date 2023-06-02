$(document).ready(function () {


    $(".loginForm_closeIcon").click(function () {


        loginForm_CloseLoginForm()
    })
    $(" .a_logOut").click(function () {
        alert("Log Out Successfully")
        $(".nonLoginFuncWrapper").removeClass("containerHide")
        $(".loginFunctionWrapper,.header_userInfoWrapper").addClass("containerHide")
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
            asyc: false,
            success: function (rs) {

                console.log(rs);

                loginForm_CloseLoginForm()
                alert("Login Successfully, Welcome " + rs.userName)
                createCookieForUser(rs);
                loginCustomizeForUser(rs)

            },
            error: function (xhr, status, error) {

                switch (xhr.readyState) {
                     case  4:
                        switch (xhr.responseText) {

                            case "No Result Found Exception":
                                alert("Wrong Account or Password!")
                                break

                        }
                        break;
                }

            }

        });

    })

})

var   userRole
function createCookieForUser(rs) {


    userIDSession = rs.userID;

    userType = rs.roleTitle;

    usernmae = rs.userName;

        userRole=rs.roleId;


}

const currentDate = getCurrentDate();
const staffDeualDSearchIndex=999
function loginCustomizeForUser(rs) {


    $(".loginFormInput").val("")
    $(".nonLoginFuncWrapper").addClass("containerHide")
    $(".loginFunctionWrapper,.header_userInfoWrapper").removeClass("containerHide")


    $(".header__dept").html(rs.roleTitle)
    $(".header__singUp").html(rs.userName)
    $(".header__singUp").data("userid", rs.userId);

    $(".venu-apply-input--date").prop("min",currentDate);


    userIDSession = rs.userId

    if (userRole == 3) {


        userDataForConfigure.memberIDForLoadBooking = rs.userId
        userDataForConfigure.bookingRecordSearchLeft = 1
        userDataForConfigure.bookingRecordSearchRight = 6

        $(".header_staffFuncLink, .booking_records_search_userName,.bookingRecord-search-label,.staffFun").addClass("containerHide")
        $(".header_memberFuncLink,.mailIconInsideRep").removeClass("containerHide")
        $(".left").html("Unapproved")
    } else {

        userDataForConfigure.memberIDForLoadBooking = staffDeualDSearchIndex
        userDataForConfigure.bookingRecordSearchLeft = 3
        userDataForConfigure.bookingRecordSearchRight = 5

        $(".header_staffFuncLink,.booking_records_search_userName,.bookingRecord-search-label,.staffFun").removeClass("containerHide")
        $(".header_memberFuncLink,.mailIconInsideRep").addClass("containerHide")

        $(".left").html("Approve")
    }

}
    