package C04_15_springboot.web_springboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SayHelloWebSpringBoot {

    // 경로를 "/" 이것으로 설정하면 접속할 때 바로 보이는 경로다
    @RequestMapping("/")
    public String sayHelloWebSpringBoot() {
        return "Hello, SpringBoot Web!";
    }
}
