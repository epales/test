function success1(abil) {

    var ability = document.getElementsByClassName(abil);
    if (abil == "abil1") {
        if (firstStoneCount < 10) {
            ability.item(firstStoneCount).src = "img/Blue.png";
            firstStoneCount++;

            if (expectValue > 25) {
                expectValue -= 10;
            }
        } else {
            alert('첫 번째의 각인을 모두 세공했습니다.');
            return;
        }
    } else if (abil == 'abil2') {
        if (secondStoneCount < 10) {
            ability.item(secondStoneCount).src = "img/Blue.png";
            secondStoneCount++;

            if (expectValue > 25) {
                expectValue -= 10;
            }

        } else {
            alert('두 번째의 각인을 모두 세공했습니다.');
            return;
        }
    } else {
        if (thirdStoneCount < 10) {
            ability.item(thirdStoneCount).src = "img/Red.png";
            thirdStoneCount++;
            if (expectValue > 25) {
                expectValue -= 10;
            }
        } else {
            alert('세 번째의 각인을 모두 세공했습니다.');
            return;
        }
    }
}
function fail1(abil) {

    var ability = document.getElementsByClassName(abil);
    if (abil == "abil1") {
        if (firstStoneCount < 10) {
            ability.item(firstStoneCount).src = "img/Gray.png";
            firstStoneCount++;

            if (expectValue < 75) {
                expectValue += 10;
            }
        } else {
            alert('첫 번째의 각인을 모두 세공했습니다.');
            return;
        }
    } else if (abil == 'abil2') {
        if (secondStoneCount < 10) {
            ability.item(secondStoneCount).src = "img/Gray.png";
            secondStoneCount++;
            if (expectValue < 75) {
                expectValue += 10;
            }
        } else {
            alert('두 번째의 각인을 모두 세공했습니다.');
            return;
        }
    } else {
        if (thirdStoneCount < 10) {
            ability.item(thirdStoneCount).src = "img/Gray.png";
            thirdStoneCount++;
            if (expectValue < 75) {
                expectValue += 10;
            }
        } else {
            alert('세 번째의 각인을 모두 세공했습니다.');
            return;
        }
    }
}
function success2(abil) {
    if (!button7.disabled) {
        CraftDisable();
    }
    var ability = document.getElementsByClassName(abil);
    if (abil == "abil1") {
        if (firstStoneCount < 10) {
            ability.item(firstStoneCount).src = "img/Blue.png";
            firstStoneCount++;
        } else {
            alert('첫 번째의 각인을 모두 세공했습니다.');
            return;
        }
    } else if (abil == 'abil2') {
        if (secondStoneCount < 10) {
            ability.item(secondStoneCount).src = "img/Blue.png";
            secondStoneCount++;
        } else {
            alert('두 번째의 각인을 모두 세공했습니다.');
            return;
        }
    } else {
        if (thirdStoneCount < 10) {
            ability.item(thirdStoneCount).src = "img/Red.png";
            thirdStoneCount++;
        } else {
            alert('세 번째의 각인을 모두 세공했습니다.');
            return;
        }
    }
    aa.innerText = "직접 세공";
}

function fail2(abil) {
    if (!button7.disabled) {
        CraftDisable();
    }
    var ability = document.getElementsByClassName(abil);
    if (abil == "abil1") {
        if (firstStoneCount < 10) {
            ability.item(firstStoneCount).src = "img/Gray.png";
            firstStoneCount++;
        } else {
            alert('첫 번째의 각인을 모두 세공했습니다.');
            return;
        }
    } else if (abil == 'abil2') {
        if (secondStoneCount < 10) {
            ability.item(secondStoneCount).src = "img/Gray.png";
            secondStoneCount++;
        } else {
            alert('두 번째의 각인을 모두 세공했습니다.');
            return;
        }
    } else {
        if (thirdStoneCount < 10) {
            ability.item(thirdStoneCount).src = "img/Gray.png";
            thirdStoneCount++;
        } else {
            alert('세 번째의 각인을 모두 세공했습니다.');
            return;
        }
    }
    aa.innerText = "직접 세공";
}

function selfCraftDisable() {
    button1.disabled = true;
    button2.disabled = true;
    button3.disabled = true;
    button4.disabled = true;
    button5.disabled = true;
    button6.disabled = true;
}
function CraftDisable() {
    button7.disabled = true;
    button8.disabled = true;
    button9.disabled = true;
}
function craft(abil) {
    if (!button1.disabled) {
        selfCraftDisable();
    }
    const randomNum = Math.floor(Math.random() * 100) + 1;
    //1. 클래스 인식해서 받아오고
    console.log(abil)
    //2. 카운트 확인함 10개 다 채우면 확률세공 막거나 얼럿
    console.log(expectValue + " : " + randomNum);

    if (expectValue >= randomNum) {
        success1(abil);
        console.log("세공 성공! ^ v ^");
    } else {
        fail1(abil);
        console.log("세공 실패! ㅠㅡㅠ");
    }
    console.log("현재 확률 : " + expectValue + "%");
    percent();
    //3. 확률은 성공 시 -10% 실패 시 +10% 최대 75% 최소 25%
    //4. 모든 세공 완료 시 줄 당 성공 횟수 출력

}

function reset() {
    button1.disabled = false;
    button2.disabled = false;
    button3.disabled = false;
    button4.disabled = false;
    button5.disabled = false;
    button6.disabled = false;
    button7.disabled = false;
    button8.disabled = false;
    button9.disabled = false;

    var ability1 = document.getElementsByClassName('abil1');
    var ability2 = document.getElementsByClassName('abil2');
    var ability3 = document.getElementsByClassName('minusAbility');

    firstStoneCount = 0;
    secondStoneCount = 0;
    thirdStoneCount = 0;
    expectValue = 75;

    percent();

    for (let i = 0; i < 10; i++) {
        ability1.item(i).src = "img/White.png";
        ability2.item(i).src = "img/White.png";
        ability3.item(i).src = "img/White.png";
    }
}

const ability1Set = document.querySelector('.ability1Set');
const ability2Set = document.querySelector('.ability2Set');
const ability3Set = document.querySelector('.ability3Set');
const successPercent = document.querySelector('.successPercent');
const resetDiv = document.querySelector('.reset');


for (let i = 1; i < 11; i++) {
    const img1 = new Image();
    img1.src = 'img/White.png';
    img1.className = 'abil1';
    img1.style = 'width:20px; height:20px;';
    ability1Set.appendChild(img1);

    const img2 = new Image();
    img2.src = 'img/White.png';
    img2.className = 'abil2';
    img2.style = 'width:20px; height:20px;';
    ability2Set.appendChild(img2);

    const img3 = new Image();
    img3.src = 'img/White.png';
    img3.className = 'minusAbility';
    img3.style = 'width:20px; height:20px;';
    ability3Set.appendChild(img3);
}

const button1 = document.createElement('button');  // 1각인 성공
const button2 = document.createElement('button');  // 1각인 실패
const button3 = document.createElement('button');  // 2각인 성공
const button4 = document.createElement('button');  // 2각인 성공
const button5 = document.createElement('button');  // 3각인 성공
const button6 = document.createElement('button');  // 3각인 성공
const button7 = document.createElement('button');  // 1각인 확률 세공
const button8 = document.createElement('button');  // 2각인 확률 세공
const button9 = document.createElement('button');  // 3각인 확률 세공
const button10 = document.createElement('button'); // 전체 초기화

var firstStoneCount = 0;    // 1각인 세공 카운트
var secondStoneCount = 0;   // 2각인 세공 카운트
var thirdStoneCount = 0;    // 3각인 세공 카운트
var expectValue = 75;       // 각인 성공 확률 (변동)

function percent() {
    let aa = document.getElementsByClassName("percentage")[0];
    aa.innerText = expectValue + "%";
}
let aa = document.getElementsByClassName("percentage")[0];
aa.innerText = expectValue + "%";

button1.className = 'abil1';
button1.innerHTML = '성공';
ability1Set.appendChild(button1);

button2.className = 'abil1';
button2.innerHTML = '실패';
ability1Set.appendChild(button2);

button3.className = 'abil2';
button3.innerHTML = '성공';
ability2Set.appendChild(button3);

button4.className = 'abil2';
button4.innerHTML = '실패';
ability2Set.appendChild(button4);

button5.className = 'minusAbility';
button5.innerHTML = '성공';
ability3Set.appendChild(button5);

button6.className = 'minusAbility';
button6.innerHTML = '실패';
ability3Set.appendChild(button6);

button7.className = 'abil1';
button7.innerHTML = '확률 세공하기';
ability1Set.appendChild(button7);

button8.className = 'abil2';
button8.innerHTML = '확률 세공하기';
ability2Set.appendChild(button8);

button9.className = 'minusAbility';
button9.innerHTML = '확률 세공하기';
ability3Set.appendChild(button9);

button10.className = 'reset';
button10.innerHTML = '초기화';
resetDiv.appendChild(button10);

button1.addEventListener('click', () => {
    success2(button1.className);
})
button2.addEventListener('click', () => {
    fail2(button2.className);
})
button3.addEventListener('click', () => {
    success2(button3.className);
})
button4.addEventListener('click', () => {
    fail2(button4.className);
})
button5.addEventListener('click', () => {
    success2(button5.className);
})
button6.addEventListener('click', () => {
    fail2(button6.className);
})

button7.addEventListener('click', () => {
    craft(button7.className);
})

button8.addEventListener('click', () => {
    craft(button8.className);
})

button9.addEventListener('click', () => {
    craft(button9.className);
})

button10.addEventListener('click', () => {
    reset();
})