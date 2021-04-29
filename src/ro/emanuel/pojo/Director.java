package ro.emanuel.pojo;

public class Director {

	private int id;
	private String nume;
	private int varsta;
	private String telefon;
	private double salar;
	
	public Director() {
		super();
	}

	public Director(int id, String nume, int varsta, String telefon, double salar) {
		super();
		this.id = id;
		this.nume = nume;
		this.telefon = telefon;
		this.varsta = varsta;
		this.salar = salar;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public int getVarsta() {
		return varsta;
	}

	public void setVarsta(int varsta) {
		this.varsta = varsta;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public double getSalar() {
		return salar;
	}

	public void setSalar(double salar) {
		this.salar = salar;
	}
}
