word = input()
result = word[0]
for i in range(1,len(word)):
    if word[i] == "-":
        result += word[i+1]
        
print(result)