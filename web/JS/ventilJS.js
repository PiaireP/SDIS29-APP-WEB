var lesActivites = document.getElementsByClassName("ztVentil");
var lesCouleurs =["gris", "jaune", "vert"]

//Permet de changer la valeur et la couleur des cellules du tableau des affectations
for(var uneActivite of lesActivites) {
    uneActivite.onclick = function() {
        act = this.value;
        newAct= (act+1)%3; // %3 empêche d'aller au delà de 2 
        couleur = lesCouleurs[newAct];
        this.classList.remove(lesCouleurs[act]);
        this.classList.add(couleur);
        this.value = newAct;
        
    }
}

//Bloquer le checkbox si la case est grise
/*var checkbox = document.querySelectorAll("#checkbox");

for(i=0; i< lesActivites.length; i++){
    if (lesActivites[i].value == 0) {
        lesActivites[i].nextSibling.nextSibling.disabled=true;
    }
}*/




