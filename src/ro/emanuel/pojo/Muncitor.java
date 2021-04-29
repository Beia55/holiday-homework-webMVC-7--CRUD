package ro.emanuel.pojo;

public class Muncitor {
  	
	private int id;
	private String nume;
	private int varsta;
	private int vechime;
	private int grupaMunca;
	
	public Muncitor() {
		super();
	}

	public Muncitor(int id, String nume, int varsta, int vechime, int grupaMunca) {
		super();
		this.id = id;
		this.nume = nume;
		this.varsta = varsta;
		this.vechime = vechime;
		this.grupaMunca = grupaMunca;
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

	public int getVechime() {
		return vechime;
	}

	public void setVechime(int vechime) {
		this.vechime = vechime;
	}

	public int getGrupaMunca() {
		return grupaMunca;
	}

	public void setGrupaMunca(int grupaMunca) {
		this.grupaMunca = grupaMunca;
	}
}
