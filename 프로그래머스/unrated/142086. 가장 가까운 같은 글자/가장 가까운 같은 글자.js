function solution(s) {
    let returnarray = new Array();
    for(let i=0;i<s.length;i++){
        if(s.indexOf(s[i])===i){
            // 처음문자
            returnarray.push(-1);
        }
        else{
            // 뒤에문자
            let j=i-1;
            while(true){

                if(s[i]==s[j]){
                    returnarray.push(i-j);
                    break;
                }
                j=j-1;
            }
            
        }
            
    }
    
    return returnarray;
}