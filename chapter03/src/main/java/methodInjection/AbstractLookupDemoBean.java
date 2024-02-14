package methodInjection;

public abstract class AbstractLookupDemoBean implements DemoBean {
    private Singer mySinger;

    public abstract Singer getMySinger();

    @Override
    public void doSomething() {
        getMySinger().sing();
    }
}
