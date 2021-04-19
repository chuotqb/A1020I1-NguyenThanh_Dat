package bai1_introduction_to_java.bai_tap;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import java.util.Scanner;
public class LoiChao {
    public static void main(String[] args) {
        System.out.println("Enter your name: ");
        Scanner scanner= new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("Hello: "+ name );
    }
}
