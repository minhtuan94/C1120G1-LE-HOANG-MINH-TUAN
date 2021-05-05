let sum: number = 0;
let count: number = 0;
//cho i chạy từ 2 đến 30
for (let i = 2; count < 30; i++) {
    let isPrime: boolean = true;
    //nếu i = 2 thì sum+2 và count +1
    if (i == 2) {
        sum += i;
        count++;
        continue;
    }
    for (let j = 2; j <= Math.sqrt(i); j++) {
        if (i % j == 0) {
            isPrime = false;
            break;
        }
    }
    if(!isPrime){
        continue;
    }
    sum += i;
    count++;
}
console.log(sum);
document.body.innerHTML = `Tổng 30 số nguyên tố đầu tiên là: ${sum}`