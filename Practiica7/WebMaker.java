import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.Serializable;
import java.io.IOException;
import java.util.Scanner;

/**
* WebMaker.java
*
* Esta clase es utilizada durante la realización de la práctica 7 de LP2
*
* @author Ing. Héctor M. Quej Cosgaya
*/
public class WebMaker implements Serializable {

	private String webTitle;
	private String pageHeader;
	private StringBuilder pageBody;
	private String pageFooter;

	public WebMaker() {
		this.webTitle = "Mi p&aacute;gina web";
		this.pageHeader = null;
		this.pageBody = new StringBuilder();
		this.pageFooter = null;
	}

	/**
	* Imprime el encabezado de nuestra página web. El encabezado de una página web
	* está compuesto por la declaración DOCTYPE, la apertura del documento html,
	* y la cabeza (head), dentro de la cual escribimos el título de la página. Adicionalmente
	* abrimos la etiqueta del cuerpo (body) para empezar a crear contenido dentro de
	* ella, y escribimos un título sencillo.
	*/
	public String imprimirEncabezado() {
		if(pageHeader == null) {
			StringBuilder sb = new StringBuilder();

			sb.append("<!DOCTYPE html>");
			sb.append("<html>");
			sb.append("<head>");
			sb.append("<title>");
			sb.append(webTitle);
			sb.append("</title>");
			sb.append("</head>");
			sb.append("<body>");
			sb.append("<h1>");
			sb.append("Est&aacute; es mi p&aacute;gina web!");
			sb.append("</h1>");

			this.pageHeader = sb.toString();
		}

		return this.pageHeader;
	}

	/**
	* Muestra el texto proporcionado como argumento dentro de una
	* etiqueta de párrafo <p> de HTML.
	*
	* @param texto el texto a mostrar
	*/
	public String imprimirTexto(String texto) {
		StringBuilder aux = new StringBuilder();

		aux.append("<p>");
		aux.append(texto);
		aux.append("</p>");

		// Agregamos el texto recién creado a nuestra página
		this.pageBody.append(aux.toString());

		// Regresamos el párrafo creado
		return aux.toString();
	}

	/**
	* Muestra la imagen con el nombre proporcionado dentro de una etiqueta
	* de imagen <img> de HTML
	*
	* @param imagename el nombre del archivo de la imagen a mostrar
	*/
	public String insertarImagen(String imagename) {
		StringBuilder aux = new StringBuilder();

		aux.append("<img src=\"");
		aux.append(imagename);
		aux.append("\">");

		// Agregamos la imagen recién creada a nuestra página
		this.pageBody.append(aux.toString());

		// Regresamos la imagen creada
		return aux.toString();
	}

	/**
	* Imprime el cierre de nuestra página web. Antes de cerrar el cuerpo (que fue
	* abierto en el encabezado) escribimos un pequeño párrafo de muestra. Finalmente
	* cerramos tanto el cuerpo como el documento HTML.
	*/
	public String imprimirCierre() {
		if (this.pageFooter == null) {
			StringBuilder aux = new StringBuilder();

			aux.append("<footer>");
			aux.append("<p style=\"font-size=8px; font-family:sans-serif;\">");
			aux.append("Made with WebMaker&trade;. &copy; 2013 - 2014 Facultad de Ingenier&iacute;a. Algunos derechos reservados");
			aux.append("</p>");
			aux.append("</body>");
			aux.append("</html>");

			this.pageFooter = aux.toString();
		}

		// Guardamos la web
		this.savePage();

		return this.pageFooter;
	}

	/**
	* Imprime el contenido íntegro de la página web.
	*/ 
	public String printPage() {
		return this.imprimirEncabezado() + this.pageBody.toString() + this.getForm() + this.imprimirCierre();
	}

	/** 
	* Agrega el contenido del formulario a la página web
	*/
	private String getForm() {
		StringBuilder aux = new StringBuilder();

		try {
			Scanner in = new Scanner(new FileInputStream("form.txt"));

			while(in.hasNext())
			aux.append(in.nextLine());

			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return aux.toString();
	}

	/** 
	* Guarda la página web con todo el contenido que fue agregado a ella hasta el momento
	*/
	private void savePage() {
		try {
			// Creamos el flujo de salida al archivo+
			FileOutputStream outputStream = new FileOutputStream("web.obj");
			ObjectOutputStream out = new ObjectOutputStream(outputStream);

			// Guardamos la página web
			out.writeObject(this);

			// Cerramos los flujos
			out.close();
			outputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}