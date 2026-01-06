package h1;

public class Cell {

	private int indexRow;
	private int indexCol;
	private boolean alive;
	private int numLivingNeighbors;
	private boolean isAliveNextGen;

	// getter/setter indexRow
	public int getIndexRow() {
		return indexRow;
	}

	public void setIndexRow(int indexRow) {
		this.indexRow = indexRow;
	}

	// getter/setter indexCol
	public int getIndexCol() {
		return indexCol;
	}

	public void setIndexCol(int indexCol) {
		this.indexCol = indexCol;
	}

	// getter/setter alive
	public boolean getAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	// getter/setter numLivingNeighbors
	public int getNumLivingNeighbors() {
		return numLivingNeighbors;
	}

	public void setNumLivingNeighbors(int numLivingNeighbors) {
		this.numLivingNeighbors = numLivingNeighbors;
	}

	// getter/setter isAliveNextGen
	public boolean getIsAliveNextGen() {
		return isAliveNextGen;
	}

	public void setIsAliveNextGen(boolean isAliveNextGen) {
		this.isAliveNextGen = isAliveNextGen;
	}

	// konstruktoren
	public Cell(int indexRow, int indexCol, boolean alive) {
		this.indexRow = indexRow;
		this.indexCol = indexCol;
		this.alive = alive;
	}

	public Cell(int indexRow, int indexCol) {
		this.indexRow = indexRow;
		this.indexCol = indexCol;
	}

	// Methoden
	private void decideNextStatus() {
		if (alive == true && (numLivingNeighbors == 2 || numLivingNeighbors == 3)){
			isAliveNextGen = true;
		}
		else if(alive == true && (numLivingNeighbors < 2 || numLivingNeighbors > 3)) {
			isAliveNextGen = false;
		}
		else if(alive == false &&  numLivingNeighbors == 3) {
			isAliveNextGen = true;
		}
		else {
			isAliveNextGen = false;
		}
	}
	public void  countLivingNeighbors (Cell [][] gridArray) {
		int count = 0;
		
		for (int r = indexRow - 1; r <= indexRow + 1; r++) {
			for (int c = indexCol - 1; c <= indexCol + 1; c++) {
				
				if (r == indexRow && c == indexCol) {
					continue;
				}
				if (r >= 0 && r < gridArray.length &&  c >= 0 && c < gridArray[0].length) {
	                    if (gridArray[r][c].getAlive() == true) {
	                        count++;
	                    }
	                }
			}
		}
		this.numLivingNeighbors = count;
		decideNextStatus();
	}
}
