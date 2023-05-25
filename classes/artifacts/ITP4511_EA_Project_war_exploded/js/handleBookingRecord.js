




$(document).on("click",".switch-button-case ",function(){
    
    getData(this);
    
})

function getData(button) {
    //reallocate user id and member id , bug here

    var memberID=$(".booking_records_search_userName").val();
    if($(button).hasClass("right")){//aproved

        getBookingRCIntoTable(5,memberID)
    }else{
        getBookingRCIntoTable(3,memberID)

    }

}






function getMemberIDAndUserName() {

    //type 3 for get all record un approved for user


    let result = ""
    $.ajax({

        type: 'GET',

       data:{type:"3"},
        async: false,
        url: "/userControllerTest",
        success: function (data) {


            result = data
        },//EDF AJAX sucess FUNCTION

        error: function (xhr, status, error) {

            console.log('An error occurred while updating status');
        }


    });//EOF AJAX*/

    return result;
}

