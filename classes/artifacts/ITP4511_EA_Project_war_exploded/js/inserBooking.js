var getReportsIntoInbox
var dataForInbox
$(document).ready(function () {
//(function () { 

})




//Venue Timeslot Box event:clicking a timeslot box will add it to selected box of user
$(document).on('click', '.venu-apply-form-session', function (e) {

    e.stopPropagation();

    if(  $(this).hasClass("sessionBooked"))
        return;
    let content = $('.venue-apply-form-sessionsSelected-box').html();
    content +=

        '  <div class="venu-session-selected" id=' + $(this).data("sessionid")+' )>'

        + ' <input type="hidden"  class="sessionSelected" value=' + $(this).data("sessionid") + '>'
        +'<div>'+ $(".venu-apply-input--campus option:selected").html()
        + '<span class="cancelSessionSelected">X</span> </div>'

        + '<div>' + $(".venu-apply-form-displayVnue--date").html()+'</div>'


        + '<div>' + $(this).html() +'</div>'
        + getGetListForBooking(userIDSession, $(this).data("sessionid"))
        + '</div>'

        $(this).addClass("sessionBooked");
    $('.venue-apply-form-sessionsSelected-box').html(content);

})





//<editor-fold desc="Booking Venues ">


var BookingDateSelected = getCurrentDate()
var BookingCampusSelected = 1

//Selecting a date triggers refreshing venue timeslot
$(document).on('change', '.venu-apply-input--date', function (e) {

    e.stopPropagation();
    BookingDateSelected = $(this).val();
    $('.venu-apply-form-displayVnue--date').html('Timeslot: '+$(this).val())
    getSessionByDate(BookingCampusSelected, BookingDateSelected)

});

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
                    '<div class="venu-apply-form-session ' + sessionCssStatus + '"   data-sessionID=' + rc.sessionId + " id=" + rc.sessionId +  '  >' + rc.sessionStartTime + " ~ " + rc.sessionEndTime + sessionNote + '</div>';


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


//Selecting a campus triggers refreshing venue timeslot
$(document).on('change', '.venu-apply-input--campus', function (e) {

    e.stopPropagation();

    BookingCampusSelected = $(this).val();
    getSessionByDate(BookingCampusSelected, BookingDateSelected)
});




$(document).on('click', '.cancelSessionSelected', function (e) {
    e.stopPropagation();
    $(".venu-apply-form-disply-sessions").find("#"+ $(this).parent().attr("id") +"").removeClass("sessionBooked")
    $(this).parent().parent().remove()
});

//</editor-fold>


//get guest list for session
function getGetListForBooking(userID = userIDSession, sessionID) {


    let guestLists = getGeustsGeneral(userID)

    $(".ven-apply-form-guestListInsideBox").html();
    let content = ""



    $(guestLists).each(function (i, rc) {


        content +=

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


function getBookingRC(type=null,memberID=null) {

    //type 3 for get all record un approved for user


    let result = ""
    $.ajax({

        type: 'POST',

        data: { type: type,memberID:memberID},
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





//<editor-fold desc="Function For Booking table for display records for a user">
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

    let sessionDS=getSessionInfoByBookID(bookID);
    let data=""
    let guestInfo=""

    let head='    <table class="bookingRecordsBox-sessionBox">'
        +'      <thead>'
        +'        <th>Venue</th>'
        +'        <th>Session Date</th>'
        +'        <th>Start Time</th>'
        +'        <th>End Time</th>'
        +'        <th>Gueset List</th>'
        +'      </thead>'

    $.each($(sessionDS), function (i, rc) {
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



var getBookingRCIntoTable=
//<editor-fold desc="Handle Booking Record">
function getBookingRCIntoTable(searchType=null ,memberID=null) {
    let bookingRC = getBookingRC(searchType,memberID)
    let content = ""


    $.each($(bookingRC), function (i, rc) {


        let sessionInfoContent=getSessionIntoTalbe(rc.bookId) //
        let statusContent= statusContentFun(rc.bookStatus ); // display the relveant text to according to status num
        let attachmentBox=getAttachmentBox(rc.bookReceipt,rc.bookId)//see if there is a attachment uploaed
        let dataCustomizedForUserType=getDataCustomizedForUserType(searchType);

        //loading 不同type的區別
        // 不同狀態

        /*
        one search with multi condition
        *  1. staff  => load only wait to approve
        *       getBookingRC()
        *  2. customer => load all relevant to cusotmer
        *       getBookingRC
        * */
        content +=

            ' <tr class="bookingRCBoxGeneral specificBookingRC_' + i + '" data-bookingid=' + rc.bookId + '>'
            + '   <td  >' + rc.bookId + '</td>'
            + '   <td  >' + rc.bookDate + '</td>'
            + '   <td >' + statusContent + '</td>'

            + '   <td>' + sessionInfoContent + ' </td>'
            + '   <td  class="bookingAttach" >' + attachmentBox + '</td>'
            + '   <td><input type="button" class="submitButton submitBookingRecord" value="'+dataCustomizedForUserType.buttonValue+'" data-submit_box=".specificBookingRC_' + i + '"  data-submit_type="'+dataCustomizedForUserType.submitType+'">  </td>'
            + ' </tr>'

    })

//    +'   <td><textarea class="bookingRemark bookingRemark--staff" name="" id="" cols="30"'
    //  +'       rows="10">'+rc.bookRemark+'</textarea></td>'

    $(".bookingRecordTbdy").html(content);

}
function getDataCustomizedForUserType(searchType ){
    let type = ( 	$.cookie("userType")=="Staff" || $.cookie("userType")=="Senior Management")? 1:0
    let jsData = {};
    if (type == 1) {
//        $(".booking-record-table-funcTH").html("")
        if(searchType==5){
            jsData.buttonValue = "N/A";
            jsData.submitType = "NA";

        }else{
        jsData.buttonValue = "Approve";
        jsData.submitType = "ApproveBooking";
        }
    }else{

        jsData.buttonValue="Save"
        jsData.submitType="bookingRecord"
    }
   return jsData;
}

function getSubmitButton(bookingId){
    let submitButton =
        ' <div class="mailAttachBox mailAttachBox--mainMailBox">'
        + '       <input type="file" id="file-input--mainMailBox_ '+ bookingId+'" class="fileInput fileInput--mainMailBox inputDisplay--mainMailBox file-input-mail-JS 0" name="image0" />'
        + '       <div class="preview preview--mainMailBox"></div>'

        + '   </div>'

        + '                        <div class="uploadForAttach">'
        + '                          <label for="file-input--mainMailBox_ '+ bookingId+'"   >'
        + '                            <img src="./images/attachIcon.png" />'
        + '                          </label>'
        + '                        </div>'

    return submitButton;
}


function getAttachmentBox(bookReceiptPath,bookID){
    let attachmentBox=""



    if (bookReceiptPath == null) {
        attachmentBox =
            "Upload here!"
            +  getSubmitButton(bookID)

    }
    else
    {

        attachmentBox =

            "<div  class='attachTitleBox'><span class='attachTitle'></span>"
            + "<div class='attachPic'>"

            + '<img class="thumbnails" src="/uploads/' + bookReceiptPath + '" alt="No"       ></a>'

            + "</div>"
            + "</div>"
    }

return attachmentBox
}


//</editor-fold>

















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

            getBookingRCIntoTable(3,userIDSession,1)

        },

    });//EO ajax


}

