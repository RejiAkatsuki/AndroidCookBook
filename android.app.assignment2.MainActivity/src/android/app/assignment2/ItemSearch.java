package android.app.assignment2;

public class ItemSearch {
	
	private int image;
	private String name;
	private double rate;
	
	public ItemSearch(int image,String name,double rate){
		this.image=image;
		this.name=name;
		this.rate=rate;
	}
	
	public int getImage(){
		return this.image;
	}
	
	public String getName(){
		return this.name;
	}
	
	public double getRate(){
		return this.rate;
	}

}
