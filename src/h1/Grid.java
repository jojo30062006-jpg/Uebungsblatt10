package h1;

public class Grid {
	
	private Cell [][] gridArray;

	//getter
	public Cell [][] getGridArray () {
		return gridArray;
	}
	
	//setter
	public void setGridArray (Cell [][] neugridArray) {
		this.gridArray = neugridArray;
	}
	
	//Konstruktor
	public Grid(Cell [] cells, int gridRows, int gridCols) {
		
		gridArray = new Cell [gridRows][gridCols];
		
		for (int i = 0; i < gridRows; i++) {
			for (int j = 0; j < gridCols; j++) {
				gridArray [i][j] = new Cell (i,j,false);
			}
		}
		for (int s = 0; s < cells.length; s++) {
			int r = cells[s].getIndexRow();
			int c = cells[s].getIndexCol();
			if(r >= 0 && r < gridRows && c >= 0 && c < gridCols) {
				gridArray[r][c].setAlive(true);
			}	
		}
		for (int i = 0; i < gridRows; i++) {
			for (int j = 0; j < gridCols; j++) {
				 gridArray[i][j].countLivingNeighbors(gridArray);
			}
		}
	}
	
	//Methoden 
	public void computeNextGen() {
		for (int i = 0; i < gridArray.length; i++) {
			for (int j = 0; j < gridArray[0].length; j++) {
				 gridArray[i][j].countLivingNeighbors(gridArray);
			}
		}
		
		for (int i = 0; i < gridArray.length; i++) {
			for (int j = 0; j < gridArray[0].length; j++) {
				gridArray[i][j].setAlive(gridArray[i][j].getIsAliveNextGen());
				}
			}
	}
	public void computeGeneration (int n) {
		for ( int i = 0; i < n; i++) {
			computeNextGen();
		}
	}
}
 