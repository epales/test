const articlesPerPageSize = 10;
    
function getPageId(n) {
    return 'article-page-' + n;
}
  
function getArticle(art) {
  
  //const articleImage = getArticleImage();
  
  const div0 = document.createElement("td");
  const div1 = document.createElement("div");
  const img = document.createElement("img");
  const p1 = document.createElement("p");
  const b1 = document.createElement("b");
  const div7 = document.createElement("div");
  const span1 = document.createElement("span");
  
  div0.id="itemBox";
  
  img.src = art.icon;
  img.className = "imageClass";
  img.addEventListener('click', () => {
    move(art.code,art.categoriesCode);
  })
  img.style.width = '20px';
  img.style.height = '20px';
  
  div1.className="imageBlock";
  
  p1.textContent = art.name;
  
  b1.textContent=art.currentMinPrice;

  div0.appendChild(div1);
  div1.appendChild(img);
  div1.appendChild(p1);
  div1.appendChild(b1);
  div7.appendChild(span1);
  return div0;
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
        const pageElement = document.createElement('table');
        pageElement.id = getPageId(page);
        pageElement.className = 'table';
        const div10 = document.createElement('tr');
        div10.id = "body";
        pageElement.appendChild(div10);
        for (var i = 0; i < result.length; i++) {
          div10.appendChild(getArticle(result[i]));
        }
        articleList.appendChild(pageElement);
    });
}
     
const articleList = document.getElementById('article-list');

let page = 0;
  
addPage(page);
    
function nextPage() {
  if (page < 2) {
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
    
    
    