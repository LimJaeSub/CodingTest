const fs = require('fs');
const input = fs.readFileSync("dev/stdin").toString().trim().split('\n');

const numcount = input[0];
input.shift();
const numarr = input.map(Number);
numarr.sort(function(a, b)  {
    return a - b;
  });

console.log(numarr.join("\n"));