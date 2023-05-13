 
var mailResult
var mailLastestOne



 function getMailRecords(isSent){
    
      let content=""
      $('.mail-record-box-table').html("");
      $('.mail-record-box-table').fadeOut(1);


      $.ajax({
        type:'POST',
        dataType: "json",
        data: {
       
        isSent:isSent,
       
          },
         async: false,
   
          url: "./php/getMailRecords.php",
          success: function (result) {
mailResult =result
 
                
     $.each(result, function(index, data){

 

                let isSentByOfficer=(data.isSentByOfficer==1)
               

           
            content +=
'   <div class="mail-list-summary-one  '+ ((!isSentByOfficer&&data.isRead==0)?"mail-list-summary-one--isRead":"")+'" '  
+' data-mailid='+data.mailId 
+' data-issent='+data.isSent
+' data-isSentByOfficer='+isSentByOfficer
+' data-isread='+data.isRead+'>'
+'              <div class="mail-list-titleAndcontent">'
+'                <div class="mail-list-title">'+ data.title+'</div>'
+'                <div class="mail-list-content">'+data.content+'</div>'
+'              </div>'
+'              <div class="mail-list-date">'+ data.dateCreated
            + '</div>'
+'            </div>'

 

            
        })
           $.each(result, function(index, data){
           
            mailLastestOne=data.mailId
            
            return false;
        })
        
                

      
            
                     
        
        $(".mail-record-box-table").append(
        content==""?"No any mail":( content) );
                      
 
 
        $('.mail-record-box-table').fadeIn(500);
      //  addNoIndex(); 
        //  var table =document.getElementById('mail-record-box-table')
       // getPagination(table);


              }
 
        
}) }
 