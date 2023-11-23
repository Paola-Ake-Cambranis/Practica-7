/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.util.Scanner;
import java.io.*;

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