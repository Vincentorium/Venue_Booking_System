
$(document).ready(function () {

 
  



var idOfBox=""  //the id of detailed box of flight
var content = ""

function getComplaint(){
      $('.forInsert').html("");
   
      $('.forInsert').fadeOut(1);
      
      // $(".login_errorMes").text("");
       // var userN = $(".login_username").val().trim();
       
         var arrivalLoc =  $(".filter__formInput--locFrm").val();
         var dateStart = $(".filter__formInput--date").val();
          var timeStart = $(".filter__formInput--time").val();
        // alert(arrivalLoc+" "+dateStart+timeStart);

        $.ajax({
          url: "./php/getFlight.php",
          dataType: "json",
          type: 'POST',
          data: {
            dateFmAL: dateStart,
            startTimeFmAL:timeStart,
            cityToAL: arrivalLoc,
          },
          success: function (rs) {
 content = ""
 var tfvalue="disabled";
for(i=0; i<rs.length; i++){
  
    content += '<tr>'+
    '<td>'+
    '<div class="BookingTabel_bookingBox">'
        


        +'<span class="bookingBox_FLightNO">' +"Flight Number:"+rs[i]['flightNoAL']+' </span>'
       +'<br><br>' +'<span class="bookingBox_timeCon">'+rs[i]['transferOrNotAL']+' - '+rs[i]['timeConsuAL']+'</span>'
        

        +' <div class="bookingTable__mid">'
            +'<div class="bookingTable_airlineFrm">'
        
                      +'<span class="bookingTable_airlineFrm_region">'+rs[i]['regionCodeFmAL']+'</span>&nbsp&nbsp&nbsp'+"         "
                      +'<span class="bookingTable_airlineFrm_time">'+rs[i]['startTimeFmAL']+'</span>'
                      +'<span class="bookingTable_airlineFrm_city">'+rs[i]['cityFmAL']+'</span>'
                      +'<span class="bookingTable_airlineFrm_date">'+rs[i]['dateFmAL']+'</span>'
                      +'<span class="bookingTable_airlineFrm_week">'+rs[i]['weekFmAL']+'</span>'
            +'</div>'
        
            +'<div class="bookingTable_airlineMid">'
            +'</div>'

            + '<div class="bookingTable_airlineTo">'
                      +'<span class="bookingTable_airlineFrm_region">'+rs[i]['regionCodeToAL']+ '</span>&nbsp&nbsp&nbsp'+"         "
                      +'<span class="bookingTable_airlineFrm_time">'+rs[i]['startTimeToAL']+'</span>'
                      +'<span class="bookingTable_airlineFrm_city">'+rs[i]['cityToAL']+'</span>'
                      +'<span class="bookingTable_airlineFrm_date">'+rs[i]['dateToAL']+'</span>'
                      +'<span class="bookingTable_airlineFrm_week">'+rs[i]['weekToAL']+'</span>'
 
            + '</div>'
            + '<div class="bookingTable_price">'
                      +'<span class="bookingTable_priceSpan">$ '+ rs[i]['priceAL']
                      +'</span>'
            +'</div>' 

        +'</div>' // end of mid
        
         
  
         +'<div class="bookingTable__bottom">'
            +'<span  class="tooltip tooltipDetail">  <button class="bookingTable__detailBtn bookingTable__detailBtnForBox"  id="bookingTable__detailBtn_'+i+'"   >'+"Seat Availability"+'</button></span>'
        +'</div> '

//reserver


+'   <div class="bookingTable__detailBox" id="bookingTable__detailBtn_'+i+'_Box">'
+                               ' <table id="reserveTable" class="reserveTable"><thead>'
                                +'<tr><th>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspClass</th>'
                                +'<th>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspSeat <br>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp Availability</th>'
                                +'<th>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspPrice</th>'
                                +'<th>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp Option </th>'
                                    +'</tr>'
                                   +' </thead>'

                                   +' <tbody>'
+                                        '<tr>'
+'                                      <td>Business</td>'
                                      +  '    <td>2</td>'
 
                                            +'<td>$'+(parseInt(rs[i]['priceAL'])+400) +'</td>'
                                               +'<td><input type="radio"   id="javascript" class="classOptionRad" name="fav_language" value="JavaScript">'
                                       +'</td>'
                                        +'  </tr>'
                                       +' <tr>'
                                         +'   <td> <span>Standard </span></td>'
                                           +' <td> <span>1 </span></td>'
                                  +'<td>$'+(parseInt(rs[i]['priceAL'])+200) +'</td>'
                                          +'<span tooltip="Click Radio Button here to pick one seat in your Class" class="tooltip tooltipOption"><td><input type="radio"  id="javascript" name="fav_language" class="classOptionRad" value="JavaScript"></span>'
                                       +'</td>'
                                       +' </tr>'
                                        +'<tr>'
                              /*             +'<td>'+(parseInt(rs[i]['priceAL'])+200) +'</td>'
                                            +'<td>'
                                              +'  <div class="bookingTable__qtyPickCtn">'
                                                +'    <input type="button" value="-"'
                                                  +'      class="bookingTable__qtyPicker--minus">'
                                                   +' <input type="number" value="0" class="bookingTable__qty">'
                                                    +'<input type="button" value="+"'
                                                      +'  class="bookingTable__qtyPicker--plus">'
                                              +'  </div>'
                                            +'</td>'*/


    
                                       +' </tr>'

                                        +'<tr>'
                                 

                                     
                                          +'  <td> <span>Economic </span></td>'
                                            +'<td> <span>0 </span></td>'
 
                  +'<td>$'+(parseInt(rs[i]['priceAL'])) +'</td>'
                       +'<td><input type="radio" '+tfvalue+' id="javascript" class="classOptionRad" name="fav_language" value="JavaScript">'
                                       +'</td>'
                                      +'  </tr>'

                               +' </table>'

+'                                <div class="bookingTable__bottom">'
                        


+'      <span " class="tooltip tooltipRev"> </span> <button class="bookingTable__detailBtn bookingTable__detailBtnForReserve" data-modal-target="#modal"  data-default="reserveFlight"">Reserve</button>'


                               +'                              </div>'
    +'                        </div>'


//reserver


     + '</div></td></tr>';
} 
 
 
$('.forInsert').append(content);
  $('.forInsert').fadeIn(500);

 pageSep();
















              },
          error: function (err) {
           console.log("userN" + userN+" userN" + passW);
 
$(".login_indicatorBox").append("<h5 class='login_errorMes stateMsg' ><img class='errImg' src='./images/errImg.png' alt='errIcon' width='25'  height='15'>wrong account or password</h5>");
 
          }
        });

}
 $(".filterForm__searchBtn").click(function () {
//how to add manipulate without event  $('.tooltipDetail').attr('tooltip',"Click Reserve Button to check out more detail")
 
     
   
      //$('.forInsert').fadeOut(1);
      
       $('.forInsert').html("");
       $('.forInsert').fadeOut(1);
      // $(".login_errorMes").text("");
       // var userN = $(".login_username").val().trim();
       
         var arrivalLoc =  $(".filter__formInput--locFrm").val();
         var dateStart = $(".filter__formInput--date").val();
          var timeStart = $(".filter__formInput--time").val();
        // alert(arrivalLoc+" "+dateStart+timeStart);

        $.ajax({
          url: "./php/getFlight.php",
          dataType: "json",
          type: 'POST',
          data: {
            dateFmAL: dateStart,
            startTimeFmAL:timeStart,
            cityToAL: arrivalLoc,
          },
          success: function (rs) {
 content = ""
 var tfvalue="disabled";
for(i=0; i<rs.length; i++){
  
    content += '<tr>'+
    '<td>'+
    '<div class="BookingTabel_bookingBox">'
        


        +'<span class="bookingBox_FLightNO">' +"Flight Number:"+rs[i]['flightNoAL']+' </span>'
       +'<br><br>' +'<span class="bookingBox_timeCon">'+rs[i]['transferOrNotAL']+' - '+rs[i]['timeConsuAL']+'</span>'
        

        +' <div class="bookingTable__mid">'
            +'<div class="bookingTable_airlineFrm">'
        
                      +'<span class="bookingTable_airlineFrm_region">'+rs[i]['regionCodeFmAL']+'</span>&nbsp&nbsp&nbsp'+"         "
                      +'<span class="bookingTable_airlineFrm_time">'+rs[i]['startTimeFmAL']+'</span>'
                      +'<span class="bookingTable_airlineFrm_city">'+rs[i]['cityFmAL']+'</span>'
                      +'<span class="bookingTable_airlineFrm_date">'+rs[i]['dateFmAL']+'</span>'
                      +'<span class="bookingTable_airlineFrm_week">'+rs[i]['weekFmAL']+'</span>'
            +'</div>'
        
            +'<div class="bookingTable_airlineMid">'
            +'</div>'

            + '<div class="bookingTable_airlineTo">'
                      +'<span class="bookingTable_airlineFrm_region">'+rs[i]['regionCodeToAL']+ '</span>&nbsp&nbsp&nbsp'+"         "
                      +'<span class="bookingTable_airlineFrm_time">'+rs[i]['startTimeToAL']+'</span>'
                      +'<span class="bookingTable_airlineFrm_city">'+rs[i]['cityToAL']+'</span>'
                      +'<span class="bookingTable_airlineFrm_date">'+rs[i]['dateToAL']+'</span>'
                      +'<span class="bookingTable_airlineFrm_week">'+rs[i]['weekToAL']+'</span>'
 
            + '</div>'
            + '<div class="bookingTable_price">'
                      +'<span class="bookingTable_priceSpan">$ '+ rs[i]['priceAL']
                      +'</span>'
            +'</div>' 

        +'</div>' // end of mid
        
         
  
         +'<div class="bookingTable__bottom">'
            +'<span  class="tooltip tooltipDetail" tooltip="Click Seat Availability Button to get more detail">  <button class="bookingTable__detailBtn bookingTable__detailBtnForBox"  id="bookingTable__detailBtn_'+i+'"   >'+"Seat Availability"+'</button></span>'
        +'</div> '

//reserver


+'   <div class="bookingTable__detailBox" id="bookingTable__detailBtn_'+i+'_Box">'
+                               ' <table id="reserveTable" class="reserveTable"><thead>'
                                +'<tr><th>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspClass</th>'
                                +'<th>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspSeat <br>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp Availability</th>'
                                +'<th>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspPrice</th>'
                                +'<th>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp Option </th>'
                                    +'</tr>'
                                   +' </thead>'

                                   +' <tbody>'
+                                        '<tr>'
+'                                      <td>Business</td>'
                                      +  '    <td>2</td>'
 
                                            +'<td>$'+(parseInt(rs[i]['priceAL'])+400) +'</td>'
                                               +'<td><input type="radio"   id="javascript" class="classOptionRad" name="fav_language" value="JavaScript">'
                                       +'</td>'
                                        +'  </tr>'
                                       +' <tr>'
                                         +'   <td> <span>Standard </span></td>'
                                           +' <td> <span>1 </span></td>'
                                  +'<td>$'+(parseInt(rs[i]['priceAL'])+200) +'</td>'
                                          +'<span tooltip="Ticket Radio Button here to pick one seat in your Class" class="tooltip tooltipOption"><td><input type="radio"  id="javascript" name="fav_language" class="classOptionRad" value="JavaScript"></span>'
                                       +'</td>'
                                       +' </tr>'
                                        +'<tr>'
                              /*             +'<td>'+(parseInt(rs[i]['priceAL'])+200) +'</td>'
                                            +'<td>'
                                              +'  <div class="bookingTable__qtyPickCtn">'
                                                +'    <input type="button" value="-"'
                                                  +'      class="bookingTable__qtyPicker--minus">'
                                                   +' <input type="number" value="0" class="bookingTable__qty">'
                                                    +'<input type="button" value="+"'
                                                      +'  class="bookingTable__qtyPicker--plus">'
                                              +'  </div>'
                                            +'</td>'*/


    
                                       +' </tr>'

                                        +'<tr>'
                                 

                                     
                                          +'  <td> <span>Economic </span></td>'
                                            +'<td> <span>0 </span></td>'
 
                  +'<td>$'+(parseInt(rs[i]['priceAL'])) +'</td>'
                       +'<td><input type="radio" '+tfvalue+' id="javascript" class="classOptionRad" name="fav_language" value="JavaScript">'
                                       +'</td>'
                                      +'  </tr>'

                               +' </table>'

+'                                <div class="bookingTable__bottom">'
                        


+'      <span " class="tooltip tooltipRev"> </span> <button class="bookingTable__detailBtn bookingTable__detailBtnForReserve" data-modal-target="#modal"  data-default="reserveFlight"">Reserve</button>'


                               +'                              </div>'
    +'                        </div>'


//reserver


     + '</div></td></tr>';
} 
 
 
 
$('.forInsert').append(content).fadeIn(500);
 
 pageSep();
















              },
          error: function (err) {
           console.log("userN" + userN+" userN" + passW);
 
$(".login_indicatorBox").append("<h5 class='login_errorMes stateMsg' ><img class='errImg' src='./images/errImg.png' alt='errIcon' width='25'  height='15'>wrong account or password</h5>");
 
          }
        });
      });


//getFlight();
//getFlight_DeptDemo()

/*get complaint post_____complaint1*/
function getFlight(){
      $('.forInsert').html("");
   
      $('.forInsert').fadeOut(1);
      
      // $(".login_errorMes").text("");
       // var userN = $(".login_username").val().trim();
       
   //     var arrivalLoc =  $(".filter__formInput--locFrm").val();
     //    var dateStart = $(".filter__formInput--date").val();
       //   var timeStart = $(".filter__formInput--time").val();
        // alert(arrivalLoc+" "+dateStart+timeStart);

        $.ajax({
          url: "./php/getFlight.php",
          dataType: "json",
          type: 'POST',
          data: {
         
          },
          success: function (rs) {
 content = ""
 var tfvalue="disabled";


    content +=  
     '<div class="allPostSpecificPost complaintPost1">' 
   
        //SOF 1 class postBox 1
         + '<div class="BookingTabel_bookingBox rowCTM3 active">'
            //SOF 1.1  postBox_contentBox  1.1   
          +  '<div class="commendBox complaint1 post1 active">'
  
              // SOF 1.1.1 postBox_contentBox_commentNoDisplay  
              +'<div class="allPostCmtBox">'
            +'    <img class="allPostCmtIcon" src="images/iconCmt.png"/>' 
        
                   +'  <div class="allPostPollutionType allPostPollutionType1_demo">   Pest Control     </div> '

              +'</div>'//EDF 1.1.1 postBox_contentBox_commentNoDisplay  1.1.1
          
            
              +'  <div class="allPostContentNFunction">'//SODF  1.1.2.0 allPostContentNFunction

                     //SOF 1.1.2 postBox_contentBox_contentBox 
              +'<div class="cmtInfor cmtInforIndex">'

                 //SOF 1.1.2.1  postBox_contentBox_contentBox_picBox
                +'   <div class="allPostPicBox">'
               +'    <img class="allPostPostImg" src="images/wastePollution.jpg"  />' 
              +'   </div>'
 
                //SOF 1.1.2.2  postBox_contentBox_contentBox_Content
                 +'   <div class="postBox_contentBox_contentBox_Content">'
                      +'   <div class="postBox_contentBox_contentBox_title cmtInProgress2 registerClass" data-modal-target="#modal" data-default="orderList" >'
                        +'    <h3 class="allPostTitle"  data-modal-target="#modal" data-default="orderList">裝修完就將啲廢料丟喺山坡，搞到成個垃圾崗咁！</h3>'
                       
                            +'</div>'
                      +'   <div class="postBox_contentBox_contentBox_author">'
                          +'<table ><tr>'
                           
                            +'<td class="allPostArea">'
                            
                            +'Area: Tsim Sha Tsui/Ashley Road &nbsp&nbsp'
                            +'</td>'
                            // +'</tr><tr>'
                            +'<td class="allPostPostDetail">Posted by</td>'
                            +'<td class="allPostPostDetail">'
                                
                            +'</td>'
                          
                            +'<td class="allPostPostDetail">林立志</td>'
                            +'<td class="allPostPostDetail" style="width:85px;">'
                            +'<span class="allPostPostDetail"> · </span>'
                              +' 18 Jan 2023'
                        

                              +'</td></tr>'

          +'<tr class="allPostFuncRow"><td class="allPostFunctiontd">'
          
          +'<div class="allPostFuncRow">'
   
                     +'<span class="tagArea">dumping</span>'
            +'<span class="tagArea">chemical</span>'


                +  '</td><td>  '
                +  '</td><td>  '
                +  '</td><td>  '
                +  '</td><td>  '
                
                  +'<span> '
                  +'    <img class="allPostFavIcon" src="images/iconFav.jpg"  />' 
                   
                 + '</span>'

            +'</td>'                

           +'  </div>'//EODF  1.2 allPostFunction

+'</tr>'


                              +'  </table>'
                             +'</div>'

               
                    +'</div>'//EOF 1.1.2.2  postBox_contentBox_contentBox_Content

                +'    </div>' //EOF 1.1.2 postBox_contentBox_contentBox 
 
      +'  </div>'//EODF  1.1.2.0 allPostContent&Function
          
              +'  </div>'//EOF 1.1  postBox_contentBox  1.1   
   
            //SOF 1.2 allPostFunction
                 
               +'  </div>'//EODF  class postBox 1
 
                 +'  <div class="mngtFunction postMngtStatus ">'
                 +'<span class="allPostStatusDptTitle">Departments </span>'
           
               
                +'<span class="allPostStatusDpt">EPD</span>'
                +'<span class="allPostStatusDpt">HA</span>'
                +'  </div>'
              +'  </div>'

              //post2 ___________________
               +'<div class="allPostSpecificPost complaintPost2">' 
   
        //SOF 1 class postBox 1
         + '<div class="BookingTabel_bookingBox rowCTM3 active">'
            //SOF 1.1  postBox_contentBox  1.1   
          +  '<div class="commendBox complaint1 post1 active">'
  
              // SOF 1.1.1 postBox_contentBox_commentNoDisplay  
              +'<div class="allPostCmtBox">'
            +'    <img class="allPostCmtIcon" src="images/iconCmt.png"/>' 
        
                   +'  <div class="allPostPollutionType">   Pest Control     </div> '

              +'</div>'//EDF 1.1.1 postBox_contentBox_commentNoDisplay  1.1.1
          
            
              +'  <div class="allPostContentNFunction">'//SODF  1.1.2.0 allPostContentNFunction

                     //SOF 1.1.2 postBox_contentBox_contentBox 
              +'<div class="cmtInfor cmtInforIndex">'

                 //SOF 1.1.2.1  postBox_contentBox_contentBox_picBox
                +'   <div class="allPostPicBox">'
               +'    <img class="allPostPostImg" src="images/fatRat.jpg"  />' 
              +'   </div>'

                //SOF 1.1.2.2  postBox_contentBox_contentBox_Content
                 +'   <div class="postBox_contentBox_contentBox_Content">'
                      +'   <div class="postBox_contentBox_contentBox_title cmtInProgress">'
                        +'    <h3 class="allPostTitle"> 放食環署鼠餌, 反養肥老鼠</h3>'
                        
                            +'</div>'
                      +'   <div class="postBox_contentBox_contentBox_author">'
                          +'<table ><tr>'
                           
                            +'<td class="allPostArea">'
                            
                            +'Area: Mong Kok/Fa Yuen Street &nbsp&nbsp'
                            +'</td>'
                            // +'</tr><tr>'
                            +'<td class="allPostPostDetail">Posted by</td>'
                            +'<td class="allPostPostDetail">'
  
                            +'</td>'
                          
                            +'<td class="allPostPostDetail">林立志</td>'
                            +'<td class="allPostPostDetail" style="width:85px;">'
                            +'<span class="allPostPostDetail"> · </span>'
                              +' 19 Jan 2023'
                        

                              +'</td></tr>'

          +'<tr class="allPostFuncRow"><td class="allPostFunctiontd">'
          
          +'<div class="allPostFuncRow">'
            +'<span class="tagArea">rat</span>'

                +  '</td><td>  '
                +  '</td><td>  '
                +  '</td><td>  '
                +  '</td><td>  '
                
                  +'<span> '
                  +'    <img class="allPostFavIcon" src="images/iconFav.jpg"  />' 
                   
                 + '</span>'

            +'</td>'                

           +'  </div>'//EODF  1.2 allPostFunction

+'</tr>'


                              +'  </table>'
                             +'</div>'

               
                    +'</div>'//EOF 1.1.2.2  postBox_contentBox_contentBox_Content

                +'    </div>' //EOF 1.1.2 postBox_contentBox_contentBox 
 
      +'  </div>'//EODF  1.1.2.0 allPostContent&Function
          
              +'  </div>'//EOF 1.1  postBox_contentBox  1.1   
   
            //SOF 1.2 allPostFunction
                 
               +'  </div>'//EODF  class postBox 1
 
                 +'  <div class="mngtFunction postMngtStatus ">'
                 +'<span class="allPostStatusDptTitle">Department </span>'
                +'<span class="allPostStatusDpt">FEHD</span>'
               +'<span class="allPostStatusDpt"></span>'
                 +'<span class="allPostStatusDpt"></span>'
                +'  </div>'
              +'  </div>'


              //post3____________
              +'<div class="allPostSpecificPost complaintPost3">' 
   
        //SOF 1 class postBox 1
         + '<div class="BookingTabel_bookingBox rowCTM3 active">'
            //SOF 1.1  postBox_contentBox  1.1   
          +  '<div class="commendBox complaint1 post1 active">'
  
              // SOF 1.1.1 postBox_contentBox_commentNoDisplay  
              +'<div class="allPostCmtBox">'
            +'    <img class="allPostCmtIcon" src="images/iconCmt.png"/>' 
        
                   +'  <div class="allPostPollutionType">   Air Pollution     </div> '

              +'</div>'//EDF 1.1.1 postBox_contentBox_commentNoDisplay  1.1.1
          
            
              +'  <div class="allPostContentNFunction">'//SODF  1.1.2.0 allPostContentNFunction

                     //SOF 1.1.2 postBox_contentBox_contentBox 
              +'<div class="cmtInfor cmtInforIndex">'

                 //SOF 1.1.2.1  postBox_contentBox_contentBox_picBox
                +'   <div class="allPostPicBox">'
               +'    <img class="allPostPostImg" src="images/cdust.jpg"  />' 
              +'   </div>'

                //SOF 1.1.2.2  postBox_contentBox_contentBox_Content
                 +'   <div class="postBox_contentBox_contentBox_Content">'
                      +'   <div class="postBox_contentBox_contentBox_title cmtInProgress">'
                        +'    <h3 class="allPostTitle">Intolerable dust around IVE</h3>'
                        
                            +'</div>'
                      +'   <div class="postBox_contentBox_contentBox_author">'
                          +'<table ><tr>'
                           
                            +'<td class="allPostArea">'
                            
                            +'Area: Tsim Sha Tsui/Ashley Road &nbsp&nbsp'
                            +'</td>'
                            // +'</tr><tr>'
                            +'<td class="allPostPostDetail">Posted by</td>'
                            +'<td class="allPostPostDetail">'
                                   
                            +'</td>'
                          
                            +'<td class="allPostPostDetail">林立志</td>'
                            +'<td class="allPostPostDetail" style="width:85px;">'
                            +'<span class="allPostPostDetail"> · </span>'
                              +' 18 Jan 2023'
                        

                              +'</td></tr>'

          +'<tr class="allPostFuncRow"><td class="allPostFunctiontd">'
          
          +'<div class="allPostFuncRow">'
            +'<span class="tagArea">Dust</span>'
            

                +  '</td><td>  '
                +  '</td><td>  '
                +  '</td><td>  '
                +  '</td><td>  '
                
                  +'<span> '
                  +'    <img class="allPostFavIcon" src="images/iconFav.jpg"  />' 
                   
                 + '</span>'

            +'</td>'                

           +'  </div>'//EODF  1.2 allPostFunction

+'</tr>'


                              +'  </table>'
                             +'</div>'

               
                    +'</div>'//EOF 1.1.2.2  postBox_contentBox_contentBox_Content

                +'    </div>' //EOF 1.1.2 postBox_contentBox_contentBox 
 
      +'  </div>'//EODF  1.1.2.0 allPostContent&Function
          
              +'  </div>'//EOF 1.1  postBox_contentBox  1.1   
   
            //SOF 1.2 allPostFunction
                 
               +'  </div>'//EODF  class postBox 1
 
                 +'  <div class="mngtFunction postMngtStatus ">'
             +'<span class="allPostStatusDptTitle">Department </span>'
                +'<span class="allPostStatusDpt">EPD</span>'
               +'<span class="allPostStatusDpt"></span>'
                 +'<span class="allPostStatusDpt"></span>'
                +'  </div>'
              +'  </div>'

             
 
console.log(content)
$('.forInsert').append(content);
  $('.forInsert').fadeIn(500);

// pageSep();





              },
          error: function (err) {
           console.log("userN" + userN+" userN" + passW);
 
$(".login_indicatorBox").append("<h5 class='login_errorMes stateMsg' ><img class='errImg' src='./images/errImg.png' alt='errIcon' width='25'  height='15'>wrong account or password</h5>");
 
          }
        });

}


/*get complaint post_____complaint1*/
function getFlight_DeptDemo(){
      $('.forInsert').html("");
   
      $('.forInsert').fadeOut(1);
      
      // $(".login_errorMes").text("");
       // var userN = $(".login_username").val().trim();
       
   //     var arrivalLoc =  $(".filter__formInput--locFrm").val();
     //    var dateStart = $(".filter__formInput--date").val();
       //   var timeStart = $(".filter__formInput--time").val();
        // alert(arrivalLoc+" "+dateStart+timeStart);

        $.ajax({
          url: "./php/getFlight.php",
          dataType: "json",
          type: 'POST',
          data: {
         
          },
          success: function (rs) {
 content = ""
 var tfvalue="disabled";


    content +=  
     '<div class="allPostSpecificPost complaintPost1">' 
   
        //SOF 1 class postBox 1
         + '<div class="BookingTabel_bookingBox rowCTM3 active">'
            //SOF 1.1  postBox_contentBox  1.1   
          +  '<div class="commendBox complaint1 post1 active">'
  
              // SOF 1.1.1 postBox_contentBox_commentNoDisplay  
              +'<div class="allPostCmtBox">'
            +'    <img class="allPostCmtIcon" src="images/iconCmt.png"/>' 
        
                   +'  <div class="allPostPollutionType allPostPollutionType1_demo">   Pest Control     </div> '

              +'</div>'//EDF 1.1.1 postBox_contentBox_commentNoDisplay  1.1.1
          
            
              +'  <div class="allPostContentNFunction">'//SODF  1.1.2.0 allPostContentNFunction

                     //SOF 1.1.2 postBox_contentBox_contentBox 
              +'<div class="cmtInfor cmtInforIndex">'

                 //SOF 1.1.2.1  postBox_contentBox_contentBox_picBox
                +'   <div class="allPostPicBox">'
               +'    <img class="allPostPostImg" src="images/wastePollution.jpg"  />' 
              +'   </div>'
 
                //SOF 1.1.2.2  postBox_contentBox_contentBox_Content
                 +'   <div class="postBox_contentBox_contentBox_Content">'
                      +'   <div class="postBox_contentBox_contentBox_title cmtInProgress2 registerClass" data-modal-target="#modal" data-default="orderList" >'
                        +'    <h3 class="allPostTitle"  data-modal-target="#modal" data-default="orderList">裝修完就將啲廢料丟喺山坡，搞到成個垃圾崗咁！</h3>'
                       
                            +'</div>'
                      +'   <div class="postBox_contentBox_contentBox_author">'
                          +'<table ><tr>'
                           
                            +'<td class="allPostArea">'
                            
                            +'Area: Tsim Sha Tsui/Ashley Road &nbsp&nbsp'
                            +'</td>'
                            // +'</tr><tr>'
                            +'<td class="allPostPostDetail">Posted by</td>'
                            +'<td class="allPostPostDetail">'
                                
                            +'</td>'
                          
                            +'<td class="allPostPostDetail">林立志</td>'
                            +'<td class="allPostPostDetail" style="width:85px;">'
                            +'<span class="allPostPostDetail"> · </span>'
                              +' 18 Jan 2023'
                        

                              +'</td></tr>'

          +'<tr class="allPostFuncRow"><td class="allPostFunctiontd">'
          
          +'<div class="allPostFuncRow">'
   
                     +'<span class="tagArea">dumping</span>'
            +'<span class="tagArea">chemical</span>'


                +  '</td><td>  '
                +  '</td><td>  '
                +  '</td><td>  '
                +  '</td><td>  '
                
                  +'<span> '
                  +'    <img class="allPostFavIcon" src="images/iconFav.jpg"  />' 
                   
                 + '</span>'

            +'</td>'                

           +'  </div>'//EODF  1.2 allPostFunction

+'</tr>'


                              +'  </table>'
                             +'</div>'

               
                    +'</div>'//EOF 1.1.2.2  postBox_contentBox_contentBox_Content

                +'    </div>' //EOF 1.1.2 postBox_contentBox_contentBox 
 
      +'  </div>'//EODF  1.1.2.0 allPostContent&Function
          
              +'  </div>'//EOF 1.1  postBox_contentBox  1.1   
   
            //SOF 1.2 allPostFunction
                 
               +'  </div>'//EODF  class postBox 1
 
                 +'  <div class="mngtFunction postMngtStatus ">'
                 +'<span class="allPostStatusDptTitle">Departments </span>'
           
               
                +'<span class="allPostStatusDpt">EPD</span>'
                +'<span class="allPostStatusDpt">HA</span>'
                +'  </div>'
              +'  </div>'

            
             
 
console.log(content)
$('.forInsert').append(content);
  $('.forInsert').fadeIn(500);

// pageSep();





              },
          error: function (err) {
           console.log("userN" + userN+" userN" + passW);
 
$(".login_indicatorBox").append("<h5 class='login_errorMes stateMsg' ><img class='errImg' src='./images/errImg.png' alt='errIcon' width='25'  height='15'>wrong account or password</h5>");
 
          }
        });

}



 







//for detail of flight_______________
 
function showDetailBox(index){
    var element="#showDetailBox_"+index+"_Box";
    alert(element);
    if ( $(element).css('display') == 'none' || $(element).css("visibility") == "hidden"){
    // 'element' is hidden
//}
             //   if (isHidden) {
                    $(element).slideDown();
                    
                } else {
             
                    $(element).slideUp();
                }

}
 /*後加載處理
 
 */
//$('body bookingTable__detailBtn').on('click', function(e){

 
$('body').on('change','.classOptionRad', function(){
$('.tooltipOption').removeAttr('tooltip')
$('.tooltipRev').attr('tooltip','Click Reserve Button to submit the reservation')
//$('.tooltipRev').addClass('active')
})
  
$('body').on('click','.bookingTable__detailBtnForReserve', function(){
$('.tooltipRev').removeAttr('tooltip')
//$('.tooltipRev').attr('tooltip','Click Reserve Button to submit the reservation')
//$('.tooltipRev').addClass('active')
})
 

$('body').on('click','.bookingTable__detailBtnForBox', function(e){
  $('.tooltipDetail').removeAttr('tooltip');
    idOfBox ="#"+e.target.id+"_Box";
   /*
   
   */
   /*var idOfBox ="#"+e.target.id+" .bookingTable__detailBox"; 
   box is not the subelement of button...

   */
   /* 
  so it would better to have data-attribute for the element.
 */

 
   //bookingTable__detailBtn_1
  //  alert(idOfBox);
  //$('.bookingTable__detailBox:hidden'
  //ref
  //https://stackoverflow.com/questions/178325/how-do-i-check-if-an-element-is-hidden-in-jquery?page=1&tab=scoredesc#tab-top
               // var isHidden = $(".bookingTable__detailBox").is(":hidden");
 //               var isHidden =$('.bookingTable__detailBox:hidden')// $(".bookingTable__detailBox").is(":hidden"); 
    if ( $( idOfBox+':hidden').css('display') == 'none' || $( '.bookingTable__detailBox:hidden').css("visibility") == "hidden"){
   
      //if($( '#bookingTable__detailBtn_1_Box').length){alert("boxById exists");} 
       //if($( '.bookingTable__detailBox' ).length){alert("box exists");} 
                // 'element' is hidden
//}

/*    alert("This: "+ this 
          + "\nThis id: "+this.id
          + "\n\nEvent: "+e.id
          +" \nEvent.target: "+e.target
          +"\nEvent.target.id: "+e.target.id)
 */
 
          $(idOfBox).slideDown();
                   
                } else {
                      $(idOfBox).slideUp();
          //        $('.tooltipDetail').attr('tooltip','Click Reserve Button to check out more detail');
                }
})
  

//reserve
/*
$('sumbitReserve').click(function(){

  $('.confirmmsgBox').addClass('active');
})
*/
 
$('body').on('click','.bookingTable__detailBtnForReserve', function(e){
 
})
//__________________________end of reserve


//close the msg of reservation
 
function pageSep() {
         $('.pagination').html('');

var table = $('#mytable')


      $('.pagination').html('')
      var trnum = 0
      var maxRows = 15;//parseInt($(this).val())

      //      var totalRows = $(table + '  tbody tr').length
      var totalRows = $('tbody tr').length
      //    $(table + ' tr:gt(0)').each(function () {
      $('tr:gt(0)').each(function () {
        trnum++ 
        if (trnum > maxRows) {

          $(this).hide()
//            alert('Max'+maxRows+' '+'t'
        }
        if (trnum <= maxRows) {
          $(this).show()
        }
      })
    
    
    //____________________
      if (totalRows > maxRows) {
        var pagenum = Math.ceil(totalRows / maxRows)
        for (var i = 1; i <= pagenum;) {
          $('.pagination').append('<li data-page="' + i + '">\<span>' + i++ +
            '<span class="sr-only">(current)</span></span>\</li>').show()
         }
      }
      $('.pagination li:first-child').addClass('active')


      //function for swtich page
      $('.pagination li').on('click', function () {

        var pageNum = $(this).attr('data-page')
        var trIndex = 0;

        $('.pagination li').removeClass('active')
        $(this).addClass('active')
        $('tr:gt(0)').each(function () {

          trIndex++;
          if (trIndex > (maxRows * pageNum) || trIndex <= ((maxRows * pageNum) - maxRows)) {
            $(this).hide()

          } else {
            $(this).show()
          }

        })

      })

    }
   
   ///end of click max
   
   
   
 
    //Quantity selector

    $(document).on('click', '.bookingTable__qtyPicker--plus', function () {
        $(this).prev().val(+$(this).prev().val() + 1);
    });
    $(document).on('click', '.bookingTable__qtyPicker--minus', function () {
        if ($(this).next().val() > 0) $(this).next().val(+$(this).next().val() - 1);
    });


$('.cmtManagement').click(function(){
  //clear the html, should don't need to remove
    getComplaint();
    $('.switch-button').addClass('switch-active');
        $('.filterForm').addClass('hideClass');
})
$('.searchFlightHeaderLink').click(function(){
  //clear the html, should don't need to remove
    getFlight();
    $('.switch-button').removeClass('switch-active');
 
        $('.filterForm').removeClass('hideClass');
})



 
$(document).on('click','.cmtInProgress',function(){
   
  //clear the html, should don't need to remove
  
  window.location.href = "indexOfComplaint2.html";
  

})








   });

   