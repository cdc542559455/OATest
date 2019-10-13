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
