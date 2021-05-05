function fibo(n) {
    var a = 1, b = 1, c;
    var sum = 0;
    var count = 2;
    // sum += a + b;
    while (count <= n) {
        c = a + b;
        a = b;
        b = c;
        sum += c;
        count++;
    }
    console.log("Sum of " + n + " First Fibonacci is " + sum);
}
fibo(3);
