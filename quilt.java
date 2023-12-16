public class Quilt {
    public static void main(String[] args) {
        Manager cQuilt = new Manager(args);
        int cHeight = cQuilt.getHeight();
        int cWidth = cQuilt.getWidth();
        int[] colorArray = cQuilt.getColorCount();
        int diffColor = colorArray.length;
        int i;
        int j;
        for (i = 0; i < diffColor; i++) {
            System.out.println("I: " + i + " Anzahl der Farben: " + colorArray[i]);
        }
        int x = 5;
        int y = 10;
        int[][] tebbich = new int[x][y];
        Quilt.initRandom(tebbich, colorArray);
        for (i = 0; i < diffColor; i++) {
            System.out.println("I: " + i + " Anzahl der Farben: " + colorArray[i]);
        }
        boolean testQuilt = cQuilt.testRandomQuilt(tebbich);
    }

    public static int randomColor(int[] cArray) {
        int min = 0;
        int max = 8;
        int random;
        do {
            random = (int) (Math.random() * (max - min + 1));

        } while (cArray[random] == 0);
        return random;

    }

    public static void initRandom(int[][] square, int[] cArray) {
        int i, j;
        for (i = 0; i < square.length; i++) {
            for (j = 0; j < square[0].length; j++) {
                int intRandom = Quilt.randomColor(cArray);
                int arrayValue = cArray[intRandom];
                System.out.println("Farbe: " + intRandom);
                System.out.println("Anzahl Farbplaettchen: " + arrayValue);
                square[i][j] = intRandom;
                Quilt.fixPatch(square, cArray, i, j);
            }
        }
    }

    public static boolean fixPatch(int[][] square, int[] cArray, int Zeile, int Spalte) {
        int istFarbe = square[Zeile][Spalte];
        int[] neighbors = cQuilt.getNeighbors(square, Zeile, Spalte);
        int i = 0;
        while (i < neighbors.length) {
            if (neighbors[i] != istFarbe) {
                i++;
            } else {
                istFarbe = Quilt.randomColor(cArray);
                i = 0;
            }
        }
        if (square[Zeile][Spalte] == istFarbe) {
            cArray[istFarbe] = cArray[istFarbe] - 1;
            return true;
        } else {
            square[Zeile][Spalte] = istFarbe;
            cArray[istFarbe] = cArray[istFarbe] - 1;
            return false;
        }
    }
}
