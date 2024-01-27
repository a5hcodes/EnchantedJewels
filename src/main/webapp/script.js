function validateForm(){
    let emailregex= RegExp(/^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/);
    let x=document.forms.fname.form2Example27.value;
    let e = x.trim(); 
    if (!emailregex.test(e) || e ===" " ){
        document.getElementById("form2Example17").innerHTML=("Please enter a valid email");
        return false;
    } 
    else if (e.length !== 8) {
        document.getElementById("form2Example27").innerHTML=("Please enter 8 digit password");
        return false;
    }
}
