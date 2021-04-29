package ro.emanuel.pojo;

public class Produs {
	
	private int id;
	private String denumire;
	private double pret;
	private double cantitate;
	private String culoare;
	
	public Produs() {
		super();
	}

	public Produs(int id, String denumire, double pret, double cantitate, String culoare) {
		super();
		this.id = id;
		this.denumire = denumire;
		this.pret = pret;
		this.cantitate = cantitate;
		this.culoare = culoare;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDenumire() {
		return denumire;
	}

	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}

	public double getPret() {
		return pret;
	}

	public void setPret(double pret) {
		this.pret = pret;
	}

	public double getCantitate() {
		return cantitate;
	}

	public void setCantitate(double cantitate) {
		this.cantitate = cantitate;
	}

	public String getCuloare() {
		return culoare;
	}

	public void setCuloare(String culoare) {
		this.culoare = culoare;
	}
}
