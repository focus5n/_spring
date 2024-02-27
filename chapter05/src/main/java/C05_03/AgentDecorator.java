package C05_03;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class AgentDecorator implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {

        System.out.println("James ");

        // 원래 메서드 호출
        Object returnValue = invocation.proceed();

        System.out.println("!");

        // 변경된 값을 반환
        return returnValue;
    }
}
