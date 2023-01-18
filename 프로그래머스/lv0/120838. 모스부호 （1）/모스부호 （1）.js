function solution(letter) {
    morse = { 
    '.-':'a','-...':'b','-.-.':'c','-..':'d','.':'e','..-.':'f',
    '--.':'g','....':'h','..':'i','.---':'j','-.-':'k','.-..':'l',
    '--':'m','-.':'n','---':'o','.--.':'p','--.-':'q','.-.':'r',
    '...':'s','-':'t','..-':'u','...-':'v','.--':'w','-..-':'x',
    '-.--':'y','--..':'z'
    }
    let letterarr = letter.split(" ");
    let returnarr = new Array();
    for(let i=0;i<letterarr.length;i++){
        returnarr.push(morse[letterarr[i]]);
    }

    return returnarr.join("");
    
    
}