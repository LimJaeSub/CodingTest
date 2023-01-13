function solution(num_list) {
    let newarr = new Array();
    for(let i=num_list.length-1;i>=0;i--){
        newarr.push(num_list[i]);
    }
    return newarr;
}