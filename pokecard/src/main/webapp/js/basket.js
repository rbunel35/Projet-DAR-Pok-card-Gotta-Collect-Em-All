$(function() {

	// $("#list-type").html(res);

	getServerData("/basket/user/" + localStorage.getItem("pokecardId"), fillBasket,
			null);

});
var lastCards;

function fillBasket(res) {
	console.log(res.length);
	var img, extension, number, price,cardName;
	var searchb = "", ownb = "", tr1 = "", tr2 = "";
	for (var i = 0; i < res.length; i++) {
		console.log(res[i]);
		cardName= subfy(res[i].cardName);
		img = subfy(res[i].image);
		extension = subfy(res[i].extension);
		number = res[i].search;
		price = res[i].price;
		
		// comment = subfy(res[i].comment);
		tr1 = tr(td(cardName)
				+ td(extension)
				+ td(price)
				+ td(number));
		
		//		+ td('<button><span class="glyphicon glyphicon-eye-open"></span></button>'));
		searchb += tr1;
		/*if (res[i].search) {
			searchb += tr1;
		} else {
			// ownb+=tr1;
		}
		*/
	}
	console.log("search " + searchb);
	$("#searchBasket").html(searchb);

	$('#example').DataTable();
	// $("#ownBasket").html(searchb);

	/*
	 * /lastCards = res; var img,cardName,owner,price,comment; var co=""; for
	 * (var i = 0; i < res.length; i++) { id = subfy(res[i].id); img =
	 * subfy(res[i].image); cardName = subfy(res[i].cardName); owner =
	 * subfy(res[i].userName); price = res[i].price; comment =
	 * subfy(res[i].comment); co+=carte(img, cardName, owner, price,comment,id);
	 * //console.log(carte(img, cardName, owner, price)); } //console.log(res);
	 */
}
function getServerData(url, success, failure) {
	// console.log('get server data');
	$.ajax({
		dataType : "json",
		url : url,
		async : false,
		type : "GET",
		success : success,
		error : function(jqXHR, textStatus, errorThrown) {
			console.log("textstatus : " + textStatus);
		}
	});
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

function carte(image, cardName, owner, price, comment) {
	var x = Math.random();
	var y = Math.random();
	var contenu = '<div class="col-sm-6 col-md-6 p0"><div class="box-two proerty-item"><div class="item-thumb">';
	contenu += '<a href="#"  >';
	// contenu+='<img src="assets/img2/Pikachu.png" height="240" width="300">';
	contenu += '<img src="' + image + '" height="240" width="300" >';// '<img
	// '+((x>0.5)?'src="'+image+'"':'src="'+image+'"')+'height="240"
	// width="300">';
	contenu += '</a></div>';
	contenu += '<div class="item-entry overflow"><h5><a href="#">';
	contenu += cardName + '</a></h5>';// (x>0.5)?'Pikachu</a></h5>':'Nymphali</a></h5>'
	var pers = owner;// (y<0.25)?'karim':(y<0.5)?'Mohamed':(y<0.75)?'richard':'patrick';
	contenu += '<div class="dot-hr"></div><span class="pull-left"><b>' + pers
			+ '</b></span>';
	contenu += '<span class="proerty-price pull-right"> € ' + price + '</span>';
	contenu += '<p style="display: none;">' + comment + '</p>';
	// contenu+='<div class="property-icon"><p>'+Math.floor((Math.random() * 5)
	// + 1)+' exemplaires</p></div>';
	contenu += '</div></div></div>';

	return contenu;

}

function cardTitle() {

}

function modaltrig(id) {
	// console.log("modal trig : "+id);
	getServerData("/card/" + id, fillModal, null);
}
/*
 * id = subfy(res[i].id); img = subfy(res[i].image); cardName =
 * subfy(res[i].cardName); owner = subfy(res[i].userName); price = res[i].price;
 * comment = subfy(res[i].comment);
 */
function fillModal(res) {
	var img, cardName, owner, addDate, exemplary, extention, number, price, comment;
	console.log("image : " + subfy(res.image));
	$("#cardImage").html('<img src="' + subfy(res.image) + '">');
	$("#cardTitle").html(subfy(res.cardName));
	$("#cardOwner").html(subfy(res.userName));
	$("#cardAddDate").html(new Date(res.addDate));
	$("#cardExemplary").html(res.exemplary);
	// $("#cardExtention").html(subfy(res.extention));
	$("#cardNumber").html(res.number);
	$("#cardPrice").html(res.price);

}

function stringify(res) {
	return JSON.stringify(res);
}
function subfy(res) {
	return sub(stringify(res));
}
function sub(r) {
	return r.toString().substring(1, r.toString().length - 1);
}
function td(r) {
	return '<td>' + r + '</td>';
}
function tr(r) {
	return '<tr>' + r + '</tr>';
}