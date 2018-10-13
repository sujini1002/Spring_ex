package aop;

public class AopMain {

	public static void main(String[] args) {
		
		RecCalcurator recCalcurator = new RecCalcurator();
		CalcuratorImp calcuratorImp = new CalcuratorImp();
		
		//플럭시를 통한 실행처리
		System.out.println("플록시를 이용한 처리");
		System.out.println("=============================");
		System.out.println("1. recCalcurator factorial(100) 결과 : "+ new ExeTimeCalcurator(recCalcurator).factorial(100));
		System.out.println("2. calcuratorImp factorial(100) 결과 : "+ new ExeTimeCalcurator(calcuratorImp).factorial(100));
		/*long resultTime1 = new RecCalcurator().factorial(100);
		System.out.println("factorial(100) 결과 : "+ resultTime1);
		System.out.println("============================================================");
		long resultTime2 = new CalcuratorImp().factorial(100);
		System.out.println("factorial(100) 결과 : "+ resultTime2);*/
		
	}

}
