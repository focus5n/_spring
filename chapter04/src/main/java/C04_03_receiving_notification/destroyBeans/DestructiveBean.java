package C04_03_receiving_notification.destroyBeans;

import java.io.File;

public class DestructiveBean {
    private File file;
    private String filePath;

    public void afterPropertiesSet() throws Exception {
        System.out.println("Init Bean : DestructiveBean");

        if (filePath == null) {
            String message = DestructiveBean.class + " 타입에는 filePath 프로퍼티를 설정해야 합니다.";
            throw new IllegalArgumentException(message);
        }

        file = new File(filePath);
        if (file.createNewFile()) {
            System.out.println("파일 생성 성공!");
        } else {
            System.out.println("파일 생성 실패!");
        }

        System.out.println("Check File exists : " + file.exists());
    }

    public void destroy() {
        System.out.println("Destroy Bean : DestructiveBean");

        if (!file.delete()) {
            System.out.println("오류 : 파일 삭제에 실패했습니다.");
        }

        System.out.println("Check File exists : " + file.exists());
    }

    public void setFilePath(String filePath) {
        System.out.println("Is this call?" + filePath);
        this.filePath = filePath;
        System.out.println(this.filePath);
    }
}
