package ro.emanuel.pojo;

public class Medic {

	private int id;
	private String nume;
	private String specialitate;
	private int vechime;
	private double salar;
	
	public Medic() {
		super();
	}

	public Medic(int id, String nume, String specialitate, int vechime, double salar) {
		super();
		this.id = id;
		this.nume = nume;
		this.specialitate = specialitate;
		this.vechime = vechime;
		this.salar= salar ;
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

	public String getSpecialitate() {
		return specialitate;
	}

	public void setSpecialitate(String specialitate) {
		this.specialitate = specialitate;
	}

	public int getVechime() {
		return vechime;
	}

	public void setVechime(int vechime) {
		this.vechime = vechime;
	}

	public double getSalar() {
		return salar;
	}

	public void setSalar(double salar) {
		this.salar = salar;
	}
}
