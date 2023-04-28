
function insertMail(content,title,attachMail){


    
     var imageData = new FormData();
    imageData.append('image', attachMail);
 
    imageData.append('id',null);
    imageData.append('title',title);
    imageData.append('content',content);
    imageData.append('FKrepId',repID);
    imageData.append('FKOfficerId',$.cookie('userID'));
 
 


 


$.ajax({
        
            url: 'php/inserMail.php',
            type: 'POST',
      data: imageData,
      processData: false,
      contentType: false,
            success: function(response) {

                    console.log('Mail inserted!');

                    alert("mail sent!");
               $('.modalOfMail').removeClass('active');
               content.val("")
               title.val("")
               attachMail.val("")
                 $('.file-input-Ctn-mail').addClass('demonHide');
           
            },
    
        });//EO ajax

}





function updateMaiStatus(mailIDSet){


$.ajax({
     url: 'php/updateMailReadStatus.php',
     type: 'POST',
     data: {
          mailIDSet:mailIDSet,
      },
      
            success: function(response) {

                 
                    alert("mail read!");
             
           
            },
    
        });//EO ajax

}