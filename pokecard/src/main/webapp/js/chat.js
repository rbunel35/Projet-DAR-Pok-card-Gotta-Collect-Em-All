$(function() {

	/*
	 * $("#chatDestination").html("momo"); $("#chatName").html("moha");
	 * $("#messageLogin").html(""); $("#messageContent").html("");
	 */
	$("#saveChatId").hide();
	//localStorage.setItem("pokecardLogin","mohamed");
	getServerData("/chat/chatList/"+localStorage.getItem("pokecardLogin"), fillChat, null);
});

function fillChat(res) {
	//console.log(res);
	var id, name, origin, destination, privy;
	var chatlist = "";
	for (var i = 0; i < res.length; i++) {
		id = subfy(res[i].id);
		destination = subfy(res[i].destination);
		name = subfy(res[i].name);
		chatlist += liChatList(destination, name, id);
		//console.log(chatlist);
	}
	$("#chatList").html(chatlist);

}
var myVar = setInterval(function(){ reload() }, 300);

function setColor() {
  //var x = document.body;
  //x.style.backgroundColor = x.style.backgroundColor == "yellow" ? "pink" : "yellow";
  console.log('cdcd');
}
 
function stopColor() {
  clearInterval(myVar);
}


function reload(){
	//console.log('');
	getServerData("/chat/newMessage/"+localStorage.getItem("pokecardLogin"),reloadAux,null);
}

function reloadAux(res) {
	console.log(res[0]);
}

function liChatList(pers, name, id) {
	var content;
	content = '<li class="left clearfix" onclick=test("' + id + '")>';
	content += '<div class="chat-body clearfix">';
	content += '<div class="header_sec">';
	content += '<strong class="primary-font" id="chatDestination">' + pers;
	content += '</strong>';
	content += '</div>';
	content += '<div class="contact_sec">';
	content += '<strong class="primary-font" id="chatName">' + name
			+ '</strong>';
	content += '</div>';
	content += '</div>';
	content += '</li>';

	return content;
}

function test(id) {
	$("#saveChatId").html(id);
	//$("#saveChatId").show();
	setInterval(function(){ test(id) }, 7000);
	getServerData("chat/messages/"+id, fillMessages, null);
}
function fillMessages(res) {
	
	var co="";
	var content,login;
	//chatId()
	for (var i = res.length-1; i >= 0; i--) {
		content = subfy(res[i].content);
		login = subfy(res[i].login);
		//console.log(content+", "+login);
		co+=liMessages(login,content);
		//console.log(co);
	}
	
	$("#messageList").html(co);
}

function liMessages(pers, con) {
	var content;
	content = '<li class="left clearfix"><span class="chat-img1 pull-left"> <strong >'+pers+'</strong></span>';
	content += '<div class="chat-body1 clearfix">';
	content += '<p >'+con+'</p>';
	content += '</div></li>';
	
	return content;

}

function sendMessage(){
	var id = $("#saveChatId").text();
	var message = $("#messageText").val();
	//localStorage.setItem("pokecardLogin","mohamed");
	var login = localStorage.getItem("pokecardLogin");
	//alert(message+",id : "+id+" user : "+login);
	getServerData("/chat/insertMessage/"+message+"/"+login+"/"+id);
	//test(id);
	
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