function solution(s){
    let [maincount,othercount,count] = [0,0,0];
    s = s.split("");
    let main=null;
    for(let i=0;i<s.length;i++){
        if(main==null){
            main=s[i];
            maincount++;
        }
        else{
            if(maincount==1 && othercount == 0){
                // 새로운 상태일때
                if(main==s[i]){
                    maincount++;
                }
                else{
                    count++;
                    maincount=0;
                    othercount=0;
                    main=null;
                }
            }
            else{
                // 진행중인 상태일때
                if(main==s[i]){
                    maincount++;
                }
                else{
                    othercount++;
                }
                if(maincount==othercount){
                    count++;
                    maincount=0;
                    othercount=0;
                    main=null;
                }
            }

        }
        if(maincount!=othercount && i==s.length-1){
            count++;
        }
        //console.log(maincount,othercount,count); 
    }

    return count;

}