package C05_03;

public class SecurityManager {

    private static ThreadLocal<SecureUser> threadLocal = new ThreadLocal<>();

    public void login(String userName, String password) {
        threadLocal.set(new SecureUser(userName, password));
    }

    public void logout() {
        threadLocal.set(null);
    }

    public SecureUser getSecureUserInfo() {
        return threadLocal.get();
    }
}
