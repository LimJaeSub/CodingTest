function solution(my_string) {
    return Array.from(my_string).map((it)=>{
        if(it.charCodeAt()>=97){
            return it.toUpperCase();
        }
        else{
            return it.toLowerCase();
        }
    }).join("");
}