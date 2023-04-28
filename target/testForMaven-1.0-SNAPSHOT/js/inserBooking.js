var getReportsIntoInbox
var dataForInbox
$(document).ready(function () {
//(function () { 

})


function getSessionByDate(campID, date) {


    var content = ""


    $.ajax({
        type: 'POST',
        dataType: "json",
        data: {
            campID: campID,
            date: date,
            type: 1,

        },
        async: false,
        url: '/sessionController',
        success: function (result) {

            $('.venu-apply-form-disply-sessions').html("");

            $('.venu-apply-form-disply-sessions').fadeOut(1);
            let sessionNote = "";
            let sessionCssStatus = "";
            $.each(result, function (i, rc) {

                if (rc.sessionStatus == 1) {

                    sessionNote = "<br>booked";
                    sessionCssStatus = "sessionBooked"
                }
                //need handle if cancel it


                content +=
                    '<div class="venu-apply-form-session ' + sessionCssStatus + '"   data-sessionID=' + rc.sessionId + '  >' + rc.sessionStartTime + " ~ " + rc.sessionEndTime + sessionNote + '</div>';


            });//end of $.each

            //$('.forInsert').append(content);


        },//EDF AJAX sucess FUNCTION

        error: function (xhr, status, error) {
            content = "Not new task yet!"
            console.error('An error occurred while updating status');
        }


    });//EOF AJAX*/

    $('.venu-apply-form-disply-sessions').html(content == "" ? "No Session for totady" : content)
    $('.venu-apply-form-disply-sessions').fadeIn(500)
}//EOF GETREPORTS FUNCTION


$(document).on('click', '.venu-apply-form-session', function (e) {

    e.stopPropagation();

    let content = $('.venue-apply-form-sessionsSelected-box').html();
    content +=

        '  <div class="venu-session-selected">'

        + ' <input type="hidden"  class="sessionSelected" value=' + $(this).data("sessionid") + '>'
        + $(".venu-apply-input--date").val()
        + '<span class="cancelSessionSelected">X</span>'
        + "<br>"
        + $(this).html()
        + getGetListForBooking(userIDSession, $(this).data("sessionid"))
        + '</div>'

    $('.venue-apply-form-sessionsSelected-box').html(content);

})

$(document).on('click', '.cancelSessionSelected', function (e) {

    e.stopPropagation();


    $(this).parent().remove()


})


var BookingDateSelected = getCurrentDate()
var BookingCampusSelected = 1
$(document).on('change', '.venu-apply-input--date', function (e) {

    e.stopPropagation();
    BookingDateSelected = $(this).val();


    getSessionByDate(BookingCampusSelected, BookingDateSelected)

})


$(document).on('change', '.venu-apply-input--campus', function (e) {

    e.stopPropagation();

    BookingCampusSelected = $(this).val();
    getSessionByDate(BookingCampusSelected, BookingDateSelected)
})


function getGetListForBooking(userID = userIDSession, sessionID) {


    let guestLists = getGeustsGeneral(userID)

    $(".ven-apply-form-guestListInsideBox").html();
    let content = ""

    $(guestLists).each(function (i, rc) {


        content +=

            //
            //
            //  ' <tr>'
            // +' <td>'+'  <input type="checkbox" name="session_'+sessionID+'_guest"  value=' + rc.guestId + ' > '+'</td>'
            // +' <td> '+rc.guestName+'</td>'
            // +' </tr>'


            ' <tr>'
            + ' <td>' + '  <input type="checkbox" class="guestID"  value=' + rc.guestId + ' > ' + '</td>'
            + ' <td> ' + rc.guestName + '</td>'
            + ' </tr>'


    })

    return content = (content == "" ? "No Guest added before" : ('<details open> <summary>Guest list for the session</summary>     <table class="guestForBookingBox">' + content + ' </table></details>'))


    return content
//    $(".ven-apply-form-guestListInsideBox").html(content == "" ? "No Guest added before" : (content ))
}


$(".bookingFormSubmit").click(function (e) {

    e.preventDefault();


    var result = [];

    var sessionSelected = $('.venu-session-selected');

    $.each(sessionSelected, function (i, rc) {
        var sessionObj = {}; // 創建新對象

        sessionObj.sessionID = $(rc).children(':first-child').val();

        var guestList = [];

        $.each($(rc).find('.guestID:checked'), function (i, rc) {
            guestList.push($(rc).val());
        });

        sessionObj.guestList = guestList;

        result[i] = sessionObj; // 將新對象添加到 result 數組中
    });



    $.ajax({

        type: 'POST',
        url: '/bookingController',
        contentType: 'application/json',
        data: JSON.stringify(result),
        success: function (result) {

            alert("Update Successfully!");
            getGeusts(1, 1);//#temp need cookie
        },//EDF AJAX sucess FUNCTION

        error: function (xhr, status, error) {
            $("#chartContainer").html("No relevant Record")
            console.log('An error occurred while updating status');
        }


    });//EOF AJAX*/


})

function addBooking(formData) {


    $.ajax({

        type: 'POST',

        data: formData,

        url: "/bookingController",
        success: function (result) {

            alert("Update Successfully!");
            getGeusts(1, 1);//#temp need cookie
        },//EDF AJAX sucess FUNCTION

        error: function (xhr, status, error) {
            $("#chartContainer").html("No relevant Record")
            console.log('An error occurred while updating status');
        }


    });//EOF AJAX*/


}






















function getBookingRC(userID) {

    let result=""
    $.ajax({

        type: 'POST',

        data: {userID:userID,type:1},
    async:false,
        url: "/bookingController",
        success: function (data) {


            result=data
        },//EDF AJAX sucess FUNCTION

        error: function (xhr, status, error) {

            console.log('An error occurred while updating status');
        }


    });//EOF AJAX*/

return result;
}








function getBookingRCIntoTable() {
  let bookingRC=  getBookingRC(userIDSession)


            let content=""



    $.each($(bookingRC),function (i,rc) {


        let  gueslistRS =getGeustListBySessionID(rc.sessionID);
        let  guestLit=""
        let noOfSessionOfARequest=2;
        $.each($(bookingRC),function (i,rc) {

            guestLit+='       <li>'+ rc.guestName+'</li>'
        })



                    content+=

                        ' <tr>'
                        +'   <td  >'+rc.sessionFKbookingRecord+'</td>'
                        +'   <td  >'+rc.bookDate+'</td>'
                        +'   <td>'+rc.venName+'<</td>'
                        +'   <td>>'+rc.sessionDate+'</td>'
                        +'   <td>'+rc.sessionDate+'</td>'
                        +'   <td>'+rc.sessionStartTime+'</td>'
                        +'   <td>'
                        +'     <ol>'
                        +guestLit
                        +'     </ol>'
                        +'   </td>'
                        +'   <td>'+rc.venBookingFee+'</td>'
                        +'   <td rowspan='+noOfSessionOfARequest+'><a href=""> 20230311-receipt</a><button>Delete</button></td>'
                        +'   <td>Notificaiton template</td>'
                        +'   <td rowspan='+noOfSessionOfARequest+' >'+rc.bookStatus
                        +'   </td>'
                        +'   <td><textarea class="bookingRemark bookingRemark--user" name="" id="" cols="30"'
                        +'       rows="10">'+rc.bookRemark+'</textarea></td>'
                        +'   <td><textarea class="bookingRemark bookingRemark--staff" name="" id="" cols="30"'
                        +'       rows="10">'+rc.bookRemark+'</textarea></td>'
                        +'   <td><input type="button" value="Save"></td>'
                        +' </tr>'

                })



        $(".bookingRecordTbdy").html(content);

}



