import java.util.Scanner;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author VALPAO
 */
public class Controladora {
    public static void main (String args[]){
        
try{
DataOutputStream escritor = new DataOutputStream (new FileOutputStream("hola.bin"));


escritor.writeInt(33465);
escritor.writeChar('a');
escritor.writeChar('z');
escritor.writeShort(10);
escritor.close();
DataInputStream lector = new DataInputStream (new FileInputStream("hola.bin"));
System.out.println(lector.readInt());
System.out.println(lector.readChar());
System.out.println(lector.readChar());
System.out.println(lector.readShort());
escritor.close();
}
catch (FileNotFoundException e){} 
catch (IOException ex) {}
}
}

