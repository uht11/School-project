<?php
/*  
    Last updated: April 2020
    Author name:  Uzzul Hussain 
    Email:        uzzulht@gmail.com
*/

//headers allows the http request from any origin on the internet, if its not given then it'll be local
header('Access-Control-Allow-Origin: *');
header('Access-Control-Allow-Methods: GET, POST');
header("Access-Control-Allow-Headers: X-Requested-With");

//variables taken from the GET request parameter calls
$userName=$_GET["name"];
$password=$_GET["pass"];
$text=$_GET["msg"];
$type=$_GET["type"];

//calling appropate functions based on the type paramenter if not given returns 0
if($type == 'send'){ 
  sendData($userName,$password, $text);
}
elseif($type == 'listen' ){
  getData($userName);
}
else{
  echo '0';
}

/* 
  if type ==  send this method is called 
*/
function sendData($userName, $password, $text){  

    date_default_timezone_set('US/Eastern');                                                      //setting time zone to eastern for messages time stamp
    
    
    $conn = mysqli_connect( 'sql.njit.edu' , 'uh6', 'GameMaster1!', 'uh6');                       //create server connection
    if ($conn->connect_error){echo '0'; die("Connection failed: " . $conn->connect_error);}       // Check connection

    $sql = "SELECT * FROM Chat WHERE name = '$userName' && password = '$password'";               // query for SQL server
    $result = $conn->query($sql);                                                                 //assign return data to result variable
    $newChat = "--".date("m/d h:i:sa")."\n$text\n";                                               //add timestamp to the msg and line break at the end
      
      
      if ($result->num_rows > 0) {                                                                //If there is a user with the given name and password then add the new text data
        
          $sql = "INSERT INTO `uh6`.`Chat` (`name`, `password`, `chat`) VALUES ('$userName', '$password', '$newChat')";   // query for SQL server
          $result = $conn->query($sql);                                                           //assign return data to result variable
          if($result) { echo "Message sent!"; }                                                   //if there is a response back from server echo success
          else { echo 'Server Error, please again try later';}                                    // if no response back return error msg

      } 
      else { echo "Authentication failed, please check your name and password"; }                // if returned result has no nows then user or password not found

      $conn->close();                                                                            // close server connection
      
}//end of sendData()

/* 
  if type ==  listen this method is called 
*/
function getData($userName){  
    $dataArr = [];                                                                              //array will be used to send later , null atm
    $conn = mysqli_connect( 'sql.njit.edu' , 'uh6', 'GameMaster1!', 'uh6');                     //create server connection
    if ($conn->connect_error){echo '0'; die("Connection failed: " . $conn->connect_error);}     // Check connection

    $sql = "SELECT `chat` FROM Chat WHERE name = '$userName'";                                  // query for SQL server
    $result = $conn->query($sql);                                                               //assign return data to result variable
    $dump = print_r($result, true);                                                             // TEMP variable to hold response data for later use

      if ($result->num_rows > 0) {                                                              //If there is a user with the given name then add it to dataArr[]
          
        while($row = $result->fetch_assoc()) {                                                  //while loop using default methods to loop through all the values of the result array
          $dataArr[] = $row["chat"];                                                            // adding the chat row data into our dataArr[]
        }echo json_encode($dataArr);                                                            //end of the while loop, ie. all the data is added to our array now return it using json_encode()

      }
      elseif(strpos($dump, '[num_rows] => 0') == true){echo json_encode('1'); }                 //check if the user name exits it num_rows will be NULL if user dont exisits 
      else{echo json_encode('0'); }
  
      $conn->close();                                                                           // close server connection
        
}//end of getData()

?>