n = int(input())
result = 0
for i in range(n):
    pi = input()
    result += int(pi[:-1]) ** int(pi[-1])
    
print(result)