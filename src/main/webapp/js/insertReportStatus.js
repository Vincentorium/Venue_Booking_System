

//for operator to update report status between unapprove and approve fo
$(document).on('click','.reportSubmitButton',function(e){
        var repStatusRemark=$('.reportTextArea').val()
    var status=$('.repSubmitStatus').val()=="unchange"?null:$('.repSubmitStatus').val()

    var imageData = new FormData();
    imageData.append('image', $('#file-input-report')[0].files[0]);
 
 imageData.append('repStatusID',null);
 imageData.append('repStatusType',status);
 imageData.append('repID',repID);
 imageData.append('repStatusRemark',repStatusRemark);
   imageData.append('repUserID',$.cookie('userID'));

  //  var repID=$(this).data("repid")

var data = {
    
    repStatusID:null, 
    repStatusType:status,
    repStatusDateCreated: 0,
    repID:repID,
    repStatusRemark:repStatusRemark,
    repUserID:$.cookie('userID')
    };


 


$.ajax({
        
            url: 'php/updateStatusForOfficer.php',
            type: 'POST',
      data: imageData,
      processData: false,
      contentType: false,
            success: function(response) {

                    console.log('Status updated!');
                    
                    getAllReort()
                    getReportsIntoInbox()
                    getReortForTable()
                    modal()

                    alert("Successfully Update the status!")
                    $('.active').removeClass('active');
                    //$('.stateMsg').remove();
                 //   $('#float').html($('#float').html()=="Approve"?"Unapprove":"Approve")
            },
    
        });//EO ajax



    });//EO click Func
 
 
