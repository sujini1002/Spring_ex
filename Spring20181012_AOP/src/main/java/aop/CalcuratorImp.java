package aop;

public class CalcuratorImp implements Calcurator {

	@Override
	public long factorial(long num) {
		// 시작시간
		//long startTime = System.nanoTime();
		
		long result = 1;
		
		for(int i=1;i<num;i++) {
			result = result * i; //result +=  i;
		}
		//종료시간
		//long endTime = System.nanoTime();
		//System.out.println("factorial("+num+") 실행시간 : "+ (endTime-startTime));
		
		return result;
	}


}
