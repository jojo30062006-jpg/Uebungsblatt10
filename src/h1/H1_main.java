package h1;

public class H1_main {

    public static void main(String[] args) {

        // Startmuster: Blinker (horizontal)
        Cell[] startCells = {
            new Cell(1, 0),
            new Cell(1, 1),
            new Cell(1, 2)
        };

        Grid grid = new Grid(startCells, 3, 3);

        System.out.println("Generation 0:");
        printGrid(grid);

        grid.computeNextGen();
        System.out.println("\nGeneration 1:");
        printGrid(grid);

        grid.computeNextGen();
        System.out.println("\nGeneration 2:");
        printGrid(grid);
    }

    // Hilfsmethode zur Ausgabe
    private static void printGrid(Grid grid) {
        Cell[][] arr = grid.getGridArray();

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j].isAlive() ? "1 " : "0 ");
            }
            System.out.println();
        }
    }
}
