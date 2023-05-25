
$(document).ready(function () {
 getGroupOfComplaint()
 

function getGroupOfComplaint(){
      $('.Insert_Group').html("");
   
      $('.Insert_Group').fadeOut(1);
   
 content = ""
 var tfvalue="disabled";


    content +=   

    
'<ul class="urgentListBox" >'  


  +'<li >'//
  +'<div class="favTag">'
+'  <div class="urgentBox">'

+'Cherry Street Park'
+'</div>'

+'  <div class="urgentBox">'

+'last 10 days'
+'</div>'

+'  <div class="urgentBox">'

+'Pet Control'
+'</div>'

+'</div>'
    +'<ul >' //l#1.1  SOF specificGroupUnderGrouplist
 //l#1.1.1

      +' <li >Pest Control: last 10 days'//

      /*pos3____________________________________________*/

       +'<div class="allPostSpecificPost">'+
   
        //SOF 1 class postBox 1
          '<div class="BookingTabel_bookingBox rowCTM3 active">'+
            //SOF 1.1  postBox_contentBox  1.1   
            '<div class="commendBox complaint1 post1 active">'
  
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
                                                        +'<span class="allPostPostDetail"> · </span>'
                                           +'    <img class="allPostAuthor" src="images/pp2.png"  />' 

                            +'</td>'
                          
                            +'<td class="allPostPostDetail">Vincent</td>'
                            +'<td class="allPostPostDetail" style="width:85px;">'
                            +'<span class="allPostPostDetail"> · </span>'
                              +' 18 Jan 2023'
                        

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
                +'     Wait in line <span class="allPostStatusDpt">FEHD </span>'
                +'  </div>'
              +'  </div>'
 
 //eof  //l#1.1.1        
+'  </li>'
  //SOF l#1.1.2        

  
      +' <li >16-Jan-2023: Fact Check'//
  
      /*pos3____________________________________________*/
          
       +'<div class="allPostSpecificPost">'+
   
        //SOF 1 class postBox 1
          '<div class="BookingTabel_bookingBox rowCTM3 active">'+
            //SOF 1.1  postBox_contentBox  1.1   
            '<div class="commendBox complaint1 post1 active">'
  
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
                                                        +'<span class="allPostPostDetail"> · </span>'
                                           +'    <img class="allPostAuthor" src="images/pp2.png"  />' 

                            +'</td>'
                          
                            +'<td class="allPostPostDetail">Vincent</td>'
                            +'<td class="allPostPostDetail" style="width:85px;">'
                            +'<span class="allPostPostDetail"> · </span>'
                              +' 18 Jan 2023'
                        

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
                +'     Wait in line <span class="allPostStatusDpt">FEHD </span>'
                +'  </div>'
               +  '</td>'
 
 //eof  //l#1.1.1        
+'  </li>'




//______________________________3

      +' <li >16-Jan-2023: Fact Check'//
  
      /*pos3____________________________________________*/
          
       +'<div class="allPostSpecificPost">'+
   
        //SOF 1 class postBox 1
          '<div class="BookingTabel_bookingBox rowCTM3 active">'+
            //SOF 1.1  postBox_contentBox  1.1   
            '<div class="commendBox complaint1 post1 active">'
  
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
                                                        +'<span class="allPostPostDetail"> · </span>'
                                           +'    <img class="allPostAuthor" src="images/pp2.png"  />' 

                            +'</td>'
                          
                            +'<td class="allPostPostDetail">Vincent</td>'
                            +'<td class="allPostPostDetail" style="width:85px;">'
                            +'<span class="allPostPostDetail"> · </span>'
                              +' 18 Jan 2023'
                        

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
                +'     Wait in line <span class="allPostStatusDpt">FEHD </span>'
                +'  </div>'
               +  '</td>'
 
 //eof  //l#1.1.1        
+'  </li>'


 
 +'</ul>' //EOF specificGroupUnderGrouplist
 

 +'  </li>'
 

 +'</ul>' //EOF Grouplist
console.log(content)
$('.Insert_Group').append(content);
  $('.Insert_Group').fadeIn(500);

// pageSep();



 
}

   });

   