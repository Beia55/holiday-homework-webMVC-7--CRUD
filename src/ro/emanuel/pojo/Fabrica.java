package ro.emanuel.pojo;

public class Fabrica {
	
	private int id;
	private String denumire;
	private String industrie;
	private String adresa;
	
	public Fabrica() {
		super();
	}

	public Fabrica(int id, String denumire, String industrie, String adresa) {
		super();
		this.id = id;
		this.denumire = denumire;
		this.industrie = industrie;
		this.adresa = adresa;
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

	public String getIndustrie() {
		return industrie;
	}

	public void setIndustrie(String industrie) {
		this.industrie = industrie;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
}
