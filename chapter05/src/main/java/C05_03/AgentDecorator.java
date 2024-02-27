package C05_03;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class AgentDecorator implements MethodInterceptor, MethodBeforeAdvice {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {

        System.out.println("James ");

        // 원래 메서드 호출
        Object returnValue = invocation.proceed();

        System.out.println("!");

        // 변경된 값을 반환
        return returnValue;
    }

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("Before " + method.getName() + ", is this work?");
    }
}
