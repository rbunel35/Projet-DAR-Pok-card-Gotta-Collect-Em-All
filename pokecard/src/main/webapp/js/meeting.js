$(function() {

	//alert('meeting');
	getServerData("/meeting/"+localStorage.getItem("pokecardLogin"),meetList,null);
});

function meetList(res) {
	console.log(res);
	var co="";
	var name, adress, date
	for (var i = 0; i < res.length; i++) {
		name = subfy(res[i].name);
		adress = subfy(res[i].adress);
		date = res[i].date;
		co+=tr(td(name)+td(adress)+td(new Date(date)));
		
	}
	console.log(co);
	$("#meetList").html(co);
	$('#example').DataTable();
	
}
/** UTILS * */
function addMetting() {
	var name = $("#meetName").val();
	var address = $("#meetAddress").val();
	var date = $("#meetDate").val();
	var time = $("#meetTime").val();
	//date.setTime(time);
	var month = date.split("-")[1];
	var year = date.split("-")[0];
	var day = date.split("-")[2];
	var hour = time.split(":")[0];
	var minutes = time.split(":")[1];
	var d = new Date(); d.setDate(day); d.setMonth(month-1); d.setFullYear(year); d.setHours(hour); d.setMinutes(minutes);
	console.log( d.getTime() );
	var s = d.getTime();
	postServerData("/meeting/add/"+address+"/"+localStorage.getItem("pokecardLogin")+"/"+name+"/"+encodeURIComponent(s),alert('rendez vous ajouter'),null);
	location.href = "/meet";
	//postSerData("m")
	/*
	console.log("year : "+year+", month : "+month+",day : "+day+",hour : "+hour+",minutes : "+minutes);
	
	//var d = new Date(date.split("-")[1],date.split("-")[0],date.split("-")[2],time.split(":")[0],time.split(":")[1],0,0);
	//console.log("d : "+d)
	*/
	//alert(name+' '+address+' '+d);
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
function td(r) {
	return '<td>' + r + '</td>';
}
function tr(r) {
	return '<tr>' + r + '</tr>';
}