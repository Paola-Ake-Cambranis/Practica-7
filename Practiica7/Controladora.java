import java.util.Scanner;
import java.io.*;

/**
 *
 * @author nenod
 */
public class Controladora {
public static void main (String args[]){
try{
ObjectInputStream
lector = new ObjectInputStream(new FileInputStream("web.obj"));
PrintWriter escritor = new PrintWriter("main.html");
WebMaker pagina = (WebMaker)(lector.readObject());
escritor.print(pagina.printPage());
lector.close();
escritor.close();
}
catch (FileNotFoundException e){}
catch(IOException e) {}
catch(ClassNotFoundException e){}
}
}