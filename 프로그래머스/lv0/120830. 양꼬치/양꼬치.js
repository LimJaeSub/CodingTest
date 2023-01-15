function solution(n, k) {
    const service = Math.floor(n/10);
    k=k-service;
    
    return (n*12000+k*2000);
}