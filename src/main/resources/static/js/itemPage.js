const articlesPerPageSize = 10;
    
function getPageId(n) {
    return 'article-page-' + n;
}
  
function getArticle(item, price, sonik, YN) {
  const tr = document.createElement('tr');
  const td1 = document.createElement("td");
  const td2 = document.createElement("td");
  const td3 = document.createElement("td");
  const td4 = document.createElement("td");
  const td5 = document.createElement("td");
  const img = document.createElement("img");
  const p1 = document.createElement("p");
  
  const b1 = document.createElement("b");
  const b2 = document.createElement("b");
  const b3 = document.createElement("b");
  const b4 = document.createElement("b");

  tr.id = "body";
  
  img.src = item.icon;
  img.className = "imageClass";
  img.style.width = '20px';
  img.style.height = '20px';
  img.addEventListener('click', () => {
    move(item.code,item.categoriesCode);
  })

  td2.className="imageBlock";
  
  p1.textContent = item.name;
  p1.style.marginRight = '5px';

  b1.textContent = item.currentMinPrice;

  if (YN != 0) {
    b2.textContent = price;
    b3.textContent = sonik;
    if (sonik > 0) {
      b4.textContent = "이득";
    } else {
      b4.textContent = "손해";
    }
  } else {
    b2.textContent = "제작 불가";
    b3.textContent = "제작 불가";
    b4.textContent = "제작 불가";
  }
  
  b2.style.marginRight = '5px';
  
  
  // td3에 제작비용 추가
  // 아이템 코드로 DB 조회 후 SUM(price) 값 입력 후 출력

  // td4에 판매차익 추가
  // 시세 - 수수료 (시세 * 0.05) - 제작 비용 출력

  // td5에 이익 여부
  // 판매차익 양수 = 이득, 음수 = 손해 출력
  
  // 제작 불가 아이템의 경우
  // DB 아이템 코드 조회하여 NULL 일 경우 td3, td4, td5 에 제작 불가 출력
  
  td1.className = "th-start column";
  td2.className = "th-right column";
  td3.className = "th-right column";
  td4.className = "th-right column";
  td5.className = "th-right column";

  tr.appendChild(td1);
  tr.appendChild(td2);
  tr.appendChild(td3);
  tr.appendChild(td4);
  tr.appendChild(td5);
  
  td1.appendChild(img);
  td1.appendChild(p1);
  td2.appendChild(b1);
  td3.appendChild(b2);
  td4.appendChild(b3);
  td5.appendChild(b4);

  return tr;
}
function getTableHead() {
  const tr = document.createElement('tr');

  const th1 = document.createElement('th');
  const th2 = document.createElement('th');
  const th3 = document.createElement('th');
  const th4 = document.createElement('th');
  const th5 = document.createElement('th');

  th1.className = "th-start column";
  th2.className = "th-right column";
  th3.className = "th-right column";
  th4.className = "th-right column";
  th5.className = "th-right column";

  th1.textContent = "레시피";
  
  th2.textContent = "시세";

  th3.textContent = "제작비용";

  th4.textContent = "판매차익";

  th5.textContent = "이익여부";

  tr.appendChild(th1);
  tr.appendChild(th2);
  tr.appendChild(th3);
  tr.appendChild(th4);
  tr.appendChild(th5);

  return tr;
}

function addPage(page) {
  $.ajax({
        type: 'GET',
        url: '/scroll/list',
        data: {
          page: page, // current Page
          size: articlesPerPageSize, // max page size
        },
        dataType: 'json',
      }).done(function (result) {
        if (result.length == 0) {
          return;
        }

        $.ajax({
          type: 'GET',
          url: '/scroll/list/sonik',
          data: {
            page: page, // current Page
            size: articlesPerPageSize, // max page size
          },
          dataType: 'json',
        }).done(function (price) {

          const pageElement = document.createElement('table');
          const thead = document.createElement('thead');
          const tbody = document.createElement('tbody');
        
          pageElement.id = getPageId(page);
          pageElement.className = 'table';

          pageElement.appendChild(thead);
          pageElement.appendChild(tbody);

          thead.appendChild(getTableHead());

          for (var i = 0; i < result.length; i++) {
            console.log(price[i][0]);
            tbody.appendChild(getArticle(result[i], price[i][0], price[i][1], price[i][2] ));
          }
          articleList.appendChild(pageElement);
        });
    });
}
     
const articleList = document.getElementById('article-list');

let page = 0;

var allPage = document.querySelector(".count");

addPage(page);
    
function nextPage() {
  if (page < (Math.round(allPage.textContent/10))) {
    articleList.removeChild(document.getElementById('article-page-'+ (page)));
    addPage(++page);
  }
}
    
function prevPage() {
  if (page >= 1) {
    articleList.removeChild(document.getElementById('article-page-' + (page)));
    addPage(--page);
    }
}

function move(img, category) {
  var url = "/detail/" + img;

  if(category == 60000){
    window.location.href = url;
  }
} 
    
    
    