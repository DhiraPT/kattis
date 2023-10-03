n = int(input())
for i in range(n):
    letters = ""
    k, w = list(map(int, input().split()))
    for j in range(w):
        word = input()
        if letters == "":
            letters += word
        elif word != prev_word:
            for indx in range(k,0,-1):
                if word[:indx-1] == prev_word[k-indx+1:]:
                    letters += word[indx-1:]
                    break
        prev_word = word
    print(len(letters))