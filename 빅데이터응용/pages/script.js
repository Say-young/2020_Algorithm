function btn1_click(){
    document.getElementById("btn1").style.color ='#4AFFE0';
    document.getElementById("btn2").style.color ='white';
    document.getElementById("btn3").style.color ='white';
    document.getElementById("btn4").style.color ='white';
    document.getElementById("center-insert").style.display ='flex';
    document.getElementById("center-update").style.display ='none';
    document.getElementById("center-delete").style.display ='none';
}

function btn2_click(){
    document.getElementById("btn1").style.color ='white';
    document.getElementById("btn2").style.color ='#4AFFE0';
    document.getElementById("btn3").style.color ='white';
    document.getElementById("btn4").style.color ='white';
    document.getElementById("center-insert").style.display ='none';
    document.getElementById("center-update").style.display ='flex';
    document.getElementById("center-delete").style.display ='none';
}

function btn3_click(){
    document.getElementById("btn1").style.color ='white';
    document.getElementById("btn2").style.color ='white';
    document.getElementById("btn3").style.color ='#4AFFE0';
    document.getElementById("btn4").style.color ='white';
    document.getElementById("center-insert").style.display ='none';
    document.getElementById("center-update").style.display ='none';
    document.getElementById("center-delete").style.display ='flex';
}

function btn4_click(){
    document.getElementById("btn1").style.color ='white';
    document.getElementById("btn2").style.color ='white';
    document.getElementById("btn3").style.color ='white';
    document.getElementById("btn4").style.color ='#4AFFE0';
    document.getElementById("center-insert").style.display ='none';
    document.getElementById("center-update").style.display ='none';
    document.getElementById("center-delete").style.display ='none';
}

function oneCheckbox(a){
    var obj = document.getElementsByName("group");
    for(var i=0; i<obj.length; i++){
        if(obj[i] != a){
            obj[i].checked = false;
        }
    }

    if(obj[0]==a){
        document.getElementById("asia").style.display='block';
        document.getElementById("africa").style.display='none';
        document.getElementById("america").style.display='none';
        document.getElementById("oceania").style.display='none';
        document.getElementById("europe").style.display='none';
        document.getElementById("submit1").style.display='block';
    }else if(obj[1]==a){
        document.getElementById("asia").style.display='none';
        document.getElementById("africa").style.display='none';
        document.getElementById("america").style.display='block';
        document.getElementById("oceania").style.display='none';
        document.getElementById("europe").style.display='none';
        document.getElementById("submit2").style.display='block';
    }else if(obj[2]==a){
        document.getElementById("asia").style.display='none';
        document.getElementById("africa").style.display='none';
        document.getElementById("america").style.display='none';
        document.getElementById("oceania").style.display='none';
        document.getElementById("europe").style.display='block';
        document.getElementById("submit3").style.display='block';
    }else if(obj[3]==a){
        document.getElementById("asia").style.display='none';
        document.getElementById("africa").style.display='block';
        document.getElementById("america").style.display='none';
        document.getElementById("oceania").style.display='none';
        document.getElementById("europe").style.display='none';
        document.getElementById("submit4").style.display='block';
    }else if(obj[4]==a){
        document.getElementById("asia").style.display='none';
        document.getElementById("africa").style.display='none';
        document.getElementById("america").style.display='none';
        document.getElementById("oceania").style.display='block';
        document.getElementById("europe").style.display='none';
        document.getElementById("submit5").style.display='block';
    }
}