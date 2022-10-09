package upskill.ocm.dtos;

public class Demo {

	private Object data;
	private Object data1;
	public Demo(Object data, Object data1) {
		super();
		this.data = data;
		this.data1 = data1;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public Object getData1() {
		return data1;
	}
	public void setData1(Object data1) {
		this.data1 = data1;
	}
	@Override
	public String toString() {
		return String.format("Demo [data=%s, data1=%s]", data, data1);
	}
	
	
	
	
}
