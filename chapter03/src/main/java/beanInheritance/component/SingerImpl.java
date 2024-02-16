package beanInheritance.component;

public class SingerImpl implements Singer {

    private String name;
    private int age;

    @Override
    public void sing() {
        System.out.println("Sing : bean-inheritance.");
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "SingerImpl{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
