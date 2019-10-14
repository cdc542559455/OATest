//9. 查询矩阵
//    给int n, m，想象n*m的矩阵M,  M[i,j] = (i+1)*(j+1)，0-based
//‍‍‌‌‍‍‍‌‌‍‍‌‍‍‍‍‌‍‌一系列query，有三种类型，第一种是查询矩阵中最小的元素，第二、三分别是禁用某一行、列。
//    一个2D array的min number的query
//    题目是说给你一个2d array。其中array[j] = (i+1)*(j+1)。这个给定。
//    然后给一堆query，有三种不同的格式：
//    第一种是让你返回当前array中的最小值
//            第二种是让你把某一行disable
//    第三种是把某一列disa‍‍‌‌‍‍‍‌‌‍‍‌‍‍‍‍‌‍‌ble
//            当然disable了之后最小值就不能用了//9. 查询矩阵
////    给int n, m，想象n*m的矩阵M,  M[i,j] = (i+1)*(j+1)，0-based
////‍‍‌‌‍‍‍‌‌‍‍‌‍‍‍‍‌‍‌一系列query，有三种类型，第一种是查询矩阵中最小的元素，第二、三分别是禁用某一行、列。
////    一个2D array的min number的query
////    题目是说给你一个2d array。其中array[j] = (i+1)*(j+1)。这个给定。
////    然后给一堆query，有三种不同的格式：
////    第一种是让你返回当前array中的最小值
////            第二种是让你把某一行disable
////    第三种是把某一列disa‍‍‌‌‍‍‍‌‌‍‍‌‍‍‍‍‌‍‌ble
////            当然disable了之后最小值就不能用了
public class MatrixQuery_14 {



    public static void main(String[] args) {
        ini(3,3);
        System.out.println(query(0,1,1));
        System.out.println(query(1, 0,0));
        System.out.println(query(0,1,1));
    }
    private static boolean[] disableRow;
    private static boolean[] disableCol;
    private static int preOpRow;
    private static int preOpCol;

    public static void ini(int rows, int cols) {
        disableRow = new boolean[rows];
        disableCol = new boolean[cols];
        preOpRow = 0;
        preOpCol = 0;
    }

    public static int query(int type, int col, int row) {
        if (type == 0) {

            while (disableRow[preOpRow] && preOpRow < disableRow.length) {
                preOpRow ++;
            }

            while (disableCol[preOpCol] && preOpCol < disableCol.length) {
                preOpCol ++;
            }

            if (preOpRow == disableRow.length || preOpCol == disableCol.length) return -1;
            return (preOpCol + 1) * (preOpRow + 1);
        } else if (type == 1) {
            if (row >= 0 && row <disableRow.length ) {
                disableRow[row] = true;
                return 996;
            } else {
                return -1;
            }
        } else if (type == 2) {
            if (col >= 0 && col <disableCol.length ) {
                disableCol[row] = true;
                return 996;
            } else {
                return -1;
            }
        }

        return -1;
    }




}
