package 数组;

public class _240_二维数组中的查找 {
	public boolean findNumberIn2DArray(int[][] matrix, int target) {
		// 获取二维数组的行数
		int i = matrix.length -1;
		int j = 0;
		while(i >= 0 && j < matrix[0].length) {
			if (matrix[i][j] > target) {
				i--;
			}else if(matrix[i][j] < target) {
				j++;
			}else {
				return true;
			}
		}
		return false;
    }
}
