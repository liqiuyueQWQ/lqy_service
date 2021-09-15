package com.liqiuyue.array;

/**
 * @ClassName: MatrixReshape
 * @Description: 重塑矩阵
 * @Author: liqiuyue
 * @Date: 2021-03-30
 */
public class MatrixReshape {

    /**
     * 思路与算法

    对于一个行数为 mm，列数为 nn，行列下标都从 00 开始编号的二维数组，我们可以通过下面的方式，将其中的每个元素 (i, j)(i,j) 映射到整数域内，并且它们按照行优先的顺序一一对应着 [0, mn)[0,mn) 中的每一个整数。形象化地来说，我们把这个二维数组「排扁」成了一个一维数组。如果读者对机器学习有一定了解，可以知道这就是 \texttt{flatten}flatten 操作。

    这样的映射即为：

            (i,j)→i×n+j

    同样地，我们可以将整数 xx 映射回其在矩阵中的下标，即
        i = x/n
        j = x%n


        其中 // 表示整数除法，% 表示取模运算。

        那么题目需要我们做的事情相当于：

        将二维数组nums 映射成一个一维数组；

        将这个一维数组映射回 r 行 c 列的二维数组。

        我们当然可以直接使用一个一维数组进行过渡，但我们也可以直接从二维数组 nums 得到 r 行 c 列的重塑矩阵：

        设 nums 本身为 m 行 v 列，如果 mn != rc 那么二者包含的元素个数不相同，因此无法进行重塑；

        否则，对于 x∈[0,mn)，第 x 个元素在 nums 中对应的下标为 (x / n,x % n)，而在新的重塑矩阵中对应的下标为(x / c,x % c)。我们直接进行赋值即可。
*/


    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int row = nums.length, col = nums[0].length;
        if (col * row != r * c) {
            return new int[][]{};
        }
        int[][] matrixNums = new int[r][c];
        int n = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                matrixNums[i][j] = nums[n / col][n * col];
                n++;
            }
        }
        return matrixNums;
    }

    /**
     * 单循环
     */
    public int[][] singleFor(int[][] nums, int r, int c) {
        int row = nums.length, col = nums[0].length;
        if (col * row != r * c) {
            return new int[][]{};
        }
        int[][] matrixNums = new int[r][c];
        int n = 0;
        for (int i = 0; i < r * c; i++) {
            matrixNums[n / col][n * col] = nums[n / col][n * col];
            n++;
        }
        return matrixNums;
    }
}
