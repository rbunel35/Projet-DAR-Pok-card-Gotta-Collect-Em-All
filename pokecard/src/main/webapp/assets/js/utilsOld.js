$(function() {
	var  navbar = navBar();
	var searchbar = searchBar();
	var footerarea = footerColumn1()+footerColumn2()+footerColumn3()+footerColumn4();
	//$("#navigBar").html(navbar);
	//$("#searchBarLoc").html(searchbar);
	
	//$("#footerId").html(footerarea);
	//$("#title").html("1");
});

function navBar(){
	var nav='<div class="container">';
	nav+= '<div class="navbar-header">';
	nav+= '<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navigation">';
	nav+= '<span class="sr-only">Toggle navigation</span>';
	nav+= '<span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span>';
	nav+= '</button>';
	nav+= '<a class="navbar-brand" href="index.html"><img src="assets/img2/logo.png" alt="" height="48" width="129"></a></div>';
	nav+= '<div class="collapse navbar-collapse yamm" id="navigation">';
	nav+= '<div class="button navbar-right">';
	nav+='<button class="navbar-btn nav-button wow bounceInRight login" ><a class="" href="connexion.html" style="color:white">Connexion</a></button>';
	nav+='<button class="navbar-btn nav-button wow bounceInRight login" ><a class="" href="connexion.html" style="color:white">Inscription</a></button></div>';
	nav+='<ul class="main-nav nav navbar-nav navbar-right">';
	nav+='<li class="wow fadeInDown" data-wow-delay="0.1s"><a class="" href="index.html">Accueil</a></li>';
	nav+='<li class="wow fadeInDown" data-wow-delay="0.1s"><a class="" href="index.html">Messages (3)</a></li>';
	nav+='<li class="wow fadeInDown" data-wow-delay="0.1s"><a class="" href="index.html">Panier (3)</a></li>';
	nav+='<li class="wow fadeInDown" data-wow-delay="0.1s"><a class="" href="forum.html">Forum</a></li>';
	nav+='<li class="wow fadeInDown" data-wow-delay="0.1s"><a class="" href="index.html">A prospos</a></li>';
	nav+='</ul></div></div>';
	
	return nav;
}

function searchBar(){
	var searchbar='';
	searchbar+='<div class="container"><div class="col-md-12 large-search"><div class="search-form wow pulse">';
	searchbar+='<form action="" class=" form-inline">';
	searchbar+='<div class="col-md-12">';
	searchbar+='<div class="col-md-4">';
	searchbar+='<input type="text" class="form-control" placeholder="vous cherchez une carte">';
	searchbar+='</div>';
	searchbar+='<div class="col-md-3">';
	searchbar+='<select id="lunchBegins" class="selectpicker" data-live-search="true" data-live-search-style="begins" title="Choisis ton extention">';
	searchbar+='<option>Tempete de sable</option><option>Dragon</option><option>Team Magma vs team aqua</option><option>Legende oubliées</option><option>Emeraude</option>';
	searchbar+='</select>';
	searchbar+='</div>';
	searchbar+='<div class="col-md-3">';
	searchbar+='<select id="lunchBegins" class="selectpicker" data-live-search="true" data-live-search-style="begins" title="Choisis ta ville">';
	searchbar+='<option>Paris</option><option>Lille</option><option>Lyon</option><option>Marseille</option><option>Ile de france</option></select>';
	searchbar+='</div>';
	searchbar+='<div class="col-md-2">';
	searchbar+='<button type="button" class="btn btn-default"><span class="glyphicon glyphicon-search"></span></button>';
	searchbar+='</div></div></form></div></div>';
	
	return searchbar;
	
}
function footerArea(){
	
}

function footerColumn(title, content){
	var c='';
	c+='<div class="col-md-3 col-sm-6 wow fadeInRight animated">';
	c+='<div class="single-footer">';
	c+='<h4>'+title+'</h4>';
	c+='<div class="footer-title-line"></div>';
	c+=content;
	c+='</div></div>';
	c+='';
	c+='';
	c+='';
	c+='';
	c+='';
	
	return c;
}

function footerColumn1(){
	var title = "A propos";
	var content='<img src="assets/img2/logo.png" alt="" class="wow pulse" data-wow-delay="1s">';
	content+='<p>Lorem ipsum dolor cum necessitatibus su quisquam molestias. Vel unde, blanditiis.</p>';
	var lis = li("",i("pe-7s-mail strong","")+"service@pokechange.com") + li("",i("pe-7s-call strong","")+"01 58 54 69 52"); 
	content+=ul('footer-adress',lis);
	
	
	return footerColumn(title,content);
}

function footerColumn2(){
	var lis = li("",a("#","Accueil")) + li("",a("#","Chercher une carte")) + li("",a("#","mon profil")) + li("",a("#","forum"))  + li("",a("#","Mes cartes"));
	return footerColumn("Lien rapide",ul('footer-menu',lis));
}
function footerColumn2(){
	var lis = li("",a("#","Accueil")) + li("",a("#","Chercher une carte")) + li("",a("#","mon profil")) + li("",a("#","forum"))  + li("",a("#","Mes cartes"));
	return footerColumn("Lien rapide",ul('footer-menu',lis));
}

function footerColumn4(){
	var pi = p("","Lorem ipsum dolor sit amet, nulla  suscipit similique quisquam molestias. Vel unde, blanditiis.");
	var c = '<form><div class="input-group"><input class="form-control" type="text" placeholder="E-mail ... " style="color:black"><span class="input-group-btn"> ';
	c+='<button class="btn btn-primary subscribe" type="button"><i class="pe-7s-paper-plane pe-2x" style="color:black" ></i></button></span></div></form>';
	c+='<div class="social pull-right"><ul>';
	c+='<li><a class="wow fadeInUp animated" href="#"><i class="fa fa-twitter"></i></a></li>'
	c+='<li><a class="wow fadeInUp animated" href="#" data-wow-delay="0.2s"><i class="fa fa-facebook"></i></a></li>';
	c+='<li><a class="wow fadeInUp animated" href="#" data-wow-delay="0.3s"><i class="fa fa-google-plus"></i></a></li></ul></div>';
	c+='';
	c+='';
	
	return footerColumn('Recevez nos news',pi+c);	
}
// litumb(imag,titr,paragr,dat)
function footerColumn3(){
	var litumbs = ("assets/img2/Pikachu.png","Pikachu","Lorem ipsum dolor sit amet, nulla ...","2016/12/12");
	litumbs += ("assets/img2/Nymphali.png","Nymphali","Lorem ipsum dolor sit amet, nulla ...","2016/12/12");
	litumbs += ("assets/img2/Pikachu.png","Pikachu","Lorem ipsum dolor sit amet, nulla ...","2016/12/12");
	litumbs += ("assets/img2/Pikachu.png","Pikachu","Lorem ipsum dolor sit amet, nulla ...","2016/12/12");
	
	return footerColumn("Dernies ajouts",litumbs);
}
/*
<div class="single-footer">
                                <h4>Derniers ajouts</h4>
                                <div class="footer-title-line"></div>
                                <ul class="footer-blog">
                                    <li>
                                        <div class="col-md-3 col-sm-4 col-xs-4 blg-thumb p0">
                                            <a href="single.html">
                                                <img src="assets/img2/Pikachu.png">
                                            </a>
                                            <span class="blg-date">12-12-2016</span>

                                        </div>
                                        <div class="col-md-8  col-sm-8 col-xs-8  blg-entry">
                                            <h6> <a href="single.html">pikachu</a></h6> 
                                            <p style="line-height: 17px; padding: 8px 2px;">Lorem ipsum dolor sit amet, nulla ...</p>
                                        </div>
                                    </li> 

                                    <li>
                                        <div class="col-md-3 col-sm-4 col-xs-4 blg-thumb p0">
                                            <a href="single.html">
                                                <img src="assets/img2/Nymphali.png">
                                            </a>
                                            <span class="blg-date">12-12-2016</span>

                                        </div>
                                        <div class="col-md-8  col-sm-8 col-xs-8  blg-entry">
                                            <h6> <a href="single.html">Nymphali</a></h6> 
                                            <p style="line-height: 17px; padding: 8px 2px;">Lorem ipsum dolor sit amet, nulla ...</p>
                                        </div>
                                    </li>

									<li>
                                        <div class="col-md-3 col-sm-4 col-xs-4 blg-thumb p0">
                                            <a href="single.html">
                                                <img src="assets/img2/Pikachu.png">
                                            </a>
                                            <span class="blg-date">12-12-2016</span>

                                        </div>
                                        <div class="col-md-8  col-sm-8 col-xs-8  blg-entry">
                                            <h6> <a href="single.html">pikachu</a></h6> 
                                            <p style="line-height: 17px; padding: 8px 2px;">Lorem ipsum dolor sit amet, nulla ...</p>
                                        </div>
                                    </li>


                                </ul>
                            </div>
*/


/*
<div class="col-md-3 col-sm-6 wow fadeInRight animated">
                            <div class="single-footer news-letter">
                                <h4>Recevez nos news</h4>
                                <div class="footer-title-line"></div>
                                <p>Lorem ipsum dolor sit amet, nulla  suscipit similique quisquam molestias. Vel unde, blanditiis.</p>

                                <form>
                                    <div class="input-group">
                                        <input class="form-control" type="text" placeholder="E-mail ... " style="color:black">
                                        <span class="input-group-btn">
                                            <button class="btn btn-primary subscribe" type="button"><i class="pe-7s-paper-plane pe-2x" style="color:black" ></i></button>
                                        </span>
                                    </div>
                                    <!-- /input-group -->
                                </form> 

                                <div class="social pull-right"> 
                                    <ul>
                                        <li><a class="wow fadeInUp animated" href="#"><i class="fa fa-twitter"></i></a></li>
                                        <li><a class="wow fadeInUp animated" href="#" data-wow-delay="0.2s"><i class="fa fa-facebook"></i></a></li>
                                        <li><a class="wow fadeInUp animated" href="#" data-wow-delay="0.3s"><i class="fa fa-google-plus"></i></a></li>
                                    </ul> 
                                </div>
                            </div>
                        </div>
*/



/*
    <div class=" footer">
                <div class="container">
                    <div class="row">
                        <div class="col-md-3 col-sm-6 wow fadeInRight animated">
                            <div class="single-footer">
                                <h4>Lien rapide </h4>
                                <div class="footer-title-line"></div>
                                <ul class="footer-menu">
                                    <li><a href="#">Accueil</a>  </li> 
                                    <li><a href="#">chercher un carte</a>  </li> 
                                    <li><a href="#">mes cartes</a></li> 
                                    <li><a href="#">forum</a></li> 
                                    <li><a href="#">à propos</a></li> 
                                </ul>
                            </div>
                        </div>
                        <div class="col-md-3 col-sm-6 wow fadeInRight animated">
                            <div class="single-footer">
                                <h4>Derniers ajouts</h4>
                                <div class="footer-title-line"></div>
                                <ul class="footer-blog">
                                    <li>
                                        <div class="col-md-3 col-sm-4 col-xs-4 blg-thumb p0">
                                            <a href="single.html">
                                                <img src="assets/img2/Pikachu.png">
                                            </a>
                                            <span class="blg-date">12-12-2016</span>

                                        </div>
                                        <div class="col-md-8  col-sm-8 col-xs-8  blg-entry">
                                            <h6> <a href="single.html">pikachu</a></h6> 
                                            <p style="line-height: 17px; padding: 8px 2px;">Lorem ipsum dolor sit amet, nulla ...</p>
                                        </div>
                                    </li> 

                                    <li>
                                        <div class="col-md-3 col-sm-4 col-xs-4 blg-thumb p0">
                                            <a href="single.html">
                                                <img src="assets/img2/Nymphali.png">
                                            </a>
                                            <span class="blg-date">12-12-2016</span>

                                        </div>
                                        <div class="col-md-8  col-sm-8 col-xs-8  blg-entry">
                                            <h6> <a href="single.html">Nymphali</a></h6> 
                                            <p style="line-height: 17px; padding: 8px 2px;">Lorem ipsum dolor sit amet, nulla ...</p>
                                        </div>
                                    </li>

									<li>
                                        <div class="col-md-3 col-sm-4 col-xs-4 blg-thumb p0">
                                            <a href="single.html">
                                                <img src="assets/img2/Pikachu.png">
                                            </a>
                                            <span class="blg-date">12-12-2016</span>

                                        </div>
                                        <div class="col-md-8  col-sm-8 col-xs-8  blg-entry">
                                            <h6> <a href="single.html">pikachu</a></h6> 
                                            <p style="line-height: 17px; padding: 8px 2px;">Lorem ipsum dolor sit amet, nulla ...</p>
                                        </div>
                                    </li>


                                </ul>
                            </div>
                        </div>
                        

                    </div>
                </div>
            </div>             
                    
                        
                            
                                
                                    
                                
                                                                   
                                    
                                        
                                        
								                                   
                                    
                                        
                                
								                                   
                                    
										 
									
                                
								
                                
                            </div>
                        </form>
                    </div>
                </div>
            </div>*/
			
			function li(cl,res){
	return '<li class="'+cl+'">'+res+'</li>';
}
function ul(cl,res){
	return '<ul class="'+cl+'">'+res+'</ul>';
}
function i(cl,res){
	return '<i class="'+cl+'">'+res+'</i>';
}

function balise(bal,cl,res){
	return '<'+bal+'class="'+cl+'">'+res+'</'+bal+'>';
}

function a(cl,res){
	return '<a href="'+cl+'" >'+res+'</a>';
}

function p(cl,res){
	return '<p class="'+cl+'" >'+res+'</p>';
}

function litumb(imag,titr,paragr,dat){
	var c = '<li>';
	c+='<div class="col-md-3 col-sm-4 col-xs-4 blg-thumb p0">';
	c+='<a href="single.html"><img src="'+imag+'"></a>';
	c+='<span class="blg-date">'+dat+'</span></div>';
	c+='<div class="col-md-8  col-sm-8 col-xs-8  blg-entry"><h6> <a href="single.html">'+titr+'</a></h6>';
	c+='<p style="line-height: 17px; padding: 8px 2px;">'+paragr+'</p>';
	c+='</div>';
	c+=' </li>';
	c+='';
	
	return c;
}
                                        
                                            
                                                
                                           
                                            

                                        
                                        
                                             
                                            
                                        
                                   