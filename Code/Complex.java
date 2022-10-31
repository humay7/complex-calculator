import java.util.StringTokenizer;



public class Complex {
	private double valueReal;
	private double valueImag;
	//Getters
	public double getReal() {
		return valueReal;
	}
	public double getImag() {
		return valueImag;
	}
	//Setters
	public void setReal(double valueReal) {
		this.valueReal = valueReal;
	}
	
	public void setImag(double valueImag) {
		this.valueImag = valueImag;
	}
	public Complex(double valueReal, double valueImag) {
		this.valueReal = valueReal;
		this.valueImag = valueImag;
		
	}
	public String toString() {
		if(this.valueImag>=0) {
			return this.valueReal+" + "+this.valueImag+"i";
		}else {
			return this.valueReal+" - "+(-this.valueImag)+"i";
		}
	}
	public static void main(String[] args) {
		
	}
	
	
}
