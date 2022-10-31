import java.util.StringTokenizer;

public class Multiplication extends Complex implements Operation {
	private Complex num1;
	private Complex num2;
	
	public Multiplication(Complex num1, Complex num2) {
		super(0, 0);
		this.num1 = num1;
		this.num2 = num2;
		
	}
	
	public String opExecute() {
		//Find real part
		Real realValue = new Real((num1.getReal()*num2.getReal())-(num1.getImag()*num2.getImag()));
		//Find imaginary part
		Imaginary imagValue = new Imaginary((num1.getReal()*num2.getImag())+(num1.getImag()*num2.getReal()));
		Complex product = new Complex(realValue.getReal(), imagValue.getImag());
		String result = product.toString();
		return result;
		
	}
	public static void main(String[] args) {
		
	

}
}

