function checkForCancelBooking() {
	$.ajax({
		url: "./php/getReportNum.php",
		type: "GET",
		success: function(data) {
			if (        data.numOfRep  > numOfReport) {
				alert("You have " + (data.numOfRep-numOfReport)+ " new mails!");
			}
		},
		error: function(xhr, status, error) {
			console.log(error);
		}
	});
}
var numOfReport;
getReportNum()
function getReportNum() {
	$.ajax({
		url: "./php/getReportNum.php",
		type: "GET",
		dataType: "json",
		success: function(data) {
			numOfReport =data.numOfRep;

		},
		error: function(xhr, status, error) {
			console.log(error);
		}
	});
}

setInterval(checkForCancelBooking, 5000);
