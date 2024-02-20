package C04_03_receiving_notification.destroyBeans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.File;

public class DestructiveBeanWithJSR250 {
    private File file;
    private String filePath;

    @PostConstruct
    public void afterPropertiesSet() throws Exception {
        System.out.println(":::::: Init Bean STT ::::::");

        if (filePath == null) {
            String message = DestructiveBeanWithJSR250.class + " 유형에는 filePath 요소를 설정해야 함요.";
            throw new IllegalArgumentException(message);
        }

        file = new File(filePath);
        file.createNewFile();
        System.out.println("::: Check File exists : " + file.exists() + " :::");

        System.out.println(":::::: Init Bean END ::::::" + "\n");
    }

    @PreDestroy
    public void destroy() {
        System.out.println(":::::: Destroy Bean STT ::::::");

        if (file.delete()) {
            System.out.println("::: 파일 삭제 성공 :::");
        } else {
            System.out.println("::: 파일 삭제 실패 :::");
        }

        System.out.println(":::::: Destroy Bean END ::::::" + "\n");
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
