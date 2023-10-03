n = int(input())
while n != -1:
    total = 0
    t2 = 0
    for i in range(n):
        s, t = list(map(int, input().split()))
        total += s*(t-t2)
        t2 = t
    print(total, "miles")
    n = int(input())