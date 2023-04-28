<?php
include "config.php";
extract($_POST);
// Perform a query
$sql = "SELECT * FROM `repstatus` 
left join users on users.userID = repstatus.repUserID 
where repstatus.repStatusFKreports='$repID' and users.userDept not in('Operator','complainer')";


$result = mysqli_query($conn, $sql);

$record = array();
// Fetch data
$statusPre='approved';
if (mysqli_num_rows($result) > 0) {
    while ($row = mysqli_fetch_assoc($result)) {

$image_data = base64_encode($row['repStatusAttach']);

// Create an associative array with both binary image data and other data
$record[] = array(

	'userID' => $row['userID'],
	'userName' => $row['userName'],
    'userDept' => $row['userDept'],

	'repStatusID' => $row['repStatusID'],
	'repStatusType' => $row['repStatusType'],
	'repStatusDateCreated' => $row['repStatusDateCreated'],
	'repStatusFKreports' => $row['repStatusFKreports'],
	'repUserID' => $row['repUserID'],
	'repStatusRemark' => $row['repStatusRemark'],
	'repStatusAttach' => $image_data,
	'repStatusAttachName' => $row['repStatusAttachName'],

	
	'statusPre' => $statusPre,
    'repAttach' => $image_data);

	$statusPre=$row['repStatusType'];
 }
			echo  json_encode($record);
} else {
    echo "No results found.";
}

// Close connection
mysqli_close($conn);


?>