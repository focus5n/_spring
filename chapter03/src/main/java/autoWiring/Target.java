package autoWiring;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Target {

    private Foo fooOne;
    private Foo fooTwo;
    private Bar bar;

    public Target() {}

    public Target(Foo foo) {
        System.out.println("Target(Foo foo) 호출");
    }
    
    public Target(Foo foo, Bar bar) {
        System.out.println("Target(Foo foo, Bar bar) 호출");
    }

    public void setFooOne(Foo fooOne) {
        this.fooOne = fooOne;
        System.out.println("프로퍼티 fooOne 설정");
    }

    public void setFooTwo(Foo fooTwo) {
        this.fooTwo = fooTwo;
        System.out.println("프로퍼티 fooTwo 설정");
    }
    
    public void setBar(Bar bar) {
        this.bar = bar;
        System.out.println("프로퍼티 bar 설정");
    }
}
