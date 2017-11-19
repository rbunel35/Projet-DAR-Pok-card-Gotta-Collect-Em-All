$(function() {
	var res="";
	for(var i =0; i<4; i++){
		res+=commentaire();
	}
	$("#list-type").html(res);
});

function commentaire(){
	var comment='';
	comment+='<div class="row comment">';
	comment+='<div class="col-sm-3 col-md-2 text-center-xs">';
	comment+='<h5 class="text-uppercase">Richard</h5>';
	comment+='</div>';
	comment+='<div class="col-sm-9 col-md-10">';
	//comment+='<h5 class="text-uppercase">Julie Alma</h5>';
	comment+='<p class="posted"><i class="fa fa-clock-o"></i> September 23, 2011 at 12:00 am</p>';
	comment+='<p>Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas.';
	comment+='Aenean ultricies mi vitae est. Mauris placerat eleifend leo.</p>';
	comment+='</div></div>';
	
	return comment;
}
/*
<div class="row comment">
                                <div class="col-sm-3 col-md-2 text-center-xs">
                                    <p>
                                        <img src="assets/img/client-face1.png" class="img-responsive img-circle" alt="">
                                    </p>
                                </div>
                                <div class="col-sm-9 col-md-10">
                                    <h5 class="text-uppercase">Julie Alma</h5>
                                    <p class="posted"><i class="fa fa-clock-o"></i> September 23, 2011 at 12:00 am</p>
                                    <p>Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum tortor quam, feugiat vitae, ultricies eget, tempor sit amet, ante. Donec eu libero sit amet quam egestas semper.
                                        Aenean ultricies mi vitae est. Mauris placerat eleifend leo.</p>
                                    <p class="reply"><a href="#"><i class="fa fa-reply"></i> Reply</a>
                                    </p>
                                </div>
                            </div>
							*/

