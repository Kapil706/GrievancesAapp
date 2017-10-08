<?php
$db = mysqli_connect("localhost", "root", "", "users");
if(isset($_POST['mobile'])){
       $phon   = mysqli_real_escape_string($db,$_POST['mobile']);
       $pas  = mysqli_real_escape_string($db,$_POST['password']);
$sql = "SELECT * FROM users WHERE phone= $phon AND password=$pas";
		$result = $db->query($sql);

if ($result->num_rows == 1) {
    // output data of each row
    $row = $result->fetch_assoc();
       echo $row["id"] ;
    }else{
		echo "false";
		}
}else{
	echo "exception";
}
?>