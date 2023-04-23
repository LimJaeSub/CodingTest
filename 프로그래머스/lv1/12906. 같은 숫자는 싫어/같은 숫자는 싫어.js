function solution(arr)
{
    return arr.filter((it,idx)=>{
        return arr[idx]!==arr[idx+1];
    })
}