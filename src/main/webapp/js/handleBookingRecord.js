




$(document).on("change",".booking_records_search_userName",function(){

    var memberID=$(this).val();
    var buttonSelected=$(".right.active-case").hasClass("active-case")?5:3;
    getBookingRCIntoTable(buttonSelected,memberID)


})
$(document).on("click",".switch-button-case ",function(){

    getData(this);

})

function getData(button) {
    //reallocate user id and member id , bug here

    let memberID=$(".booking_records_search_userName").val();
    if($(button).hasClass("right")){//aproved

        getBookingRCIntoTable(userDataForConfigure.bookingRecordSearchRight,memberID)
    }else{
        getBookingRCIntoTable(userDataForConfigure.bookingRecordSearchLeft,memberID)

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
        success: function (rs) {
            let content = "";

            $(rs).each(function(index, element) {
                content += '<option value="'+element.userId+'" >' +element.userId+ " - "           +element.userName+'</option>';
            });
            $(".booking_records_search_userName").html(content);



            if(userType!="Member"){
                $('.booking_records_search_userName option:first').prop('selected', true);


            }else{



            }

        },

        error: function (xhr, status, error) {

            console.log('An error occurred while updating status');
        }


    });//EOF AJAX*/

    return result;
}

