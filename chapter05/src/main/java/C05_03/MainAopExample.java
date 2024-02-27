package C05_03;

import org.springframework.aop.framework.ProxyFactory;

public class MainAopExample {

    public static void main(String... args) {
        
        // 조인포인트 인스턴스 생성 -> 프록시팩토리 인스턴스 생성
        Agent target = new AgentBond();
        ProxyFactory proxyFactory = new ProxyFactory();

        // 어드바이스 구성 -> 타겟 구성 -> 타겟프록시 구성
        proxyFactory.addAdvice(new AgentDecorator());
        proxyFactory.setTarget(target);
        Agent agentProxy = (Agent) proxyFactory.getProxy();

        // 실행
        System.out.println(":::: Target Say ::::");
        target.speak();
        System.out.println(":::: Target Say ::::");
        System.out.println(":::: Proxy Say ::::");
        agentProxy.speak();
        System.out.println(":::: Proxy Say ::::");
    }
}
