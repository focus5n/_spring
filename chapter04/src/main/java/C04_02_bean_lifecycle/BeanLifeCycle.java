package C04_02_bean_lifecycle;

public class BeanLifeCycle {

    public static void main(String... args) {
        
        // 생성, 소멸 등 특정 시점에 통지를 받을 수 있도록 빈을 생성.
        // post-initialization : 프로퍼티 값 설정 - 의존성 점검 - 통지
        // pre-destruction : 통지 - 빈 인스턴스 소멸 but 프로토타입 빈은 본 이벤트를 호출하지 않음.
        // 스프링이 기능을 제공하는 매커니즘 : 인터페이스, 메서드, 애너테이션
        // 인터페이스 기반 : 빈에 통지받길 원하는 통지 유형 인터페이스를 구현
        // 메서드 기반 : 빈이 초기화, 소멸될 때 호출할 메서드 이름을 ApplicationContext 구성에 지정.
        // 애너테이션 기반 : 빈이 초기화, 소멸될 때 호출할 메서드 이름을 JSR-250 구성에 정의된 애너테이션으로 구성.
        // 일반적으로 메서드, 애너테이션 기반 방식을 추천. 이렇다면 스프링에 특화된 어떤 인터페이스도 구현할 필요가 없음.

        // 스프링 빈 라이프사이클
        // 1. 빈 초기화(구성 찾기 + 구성 할당) 및 의존성 주입
            // 1. 구성 정보에서 빈 정의를 검색 (XML, 애너테이션, 자바 Configuration)
            // 2. 빈 인스턴스 생성
            // 3. 빈 의존성 주입 (Setter 수정자 주입, @Autowired 필드 주입)
        // 2. 빈이 스프링을 알아야 하는지 확인
            // BeanNameAware 구현했다면 setBeanName() 호출
            // BeanClassLoaderAware 구현했다면 setBeanClassLoader() 호출
            // ApplicationContextAware 구현했다면 setApplicationContext() 호출
        // 3. 빈 생성 라이프사이클 콜백
            // @PostConstruct 적용된 메서드 호출
            // 빈이 InitializingBean 구현했다면 afterPropertiesSet() 호출
            // 빈에 init-method 정의됐거나 @Bean(initMethod = "...") 지정됐다면 지정된 초기화 메서드 호출
        // 4. 빈 소멸 라이프사이클 콜백
            // @PreDestroy 적용된 메서드 호출
            // 빈이 DisposableBean 구현했다면 destroy() 호출
            // 빈에 destroy-method 정의됐거나 @Bean(destroyMethod = "...") 지정됐다면 지정된 초기화 메서드 호출
    }
}
