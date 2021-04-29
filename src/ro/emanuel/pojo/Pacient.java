package ro.emanuel.pojo;

public class Pacient {

	private int id;
	private String nume;
	private String adresa;
	private int varsta;
	private String diagnostic;

	public Pacient() {
		super();
	}

	public Pacient(int id, String nume, String adresa, int varsta, String diagnostic) {
		super();
		this.id = id;
		this.nume = nume;
		this.adresa = adresa;
		this.varsta = varsta;
		this.diagnostic = diagnostic;
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

	public int getVarsta() {
		return varsta;
	}

	public void setVarsta(int varsta) {
		this.varsta = varsta;
	}

	public String getDiagnostic() {
		return diagnostic;
	}

	public void setDiagnostic(String diagnostic) {
		this.diagnostic = diagnostic;
	}
}
