package android.app.assignment2;

public class Recipes {
	private int id;
	private int img;
	private String state;
	private String name;
	private String pre_time;
	private String cook_time;
	private double rate;

	public Recipes(int id, int img, String name, String state,
			String pre_time, String cook_time, double rate) {
		this.id = id;
		this.img = img;
		this.name = name;
		this.state = state;
		this.pre_time = pre_time;
		this.cook_time = cook_time;
		this.rate = rate;
	}

	public int getID() {
		return id;
	}

	public void setID(int id) {
		this.id = id;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getImg() {
		return img;
	}

	public void setImg(int img) {
		this.img = img;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPreTime() {
		return pre_time;
	}

	public void setPreTime(String pre_time) {
		this.pre_time = pre_time;
	}

	public String getCookTime() {
		return cook_time;
	}

	public void setCookTime(String cook_time) {
		this.cook_time = cook_time;
	}

	public Double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

}
