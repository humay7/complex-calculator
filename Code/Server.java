import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;

public class Server {
	public static void main(String[] args) {
    	ServerSocket socketserver;
        Socket socket1 ;
        BufferedReader in;
        PrintWriter out;
        String result = "";
        double r1, r2, im1, im2;
        Complex num1, num2;
        System.out.println("Server's ready!");
        while(true) {
        try {
            socketserver = new ServerSocket(2007);
            socket1 = socketserver.accept();
            in = new BufferedReader (new InputStreamReader (socket1.getInputStream()));
            try {
            String equation = in.readLine();
            equation = equation.replaceAll("\\(", " ");
            equation = equation.replaceAll("\\)", " ");
            equation = equation.trim();
            StringTokenizer st = new StringTokenizer(equation);
            r1 = Double.parseDouble(st.nextToken());
            String operation1 = st.nextToken();
            String check = st.nextToken().replaceAll("[^\\d]", " ").trim();
            if(operation1.equals("-")) {
            	if(check.equals("")){
            		im1 = -1;
            	}
            	else im1 = -Double.parseDouble(check);
            }else {
            	if(check.equals("")){
            		im1 = 1;
            	}
            	else im1 = Double.parseDouble(check);
            }
            
            String operation = st.nextToken();
            r2 = Double.parseDouble(st.nextToken());
            String operation2 = st.nextToken();
            check = st.nextToken().replaceAll("[^\\d]", " ").trim();
            if(operation2.equals("-")) {
            	if(check.equals("")){
            		im2 = -1;
            	}
            	else im2 = -Double.parseDouble(check);
            }else {
            	if(check.equals("")){
            		im2 = 1;
            	}
            	else im2 = Double.parseDouble(check);
            }
            
            num1 = new Complex(r1, im1); //create an object (number 1) of Complex class 
            num2 = new Complex(r2, im2); //create an object (number 2) of Complex class 
            
            //depending on operation different classes are used 
            
            if(operation.equals("+")){
            	Addition eq = new Addition(num1, num2);
            	result = eq.opExecute();
            }if(operation.equals("-")) {
            	Subtraction eq = new Subtraction(num1, num2);
            	result = eq.opExecute();
            }if(operation.equals("*")) {
                Multiplication eq = new Multiplication(num1, num2);
                result = eq.opExecute();
            }if(operation.equals("/")) {
                if(im2!=0) {
                	result = "Not an integer division!";
                }else if(r2==0) {
                	result = "Cannot divide by zero!";
                }else {
                	Division eq = new Division(num1, num2);
                	result = eq.opExecute();
                }
             }
            	
          }catch(NumberFormatException e) {
            	result = "Syntax is incorrect!";
          }catch(RuntimeException d){
            	result = "Syntax is incorrect!";
          }
            	
          out = new PrintWriter(socket1.getOutputStream());
          out.println(result); //result
          out.flush();
          socket1.close();
          socketserver.close();
        }catch (IOException e) {
        	e.printStackTrace();
        }
    }
	}
}

