import factory.SpringMessageFactory;
import message.MessageProvider;
import message.MessageRenderer;
import message.SpringMessageProvider;
import message.SpringMessageRenderer;

import javax.swing.*;

public class Hello {

    public static void main(String[] args) {

        // Step 01
        // 출력
        //System.out.println("Hello, Spring!");

        // Step 02
        // 입력받은 내용을 출력
        /*
        if (args.length > 0) {
            System.out.println(args);
        } else {
            System.out.println("Nothing");
        }
         */
        
        // Step 03
        // 입력과 출력을 분리
        /*
        MessageRenderer renderer = new SpringMessageRenderer();
        MessageProvider provider = new SpringMessageProvider();

        renderer.setMessageProvider(provider);
        renderer.render();
         */
        
        // Step 04
        // 설정파일에서 구현 클래스 이름을 읽어 인스턴트를 생성
        MessageRenderer renderer = SpringMessageFactory.getInstance().getMessageRenderer();
        MessageProvider provider = SpringMessageFactory.getInstance().getMessageProvider();

        renderer.setMessageProvider(provider);
        renderer.render("Message from property file.");
    }
}
