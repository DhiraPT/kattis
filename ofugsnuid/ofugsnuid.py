n = int(input())
numbers = []
for i in range(n):
    x = int(input())
    numbers.append(x)

print(*numbers[::-1], sep='\n')