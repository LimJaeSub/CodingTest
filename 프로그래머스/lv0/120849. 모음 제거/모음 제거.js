function solution(my_string) {
    return my_string.split("").filter((it)=>!["a","e","i","o","u"].includes(it)).join("");
}