/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



function maFunction() {
 var btValider = document.getElementById("btValidModifProfil");
 var btModif = document.getElementById("btModifProfil");
    if (btValider.style.display === "none" && btModif.style.display === "" ) {
       btValider.style.display = "";
       btModif.style.display = "none";
    }else{
        btValider.style.display = "none";
        btModif.style.display = "";
    }
}

function functionModifProfil() {
    var input = document.querySelectorAll(".modifInput");
    for (i=0 ; i < input.length ; i++) {
        input[i].disabled = false;
    }
}
   
function functionValiderProfil() { 
    var input = document.querySelectorAll(".modifInput");
    for (i=0 ; i < input.length ; i++) {
        input[i].disabled = true;
    }
}


   
/*var input = document.querySelectorAll(".modifInput");
    console.log(input);
    if (input.disabled = true){
        input.disabled = false;*/
        