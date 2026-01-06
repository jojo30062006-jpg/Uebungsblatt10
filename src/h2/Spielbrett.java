package h2;

public class Spielbrett {
	
	//Objektattribute 
	private Feld [][] brett;
	private int dim;
	
	//Getter/Setter
	public Feld[][] getBrett() {
		return brett;
	}
	public void setBrett(Feld[][] brett) {
		this.brett = brett;
	}
	public int getDim() {
		return dim;
	}
	public void setDim(int dim) {
		this.dim = dim;
	}
	
	//Konstruktor 
	public Spielbrett(int dim) {
		this.dim = dim;
		this.brett = new Feld [dim][dim];
	}	

}
