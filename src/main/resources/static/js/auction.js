function calculation() {
    const price  = document.querySelector("#auctionPrice");
    const divide = document.querySelector('input[name="calc"]:checked');
    const calcPrice = document.querySelector(".calcPrice");
    const distributionPrice = document.querySelector(".distributionPrice");
    const charge = document.querySelector(".charge");
    const profit = document.querySelector(".profit");
    const equalDistributionPrice = document.querySelector(".equalDistributionPrice");
    const equalCharge = document.querySelector(".equalCharge");
    const realProfit = document.querySelector(".realProfit");
    const realDistributionPrice = document.querySelector(".realDistributionPrice");
    const realCharge = document.querySelector(".realCharge");

    calcPrice.textContent = Math.ceil(price.value - (price.value / divide.value));
    distributionPrice.textContent = Math.floor(price.value / divide.value);
    if (price.value != 1) {
        charge.textContent = Math.ceil(price.value * 0.05);
    } else {
        charge.textContent = 0;
    }                       
    profit.textContent = Math.ceil((price.value - charge.textContent) - ((price.value - charge.textContent) / divide.value));
    equalDistributionPrice.textContent = Math.floor(profit.textContent / (divide.value - 1));

    if (price.value != 1) {
        equalCharge.textContent = Math.ceil(profit.textContent * 0.05);
    } else {
        equalCharge.textContent = 0;
    }  

    realProfit.textContent = Math.ceil(profit.textContent * 10 / 11);
    realDistributionPrice.textContent = Math.floor(realProfit.textContent / (divide.value - 1));

    if (price.value != 1) {
        realCharge.textContent = Math.ceil(realProfit.textContent * 0.05);
    } else {
        realCharge.textContent = 0;
    }  
}