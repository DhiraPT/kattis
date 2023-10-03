pieces = list(map(int, input().split()))
extra = [a - b for a, b in zip([1, 1, 2, 2, 2, 8], pieces)]
print(' '.join(map(str, extra)))