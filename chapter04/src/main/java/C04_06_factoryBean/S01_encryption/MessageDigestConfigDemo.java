package C04_06_factoryBean.S01_encryption;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class MessageDigestConfigDemo {
//
//    @Configuration
//    public static class MessageDigestConfig {
//
//        @Bean
//        public MessageDigestFactory shaDigest() {
//            var factoryOne = new MessageDigestFactory();
//            factoryOne.setAlgorithmName("SHA1");
//            return factoryOne;
//        }
//
//        @Bean
//        public MessageDigestFactory defaultDigest() {
//            return new MessageDigestFactory();
//        }
//
//        @Bean
//        MessageDigester digester() throws Exception {
//            var messageDigester = new MessageDigester();
//            messageDigester.setDigest01(shaDigest().getObject());
//            messageDigester.setDigest02(defaultDigest().getObject());
//            return messageDigester;
//        }
//    }
}
