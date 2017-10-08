<?php
$db = mysqli_connect("localhost", "root", "", "users");
if(isset($_POST['id'])){
       $phon   = mysqli_real_escape_string($db,$_POST['id']);
$sql = "UPDATE comp SET status= 'completed' WHERE id='$phon'";
		

 if($db->query($sql) === TRUE){
			
     echo "true";
		}else{
		echo "false";
		}
}else{
	echo "exception";
}
?>