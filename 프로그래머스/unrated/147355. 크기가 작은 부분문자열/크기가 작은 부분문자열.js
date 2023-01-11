function solution(t, p) {
    const plength = p.length; // p의길이
    p = Number(p); // p의 값
    let arr = new Array();
    for(let i=0;i<=t.length-plength;i++){
        let input = t.slice(i,plength+i);
        arr.push(input);
    }
    //console.log(arr);
    return arr.filter((it)=>it<=p).length;

}