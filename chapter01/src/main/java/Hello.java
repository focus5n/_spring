import message.MessageRenderer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
        /*
        MessageRenderer renderer = SpringMessageFactory.getInstance().getMessageRenderer();
        MessageProvider provider = SpringMessageFactory.getInstance().getMessageProvider();

        renderer.setMessageProvider(provider);
        renderer.render("Message from property file.");
         */

        // Step 05
        // 컴포넌트 접착코드 제거 및 구현체 인스턴스를 스프링이 알아서 공급하도록 설정
        String springContextProperty = "spring/springContext.xml";
        String rendererName = "renderer";

        ApplicationContext context = new ClassPathXmlApplicationContext(springContextProperty);
        MessageRenderer renderer = context.getBean(rendererName, MessageRenderer.class);

        renderer.render("Step 05 : Get Instance By Spring Context");
    }
}
