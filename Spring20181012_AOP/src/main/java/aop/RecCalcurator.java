package aop;

public class RecCalcurator implements Calcurator {

	@Override
	public long factorial(long num) {

		// 시작시간
		//long startTime = System.nanoTime();

		//try {
			if (num == 0) {

				return 1;
			} else {
				return num * factorial(num - 1);
			}
		//} finally {
			// 종료시간
			//long endTime = System.nanoTime();
		//}
	}

}
