function solution(id_list, report, k) {
  const answer = new Array(id_list.length);
  answer.fill(0);
  const report_list = {};

  id_list.map((user) => {
    report_list[user] = []; //key로 userid를 value로 빈 배열을 가지는 객체
  });
  //console.log(id_list);

  report.map((user) => {
    const [user_id, report_id] = user.split(" "); // [신고자 , 신고받는사람]
    //console.log(user);
    if (!report_list[report_id].includes(user_id)) {
      // 신고명단의 신고받는사람을 key로 가지는 배열에 신고자가 없을 경우
      report_list[report_id].push(user_id); // 신고자 추가
    }
  });

  for (const key in report_list) {
    if (report_list[key].length >= k) {
      // 신고자의 수가 기준을 넘어서면
      //이용정지 유저
      report_list[key].map((user) => {
        // 신고자를 모아둔 배열을 map
        answer[id_list.indexOf(user)] += 1; // 해당 배열과 같은 값을 가진 index의 값을 1 증가시킴
      });
    }
  }
  return answer;
}