t = int(input())
for i in range(t):
    total = 0
    input()
    n = int(input())
    for i in range(n):
        total += int(input())
    if total%n == 0:
        print("YES")
    else:
        print("NO")