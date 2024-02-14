package methodInjection;

public class LookupDemoBean implements DemoBean {
    private Singer mySinger;

    @Override
    public Singer getMySinger() {
        return mySinger;
    }

    public void setMySinger(Singer mySinger) {
        this.mySinger = mySinger;
    }

    @Override
    public void doSomething() {
        mySinger.sing();
    }
}
