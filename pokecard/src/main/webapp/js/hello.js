if (localStorage.getItem("pokecardLogin") != null) {
	$("#PokecardUser").html(' : <a href="/profil">'+localStorage.getItem("pokecardLogin")+'</a>');
} 
