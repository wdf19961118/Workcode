package offercode;

import java.util.List;
import java.util.ArrayList;;

public class spiralOrder {
	public static List<Integer> spiral(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int height = matrix.length, width = height == 0 ? 0 : matrix[0].length;
        int size = height * width;

        int[] dirX = {0, 1, 0, -1};
        int[] dirY = {1, 0, -1, 0};

        // 初始化起点坐标:(0,-1) 方向:向右;
        int x = 0, y = -1, dir = 0;
        for (int step, total = 0; total < size; total += step) {


            // 根据方向得到对应的位移, 并修正此后矩阵的参数(此后线段的长度)
            if (dir == 0 || dir == 2) {
                step = width;       
                height--;           
            } else {
                step = height;      
                width--;            
            }
            // 此前确定了起点坐标、方向和位移, 就可以得到当前线段的所有坐标,并输出到结果集;
            for (int i = step; i > 0; i--) {
                x += dirX[dir];
                y += dirY[dir];
                result.add(matrix[x][y]);
            }
            // 调整下一条线段方向
            dir = ++dir % 4;
        }

        return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int matrix[][] = new int[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		List<Integer> result = spiral(matrix);
		for(Integer i:result) {
			System.out.println(i);
		}
	}

}
