/*  
    Last updated: April 2020
    Author name:  Uzzul Hussain 
    Email:        uzzulht@gmail.com
*/


//once user clicks send button on index this method is called
function sendMsg(){
  //values taken from index and assigned to var
  var text = document.getElementById("msg").value;
  var name = document.getElementById("name").value.trim().toLowerCase();
  var pass = document.getElementById("password").value.trim().toLowerCase();
    
  
  //if the sent mail is blank send an error
  if(text.trim().length == 0){
    document.getElementById("sendErr").innerHTML = 'Please type a message..';//write to index via element ID
    return;// program stops
  }else{document.getElementById("sendErr").innerHTML = '<br/>&nbsp;';}//write to index via element ID

  //single ' seems to cause an error on server storage so replaced with double 
  var text = text.replace(/'/gi, "''");
  document.getElementById("msg").value = ""; //remove previously typed msg
  //http GET request, fyi there is Fatch and AXIOS which are simpler  
  var xhr = new XMLHttpRequest();
  xhr.withCredentials = true;
  xhr.addEventListener("readystatechange", function() {
    if(this.readyState === 4 && this.status == 200) {
        document.getElementById("sendErr").innerHTML = this.responseText;//write to index via element ID
    }
  });
  //assign parameter values for the data required by the php file and send GET request
  xhr.open("GET", "https://web.njit.edu/~uh6/it202project5/backEnd.php?type=send&name="+name+"&pass="+pass+"&msg="+text);
  xhr.send();

}//end of sendMsg()

//once user clicks listen button on index this method is called
function getMsg(){
  var name = document.getElementById("name2").value.trim().toLowerCase();
  var xhr = new XMLHttpRequest();
  xhr.withCredentials = true;

  //http GET request, fyi there is Fatch and AXIOS which are simpler 
  xhr.addEventListener("readystatechange", function() {
    
    //since we are receving data its best to check status and state in IF statement
    if(this.readyState === 4 && this.status == 200) {
      //if return data is 0 do
      if(JSON.parse(this.responseText) == 0){document.getElementById("textReciver").innerHTML = 'No messages..';document.getElementById("listenErr").innerHTML = '<br/>&nbsp;';}//write to index via element ID
      //if return data is 1 do
      else if(JSON.parse(this.responseText) == 1){document.getElementById("listenErr").innerHTML = 'Incorrect name, Try again...'; }//write to index via element ID
      //anything else so this
      else{
      document.getElementById("listenErr").innerHTML = '<br/>&nbsp;'; //write to index via element ID
        var mainText = JSON.parse(this.responseText);//parsing response
        var data = mainText.toString().replace(/,--/gi, ">>"); //self implemented special key to identify seperate messages
        document.getElementById("textReciver").innerHTML = data;//write to index via element ID
      }
    }
  });
  //assign parameter values for the data required by the php file and send GET request
  xhr.open("GET", "https://web.njit.edu/~uh6/it202project5/backEnd.php?type=listen&name="+name);
  xhr.send();

}//end of getMsg()