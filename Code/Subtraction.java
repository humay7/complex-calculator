import java.util.StringTokenizer;


public class Subtraction extends Complex implements Operation {
	private Complex num1;
	private Complex num2;
	
	public Subtraction(Complex num1, Complex num2) {
		super(0, 0);
		this.num1 = num1;
		this.num2 = num2;
		
	}
	
	public String opExecute() {
		//Find real parts of complex numbers
		Real real1 =  new Real(num1.getReal());
		Real real2 = new Real(num2.getReal());
		//Find imaginary parts of complex numbers
		Imaginary imag1 = new Imaginary(num1.getImag());
		Imaginary imag2 = new Imaginary(num2.getImag());
		//Subtract real parts
		Real diffReal = Real.subReal(real1, real2);
		//Subtract imaginary parts
		Imaginary diffImag = Imaginary.subImag(imag1, imag2);
		//Combine real part and imaginary part in one complex number
		Complex diff = new Complex(diffReal.getReal(), diffImag.getImag());
		String result = diff.toString();
		return result;
		
	}
	public static void main(String[] args) {
		
	}
		
}

