var modal

$(document).ready(function () {
    var openModalButtons
    var closeModalButtons
    var overlay
    var i = 0;
    modal = function modal() {

        openModalButtons = document.querySelectorAll('[data-modal-target]')
        closeModalButtons = document.querySelectorAll('[data-close-button]')
        overlay = document.getElementById('overlay')


        $.each($(openModalButtons), function (index, value) {

            $(this).off('click')
            $(this).on("click", function (e) {


                const modal = $(this).data('modal-target');//document.querySelector(button.dataset.modalTarget)
                // const modal = button.getAttribute('data-modal-target');

                const defaulModal = $(this).data('default') //; button.getAttribute('data-default');
                //getReports(dataForInbox,$(this).data('idForMysql'));


                closeModalButtons = document.querySelectorAll('[data-close-button]')
                overlay = document.getElementById('overlay')

                openModal(modal, defaulModal, $(this).data("idformysql"))

                e.stopPropagation();
            })
        });


        closeModalButtons.forEach(button => {
            button.addEventListener('click', () => {

                const modal = button.closest('.modalGeneral')
                closeModal(modal)
                $(".venue-apply-form-sessionsSelected-box").html("")
            })


        })

    }//eED Modal

    function openModal(modal, defaulModal, sqlID) {

        $(modal).addClass('active');

        if (defaulModal == 'mailIcon') {
            $(modal).addClass('active');
            var el = document.getElementById('modalOfMail');
            var scrollPosition = window.pageYOffset;
            // $('#modalOfMail').css("top", 250+scrollPosition+"px");

            el.style.top = (160 + scrollPosition) + 'px';
            console.log(el)
        } else if (defaulModal == 'tablePostTitle') {
            $(modal).addClass('active');



            let currentDate = getCurrentDate();
            getSessionByDate(1, currentDate);

            getGetListForBooking();
            $('.venu-apply-input--date').html('Timeslot: '+currentDate)

            $(".venu-apply-input--date").val(currentDate)
            $('#containerOrderList table tbody tr').attr('display', 'table-row')

        } else if (defaulModal == 'mailRecord') {
            $(modal).addClass('active');
            $('.mail-button-inbox').addClass('mailbuttonHover')
            $('.mail-button-sent').removeClass('mailbuttonHover')
            $('.mailModal').addClass('active');
            $('.mail-record-box').addClass('active');
            getMailRecords(0)
            getMailContent(mailLastestOne)
            //   $('#containerOrderList table tbody tr').attr(  'display', 'table-row!important')
            //$('#containerOrderList table tbody tr').attr(  'display', 'table-row!important')
            $('.mail-record-box table tbody tr').attr('display', 'table-row')


        } else if (defaulModal == 'bookingTableModal') {
            getBookingRCIntoTable()
            $('.mail-button-inbox').addClass('mailbuttonHover')
            $('.mail-button-sent').removeClass('mailbuttonHover')
            $('.bookingTableModal').addClass('active');
            $('.mail-record-box').addClass('active');
            getMailRecords(0)
            getMailContent(mailLastestOne)


            getPagination(mytable)
            $('.mail-record-box table tbody tr').attr('display', 'table-row')


        } else if (defaulModal == '.venueListModal') {
            getGeustIntoGuestMngt(userIDSession, 1)


        } else if (defaulModal = "") {

        }

    }


    function closeModal(modal) {

        modal.classList.remove('active');


    }


//const openModalButtons = document.querySelectorAll('[data-modal-target]')


    overlay.addEventListener('click', () => {

        const modals = document.querySelectorAll('.modal.active')
        modals.forEach(modals => {
            closeModal(modals)
        })


    })


    $('close-button overlay').click(() => {

        const modals = document.querySelectorAll('.modal.active')
        modals.forEach(modals => {
            closeModal(modals)




        })


    })

    // modal()
})//EDO title click event


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
 

 