const fs = require('fs');
const input = fs.readFileSync("dev/stdin").toString().trim();

let arr = input.split(" ");

console.log(arr==""?0:arr.length);