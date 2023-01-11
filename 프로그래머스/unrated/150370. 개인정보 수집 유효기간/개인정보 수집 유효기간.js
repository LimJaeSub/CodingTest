function solution(today, terms, privacies) {
    const answer = [];

    //날짜를 date형식으로 받음
    const todayDate = new Date(today);
  
    // term을 객체 형식으로 받아줌 ex) 'A' :6
    const termType = {};
    terms.forEach((item) => {
      const [type, term] = item.split(" ");
      termType[type] = Number(term);
    });
  
    // 개인정보 역시 구조분해할당으로 나눠줌
    privacies.forEach((item, index) => {
      const [date, type] = item.split(" ");
      const privaceDate = new Date(date);
        // 개인정보에 담긴 날짜를 재설정해준다
        // getMonth로 '달'을 가져온 뒤 타입에 맞는 '달'을 더해준다.
      privaceDate.setMonth(privaceDate.getMonth() + termType[type]);
  
      if (privaceDate <= todayDate){
        answer.push(index + 1);
      } 
    }
    );
  
    return answer;
}
