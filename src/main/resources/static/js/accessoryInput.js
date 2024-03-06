var input1 = document.querySelector("#access_1");
var input2 = document.querySelector("#access_2");
var input3 = document.querySelector("#access_3");
var input4 = document.querySelector("#access_4");
var input5 = document.querySelector("#access_5");
var input6 = document.querySelector("#access_6");
var input7 = document.querySelector("#access_7");
var input8 = document.querySelector("#access_8");


var div1 = document.querySelector("#selectAbility1");
var div2 = document.querySelector("#selectAbility2");
var div3 = document.querySelector("#selectAbility3");
var div4 = document.querySelector("#selectAbility4");
var div5 = document.querySelector("#selectAbility5");
var div6 = document.querySelector("#selectAbility6");
// 어빌리티 스톤
var div7 = document.querySelector("#selectAbility7");
var div8 = document.querySelector("#selectAbility8");
var div9 = document.querySelector("#selectAbility9");

var called = false;

input1.addEventListener('focus', () => {
    if (!called) {
        callList(div1, input1);
        called = true;
    } else {
        check();
        callList(div1, input1);
        called = true;
    }
});
input2.addEventListener('focus', () => {
    if (!called) {
        callList(div2, input2);
        called = true;
    } else {
        check();
        callList(div2, input2);
        called = true;
    }
});
input3.addEventListener('focus', () => {
    if (!called) {
        callList(div3,input3);
        called = true;
    } else {
        check();
        callList(div3,input3);
        called = true;
    }
});
input4.addEventListener('focus', () => {
    if (!called) {
        callList(div4,input4);
        called = true;
    } else {
        check();
        callList(div4,input4);
        called = true;
    }
});
input5.addEventListener('focus', () => {
    if (!called) {
        callList(div5,input5);
        called = true;
    }  else {
        check();
        callList(div5,input5);
        called = true;
    }  
});
input6.addEventListener('focus', () => {
    if (!called) {
        callList(div6,input6);
        called = true;
    } else {
        check();
        callList(div6,input6);
        called = true;
    }
});

function check() {
    var select1 = document.querySelector(".selectAbility1");
    var select2 = document.querySelector(".selectAbility2");
    var select3 = document.querySelector(".selectAbility3");
    var select4 = document.querySelector(".selectAbility4");
    var select5 = document.querySelector(".selectAbility5");
    var select6 = document.querySelector(".selectAbility6");

    if (select1 != null) {
        console.log("체크 1");
        delSelect(select1, div1);
    } else if (select2 != null) {
        console.log("체크 2");
        delSelect(select2, div2);
    } else if (select3 != null) {
        console.log("체크 3");
        delSelect(select3, div3);
    } else if (select4 != null) {
        console.log("체크 4");
        delSelect(select4, div4);
    } else if (select5 != null) {
        console.log("체크 5");
        delSelect(select5, div5);
    } else if (select6 != null) {
        console.log("체크 6");
        delSelect(select6, div6);
    }
}
function delSelect(select, div) {
    div.removeChild(select);
    called = false;
}

function setName(option, select,input, div) {
    input.value = option.text;

    div.removeChild(select);

    called = false;
}
function addOption(abil, select, input,div) {
    const option = document.createElement("option");
    option.text = abil.name;
    option.className = abil.name;
    option.addEventListener('click', () => {
        setName(option, select, input, div);
    });
    select.appendChild(option);
}
function callList(div, input) {
    const select = document.createElement("select");

    select.className = "abilityBox box " + div.id;
    select.size = 5;
    select.style.zIndex = 2;
    
    $.ajax({
        type: 'GET',
        url: '/access/list',
        data: {
            name: name
        },
        dataType: 'json',
        }).done(function (result) {
        if (result.length == 0) {
            return;
        }
            div.appendChild(select);
        for (var i = 0; i < result.length; i++) {
            addOption(result[i], select, input, div);
        }
    });
}
    