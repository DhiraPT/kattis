x = int(input())
n = int(input())
result = 0
for i in range(n):
    result += int(input())
    
print((n+1) * x - result)