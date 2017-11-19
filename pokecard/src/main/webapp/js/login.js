/**/
$(function() {

	if (localStorage.getItem("pokecardLogin") != null) {
		location.href = '/';
	}

});
function login() {
	// alert('connected');
	// var x = "richard";
	var pseudo = $('#emailLogin').val();
	var pass = $('#passwordLogin').val();
	//var s = pass.jCryption();
	//console.log(s);
	postServerData("/login/" + pseudo + "/" + pass, auxLogin, null);

	// console.log($('#loginForm').serializeArray());

}
function logout() {
	// alert('connected');
	localStorage.removeItem("pokecardId");
	localStorage.removeItem("pokecardLogin");	
	location.href = "/";
}

function auxLogin(res) {
	var x = subfy(res[0]);
	var y = subfy(res[1]);
	if (x == "login") {
		$('#alertLogin').html('<div class="alert alert-danger"><strong>login incorrect!</strong> </div>');
	} 
	else if(x == "password" ){
		$('#alertLogin').html('<div class="alert alert-danger"><strong>mot de passe incorrect!</strong> </div>');
	}
	else {

		console.log(x);
		localStorage.setItem("pokecardLogin", y);
		localStorage.setItem("pokecardId", x);
		location.href = "/";
	}
}
/** REGISTER **/

function register(){
	var login = $('#registerLogin').val();
	var pass = $('#registerPassword').val();
	var email = $('#registerEmail').val();
	postServerData("/login/"+login+"/"+email+"/"+pass,auxRegister,null);
	
}

function auxRegister(res){
	var x = subfy(res[0]);
	if( x == "login")
		$('#alertRegister').html('<div class="alert alert-danger"><strong>Utilisateur deja enregistré!</strong> </div>');
	else if( x == "mail" )
		$('#alertRegister').html('<div class="alert alert-danger"><strong>Email deja enregistré</strong> </div>');
	else 
		$('#alertRegister').html('<div class="alert alert-success"><strong>inscription reussie</strong> </div>');
	
}


function postServerData(url, success, failure) {
	$.ajax({
		dataType : "json",
		url : url,
		type : "POST",
		success : success,
		error : failure
	});
}