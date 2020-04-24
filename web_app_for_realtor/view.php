<html>
 <head>
  <title>Realtors schedule</title>
  <link rel="stylesheet" type="text/css" href="styles.css">
 </head>
 <body>
 <?php echo '<h1 align="center">Hello, Welcome to Realtor\'s info page</h1>
<div align="center">
 <form method="post"> <lable>Click To View Realtor\'s Table From DataBase:</lable>
        <input type="submit" name="submit" value="Click Here"/> 
  </form> 
</div>';

if(isset($_POST['submit'])) { 
       

$conn = mysqli_connect( 'sql.njit.edu' , 'uh6', 'MYPASSWORD', 'uh6');



echo '<table class="container"> <tr> <td width="10%">ID</td> <td>Name</td> <td>Password</td> <td>E-mail</td> <td>Client\'s Info</td> </tr>';

$sql = "SELECT Id, Name, Password, Email, Client FROM Realtors";
$result = $conn->query($sql);

if ($result->num_rows > 0) {
// output data of each row
while($row = $result->fetch_assoc()) {
echo "<tr><td>" . $row["Id"]. "</td><td>" . $row["Name"] . "</td><td>". $row["Password"]. "</td><td>". $row["Email"]. "</td><td>". $row["Client"]. "</td></tr>";
}
echo "</table>";
} else { echo "0 results"; }
$conn->close();

}

?>
</body>
</html>