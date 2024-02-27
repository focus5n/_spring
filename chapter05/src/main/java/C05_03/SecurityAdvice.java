package C05_03;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class SecurityAdvice implements MethodBeforeAdvice {

    private SecurityManager securityManager;

    public SecurityAdvice() {
        this.securityManager = new SecurityManager();
    }

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        SecureUser user = securityManager.getSecureUserInfo();

        if (user == null) {
            System.out.println("미인증 사용자임.");
            throw new SecurityException("인증해야 메서드 호출 가능함 : " + method.getName());
        } else if ("Hans".equals(user.getUserName())) {
            System.out.println("Hans 유일한 인증 사용임! - GOOD");
        } else {
            System.out.println(user.getUserName() + " 사용자로 로그인함. - BAD");
            throw new SecurityException(user.getUserName() + " 사용자는 메서드 호출 권한이 없음...");
        }
    }
}
