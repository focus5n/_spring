package C04_11_profile;

import C04_11_profile.food.FoodProviderService;
import C04_11_profile.javaProfile.HighschoolConfig;
import C04_11_profile.javaProfile.KindergartenConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainFood {

//    public static void main(String[] args) {
//        var config = "C04_11/*-config.xml";
//        var beanName = "foodProviderService";
//
//        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
//        context.load(config);
//        context.refresh();
//
//        FoodProviderService foodProviderService= context.getBean(beanName, FoodProviderService.class);
//        List<Food> lunchSet = foodProviderService.providerLunchSet();
//
//        for (Food lunchMenu : lunchSet) {
//            System.out.println("Lunch Menu : " + lunchMenu.getName());
//        }
//
//        context.close();
//    }

    public static void main(String[] args) {
        var config01 = KindergartenConfig.class;
        var config02 = HighschoolConfig.class;
        var beanName = "foodProviderService";
        var beanClass = FoodProviderService.class;

        var context = new AnnotationConfigApplicationContext(config01, config02);
        var foodProviderService = context.getBean(beanName, beanClass);
        var lunchSet = foodProviderService.providerLunchSet();

        for (var lunchMenu : lunchSet) {
            System.out.println("Lunch Menu : " + lunchMenu.getName());
        }

        context.close();
    }
}
