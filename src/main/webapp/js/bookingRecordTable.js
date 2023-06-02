$(document).on("change", ".booking_records_search_userName", function () {

    var memberID = $(this).val();
    var buttonSelected = $(".right.active-case").hasClass("active-case") ? 5 : 3;
    getBookingRCIntoTable(buttonSelected, memberID)


})
$(document).on("click", ".switch-button-case ", function () {

    getData(this);

})

function getData(button) {
    //reallocate user id and member id , bug here

    userDataForConfigure.memberIDForLoadBooking = $(".booking_records_search_userName").val();
    if ($(button).hasClass("right")) {//aproved

        getBookingRCIntoTable(userDataForConfigure.bookingRecordSearchRight, userDataForConfigure.memberIDForLoadBooking)
    } else {
        getBookingRCIntoTable(userDataForConfigure.bookingRecordSearchLeft, userDataForConfigure.memberIDForLoadBooking)

    }

}


function getMemberIDAndUserName() {

    //type 3 for get all record un approved for user


    let result = ""
    $.ajax({

        type: 'POST',

        data: {type: "3"},
        async: false,
        url: "/userControllerTest",
        success: function (rs) {
            let content = "";
            let defaultOption='<option value="999" > All Members </option>'
            $(rs).each(function (index, element) {
                let userID=element.userId
                if (userID== userIDSession) {

                    content += '<option value="' + userID + '"  selected>' + userID + " - " + element.userName + '</option>';
                } else {

                    content += '<option value="' + userID + '" >' + userID + " - " + element.userName + '</option>';
                }
            });

            $(".booking_records_search_userName").html(defaultOption+content);


            if (userType != "Member") {
                $('.booking_records_search_userName option:first').prop('selected', true);

            } else {


            }

        },

        error: function (xhr, status, error) {

            console.log('An error occurred while updating status');
        }


    });//EOF AJAX*/

    return result;
}

'use strict';

var switchButton 			= document.querySelector('.switch-button');
var switchBtnRight 			= document.querySelector('.switch-button-case.right');
var switchBtnLeft 			= document.querySelector('.switch-button-case.left');
var activeSwitch 			= document.querySelector('.activeSwitch');

function switchLeft(){
    switchBtnRight.classList.remove('active-case');
    switchBtnLeft.classList.add('active-case');
    activeSwitch.style.left 						= '0%';
}

function switchRight(){
    switchBtnRight.classList.add('active-case');
    switchBtnLeft.classList.remove('active-case');
    activeSwitch.style.left 						= '50%';

}

switchBtnLeft.addEventListener('click', function(){
    switchLeft();
}, false);

switchBtnRight.addEventListener('click', function(){
    switchRight();
}, false);

$(document).on('click','.left',function(e){


    $('.complaintTableBox').addClass('allPostTableBoxHide').slideUp(0).slideDown(500);



    $('.Insert_UnGroup').removeClass('allPostTableBoxHide').slideUp(0).slideDown(500);

})
$(document).on('click','.right',function(e){



    $('.Insert_UnGroup').addClass('allPostTableBoxHide').slideUp(0).slideDown(500);
    $('.complaintTableBox').removeClass('allPostTableBoxHide').slideUp(0).slideDown(500);

})

