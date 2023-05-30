 


        
 
$(document).on('click','.venuAddGuest--out',function(e){
  
  
  $(".venueForm--addGuest").removeClass("demonHide")
  
  $(".venuAddGuest--out").addClass("demonHide")
});





$(document).on('click','.venuAddGuest--in--cancel',function(e){


    $(".venueForm--addGuest").addClass("demonHide")

    $(".venuAddGuest--out").removeClass("demonHide")
});




$(document).ready(function(){
    $(document).on("submit","#venueForm--addGuest",function(e){
        e.preventDefault();


        inserUser(this)

    });

    $(document).on("click",".delGuest",function(e){
        e.preventDefault();
        e.stopPropagation();

        deleteUser($(this).data("userid"))

    });







});




