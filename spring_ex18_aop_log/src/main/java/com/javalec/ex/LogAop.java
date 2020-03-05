package com.javalec.ex;

import org.aspectj.lang.ProceedingJoinPoint;

public class LogAop {
	public Object loggerAop(ProceedingJoinPoint joinpoint) throws Throwable {
		//프락시 패턴임.
		String signatureStr = joinpoint.getSignature().toShortString();//메서드 이름 추출
		System.out.println(signatureStr + " is start.");
		long st = System.currentTimeMillis();

		try {
			Object obj = joinpoint.proceed();//핵심기능을 실행시킴
			return obj;
		} finally {
			//catch가 있건 없건 무조건 들어와서 로그를 출력시켜주기 위함.
			long et = System.currentTimeMillis();
			System.out.println(signatureStr + "is finished.");
			System.out.println(signatureStr + "경과 시간: " + (et - st));
		}
	}
}
