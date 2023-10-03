c = float(input())
l = int(input())
area = 0
for i in range(l):
    w = list(map(float, input().split()))
    area += w[0] * w[1]
total = c * area

print(total)