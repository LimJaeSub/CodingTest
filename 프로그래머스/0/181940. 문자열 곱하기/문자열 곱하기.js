function solution(my_string, k) {
    let original = my_string;
    for(let i=1;i<k;i++){
        my_string = my_string+original;
    }
    
    return my_string;
}