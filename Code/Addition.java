import java.util.StringTokenizer;


public class Addition extends Complex implements Operation {
	private Complex num1;
	private Complex num2;
	
	public Addition(Complex num1, Complex num2) {
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
		//Add real parts
		Real sumReal = Real.addReal(real1, real2);
		//Add imaginary parts
		Imaginary sumImag = Imaginary.addImag(imag1, imag2);
		//Combine sum of real parts and imaginary parts in one complex number
		Complex sum = new Complex(sumReal.getReal(), sumImag.getImag());
		String result = sum.toString();
		return result;
		
	}
	public static void main(String[] args) {
		

      

}
}
