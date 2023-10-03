dominant = {'A': 11, 'K': 4, 'Q': 3, 'J': 20, 'T': 10, '9': 14, '8': 0, '7': 0}
not_dominant = {'A': 11, 'K': 4, 'Q': 3, 'J': 2, 'T': 10, '9': 0, '8': 0, '7': 0}

n, b = input().split()
total = 0
for i in range(4 * int(n)):
    card = input()
    if card[1] == b:
        total += dominant[card[0]]
    else:
        total += not_dominant[card[0]]

print(total)