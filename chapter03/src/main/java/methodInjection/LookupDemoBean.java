package methodInjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("standardLookupBean")
public class LookupDemoBean implements DemoBean {
    private Singer mySinger;

    @Override
    public Singer getMySinger() {
        return mySinger;
    }

    @Autowired
    @Qualifier("singer")
    public void setMySinger(Singer mySinger) {
        this.mySinger = mySinger;
    }

    @Override
    public void doSomething() {
        mySinger.sing();
    }
}
