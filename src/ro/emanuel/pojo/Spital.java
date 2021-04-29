package ro.emanuel.pojo;

public class Spital {

	private int id;
	private String nume;
	private String adresa;
	private String telefon;
	private String email;

	public Spital() {
		super();
	}

	public Spital(int id, String nume, String adresa, String telefon, String email) {
		super();
		this.id = id;
		this.nume = nume;
		this.adresa = adresa;
		this.telefon = telefon;
		this.email = email;
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

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
