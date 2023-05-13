function getMailContent(mailId,isSentByOfficer){

  //alert("caller is " + getReports2.caller);
 
var status="readonly";

var content=""


      $.ajax({
        type:'POST',
        dataType: "json",
        data: {
       
        mailID:mailId
          },
         async: false,
   
          url: "./php/getMailContent.php",
          success: function (result) {
mailResult =result
 let data=result[0]
                let havaAttach=(data.name!==null);
                let numOfAttach=(result.length)
                let mailAttachment=""
        if(havaAttach){         
                 
              for(let i=0;i<numOfAttach;i++){
              mailAttachment+= '  <a href="./php/uploads/'+ result[i].name+'" download>'
              +'<img class="thumbnails" src="./php/uploads/'+ result[i].name+'" alt="No"   style="display: '+(havaAttach===true?"inline":"none")+'"></a>' 

              }
        }


        
                
                let sender=(isSentByOfficer?data.mailSenderName:data.citizenName)
                let recipient=(isSentByOfficer?data.citizenName:"Officer")
                let recipientBox="";
        if(isSentByOfficer){
                   recipientBox='&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; <span >Recipient: '+recipient+': </span>'
}
  
 //fetch data from the result which loads at begin.
  if(data.mailId==mailId){
   
       var identity=(!isSentByOfficer)?"Sender":"Recipient"
       var button=""
       if(!isSentByOfficer)
      {
        button=
'<div class="maiBoxFunInsideRep"> '
 
+'<div class="mail-list-content-mailBoxFunctionBox">'
+'            <button class="sendCmtBtn sendCmtBtnGP2 mailReplayButton" >Reply</button>'
 
 +'</div>'
+'</div> '

      }


       repID=data.FKrepId
      content+=
 
      

//demonHide cmtSumbitBox
 

  '<div class="mail-content-box"   >'
  
 +'<div class="mailBoxTitle">'
 +'<h3>Title: '+data.title+'</h3>'
 //

+'<span class="reportIcon mail-list-content-title-relevantReport" '
+' data-modal-target="#modal"   data-default="modal"      data-idformysql='+repID+'>Display Report </span>'
//'+data.repTitle +'
 +'</div>'
 +'<hr style="width:100%;text-align:left;margin-left:0">'
 

 +'<div>Date:'+data.dateCreated+' </div>'
 +'<hr style="width:100%;text-align:left;margin-left:0">'
 +'<div class="mailBoxRecipients">'
 +'<span >Sender: '+sender+': </span>'
+recipientBox 
// +'<input type="text" class="mailInput recipientInput" '+status+' value="'+data.userName+'" >'
  
  
  +'</div>'
 +'<hr style="width:100%;text-align:left;margin-left:0">'
 
+'<div class="submitOptions">'
+'          <textarea class="mailTextAreaForContent mailTextArea" placeholder="reply..." rows="20" name="comment[text]" id="comment_text" cols="40"'
+'            class="ui-autocomplete-input" autocomplete="off" role="textbox" aria-autocomplete="list"'
+'            aria-haspopup="true" style="resize:none;" '+status+'>'+data.content+'</textarea>'
+'          <br>'
+''+(havaAttach===true?
  ("<div  class='attachTitleBox'><span class='attachTitle'>Attachment:</span>"
      +"<div class='attachPic'>"
          + mailAttachment
      +"</div>"
  +"</div>"):"")
 
 
 
 
 
 
 
  +'<!--SO mailBoxFunctionInsideRep-->'
+button
 

+'<!--EO mailBoxFunctionInsideRep-->'

+'</div>'
+'</div>'
//EO Mail Box



+  '    <!-- SO Mail -->'
+'                <div class="mailSubmitBox modalGeneral" id="mailSubmitBox" data-repID='+repID+' data-mailtitle="'+data.title+'" data-submitbox="mainMailBoxSubmitBox" >'
+''
+'                  <div class="mailBoxRecipients">'
+'                    <span class="mail-replay-title">'
+'<img src="./images/replyIcon.png" class="replayIcon" >'
+sender+'</span>'
 
+'  <span class="mail-list-submit-box-cancel" data-close-button>X</span>'
+'                  </div>'
+''
+''
+''
+''
+'                  <div class="submitOptions">'
+'                    <textarea class="cmtBox mailTextAreaForReply mailTextArea" placeholder="remark..." rows="20"'
+'                      name="comment[text]" id="comment_text'
+'      cols=" 40" class="ui-autocomplete-input" autocomplete="off" role="textbox" aria-autocomplete="list"'
+'                      aria-haspopup="true" style="resize:none;"></textarea>'
 
+'                    <!--SO mail_specific_submitButton-->'
+'                    <div class="maiBoxFunInsideRep ">'
+''
+'                      <!--  image file and close button-->'
+'                      <span class="file-input-Ctn file-input-Ctn-mail demonHide">'
+'                        <!--  <input type="file" name="file-input" class="file-input file-input-mail file-input-mail-JS "'
+'                          id="file-input">-->'
+'                        <span class="file-input-cancel demonHide">X</span>'
+'                      </span>'


//input file
 +' <div class="mailAttachBox mailAttachBox--mainMailBox">'
 +'       <input type="file" id="file-input--mainMailBox" class="fileInput fileInput--mainMailBox inputDisplay--mainMailBox file-input-mail-JS 0" />'
 +'       <div class="preview preview--mainMailBox"></div>'
 
 +'   </div>'


+'                      <hr style="width:100%;text-align:left;margin-left:0">'
+'                      <!--  button and label and image-->'

+'                      <div class="mailBoxFunctionInsideRep">'
+'                        <input type="text"  class="mailTitleJS demonHide" data-mailTile value="Reply: '+data.title+'" >'


+'                        <button class="sendCmtBtn sendCmtBtnGP2 mailSubmitButton"'
+'                          data-submitctn=".mailSubmitBox" data-close-button>Send</button>'



+'                        <div class="uploadForAttach">'
+'                          <label for="file-input--mainMailBox">'
+'                            <img src="./images/attachIcon.png" />'
+'                          </label>'
+'                        </div>'



+'                      </div>'
+'                    </div>'
+''
+''
+'                  </div>'
+'                </div>'

+                '<!--EO Mail -->'
 

//return false


} 
 
   
     $('.mainMailBox-content').html(content)

 
    modal()
              }



            })
          
          }
 













 