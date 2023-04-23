function solution(clothes) {
    const obj={};
    for(let i=0;i<clothes.length;i++){
        if(Object.keys(obj).includes(clothes[i][1])===false){
            // 객체에 해당 키가 없을 경우
            obj[clothes[i][1]] = [clothes[i][0]];
        }
        else{
            // 객체에 해당 키가 있을 경우
            obj[clothes[i][1]].push(clothes[i][0]);
        }
    }

    if(Object.keys(obj).length===1){
        // 한 종류만 있을 경우
        return Object.values(obj)[0].length;
    }
    else{
        let result = 1;
        for(let i=0;i<Object.values(obj).length;i++){
            result = result*(Object.values(obj)[i].length+1);
        }
        return result-1;
    }
}