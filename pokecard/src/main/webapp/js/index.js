$(function() {

	var res = "";
	for (var i = 0; i < 12; i++) {
		res += carte();
	}

	getServerData("/basket/lastAddedCards", printListCard, null);
	// getServerData("/card/search/zekrom", printSearchCard, null);

});
function printListCard(res) {
	if (res.length > 0) {
		var extension = "", number = "", img, cardName, owner, price, comment;
		var co = "";
		for (var i = 0; i < res.length; i++) {
			id = subfy(res[i].id);
			extension = subfy(res[i].extension);
			number = subfy(res[i].number);
			img = subfy(res[i].image);
			cardName = subfy(res[i].cardName);
			owner = subfy(res[i].userId);
			price = res[i].price;
			// comment = subfy(res[i].comment);
			if (!res[i].search)
				co += carte(extension, number, img, cardName, owner, price, "",
						id, false);
		}
		$("#list-type").html(co);
	}
}
function printSearchCard(res) {
	if (res.length > 0) {
		var extension, number, img, cardName, owner, price, comment;
		var co = "";
		for (var i = 0; i < res.length; i++) {
			extension = subfy(res[i].extension);
			number = subfy(res[i].number);
			img = subfy(res[i].image);
			cardName = subfy(res[i].cardName);
			//owner = subfy(res[i].userId);
			price = res[i].price;
			console.log(extension + " " + number + " " + cardName + " " + img
					+ " " + price);
			co += carte(extension, number, img, cardName, owner, price, "", "",
					true);
		}
		$("#list-type").html(co);
	}
}

function carte(extension, number, image, cardName, owner, price, comment, id,
		search) {
	// console.log(extension+" "+number+" "+cardName+" "+image+" "+price);
	var x = Math.random();
	var y = Math.random();
	var tabs;
	if (search && localStorage.getItem("pokecardLogin") != null) {

	}

	var contenu = '<div class="col-sm-6 col-md-3 p0"><div class="box-two proerty-item"><div class="item-thumb">';
	if (search)
		contenu += '<a>';
	else
		contenu += '<a href="#" data-toggle="modal" data-target="#myModal" onclick=modaltrig("'
				+ id + '")>';
	contenu += '<img src="' + image + '" height="240" width="300" >';// '<img

	contenu += '</a></div>';
	contenu += '<div class="item-entry overflow"><h5>'; // <a href="#">';
	// contenu += cardName;
	// localStorage.setItem("pokecardId","csdcs");
	if (localStorage.getItem("pokecardLogin") != null) {
		tabs = [ extension, number, owner,
			cardName, image, price, true ];
		console.log(tabs);
		if (!search) {
			
			contenu += '<button type="button" class="btn btn-success" onclick="testTrue(\''
					+ tabs + '\');">Cherche</button>';
		}
			contenu += '<button type="button" class="btn btn-info" onclick="testFalse(\''
					+ tabs + '\');">Possede</button>';
		
	} else {
		contenu += "";
	}
	// contenu +='</a></h5>';
	contenu += '</h5>'
	var pers;
	/*
	 * if (localStorage.getItem("pokecardId") != null) { tabs = [ extension,
	 * number, localStorage.getItem("pokecardId"), cardName, image, price, true ]; //
	 * console.log(tabs); pers = '<a style=" margin-right: 0.5cm;" href="#"
	 * onclick="testTrue(\'' + tabs + '\');" ><span class="glyphicon
	 * glyphicon-check"></span>' + '</a>' + '<a href="#"
	 * onclick="testFalse(\'' + tabs + '\');" ><span class="glyphicon
	 * glyphicon-screenshot"></span>' + '</a>'; // <span class=""></span> }
	 * else
	 */
	pers = cardName;// owner;

	contenu += '<div class="dot-hr"></div><span class="pull-left"><b>' + pers
			+ '</b></span>';
	contenu += '<span class="proerty-price pull-right"> € ' + price + '</span>';
	contenu += '<p style="display: none;">' + comment + '</p>';
	// contenu+='<div class="property-icon"><p>'+Math.floor((Math.random() * 5)
	// + 1)+' exemplaires</p></div>';
	contenu += '</div></div></div>';

	return contenu;

}
function testTrue(tabs) {
	console.log(tabs);
	// console.log("tabs[0]",tabs.split(",")[0]);
	tabs = tabs.split(",");
	// alert('');
	$("#addBasketAlert")
			.html(
					'<div class="alert alert-success" ><strong>Je cherche cette carte!</strong></div>');
	$("#addBasketAlert").fadeTo(2000, 500).slideUp(500, function() {
		$("#addBasketAlert").slideUp(500);
	});
	var x = "basket/add/" + tabs[0] + "/" + tabs[1] + "/" + tabs[2] + "/"
			+ tabs[3] + "/" + tabs[4] + "/" + tabs[5] + "/" + tabs[6];
	console.log("x :" + x);
	console.log(tabs[3] + "/" + localStorage.getItem("pokecardLogin") + "/"
			+ tabs[2]);
	getServerData("/chat/create/"+tabs[3]+"/"+localStorage.getItem("pokecardLogin")+"/"+tabs[2]);
	postServerData("/basket/add/" + tabs[0] + "/" + tabs[1] + "/" + localStorage.getItem("pokecardId")
			+ "/" + tabs[3] + "/" + encodeURIComponent(tabs[4]) + "/"
			+ encodeURIComponent(tabs[5]) + "/" + true, null, null);
}
function testFalse(tabs) {
	// console.log(tabs);
	// console.log("tabs[0]",tabs.split(",")[0]);
	tabs = tabs.split(",");
	// alert('');
	$("#addBasketAlert")
			.html(
					'<div class="alert alert-info" ><strong>Je possède cette carte!</strong></div>');
	$("#addBasketAlert").fadeTo(2000, 500).slideUp(500, function() {
		$("#addBasketAlert").slideUp(500);
	});
	var x = "basket/add/" + tabs[0] + "/" + tabs[1] + "/" + tabs[2] + "/"
			+ tabs[3] + "/" + tabs[4] + "/" + tabs[5] + "/" + tabs[6];
	console.log("x :" + x);
	postServerData("basket/add/" + tabs[0] + "/" + tabs[1] + "/" + localStorage.getItem("pokecardId")
			+ "/" + tabs[3] + "/" + encodeURIComponent(tabs[4]) + "/"
			+ encodeURIComponent(tabs[5]) + "/" + false, null, null);
}

function searchCard() {
	// alert('mesd');
	console.log($("#searchPokemonName").val());
	getServerData("/card/search/" + $("#searchPokemonName").val(),
			printSearchCard, null);
}

function modaltrig(id) {
	// console.log("modal trig : "+id);
	getServerData("/basket/" + id, fillModal, null);
}

function fillModal(res) {
	var img, cardName, owner, addDate, exemplary, extention, number, price, comment;
	console.log("image : " + subfy(res.image));
	$("#cardImage").html('<img src="' + subfy(res.image) + '">');
	$("#cardTitle").html(subfy(res.cardName));
	// $("#cardOwner").html(subfy(res.userName));
	// $("#cardAddDate").html(new Date(res.addDate));
	// $("#cardExemplary").html(res.exemplary);
	$("#cardExtention").html(subfy(res.extension));
	$("#cardNumber").html(res.number);
	$("#cardPrice").html(res.price);

	/*
	 * $("#searchOfOwn").html('<button type="button" class="btn btn-success"
	 * onclick=onclickModalSearch("'+ subfy(res.userId) + '") >Search</button>' +'<button
	 * type="button" class="btn btn-info" onclick=onclickModalSearch()>Own</button>');
	 */

}

function onclickModalSearch(id) {
	alert('search : ' + id);
}
function onclickModalOwn() {
	alert('');
}

/** UTILS * */

function stringify(res) {
	return JSON.stringify(res);
}
function subfy(res) {
	return sub(stringify(res));
}
function sub(r) {
	return r.toString().substring(1, r.toString().length - 1);
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