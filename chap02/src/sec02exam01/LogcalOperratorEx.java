package sec02exam01;

public class LogcalOperratorEx {

	public static void main(String[] args) { //p123
		int charCode = 'a';  //'A'
		
		if((charCode>=65)& (charCode<=90)){     //앞이 거짓이어도 비교실행
			System.out.println("대문자군요");  
		}
		
		if((charCode>=97)&& (charCode<=122)) {    //앞이 거짓이면 뒤를 평가x
			System.out.println("소문자군요");
		}
		if(!(charCode<48)&&!(charCode>57)) {
			System.out.println("0~9숫자군요");
		}
		int value = 6;
		
		if((value%2 ==0)|| (value%3==0)) {
			System.out.println("3의 배수로군요");
			
		}
		if((value%2==0)||(value%3 ==0) ) {
			System.out.println("2 또는 3의 배수네요");
		}
	}

}
