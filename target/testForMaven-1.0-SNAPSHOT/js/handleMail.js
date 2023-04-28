 

$(document).on('click','.mailReplayButton',function(e){
$(".mailSubmitBox").addClass("active")
$(".mail-list-content-mailBoxFunctionBox").addClass("demonHide")
})


 $(document).on("click",".mail-list-submit-box-cancel",function(){

  $(".mail-list-content-mailBoxFunctionBox").removeClass("demonHide")
 })

 
 $(document).on("click",".mail-list-content-title-relevantReport",function(){
 getReports2(resultOfReports,$(this).data('repid'));
   
 })


$(document).on("change",".file-input",function(){
  $(this).parent().removeClass('demonHide');
});
$(document).on("click",".file-input-cancel",function(){
  $(this).parent().addClass('demonHide');
   $(this).prev().val('');
});


var isReadSet=new Set();
 
var isInboxList=true //help to identify which mail list click trigger to hand mail read 
$(document).on("click",".mail-list-summary-one",function(){
  $(".mailListHover").removeClass('mailListHover')
  $(this).addClass('mailListHover');
 
  
  //to see if the mail is needed to handle read affair
  if(isInboxList&&$(this).data('isread')==0){
    isReadSet.add($(this).data('mailid'))
   $(this).removeClass('mail-list-summary-one--isRead');}


//get mail content 
     var mailId=$(this).data('mailid')
      getMailContent(mailId)
  
});
 


$(document).on("click",".mail-button ",function(){
  $(".mail-button").removeClass('mailbuttonHover ')
  $(this).addClass('mailbuttonHover ');
});




  

//for operator to update report status between unapprove and approve fo
$(document).on('click','.mailSubmitButton',function(e){
    
    //alert($(this).data('submitctn') )
    var box=$($(this).data('submitctn')) 
    var content= box.find('.mailTextArea').val()  
    var title=box.find('.mailTitleJS').val();
  
    var attachMail=box.find('.file-input-mail-JS')[0].files[0];

    insertMail(content,title,attachMail)

$(".mail-list-content-mailBoxFunctionBox").removeClass("demonHide")

    });//EO click Func
 
 $(document).on('click','.mail-button-inbox',function(e){
      isInboxList=true
      
      getMailRecords(0)
      getMailContent(mailLastestOne)
      
})

 $(document).on('click','.mail-button-sent',function(e){
     isInboxList=false
      
      getMailRecords(1)
       getMailContent(mailLastestOne)
       if(isReadSet.size!=0)
          updateMaiStatus([...isReadSet])
          isReadSet.clear()
})
