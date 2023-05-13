
$(document).ready(function () {

var userName= $.cookie('name')

console.log("demo")
 


 
 
 

$('.complaintButton1').click(function(){
 
	$('.complaintPost1').addClass('demonHide')
})



$('.demoLogOut').click(function(){

    $.removeCookie('userID' , {path: '/'  });
    $.removeCookie('userType' , {path: '/'  });
    $.removeCookie('userName' , {path: '/'  });
window.location.href = "login.jsp";
	
})


$('.complaintList1').click(function(){

    $('.complaintBox2').addClass('demonHide')
    $('.complaintBox1').removeClass('demonHide')

})



$('.complaintList2').click(function(){


    $('.complaintBox1').addClass('demonHide')
    $('.complaintBox2').removeClass('demonHide')

	
})

$('.complaintSubmitButton').click(function(){

		if(userName==="EPD"){
			
			$('.complaintBoxPost1').removeClass('demonHide')
        $('.postMngtStatus').append( '<span class="allPostStatusDpt">HA</span>')
$('.complaintPost1').addClass('demonHide')
    $('.demonList1').removeClass('demonHide')
			alert('Sumbit Successfully')
		


		}else if(userName==="HA"){

			$('.complaintBoxPost2').removeClass('demonHide')
			$('.demonList1').removeClass('demonHide')
			$('.statusComplaints1').html('Solved')
		alert('Sumbit Successfully')
			
			
		}
	
})

$('.complaintButton1').click(function(){
	alert('Approved Successfully')
})



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
               //  +'<span class="allPostStatusDpt">HA</span>'
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
        
                   +'  <div class="allPostPollutionType">   Pest Control     </div> '

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

             
 
$('.forInsert').append(content);
  $('.forInsert').fadeIn(500);

 

}


/*get complaint post_____complaint1*/
function getFlight_DeptDemo(){
      $('.forInsert').html("");
   
      $('.forInsert').fadeOut(1);
      
 

   
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
                //+'<span class="allPostStatusDpt">HA</span>'
                +'  </div>'
              +'  </div>'

            
             
 
 
$('.forInsert').append(content);
  $('.forInsert').fadeIn(500);

// pageSep();





}

	if(userName!="meow"){
 $('.allPostPollutionType1_demo').html("Waste Pollution")

  }
  if(userName==="HA"){

    $('.postMngtStatus').append( '<span class="allPostStatusDpt">HA</span>')
    
}
 })
