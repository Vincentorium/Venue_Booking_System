
$(document).ready(function(){


 

 
 $(".loginSubm2it").click(function () {
         
 
      
            
        var userAcc = $("#username").val().trim();
        var userPassword = $("#password").val().trim();
       
 
        $.ajax({
          url: "./php/login.php",
          dataType: "json",
          type: 'POST',
          data: {
            userAcc: userAcc,

            userPassword: userPassword
          },
          success: function (result) {		
          	$.cookie('userName', userAcc, { expires: 7, path: '/' });
	          $.cookie('userType', result.userType, { expires: 7, path: '/' });
            $.cookie('userID', result.userID, { expires: 7, path: '/' });
             
			        window.location.href = "mainPage.html";

              },
          error: function (err) {
           alert("incorrect username or password.")
  
          }
        });
      });//EO Click Method
 
 
 
    })





 