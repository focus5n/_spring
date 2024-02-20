package C04_06_factoryBean.S01_encryption;

import java.security.MessageDigest;

public class MessageDigester {
    private MessageDigest digest01;
    private MessageDigest digest02;

    public void digest(String message) {
        System.out.println("Use Digest01");
        digest(message, digest01);
        System.out.println("");

        System.out.println("Use Digest02");
        digest(message, digest02);
        System.out.println("");
    }

    private void digest(String message, MessageDigest digest) {
        System.out.println("사용하는 알고리즘 : " + digest.getAlgorithm());
        System.out.println(message);
        digest.reset();
        var bytes = message.getBytes();
        var out = digest.digest(bytes);
        System.out.println("출력 값 : " + out);
    }

    public void setDigest01(MessageDigest digest01) {
        this.digest01 = digest01;
    }

    public void setDigest02(MessageDigest digest02) {
        this.digest02 = digest02;
    }
}
