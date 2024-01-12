def solution(s):
    split_s = list(map(int,s.split(" ")))
    minnum = min(split_s)
    maxnum = max(split_s)
    
    return ("{} {}".format(minnum,maxnum))
    