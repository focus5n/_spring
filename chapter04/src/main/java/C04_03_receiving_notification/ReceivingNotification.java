package C04_03_receiving_notification;

public class ReceivingNotification {

    public static void main(String... args) {

        // 의존성 검사의 단점
        // 빈은 생성자에서 앞서 의존성 검사를 진행할 수 없다.
        // 빈 생성 시점에는 스프링이 빈에 필요한 의존성을 공급할 수 없기 때문이다.
        // 따라서 스프링 초기화 콜백은 스프링이 제공할 수 있는 의존성 제공이 완료된 이후 호출된다.

        // 일반적으로 스케쥴러는 초기화 콜백 시기에 호출된다.
        // 단, 스케쥴러 관련 내용은 스케쥴러 기능을 통해 자동으로 제공할 수 있기 때문에 직접 작성하는 것을 금한다.
    }
}
