package autoWiring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component("tricky")
@Lazy
public class TrickyTarget {

    Foo fooOne;
    Foo fooTwo;
    Bar bar;

    public TrickyTarget() {
        System.out.println("TrickyTarget : Default Constructor.");
    }

    public TrickyTarget(Foo fooOne) {
        System.out.println("Target(Foo FooOne) 호출");
    }
    
    public TrickyTarget(Foo fooOne, Bar bar) {
        System.out.println("Target(Foo, Bar) 호출");
    }

    @Autowired
    public void setFooOne(Foo fooOne) {
        this.fooOne = fooOne;
        System.out.println("프로퍼티 fooOne 세팅");
    }

    @Autowired
    public void setFooTwo(Foo fooTwo) {
        this.fooTwo = fooTwo;
        System.out.println("프로퍼티 fooTwo 세팅");
    }

    @Autowired
    public void setBar(Bar bar) {
        this.bar = bar;
        System.out.println("프로퍼티 bar 세팅");
    }
}
