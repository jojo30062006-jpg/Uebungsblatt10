package h2;

public class Spielstein {
	
	//Attribute 
	private int currentRow;
	private int currentCol;
	private Spielbrett brett;
	
	//Getter/Setter 
	public int getCurrentRow() {
		return currentRow;
	}
	public void setCurrentRow(int currentRow) {
		this.currentRow = currentRow;
	}
	public int getCurrentCol() {
		return currentCol;
	}
	public void setCurrentCol(int currentCol) {
		this.currentCol = currentCol;
	}
	public Spielbrett getBrett() {
		return brett;
	}
	public void setBrett(Spielbrett brett) {
		this.brett = brett;
	}
	
	//Konstruktor
	public Spielstein(Spielbrett brett, int indexRow, int indexCol) {
		this.currentRow = indexRow;
		this.currentCol = indexCol;
		this.brett = brett;
	}
	
	//Methoden 

	private boolean movesOut() {
        char aktRichtung = brett.getBrett()[currentRow][currentCol].getDirection();
        int dim = brett.getDim();

        if (aktRichtung == 'U' && currentRow == 0) {
        	return true;
        }
        if (aktRichtung == 'D' && currentRow == dim - 1) {
        	return true;
        }
        if (aktRichtung == 'L' && currentCol == 0) {
        	return true;
        }
        if (aktRichtung == 'R' && currentCol == dim - 1) {
        	return true;
        }
        
        return false;
    }
	
	public void go(int n) {
        for (int i = 0; i < n; i++) {
            Feld aktuellesFeld = brett.getBrett()[currentRow][currentCol];

            if (!aktuellesFeld.isBoese() && !movesOut()) {
                switch (aktuellesFeld.getDirection()) {
                    case 'U':
                        currentRow--;
                        break;
                    case 'D':
                        currentRow++;
                        break;
                    case 'L':
                        currentCol--;
                        break;
                    case 'R':
                        currentCol++;
                        break;
                }
            }
        }
	}
	
}
