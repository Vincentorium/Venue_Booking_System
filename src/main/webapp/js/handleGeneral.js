var userIDSession;


//for operator to update report status between unapprove and approve fo
$(document).on('click', '.submitButton', function (e) {

    let submitButtonType = $(this).data("submit_button");
    let submitBox = $($(this).data("submit_box"))
    let tempArrMultiForSingeReport = []

    $(".fileInputed--singleReportAttach").each(function (index, value) {
        tempArrMultiForSingeReport.push(value.files[0]);
    })
    switch (submitButtonType) {
        case "reportSubmit":


            if (!submitBox.find(".submitNotifyUser").is(':checked')) {
                var status = $('.repSubmitStatus').val() == "unchange" ? null : $('.repSubmitStatus').val()
                alert("Successfully update the status to -> " + status + "!")
                updateReportStatus(tempArrMultiForSingeReport)

            } else {
                //if multi button is clicked
                /*  if(!getRevelantReportsForUpdate($(this).data("rep_street"))===false){
                       $('.relevantReportsBox').addClass("activeRelevantReps")
                           e.preventDefault();}
                  else{
                    e.preventDefault();
                    return

                  }
                  */
            }

            break;
        case "relevantReportsSubmit":

            if (updateMultiReportsStatus(tempArrMultiForSingeReport)) {
                let status = $('.repSubmitStatus').val() == "unchange" ? null : $('.repSubmitStatus').val()
                alert("Successfully update the status to " + status + "!")


            }

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
$(document).ready(function() {
checkSession()
    })
function checkSession() {




            userIDSession = $(".header__singUp").data("userid");


            userType = $(".header__dept").html();


        usernmae = $(".header__singUp").html();

    loginCustomizeForUser()


}



function loginCustomizeForUser(){
    if(userType!="Member"){
        $(".mgntFunction").removeClass(boxHide)
        $(".memberFunction").addClass(boxHide)
       }else{



    }

}
