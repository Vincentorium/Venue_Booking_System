
$(document).ready(function () {


    $('.complaintButton1').click(function () {

        $('.complaintPost1').addClass('demonHide')
    })


    $('.demoLogOut').click(function () {

        $.removeCookie('userID', {path: '/'});
        $.removeCookie('userType', {path: '/'});
        $.removeCookie('userName', {path: '/'});
        window.location.href = "login.jsp";

    })

})


