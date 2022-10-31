

public class Imaginary extends Complex{
	private double valueIm;

	public Imaginary(double valueIm) {
		super(0, valueIm);
		this.valueIm = valueIm;
		
	}
	//Getter
	public double getImag() {
		return valueIm;
	}
	//Setter
	public void setImag(double valueIm) {
		this.valueIm = valueIm;
	}
	//Add two imaginary numbers
	public static Imaginary addImag(Imaginary num1, Imaginary num2) {
		double sum = num1.valueIm+num2.valueIm;
		//Real result = new Real(sum);
		return new Imaginary(sum);
	}
	//Subtract two imaginary numbers
	public static Imaginary subImag(Imaginary num1, Imaginary num2) {
		double diff = num1.valueIm-num2.valueIm;
		//Real result = new Real(sum);
		return new Imaginary(diff);
	}
	public static void main(String[] args) {
	
	}

}

