<?php
$db = mysqli_connect("localhost", "root", "", "users");
if(isset($_POST['id'])){
       $id   = mysqli_real_escape_string($db,$_POST['id']);
$sql = "SELECT * FROM zone where zonel='$id'";
		$result = mysqli_query($db,$sql);

if (mysqli_num_rows($result)==1) {
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