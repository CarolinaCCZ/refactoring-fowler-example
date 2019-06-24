package ubu.gii.dass.refactoring;
/**
 * Tema Refactorizaciones
 * 
 * Ejemplo de aplicaciÃ³n de refactorizaciones. Actualizado para colecciones
 * genÃ©ricas de java 1.5.
 * 
 * @author M. Fowler y <A HREF="mailto:clopezno@ubu.es">Carlos LÃ³pez</A>
 * @version 1.1
 * @see java.io.File
 * 
 */

public class Movie extends MovieType {
	private String _title;
	private int _priceCode;

	public Movie(String title, int priceCode) {
		_title = title;
		_priceCode = priceCode;
	}

	public int getPriceCode() {
		return _priceCode;
	}

	public void setPriceCode(int arg) {
		_priceCode = arg;
	}

	public String getTitle() {
		return _title;
	}

	@Override
	public int getMovieType() {
		// TODO Apéndice de método generado automáticamente
		return 0;
	}

	@Override
	public void setMovieType(int type) {
		// TODO Apéndice de método generado automáticamente
		
	}
}
