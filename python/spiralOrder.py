def spiralOrder(matrix):
    result = []
    height = len(matrix)
    if height == 0:
        width = 0
    else:
        width = len(matrix[0])
    size = height*width
    #顺时针方向x和y的变化
    dirX = [0,1,0,-1]
    dirY = [1,0,-1,0]

    #初始化起点坐标:(0,-1) 方向：向右
    x, y, dir = 0, -1, 0
    total = 0
    while total < size:
        if dir == 0 or dir ==2:
            #step是每次转折后要走几步
            step = width
            #当开始走一行时，矩阵的高要减一
            height -= 1
        else:
            step = height
            # 当开始走一列时，矩阵的宽要减一
            width -=1

        for i in range(step,0,-1):
            x += dirX[dir]
            y += dirY[dir]
            result.append(matrix[x][y])
        #取余，当dir>=4时，即已经至少转一圈了，保持right down left up
        dir = (dir+1)%4
        #每遍历完一行或一列加上遍历的元素个数
        total += step

    for i in range(len(result)):
        print(result[i])

if __name__ == "__main__":
    matrix = [[1,2,3],[4,5,6],[7,8,9],[10,11,12]]
    spiralOrder(matrix)




