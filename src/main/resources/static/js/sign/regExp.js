const error = document.querySelectorAll('.error-text');
const icons = document.querySelectorAll('.content .input-container .icons span');

const idRegExp = /^[a-z][a-z1-9]{3,11}$/;
const pwdRegExp = /^(?=.*[a-zA-Z])(?=.*[0-9])[A-Za-z\d$@$!%*#?&]{8,14}$/;
const emailRegExp = /^[^ ]+@[^ ]+\.[a-z]{2,3}$/;
const nicknameRegExp = /^[a-z1-9]{4,12}$/;

function check(index) {
    switch(index) {
        case 0:
            display(index, idRegExp);
            break;
        case 1:
            display(index, pwdRegExp);
            break;
        case 2:
            display(index);
            break;
        case 3:
            display(index, emailRegExp);
            break;
        case 4:
            display(index);
            break;
        case 5:
            display(index, nicknameRegExp);
            break;
    }
    
}

function display(index, regExp = "") {
    const iconIndex = index * 2;
    if(index === 4) {
        if(inputArray[index].value) {
            inputArray[index].style.borderColor = "#56ba6f";
            return;
        }
    }
    if(!regExp) {
        if(!inputArray[index].value) {
            icons[iconIndex].style.display = "none";
            icons[iconIndex + 1].style.display = "none";
            error[index].style.display = "none";
            inputArray[index].style.borderColor = "var(--containerColor)";
            return;
        }
        if(inputArray[index - 1].value === inputArray[index].value){
            icons[iconIndex].style.display = "block";
            icons[iconIndex + 1].style.display = "none";
            error[index].style.display = "none";
            inputArray[index].style.borderColor = "#56ba6f";
            return;
        }
        icons[iconIndex].style.display = "none";
        icons[iconIndex + 1].style.display = "block";
        error[index].style.display = "block";
        inputArray[index].style.borderColor = "#be554c";
        return;
    }
    if(inputArray[index].value.match(regExp)){
        icons[iconIndex].style.display = "block";
        icons[iconIndex + 1].style.display = "none";
        error[index].style.display = "none";
        inputArray[index].style.borderColor = "#56ba6f";
    } else if(!inputArray[index].value) {
        icons[iconIndex].style.display = "none";
        icons[iconIndex + 1].style.display = "none";
        error[index].style.display = "none";
        inputArray[index].style.borderColor = "var(--containerColor)";
    }
    else {
        icons[iconIndex].style.display = "none";
        icons[iconIndex + 1].style.display = "block";
        error[index].style.display = "block";
        inputArray[index].style.borderColor = "#be554c";
    }
}

const inputArray = document.querySelectorAll('input');
for(let i = 0; i < inputArray.length; i++) {
    inputArray[i].addEventListener('keyup', () => check(i));
}