package C04_03_receiving_notification.destroyBeans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import java.io.File;

public class DestructiveBeanWithInterface implements InitializingBean, DisposableBean {

    private File file;
    private String filePath;

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(":::::: Init Bean Start : DestructiveBeanWithInterface ::::::");

        if (filePath == null) {
            String message = DestructiveBeanWithInterface.class + " 타입에는 filePath 프로퍼티를 반드시 설정해야 합니다.";
            throw new IllegalArgumentException(message);
        }

        file = new File(filePath);

        if (file.createNewFile()) {
            System.out.println("::: 파일 생성 성공! :::");
        } else {
            System.out.println("::: 파일 생성 실패~ :::");
        }

        System.out.println(":::::: Init Bean End   : DestructiveBeanWithInterface ::::::");
    }

    @Override
    public void destroy() {
        System.out.println(":::::: Destroy Bean Start : DestructiveBeanWithInterface ::::::");

        if (file.delete()) {
            System.out.println("::: 파일 삭제 성공! :::");
        } else {
            System.out.println("::: 파일 삭제 실패~ :::");
        }

        System.out.println(":::::: Destroy Bean End   : DestructiveBeanWithInterface ::::::");
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
