package sec05.exam01;

public class CircleEx2 {

	public static void main(String[] ars) {
		Circle[] c;
		c= new Circle[5];
		
		for (int i =0; i<c.length; i++) {
			c[i] = new Circle(i);
		}
		
		for(int i = 0; i<c.length; i++) {
			System.out.println(c[i].getArea());
		}
	}
	
}
