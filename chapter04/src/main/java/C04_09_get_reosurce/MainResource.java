package C04_09_get_reosurce;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.IOException;

public class MainResource {

    public static void main(String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext();

        var prefix = "test";
        var suffix = "txt";
        var file = File.createTempFile(prefix, suffix);
        System.out.println("파일 생성여부 확인 : " + file.exists());
        System.out.println("파일 이름 확인: " + file.getName());
//        file.deleteOnExit();

        String filePath = "file://hans/" + file.getPath();
        var resource01 = context.getResource(filePath);
        displayInfo(resource01);

        var dot = ".";
        String classPath = "classpath:test.txt";
        var resource02 = context.getResource(classPath);
        displayInfo(resource02);

        String urlPath = "https://google.com";
        var resource03 = context.getResource(urlPath);
        displayInfo(resource03);
    }

    private static void displayInfo(Resource resource) throws Exception {
        System.out.println(resource.getClass());
        System.out.println(resource.getURL().getContent());
        System.out.println("");
    }
}
