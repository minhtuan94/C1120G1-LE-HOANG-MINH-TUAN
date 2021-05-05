const rectangle = new Rectangle(5, 5, 10, 20);
console.log(rectangle.toString());
console.log(rectangle.area());
document.body.innerHTML += `Hình chữ nhật: ${rectangle}`;
document.body.innerHTML += `Diện tích: ${rectangle.area}`;
