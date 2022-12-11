var  n = 0;
function dropdownchecker(){
    n++;
    if(n % 2 != 0){
    document.getElementById("dropdownbox").style.display="block";
    console.log("hi  bro");
    }
    else{
        document.getElementById("dropdownbox").style.display="none";
    }
}