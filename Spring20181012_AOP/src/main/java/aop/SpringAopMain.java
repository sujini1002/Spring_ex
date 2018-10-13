package aop;

import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringAopMain {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:aopConfig.xml");
		RecCalcurator recCalcurator = ctx.getBean("cal1",RecCalcurator.class);
		CalcuratorImp calcuratorImp = ctx.getBean("cal2",CalcuratorImp.class);
		
		long calResult1= recCalcurator.factorial(10);
		System.out.println("recCalcurator 결과 : "+ calResult1);
		System.out.println("======================================");
		
		long calResult2 = calcuratorImp.factorial(10);
		System.out.println("calcuratorImp 결과 : "+ calResult2);
	}

}
