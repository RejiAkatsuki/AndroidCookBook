package android.app.assignment2;

public class Ingredients {
	private int id;
	private String ingre;

	public Ingredients(int id, String ingre) {
		this.id = id;
		this.ingre = ingre;
	}

	public int getID() {
		return id;
	}

	public void setID(int id) {
		this.id = id;
	}

	public String getIngre() {
		return ingre;
	}

	public void setIngre(String ingre) {
		this.ingre = ingre;
	}

}
