$(function() {
	var res="";
	for(var i =0; i<12; i++){
		res+=carte();
	}
	$("#list-type").html(res);
});

function carte(){
	var x = Math.random();
	var y = Math.random();
	var contenu = '<div class="col-sm-6 col-md-3 p0"><div class="box-two proerty-item"><div class="item-thumb">';
	contenu +='<a href="#" data-toggle="modal" data-target="#myModal" onclick="modaltrig()">';
	//contenu+='<img src="assets/img2/Pikachu.png" height="240" width="300">';
	contenu+='<img '+((x>0.5)?'src="assets/img2/Pikachu.png"':'src="assets/img2/Nymphali.png"')+'height="240" width="300">';
	contenu+='</a></div>';
	contenu+='<div class="item-entry overflow"><h5><a href="#">';
	contenu+=(x>0.5)?'Pikachufff</a></h5>':'Nymphali</a></h5>'
	var pers =(y<0.25)?'karim':(y<0.5)?'Mohamed':(y<0.75)?'richard':'patrick';
	contenu+='<div class="dot-hr"></div><span class="pull-left"><b>'+pers+'</b></span>';
	contenu+='<span class="proerty-price pull-right"> € 30</span>';
	contenu+='<p style="display: none;">Suspendisse ultricies Suspendisse ultricies Nulla quis dapibus nisl. Suspendisse ultricies commodo arcu nec pretium ...</p>';
	contenu+='<div class="property-icon"><p>'+Math.floor((Math.random() * 5) + 1)+' exemplaires</p>';
	contenu+='</div></div></div></div>';
	return contenu;

}

function modaltrig(){
	
	//$("#modalTitle").html('Pikachu');
	//$//("#modalBody").html('<img src="assets/img2/Pikachu.png" >');
}