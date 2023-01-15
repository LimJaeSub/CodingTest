function solution(my_string,letter){
    let globalLetter = new RegExp(letter,"g")
    return my_string.replace(globalLetter,"");
}