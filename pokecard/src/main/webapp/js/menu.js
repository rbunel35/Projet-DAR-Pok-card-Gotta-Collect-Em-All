if (localStorage.getItem("pokecardLogin") != null) {
	$('#profil').html(localStorage.getItem("pokecardLogin"));
	$('#profil').show();
	$('#logout').show();
	$('#searchNav').show();
	$('#basketNav').show();
	$('#messagesNav').show();
	$('#meetingsNav').show();
	$('#login').hide();

} else {
	$('#profil').hide();
	$('#logout').hide();
	$('#searchNav').hide();
	$('#basketNav').hide();
	$('#messagesNav').hide();
	$('#meetingsNav').hide();
	$('#login').show();
}
/*
function login() {
	// alert('connected');
	
	localStorage.setItem("pokecardLogin", "richard");
	location.href = "/";
}
*/
function logout() {
	// alert('connected');
	localStorage.removeItem("pokecardLogin");
	location.href = "/";
}