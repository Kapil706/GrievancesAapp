<?php
$db = mysqli_connect("localhost", "root", "", "users");
if(isset($_POST['fullname'])){
       $fnam = mysqli_real_escape_string($db,$_POST['fullname']);
       $emai  = mysqli_real_escape_string($db,$_POST['email']);
       $phon   = mysqli_real_escape_string($db,$_POST['mobile']);
       $addr   = mysqli_real_escape_string($db,$_POST['addr']);
       $countr = mysqli_real_escape_string($db,$_POST['state']);
       $pin = mysqli_real_escape_string($db,$_POST['pin']);
       $pas  = mysqli_real_escape_string($db,$_POST['password']);
	   $pass=md5($pas);
$sql = "INSERT INTO users(fname, email_id, password, phone, country,pincode,address) VALUES('$fnam', '$emai', '$pas', '$phon', '$countr','$pin','$addr')";
			
        if($db->query($sql) === TRUE){
			
     echo "true";
		}else{
		echo "false";
		}
}else{
	echo "exception";
}
?>