count = 1
while True:
    try:
        line1 = list(map(int, input().split()))
        line2 = list(map(int, input().split()))
        det = line1[0] * line2[1] - line1[1] * line2[0]
        mat1 = line2[1]//det
        mat2 = -line1[1]//det
        mat3 = -line2[0]//det
        mat4 = line1[0]//det
        print("Case "+ str(count) + ":")
        print(mat1, mat2)
        print(mat3, mat4)
        count += 1
        input()
    except EOFError:
        break