<?php
include "config.php";
extract($_POST);

$datetime=date('Y-m-d H:i:s');
$isSent=1;
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
$stmt_insertMail = $conn->prepare(
   "INSERT INTO `mail`
   (`id`, `dateCreated`, `title`, `content`, `attachName`, `attachment`, `FKrepID`, `FKOfficerId`,`isSent`) 
VALUES (?,?,?,?,?,?,?,?,?)");

// Bind the parameters to the placeholders
$stmt_insertMail->bind_param("isssssiii", $id, $datetime, $title, $content,
$image_name,$image_data, $FKrepId,$FKOfficerId,$isSent);
 
 

try {
    $stmt_insertMail->execute();
       echo json_encode(['success' => true]);
} catch(PDOException $e) {
    echo "Error: " . $e->getMessage();
    
}

// Execute the statement
 
      
      
  

// Close the statement and the connection
$stmt_insertMail->close();
 
$conn->close();


?>