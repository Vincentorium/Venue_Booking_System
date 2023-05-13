'use strict';

var switchButton 			= document.querySelector('.switch-button');
var switchBtnRight 			= document.querySelector('.switch-button-case.right');
var switchBtnLeft 			= document.querySelector('.switch-button-case.left');
var activeSwitch 			= document.querySelector('.activeSwitch');

function switchLeft(){
	switchBtnRight.classList.remove('active-case');
	switchBtnLeft.classList.add('active-case');
	activeSwitch.style.left 						= '0%';
}

function switchRight(){
	switchBtnRight.classList.add('active-case');
	switchBtnLeft.classList.remove('active-case');
	activeSwitch.style.left 						= '50%';
 
}

switchBtnLeft.addEventListener('click', function(){
	switchLeft();
}, false);

switchBtnRight.addEventListener('click', function(){
	switchRight();
}, false);

$(document).on('click','.left',function(e){

 
	$('.complaintTableBox').addClass('allPostTableBoxHide').slideUp(0).slideDown(500);
 
	
	
		$('.Insert_UnGroup').removeClass('allPostTableBoxHide').slideUp(0).slideDown(500);
	 
	})
$(document).on('click','.right',function(e){
	
 
	
		$('.Insert_UnGroup').addClass('allPostTableBoxHide').slideUp(0).slideDown(500);
$('.complaintTableBox').removeClass('allPostTableBoxHide').slideUp(0).slideDown(500);

})

 