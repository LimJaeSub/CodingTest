function solution(my_string) {
    my_string = my_string.toLowerCase();
    // my_string.sort((a,b)=>{
    //     a.charCodeAt()-b.charCodeAt();
    // })
    return my_string.split("").sort().join("");
}