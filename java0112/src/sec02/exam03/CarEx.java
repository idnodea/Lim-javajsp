package sec02.exam03;


public class CarEx {
	
	public static void main(String[] args) {
		Car myCar = new Car();
		
		myCar.setGas(5);;  //car의 setGas()메소드 호출
		
		boolean gasState = myCar.isLeftGas();  //Car의 isLeftGas()메소드호출
		if(gasState) {
			System.out.println("출발합니다");
			myCar.run();   //Car의 run()메소드호출
		}
		
		if(myCar.isLeftGas()) { //Car의 isLeftGas()메소드호출
			System.out.println("가스를 주입할 필요가 없습니다");
			
		}else {
			System.out.println("gas를 주입하세요");
		}
		
	}
	
}
