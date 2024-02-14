package methodInjection;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.util.StopWatch;

public class LookupDemo {

    public static void main(String... args) {
        String contextPropertyClasspath = "spring/app-context.xml";
        String beanName01 = "abstractLookupBean";
        String beanName02 = "lookupDemoBean";

        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load(contextPropertyClasspath);
        context.refresh();

        DemoBean abstractBean = (DemoBean) context.getBean(beanName01);
        DemoBean standardBean = (DemoBean) context.getBean(beanName02);

        displayInfo("abstractLookupBean", abstractBean);
        displayInfo("standardLookupBean", standardBean);

        context.close();
    }

    public static void displayInfo(String beanName, DemoBean bean) {
        Singer singer01 = bean.getMySinger();
        Singer singer02 = bean.getMySinger();

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        for (Singer singer : new Singer[10_000]) {
            singer = bean.getMySinger();
            singer.sing();
        }
        stopWatch.stop();

        System.out.println(beanName + ": 동일한 Singer 인스턴스를 사용하는가? " + (singer01 == singer02));
        System.out.println("10,000번 인스턴스를 가져오는데 걸린 시간 : " + stopWatch.getTotalTimeMillis() + " ms");
    }
}
