<?php
include "config.php";

extract($_POST);
// Perform a query

$sql = "SELECT * FROM `reports` as rep  left join users
on rep.repNormalUser=users.userID  where   repCurrentStatus!='approved' and repCurrentStatus!='unapproved'  ";
 
 
$result = mysqli_query($conn, $sql);

$record = array();
// Fetch data

if (mysqli_num_rows($result) > 0) {
    while ($row = mysqli_fetch_assoc($result)) {




$image_data = base64_encode($row['repAttach']);

// Create an associative array with both binary image data and other data
$record[] = array(
	'repID' => $row['repID'],
    'repTitle' => $row['repTitle'],
	'repDateSubmit' => $row['repDateSubmit'],
	'repType' => $row['repType'],
	'repTypeSpecification' => $row['repTypeSpecification'],
	'repLocationDetail' => $row['repLocationDetail'],
	'repLocationDetail' => $row['repLocationDetail'],
	'repLocationY' => $row['repLocationY'],
  
	'repDatePeriodBegin' => $row['repDatePeriodBegin'],
	'repDatePeriodEnd' => $row['repDatePeriodEnd'],
	'repContent' => $row['repContent'],
	'repNormalUser' => $row['repNormalUser'],
	'repDept' => $row['repDept'],
	'repCurrentStatus'=> $row['repCurrentStatus'],
	

	'userID' => $row['userID'],
	'userName' => $row['userName'],
	'userDept' => $row['userDept'],
	'userPassword' => $row['userPassword'], 
	 
    'repAttach' => $image_data);
 }
			echo  json_encode($record);
} else {
    echo "No results found.";
}

// Close connection
mysqli_close($conn);


?>