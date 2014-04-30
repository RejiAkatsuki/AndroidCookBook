package android.app.assignment2;

public class Method {
	private int id;
	private String method;
	
	public Method(int id, String method){
		this.id=id;
		this.method=method;
	}
	
	public int getID(){
		return id;
	}
	
	public void setID(int id){
		this.id=id;
	}
	
	public String getMethod(){
		return method;
	}
	
	public void setMethod(String method){
		this.method=method;
	}

}
