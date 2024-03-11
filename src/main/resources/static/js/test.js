var a = document.querySelector(".group");

var input1 = document.querySelector("#cb1-input");
var input2 = document.querySelector("#cb2-input");
var input3 = document.querySelector("#cb3-input");
var input4 = document.querySelector("#cb4-input");
var input5 = document.querySelector("#cb5-input");
var input6 = document.querySelector("#cb6-input");

var b = document.querySelector("#cb1-listbox");

var bool1 = Boolean(false);
var bool2 = Boolean(false);
var bool3 = Boolean(false);
var bool4 = Boolean(false);
var bool5 = Boolean(false);
var bool6 = Boolean(false);

input1.addEventListener('focus', () => {
    b.style.top = '28px';
    b.style.display = "block";
    bool1 = true;
    searchAllAbil();
})
input2.addEventListener('focus', () => {
    b.style.top = '60px';
    b.style.display = "block";
    bool2 = true;
    searchAllAbil();
})
input3.addEventListener('focus', () => {
    b.style.top = '92px';
    b.style.display = "block";
    bool3 = true;
    searchAllAbil();
})
input4.addEventListener('focus', () => {
    b.style.top = '124px';
    b.style.display = "block";
    bool4 = true;
    searchAllAbil();
})
input5.addEventListener('focus', () => {
    b.style.top = '156px';
    b.style.display = "block";
    bool5 = true;
    searchAllAbil();
})
input6.addEventListener('focus', () => {
    b.style.top = '188px';
    b.style.display = "block";
    bool6 = true;
    searchAllAbil();
})

input1.addEventListener('blur', () => {
    b.style.display = "none";
    bool1 = false;
})
input2.addEventListener('blur', () => {
    b.style.display = "none";
    bool2 = false;
})
input3.addEventListener('blur', () => {
    b.style.display = "none";
    bool3 = false;
})
input4.addEventListener('blur', () => {
    b.style.display = "none";
    bool4 = false;
})
input5.addEventListener('blur', () => {
    b.style.display = "none";
    bool5 = false;
})
input6.addEventListener('blur', () => {
    b.style.display = "none";
    bool6 = false;
})

input1.addEventListener('input', () => {
    
    if (b.hasChildNodes()) {
        b.replaceChildren();
    }
    searchAbil(input1.value);
})
input2.addEventListener('input', () => {
    
    if (b.hasChildNodes()) {
        b.replaceChildren();
    }
    searchAbil(input2.value);
})
input3.addEventListener('input', () => {
    
    if (b.hasChildNodes()) {
        b.replaceChildren();
    }
    searchAbil(input3.value);
})
input4.addEventListener('input', () => {
    
    if (b.hasChildNodes()) {
        b.replaceChildren();
    }
    searchAbil(input4.value);
})
input5.addEventListener('input', () => {
    
    if (b.hasChildNodes()) {
        b.replaceChildren();
    }
    searchAbil(input5.value);
})
input6.addEventListener('input', () => {
    
    if (b.hasChildNodes()) {
        b.replaceChildren();
    }
    searchAbil(input6.value);
})

function searchAbil(word) {
    $.ajax({
        url: '/access/list/' + word,
        type: "GET",
        dataType: 'json',
        data: { name: name }	// 검색 키워드
    }).done(function (result) { 	// 성공
        if (result.length == 0) {
          return;
        }
        for (var i = 0; i < result.length; i++){
            searchAbil1(result[i]);
        }
    });
}
function searchAllAbil() {
    if (b.hasChildNodes()) {
        b.replaceChildren();
    }
    
    $.ajax({
        url: '/access/list',
        type: "GET",
        dataType: 'json',
        data: { name: name }	// 검색 키워드
    }).done(function (result) { 	// 성공
        if (result.length == 0) {
          return;
        }
        for (var i = 0; i < result.length; i++){
            searchAbil1(result[i]);
        }
    });
}

function searchAbil1(result) { 
    var li = document.createElement('li');

    $('li').mousedown(function () {
        if (bool1) {
            input1.value = this.textContent;
            bool1 = false;
        } else if (bool2) {
            input2.value = this.textContent;
            bool2 = false;
        } else if (bool3) {
            input3.value = this.textContent;
            bool3 = false;
        } else if (bool4) {
            input4.value = this.textContent;
            bool4 = false;
        } else if (bool5) {
            input5.value = this.textContent;
            bool5 = false;
        } else if (bool6) {
            input6.value = this.textContent;
            bool6 = false;
        }
        b.style.display = "none";
    })

    li.textContent = result.name;
    li.role = 'option';
    b.appendChild(li);

    return b;
}