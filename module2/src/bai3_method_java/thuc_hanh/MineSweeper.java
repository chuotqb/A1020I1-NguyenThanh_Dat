package bai3_method_java.thuc_hanh;

public class MineSweeper {
    public static void main(String[] args) {
        String[][] map = {
                {"*", "."}
        };

        final int MAP_WIDTH = map[0].length;

        for (int xOrdinate = 0; xOrdinate < MAP_WIDTH; xOrdinate++) {
            String curentCell = map[0][xOrdinate];
            if (curentCell.equals("*")) System.out.print("*");
            else System.out.print(1);
        }
    }
}
