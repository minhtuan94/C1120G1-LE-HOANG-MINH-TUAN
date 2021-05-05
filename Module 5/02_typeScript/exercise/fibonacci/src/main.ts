function fibo(n:number) {
   
    let a:number = 1,b:number = 1,c:number;
    let sum:number = 0;
    let count:number = 2;
    // sum += a + b;

    while (count <= n){
        c = a + b;
        a = b;
        b = c;

        sum += c;
        count++;
    }
    console.log("Sum of "+n+" First Fibonacci is "+sum);
}

fibo(2);