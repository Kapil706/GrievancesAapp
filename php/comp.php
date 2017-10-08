<?php
$db = mysqli_connect("localhost", "root", "", "users");
if(isset($_POST['zone'])){
       $zon   = mysqli_real_escape_string($db,$_POST['zone']);
       $comp  = mysqli_real_escape_string($db,$_POST['comp']);
       $id  = mysqli_real_escape_string($db,$_POST['id']);
       $status = mysqli_real_escape_string($db,$_POST['status']);
$sql = "INSERT INTO comp (zone,cust_id,complaint,status) VALUES('$zon','$id','$comp','$status')";
		$result = $db->query($sql);

 if($db->query($sql) === TRUE){
			
     echo "true";
		}else{
		echo "false";
		}
}else{
	echo "exception";
}
?>