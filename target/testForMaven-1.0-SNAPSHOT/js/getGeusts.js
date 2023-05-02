var mailResult
var mailLastestOne


function getGeusts(userID, type) {
    let result;

    $.ajax({
        type: 'POST',
        dataType: "json",
        data: {
            type: type,
            userID: userID
        },
        async: false,

        url: "/getGeustsController",
        success: function (rs) {

            result = rs;

        }
    })
    return result
}

function getGeustListBySessionID(sessionID) {
    let result;

    $.ajax({
        type: 'POST',
        dataType: "json",
        data: {
            type: 4,
            sessionID: sessionID
        },
        async: false,

        url: "/getGeustsController",
        success: function (rs) {

            result = rs;

        }
    })
    return result
}

function getGeustIntoGuestMngt(userID, type) {
    let result = getGeusts(userIDSession, 1)
    let content
    $('.guestsFormTable').html("");

    $('.guestsFormTable').fadeOut(1);


    let header;

    mailResult = result


    header =

        "    <thead><tr><th>"
        + "name"
        + "</th><th>"
        + "email"
        + "</th><th>"
        + "Del"
        + "</th></tr>   </thead>  <tbody>"


    content = ""
    $.each(result, function (i, rc) {


        content +=

            ' <tr>'
            + ' <td>' + rc.guestName + '</td>'
            + ' <td>' + rc.guestEmail + '</td>'
            + ' <td>       <input type="button" value="Delete" data-userid=' + rc.guestId + ' class="delGuest"></td>'
            + ' </tr>'


    })


    $('.guestsFormTable').append(
        content == "" ? "No any guest yet" : ((header += content) + "  </tbody> "));

    //modal();

    $('.guestsFormTable').fadeIn(500);


}


function inserUser(formData) {

    formData.push({name: "type", value: 2});

//    ,type:2
    $.ajax({

        type: 'POST',

        data: formData,

        url: "/getGeustsController",
        success: function (result) {

            alert("Update Successfully!");
            getGeustIntoGuestMngt(userIDSession, 1);//#temp need cookie
        },//EDF AJAX sucess FUNCTION

        error: function (xhr, status, error) {
            $("#chartContainer").html("No relevant Record")
            console.log('An error occurred while updating status');
        }


    });//EOF AJAX*/

}//EOF GETREPORTS FUNCTION


function deleteUser(userID) {


//    ,type:2
    $.ajax({

        type: 'POST',

        data: {
            type: 3,
            userID: userID

        },

        url: "/getGeustsController",
        success: function (result) {

            alert("delete Successfully!");
            getGeustIntoGuestMngt(userIDSession, 1);//#temp need cookie
        },//EDF AJAX sucess FUNCTION

        error: function (xhr, status, error) {

            console.log('An error occurred while updating status');
        }


    });//EOF AJAX*/

}//EOF GETR


function getGeustsGeneral(userID) {


    let resultGet;

    $.ajax({
        type: 'POST',
        dataType: "json",
        data: {
            type: 1,
            userID: userID
        },
        async: false,

        url: "/getGeustsController",
        success: function (result) {
            resultGet = result;
        }


    })
    return resultGet;
}
