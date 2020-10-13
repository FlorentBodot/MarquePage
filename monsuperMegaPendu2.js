/*------------------------------------------------------------------------
Script gérant le jeu du pendu
-------------------------------------------------------------------------*/
var NOM_IMG_DFLT="img/pendu_";

var tabNoms = [ "BODOT","BOURGEOIS","BOUYX",
				"BRELLIER","BRUNEL","CORDELET",
				"DUBOS","EYMANN","GIBOZ",
				"HESNAULT","JOUSSAUME","LATTREZ",
				"MENARD","MONTBRUN","RALL",
				"REUTER","ROBION",
				"SELLES","YEECHONG"];

var leNom;
var nbCoup;
var ctrErr;
var proposition="";
var motPropose;
/* --------------------FONCTIONS UTILES ----------------------------------*/
function initialiser(){
	document.querySelector("#partie").style.visibility="hidden";
	nbCoup=0;
	ctrErr=0;
	tirerUnNom();
	//MEP des tirets dans proposition
	for(i=0;i<leNom.length;i++){
		proposition+="_ ";
	}
	afficherProposition();
}

/* ---------------------------------------------------
  Function chargée tirer un nom au hasard
  ----------------------------------------------------*/
function tirerUnNom() {
	nomOK = false;
	while (!nomOK) {
		idx = parseInt(Math.random() * tabNoms.length);
		if (idx >= 0 && idx <= tabNoms.length) {
			leNom = tabNoms[idx];
			nomOK = (leNom !== "undefined" && leNom != "");
		}
		console.log("LE NOM=" + leNom + " OK=" + nomOK);
	}
	return leNom;
}
// a controler 
function afficher(id,msg,h2){
	document.querySelector(id).innerHTML=((h2)?"<h2>":"<h3>")+proposition+((h2)?"</h2>":"</h3>");
}
function afficherProposition(){
	document.querySelector("#proposition").innerHTML="<h2>"+proposition+"</h2>";
}
function afficherCompteurs(){
	console.log("afficherCompteurs");
	document.querySelector("#coup").innerHTML="<h3>"+nbCoup+"</h3>";
	document.querySelector("#nberreur").innerHTML="<h3>"+ctrErr+"</h3>";
	return false;
}

var coupBon = 0;
function verifier(){
	nbCoup++;
	
	lettre = document.querySelector("#lettre").value;
	
	if(leNom.includes(lettre)){
		//la lettre existe dans le NOM
		if (proposition.includes(lettre)){
			//cas erreur
			gererErreur();
		}else{
			//la lettre est dans le NOM mais pas encore proposée
			str="";
			for(i=0;i<leNom.length;i++){
				if (leNom.charAt(i)==lettre){
					str+=lettre+" ";
					coupBon++;
				} else{
					car = proposition.charAt((i==0)?0:(i*2));
					str+=car+" ";
					
				}
			}
			proposition = str;

			afficherProposition();
			
			
		}
		
	}else{
		//la lettre n'existe pas dans le NOM
		gererErreur();
	}
	
	console.log("appel controle victoire");
	controleVictoire();
	return false;
}

function controleVictoire(){

	if (coupBon==leNom.length) {
		alert("Victoire");
	}
}

function gererErreur(){
	console.log("fn gererErreur()");
	ctrErr++;
	afficherCompteurs();
	switch(ctrErr){
			case 1:	
			document.querySelector("#debut").style.display="none";
			avcpdn();
			break;

			case 2: avcpdn();		
			break;

			case 3:	avcpdn();		
			break;

			case 4:	avcpdn();		
			break;

			case 5:	avcpdn();		
			break;

			case 6:	avcpdn();		
			break;

			case 7:	avcpdn();		
			break;

			case 8:	avcpdn();		
			break;

			case 9:	avcpdn();		
			break;

			case 10: avcpdn();			
			break;

			case 11:
			document.querySelector("#fig9").innerHTML="<img src= 'img/pendu_11.png' />";
			document.querySelector("#fig10").innerHTML="<img src= 'img/pendu_11b.png' />";			
			break;

			case 12:
			document.querySelector("#fig8").innerHTML="<img src= 'img/pendu_12b.png' />";
			document.querySelector("#fig7").innerHTML="<img src= 'img/pendu_12.png' />";			
			break;

			case 13:
			document.querySelector("#fig6").innerHTML="<img src= 'img/pendu_13b.png' />";
			document.querySelector("#fig5").innerHTML="<img src= 'img/pendu_13.png' />";			
			break;

			case 14:
			document.querySelector("#fig4").innerHTML="<img src= 'img/pendu_14b.png' />";
			document.querySelector("#fig3").innerHTML="<img src= 'img/pendu_14.png' />";		
			break;

			case 15:
			document.querySelector("#fig2").innerHTML="<img src= 'img/pendu_15b.png' />";
			document.querySelector("#fig1").innerHTML="<img src= 'img/pendu_15.png' />";
			alert("perdu");			
			return true;				
			break;

			default:
			break;
		}
		function avcpdn(){
			document.querySelector("#fig"+ctrErr).style.visibility="visible";	
		}

	return false;
}