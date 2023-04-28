<?php
include "config.php";
extract($_POST);

$datetime=date('Y-m-d H:i:s');
  // Create the SQL statement with placeholders for the values

   $image_data =null;
    $image_name =null;
if (isset($_FILES['image']) && is_uploaded_file($_FILES['image']['tmp_name'])) {
  $image_info = exif_imagetype($_FILES['image']['tmp_name']);
  
 $image_data = file_get_contents($_FILES['image']['tmp_name']);
  $image_name = uniqid() . '.' . image_type_to_extension($image_info);
  $image_path = './uploads/' . $image_name;
  file_put_contents($image_path, $image_data);
 
   
} 













 

// Prepare the statement
$stmt_insertRepStatus = $conn->prepare("INSERT INTO 
repstatus (repStatusID,repStatusType,repStatusDateCreated,
repStatusFKreports,repStatusRemark,repUserID,repStatusAttach,repStatusAttachName)

 VALUES (?,?,?,?,?,?,?,?)");

// Bind the parameters to the placeholders
$stmt_insertRepStatus->bind_param("issisiss", $repStatusID, $repStatusType, $datetime, $repID,
$repStatusRemark, $repUserID,$image_data,$image_name);


$stmt_updateCurrentStatus = $conn->prepare("UPDATE reports SET repCurrentStatus=? WHERE repID=?");
$stmt_updateCurrentStatus->bind_param("si", $repStatusType, $repID);

 


// Execute the statement

if ($stmt_insertRepStatus->execute()) {
 
         if ($stmt_updateCurrentStatus->execute()) {
         echo json_encode(['success' => true]);
      } else {
         echo "Error: " . $sql_insert . "<br>" . $conn->error;
      }
} else {
   echo "Error: " . $sql_insert . "<br>" . $conn->error;
}

// Close the statement and the connection
$stmt_insertRepStatus->close();
$stmt_updateCurrentStatus->close();
$conn->close();


?>