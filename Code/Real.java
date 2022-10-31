

public class Real extends Complex{
	private double valueR;

	public Real(double valueR) {
		super(valueR, 0);
		this.valueR = valueR;
		
	}
	//Getter
	public double getReal() {
		return valueR;
	}
	//Setter
	public void setReal(double valueR) {
		this.valueR = valueR;
	}
	//Add two real numbers
	public static Real addReal(Real num1, Real num2) {
		double sum = num1.valueR+num2.valueR;
		//Real result = new Real(sum);
		return new Real(sum);
	}
	//Subtract two real numbers
	public static Real subReal(Real num1, Real num2) {
		double diff = num1.valueR-num2.valueR;
		//Real result = new Real(sum);
		return new Real(diff);
	}
	public static void main(String[] args) {
		
	}

}

