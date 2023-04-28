<?php
include "config.php";

extract($_POST);
 
 
$update_query = "UPDATE reports SET $attribute='$value' WHERE repID='$repID'";


if (mysqli_query($conn, $update_query)) {
   
    echo json_encode(['success' => true]);
} else {
 
    echo json_encode(['success' => false, 'error' => mysqli_error($conn)]);
}

mysqli_close($conn);








?>