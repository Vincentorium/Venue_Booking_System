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


            $.each(result, function (i, rc) {
                let sessionCssStatus = "";
                let sessionNote = "";
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

    $('.venu-apply-form-disply-sessions').html(content == "" ? "No Session for this day" : content)
    $('.venu-apply-form-disply-sessions').fadeIn(500)
}//EOF GETREPORTS FUNCTION



$(document).on('click', '.venu-apply-form-session', function (e) {

    e.stopPropagation();

    let content = $('.venue-apply-form-sessionsSelected-box').html();
    content +=

        '  <div class="venu-session-selected">'

        + ' <input type="hidden"  class="sessionSelected" value=' + $(this).data("sessionid") + '>'
        + $(".venu-apply-input--campus option:selected").html()
        + '<span class="cancelSessionSelected">X</span>'

        + $(".venu-apply-form-displayVnue--date").html()

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
    $('.venu-apply-form-displayVnue--date').html('Timeslot: '+$(this).val())
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
        var sessionObj = {};

        sessionObj.sessionID = $(rc).children(':first-child').val();
        //sessionObj.campus= $(rc).children(':first-child').val();

        var guestList = [];

        $.each($(rc).find('.guestID:checked'), function (i, rc) {
            guestList.push($(rc).val());
        });

        sessionObj.guestList = guestList;

        result[i] = sessionObj;
    });


    $.ajax({

        type: 'POST',
        url: '/bookingController',
        contentType: 'application/json',
        data: JSON.stringify(result),
        success: function (result) {

            alert("Update Successfully!");
            getGeusts(1, 1);//#temp need cookie
            $(".venue-apply-form-sessionsSelected-box").html("")
            $("#modal").removeClass('active');
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

    //type 3 for get all record un approved for user
    let type =  $.cookie('userType')=="Staff"?3:1;
    let result = ""
    $.ajax({

        type: 'POST',

        data: {userID: userID, type: type},
        async: false,
        url: "/bookingController",
        success: function (data) {


            result = data
        },//EDF AJAX sucess FUNCTION

        error: function (xhr, status, error) {

            console.log('An error occurred while updating status');
        }


    });//EOF AJAX*/

    return result;
}





//<editor-fold desc="Function For Booking table">
function statusContentFun(bookStatus){


    let statusContent=""
    switch (bookStatus) {
        case 0:
            statusContent="Please upload your receipt within 24 hours"
            break;
        case 1:
            statusContent="Wait for approval"
            break;
        case 2:
            statusContent="Approved"
            break;
        case 3:
            statusContent="Booking is canceled due to late receipt upload"
            break;

    }




    return statusContent;
}
function getSessionInfoByBookID(bookID) {
    let result;

    $.ajax({
        type: 'POST',
        dataType: "json",
        data: {
            type: 3,
            bookID: bookID
        },
        async: false,

        url: "/sessionController",
        success: function (rs) {

            result = rs;

        }
    })
    return result
}
function getGuestListIntoBoxForBookingBySessionDI(sessionID){

    let getResult=getGeustListBySessionID(sessionID)



    let result='<div> <ul>'
    let guest=""
    $.each($(getResult), function (i, rc) {

        guest=rc.guestName == null?"" : rc.guestName

        result+=
            '    <li>'
            +guest
            +'    </li>'





    })


    result+=  '  </ul></div>'
    return result

}
function getSessionIntoTalbe(bookID) {

    let sessionInfo=getSessionInfoByBookID(bookID);
    let data=""
    let guestInfo=""

    let head='    <table>'
        +'      <thead>'
        +'        <th>Venue</th>'
        +'        <th>Session Date</th>'
        +'        <th>Start Time</th>'
        +'        <th>End Time</th>'
        +'        <th>Gueset List</th>'
        +'      </thead>'

    $.each($(sessionInfo), function (i, rc) {
        guestInfo=""
        guestInfo=getGuestListIntoBoxForBookingBySessionDI(rc.sessionId);
        data+=
            '      <tr>'
            +'        <td>'+rc.venName+'</td>'
            +'        <td>'+rc.sessionDate+'</td>'
            +'        <td>'+rc.sessionStartTime+'</td>'
            +'        <td>'+rc.sessionEndTime+'</td>'
            +'        <td>'+guestInfo+'</td>'
            +'      </tr>'

    })

    result=head+data+'    </table>'


    return result
}



//</editor-fold>




function getBookingRCIntoTable() {
    let bookingRC = getBookingRC(userIDSession)


    let content = ""


    $.each($(bookingRC), function (i, rc) {


        let gueslistRS = getGeustListBySessionID(rc.sessionID);
        let guestLit = ""
        let mailContetnForBookingDisplay = rc.bookReceipt
        let sessionInfoContent=getSessionIntoTalbe(rc.bookId)


        let type = ( 	$.cookie("userType")=="Staff" || $.cookie("userType")=="Senior Management")? 1:0
        let buttonValue="Save"
        let submitType="bookingRecord"

        let statusContent= statusContentFun(rc.bookStatus );


        if(type==1){
            buttonValue="Approve"
            submitType="ApproveBooking"
        }



        let submitButton =
            ' <div class="mailAttachBox mailAttachBox--mainMailBox">'
            + '       <input type="file" id="file-input--mainMailBox" class="fileInput fileInput--mainMailBox inputDisplay--mainMailBox file-input-mail-JS 0" name="image0" />'
            + '       <div class="preview preview--mainMailBox"></div>'

            + '   </div>'

            + '                        <div class="uploadForAttach">'
            + '                          <label for="file-input--mainMailBox">'
            + '                            <img src="./images/attachIcon.png" />'
            + '                          </label>'
            + '                        </div>'
        $.each($(gueslistRS), function (i, rc) {

            guestLit += '       <li>' + rc.guestName + '</li>'
        })


        // check if there is a attachment
        if (mailContetnForBookingDisplay == null) {
            mailContetnForBookingDisplay =
                "Upload here!"
                + submitButton

        }
        else
        {

            mailContetnForBookingDisplay =

                "<div  class='attachTitleBox'><span class='attachTitle'></span>"
                + "<div class='attachPic'>"

                + '<img class="thumbnails" src="/uploads/' + rc.bookReceipt + '" alt="No"       ></a>'
            console.log("Path Save to db is: " + rc.bookReceipt)
            + "</div>"
            + "</div>"
        }


        content +=

            ' <tr class="bookingRCBoxGeneral specificBookingRC_' + i + '" data-bookingid=' + rc.bookId + '>'
            + '   <td  >' + rc.bookId + '</td>'
            + '   <td  >' + rc.bookDate + '</td>'
            + '   <td >' + statusContent
            + '   </td>'


            + '   <td>' + sessionInfoContent + ' </td>'


            + '   <td  class="bookingAttach" >' + mailContetnForBookingDisplay + '</td>'


            + '   <td><input type="button" class="submitButton submitBookingRecord" value="'+buttonValue+'" data-submit_box=".specificBookingRC_' + i + '"  data-submit_type="'+submitType+'">  </td>'
            + ' </tr>'

    })

//    +'   <td><textarea class="bookingRemark bookingRemark--staff" name="" id="" cols="30"'
    //  +'       rows="10">'+rc.bookRemark+'</textarea></td>'

    $(".bookingRecordTbdy").html(content);

}



function updateBookingWithAttach(bookingBox) {


    let id = bookingBox.data('bookingid')
    var imageData = new FormData();

    imageData.append('id', id);
//    imageData.append('type', 'uploadReceipt')

//    let imagebookingBox=bookingBox.children(".bookingAttach").children(".mailAttachBox").children(".fileInput").value.file[0]
    let imagebookingBox = bookingBox.find(".fileInputed--mainMailBox")
    // let imag=imagebookingBox.files[0]
//.children(".mailAttachBox").children(".fileInput").value.file[0]
    imageData.append('image',  $(imagebookingBox).get(0).files[0]);


    $.ajax({

        url: '/otherController',
        type: 'POST',
        data: imageData,
        processData: false,
        contentType: false,
        success: function (response) {



            alert("updated!");

            getBookingRCIntoTable()
        },

    });//EO ajax




}




function approveBooking(bookingBox) {


    let id = bookingBox.data('bookingid')

    $.ajax({
        async: false,
        url: "/bookingController",
        type: 'POST',
        data:{id:id,type:4},
        success: function (response) {


            alert("Approve sucessfully");
            getBookingRCIntoTable()

        },

    });//EO ajax


}

