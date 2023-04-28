 
<?php
 
	$hostname = "127.0.0.1";
	$username = "root";
	$pwd = "";
	$db = ' itp4511_project';
 
	    $conn = mysqli_connect($hostname, $username, $pwd, $db) or die(mysqli_connect_error());
		
 
if (!$conn) {
  die("Connection failed: " . mysqli_connect_error());
}

?>