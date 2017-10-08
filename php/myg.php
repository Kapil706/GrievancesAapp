<?php
$db = mysqli_connect("localhost", "root", "", "users");
if(isset($_POST['id'])){
       $id   = mysqli_real_escape_string($db,$_POST['id']);
$sql = "SELECT * FROM comp WHERE cust_id= $id";
		$result = $db->query($sql);

if ($result->num_rows >0) {
    // output data of each row
    while($row = $result->fetch_assoc()) {
       $output[]=$row;
    }
	
       echo json_encode($output) ;
    }else{
		echo "false";
		}
}else{
	echo "exception";
}
?>