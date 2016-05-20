package com.yayao.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

import com.yayao.test.Test2;

//@Component
//@Aspect
public class AopAspectTest {
		//@Pointcut("execution(* com.yayao.test..*.*(..))" )
		public void pointCut() {
			System.out.println("pointcut");
	}
		//@Before("pointCut()")
		public void aopbeforetest(JoinPoint jp){
			
			System.out.println("aopbeforetest");
		}
		//@After("pointCut()")
		public void aopaftertest(JoinPoint joinPoin){
			System.out.println("aopaftertest"+joinPoin.hashCode());
		}
		//@Around("pointCut()")
		public Object aoparoundtest(ProceedingJoinPoint jp) throws Throwable{
			System.out.println("aoparoundtest");
			Object[] args=jp.getArgs();
			System.out.println("aoparoundtest"+args.length);
			args[0]="123456";
				System.out.println("aoparoundtest"+args[0]);
				args[1]=434;
			return jp.proceed(args);
		}
		//@AfterReturning(pointcut = "pointCut()", returning = "returnVal")
		public void aopafterreturntest(){
			System.out.println("aopafterreturntest");
		}
		//@AfterThrowing(pointcut="pointCut()",throwing="error")
		public void aopafterthrowingtest(){
			System.out.println("error");
		}
		public static void main(String[] args) {
			new Test2().updateUser("sdf");
		}
}	
