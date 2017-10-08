<?php
$db = mysqli_connect("localhost", "root", "", "users");
if(isset($_POST['id'])){
       $id   = mysqli_real_escape_string($db,$_POST['id']);
$sql = "SELECT * FROM users WHERE id= $id ";
		$result = $db->query($sql);

if ($result->num_rows >0) {
    // output data of each row
    $row = $result->fetch_assoc();
       echo $row["fname"] ;
    }else{
		echo "false";
		}
}else{
	echo "exception";
}
?>