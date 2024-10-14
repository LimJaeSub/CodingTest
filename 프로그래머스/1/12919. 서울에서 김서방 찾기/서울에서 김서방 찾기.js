function solution(seoul) {
	const kimnum = seoul.findIndex(it=>{
  	return it=="Kim";
  });
  return `김서방은 ${kimnum}에 있다`
}
