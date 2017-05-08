import java.awt.*;

public class Helix {
    public static void main(String[] args) {
        int n = 10;
        int size = n * 2 + 1;
        int[][] resultArr = new int[size][size];
        PointGeneration pointGeneration = new PointGeneration(n, n);
        for (int i = 1; i < size * size; i++) {
            Point point = pointGeneration.getNextPoint();
            resultArr[point.y][point.x] = i;
        }

        printArr(resultArr);
    }

    private static class PointGeneration {
        private final Point point;
        private int index = 0;
        private int sizeInc = 1;
        private int curInc = 1;

        public PointGeneration(int x, int y) {
            this.point = new Point(x, y);
        }

        public Point getNextPoint() {
            int directionType = index % 4;
            boolean isYAxis = ((directionType % 2) == 0);
            int signInc = (directionType < 2) ? -1 : 1;

            point.y = (isYAxis) ? point.y + signInc : point.y;
            point.x = (!isYAxis) ? point.x + signInc : point.x;

            if (curInc < sizeInc) {
                curInc++;
            } else {
                index++;
                curInc = 1;
                sizeInc = (!isYAxis) ? sizeInc + 1 : sizeInc;
            }

            return point;
        }
    }

    private static void printArr(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
