import java.util.Scanner;
import java.io.*;
/**
 *
 * @author VALPAO
 */
public class Controladora {
    public static void main (String [] args){
        try{
            WebMaker generador = new WebMaker();
            PrintWriter escritor = new PrintWriter("index.html");
            Scanner lector = new Scanner(new FileReader("form.txt"));
            escritor.println(generador.imprimirEncabezado());
            escritor.println(generador.imprimirTexto("Nana!"));
            escritor.println(generador.insertarImagen("Hachi.jpg"));
            
            while(lector.hasNext()) {
                escritor.println(lector.nextLine());
            }
            escritor.println(generador.imprimirCierre());
            lector.close();
            escritor.close();
        }
        catch (FileNotFoundException e){
        }
    }
}
