package C05_03;

import org.springframework.aop.framework.ProxyFactory;

public class MainAopExample {

//    public static void main(String... args) {
//
//        // 조인포인트 인스턴스 생성 -> 프록시팩토리 인스턴스 생성
//        Agent target = new AgentBond();
//        ProxyFactory proxyFactory = new ProxyFactory();
//
//        // 어드바이스 구성 -> 타겟 구성 -> 타겟프록시 구성
//        proxyFactory.addAdvice(new AgentDecorator());
//        proxyFactory.setTarget(target);
//        Agent agentProxy = (Agent) proxyFactory.getProxy();
//
//        // 실행
//        System.out.println(":::: Target Say ::::");
//        target.speak();
//        System.out.println(":::: Target Say ::::");
//        System.out.println(":::: Proxy Say ::::");
//        agentProxy.speak();
//        System.out.println(":::: Proxy Say ::::");
//    }

    public static void main(String... args) {
        SecurityManager securityManager = new SecurityManager();
        SecureInformation secureInformation = getSecureInformation();

        securityManager.login("Hans", "1234");
        secureInformation.importantThing();
        securityManager.logout();

        try {
            securityManager.login("Invalid User", "Bad Password");
            secureInformation.importantThing();
        } catch (SecurityException securityException) {
            System.out.println("Error Message : " + securityException.getMessage());
        }

        try {
            secureInformation.importantThing();
        } catch (SecurityException securityException) {
            System.out.println("Error Message : " + securityException.getMessage());
        }
    }

    private static SecureInformation getSecureInformation() {

        SecureInformation target = new SecureInformation();
        SecurityAdvice advice = new SecurityAdvice();
        ProxyFactory proxyFactory = new ProxyFactory();

        proxyFactory.setTarget(target);
        proxyFactory.addAdvice(advice);
        SecureInformation proxy = (SecureInformation) proxyFactory.getProxy();

        return proxy;
    }
}
