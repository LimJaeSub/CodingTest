
function solution(dot) {
    switch(true){
        case (dot[0]>0 && dot[1]>0):
            return 1;
        case (dot[0]<0 && dot[1]>0):
            return 2;
        case (dot[0]<0 && dot[1]<0):
            return 3;
        case (dot[0]>0 && dot[1]<0):
            return 4;
        default:
            break;
    }
}