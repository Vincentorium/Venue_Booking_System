var userIDSession;
var userDataForConfigure = {}
const format = (num, decimals) => num.toLocaleString('en-US', {
    minimumFractionDigits: 2,
    maximumFractionDigits: 2,
});


//for operator to update report status between unapprove and approve fo
$(document).on('click', '.submitButton', function (e) {

    let submitButtonType = $(this).data("submit_type");
    let submitBox = $($(this).data("submit_box"))
    let tempArrMultiForSingeReport = []

    $(".fileInputed--singleReportAttach").each(function (index, value) {
        tempArrMultiForSingeReport.push(value.files[0]);
    })
    switch (submitButtonType) {
        case "bookingRecord":


            updateBookingWithAttach(submitBox)
            break;
        case "ApproveBooking":

            approveBooking(submitBox)

            break;

        case "relevantReportsSubmitWithMail":

            if (updateMultiReportsStatus(tempArrMultiForSingeReport)) {
                let status = $('.repSubmitStatus').val() == "unchange" ? null : $('.repSubmitStatus').val()

                alert("Successfully update the status to " + status + "!")
                displayMailBox(dataJSForMail)

            }
            break;


        default:
            console.log("No a valid type ")
    }
//    e.stopPropagation()
//    return  

    e.stopPropagation()
});//EO click Func

function getCurrentDate() {

    var today = new Date();

    var month = (today.getMonth() + 1);
    if (month < 10) {
        month = '0' + month;
    }
    var mysqlDate = today.getFullYear() + '-' + month + '-' + today.getDate();

    return mysqlDate;
}


var userType
var usernmae
$(document)
$(document).ready(function () {
    checkSession()
})


//header click event to switch function
$(".header__statistic").click(function (e) {
    $(".stat_container").removeClass("containerHide");
    $(".favEleBox").addClass("containerHide");


    stat_loadChartByDefaultVal()

})
$(".header__Venues").click(function (e) {
    $(".stat_container").addClass("containerHide");
    $(".favEleBox").removeClass("containerHide");


})

function clearFormInput(form) {
    $(form).find("input:not([type='submit'], [type='button'])").val("");

}