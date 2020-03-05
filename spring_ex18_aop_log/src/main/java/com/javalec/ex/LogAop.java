package com.javalec.ex;

import org.aspectj.lang.ProceedingJoinPoint;

public class LogAop {
	public Object loggerAop(ProceedingJoinPoint joinpoint) throws Throwable {
		//������ ������.
		String signatureStr = joinpoint.getSignature().toShortString();//�޼��� �̸� ����
		System.out.println(signatureStr + " is start.");
		long st = System.currentTimeMillis();

		try {
			Object obj = joinpoint.proceed();//�ٽɱ���� �����Ŵ
			return obj;
		} finally {
			//catch�� �ְ� ���� ������ ���ͼ� �α׸� ��½����ֱ� ����.
			long et = System.currentTimeMillis();
			System.out.println(signatureStr + "is finished.");
			System.out.println(signatureStr + "��� �ð�: " + (et - st));
		}
	}
}
