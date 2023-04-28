<?php
include "config.php";
extract($_POST);
 
  

foreach ($mailIDSet as $record) {
    $sql_query = "UPDATE mail SET isRead =1 WHERE id= ?";
    $stmt = mysqli_prepare($conn, $sql_query);
    mysqli_stmt_bind_param($stmt, "i", $record);
   


  

try {
    mysqli_stmt_execute($stmt);
       echo json_encode(['success' => true]);
} catch(PDOException $e) {
    echo "Error: " . $e->getMessage();
    
}
}

// Execute the statement
 
      
      
  

// Close the statement and the connection
$stmt_insertMail->close();
 
$conn->close();


?>