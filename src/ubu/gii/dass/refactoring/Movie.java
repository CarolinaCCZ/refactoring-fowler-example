package ubu.gii.dass.refactoring;
/**
 * Tema Refactorizaciones
 * 
 * Ejemplo de aplicación de refactorizaciones. Actualizado para colecciones
 * genéricas de java 1.5.
 * 
 * @author M. Fowler y <A HREF="mailto:clopezno@ubu.es">Carlos López</A>
 * @version 1.1
 * @see java.io.File
 * 
 */

public class Movie extends MovieType {
	private String _title;
	private int _priceCode;
	private MovieType _movieType;

	public Movie(String title, int priceCode) {
		_title = title;
		_priceCode = priceCode;
	}

	public int getPriceCode() {
		return _priceCode;
	}

	public void setPriceCode(int arg) {
		_priceCode = arg;
		switch (arg) {
		case MovieType.CHILDRENS:
			_movieType = new Children();
			break;
		case MovieType.NEW_RELEASE:
			_movieType = new NewRelease();
			break;
		case MovieType.REGULAR:
			_movieType = new Regular();
			break;
		default:
			_movieType = null;
		}
	}

	public String getTitle() {
		return _title;
	}

	@Override
	public int getTypeCode() {
		return this._movieType.getTypeCode();
	}

	public int getFrequentRentalPoints(Rental rental) {
		int frequentRenterPoints = 0;
		frequentRenterPoints ++;
		// add bonus for a two day new release rental
		if ((rental.getMovie().getPriceCode() == MovieType.NEW_RELEASE)
				&& rental.getDaysRented() > 1)
			frequentRenterPoints++;
		return frequentRenterPoints;
	}

	public double getCharge(Rental rental) {
		double result = 0;
		switch (rental.getMovie().getPriceCode()) {
		case MovieType.REGULAR:
			result += 2;
			if (rental.getDaysRented() > 2)
				result += (rental.getDaysRented() - 2) * 1.5;
			break;
		case MovieType.NEW_RELEASE:
			result += rental.getDaysRented() * 3;
			break;
		case MovieType.CHILDRENS:
			result += 1.5;
			if (rental.getDaysRented() > 3)
				result += (rental.getDaysRented() - 3) * 1.5;
			break;
		}
		return result;
	}
}
