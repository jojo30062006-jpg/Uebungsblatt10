package h1;

public class H1_main {

    public static void main(String[] args) throws InterruptedException {

        // 1️⃣ Startzellen definieren (Beispiel: ein kleines Muster)
    	Cell[] startCells = {
    		    new Cell(1, 2),
    		    new Cell(2, 2),
    		    new Cell(3, 2),
    		    new Cell(3, 3),
    		    new Cell(2, 4)
    		};

        // 2️⃣ Grid erstellen (z. B. 5x5)
        Grid myGrid = new Grid(startCells, 5, 5);

        // 3️⃣ Anzahl Generationen
        int totalGenerations = 10;

        // 4️⃣ Simulation Schritt für Schritt
        for (int g = 1; g <= totalGenerations; g++) {

            // nächste Generation berechnen
            myGrid.computeNextGen();

            // Grid ausgeben
            System.out.println("Generation " + g + ":");
            Cell[][] gridArray = myGrid.getGridArray();
            for (int i = 0; i < gridArray.length; i++) {
                for (int j = 0; j < gridArray[0].length; j++) {
                    System.out.print(gridArray[i][j].getAlive() ? "1 " : "0 ");
                }
                System.out.println();
            }
            System.out.println(); // Leerzeile zwischen Generationen

            // kleine Pause, damit man es sieht (500ms)
            Thread.sleep(1500);
        }
    }
}
