<?php
$db = mysqli_connect("localhost", "root", "", "users");
if(isset($_POST['mobile'])){
       $phon   = mysqli_real_escape_string($db,$_POST['mobile']);
       $pas  = mysqli_real_escape_string($db,$_POST['password']);
$sql = "SELECT * FROM zone_login WHERE zon= '$phon' AND pass='$pas'";
		$result = $db->query($sql);

if ($result->num_rows == 1) {
    // output data of each row
    
       echo $phon ;
    }else{
		echo "false";
		}
}else{
	echo "exception";
}
?>