//Array of users in the realitor
var userArray = [];
userArray[0] = {name:"john", id:"12369874", password:"John11"};
userArray[1] = {name:"tom", id:"45632589", password:"Tom22"};
userArray[2]= {name:"peter", id:"12345678", password:"Peter33"};
userArray[3] = {name:"mary ann", id:"87654321", password:"maryA44"};
userArray[4] = {name:"lisa", id:"85236974", password:"lisAA551"};
userArray[5] = {name:"joy ara", id:"74589612", password:"joyA66"};

//funtion runs when user submits form
function userSubmit() {
	
	var rName = document.getElementsByName("name")[0].value;
	var rPass = document.getElementsByName("password")[0].value;
	var rEmail = document.getElementsByName("email")[0].value;
	var rId = document.getElementsByName("id")[0].value;
	var isEmail = document.getElementsByName("emailCon")[0].checked;
	var rSelect = document.getElementsByName("dropdown")[0].value;
	
	
//check if the email input is valid 
if(isEmail == true){
if(validateEmail(rEmail) == false){alert ("Please enter a valid email!");return;}
else {var emailData = "Your email confirmation has been sent to: "+rEmail;}
}
//check if the Id input is valid 
if(rId.length != 8){alert ("Please enter a valid ID \nID numbers are 8 digits long!");return;}


//check if the password input is valid 
if(validatePassword(rPass) == false){return;}




var verificationValue = verificationProcess(rName.toLowerCase(), rPass, rId);
var isMatch = verificationValue[0];
var errorNum = verificationValue[1];
if ( isMatch == true){
	if(isEmail == true){alert ("Welcome "+rName+", Your transaction for "+rSelect+" is processing! \n"+emailData);}
	else {alert ("Welcome "+rName+", Your transaction for "+rSelect+" is processing!");}
	
	}
else if(errorNum == 0){
	alert ("Sorry no account found under the name: "+rName+"!");
}
else if(errorNum == 1){
	alert ("Sorry no account found under the ID: "+rId+" ");
}
else if(errorNum == 2){
	alert ("Incorrect Password, please try again!");
}






userForward(rSelect);



}//end of function userSubmit




//function to check if the email input is valid 
function validateEmail(rEmail) {
    var regEx = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return regEx.test(String(rEmail).toLowerCase());
}// end of function validateEmail

//function to check if the password input is valid 
function validatePassword(rPass) {
	var p = rPass;
	if (p.length < 2) {
        alert ("Please enter your Password\nMax 8 Characters\nMust contain an uppercase letter\nMust contain a number"); return false;
    }
    if (p.length > 8) {
        alert ("Your password can be max 8 characters"); return false;
    }
    if (p.search(/[A-Z]/) < 0) {
        alert ("Your password must contain at least one Uppercase letter.");return false;
    }
    if (p.search(/[0-9]/) < 0) {
        alert ("Your password must contain at least one digit.");return false;
    }
    return true;
}// end of function validatePassword
 

function verificationProcess(name, pass, id){
		
		var i; var num =0;
		for (i = 0; i < userArray.length; i++) {
		  if(userArray[i]["name"] == name){num=1;
			  if(userArray[i]["id"] == id){num=2;
				  if(userArray[i]["password"] == pass){num=3;
					  return [true, num];
			  }}}
		}
		
		return [false, num];
}


function userForward(select){
	switch ( select) {
		case 'scheduling a Showing':
			location.replace("./view.html")

			break;
		case 6:
			text = "Today is Saturday";
			break;
		case 0:
			text = "Today is Sunday";
		}





}
