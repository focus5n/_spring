package C04_07_property_editor.custom;

import org.springframework.aop.framework.autoproxy.InfrastructureAdvisorAutoProxyCreator;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.InfrastructureProxy;

public class CustomEditorExample {

    private FullName name;

    public FullName getName() {
        return name;
    }

    public void setName(FullName name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CustomEditorExample{" +
                "name=" + name +
                '}';
    }

    public static void main(String[] args) {
        String config = "C04_07/custom-editor.xml";
        String beanName = "exampleBean";

        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load(config);
        context.refresh();

        var bean = context.getBean(beanName);
        System.out.println("Check Bean : " + bean);

        context.close();
    }
}
