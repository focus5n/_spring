package C04_11_profile.kindergarten;

import C04_11_profile.food.Food;
import C04_11_profile.food.FoodProviderService;

import java.util.ArrayList;
import java.util.List;

public class FoodProviderServiceImpl implements FoodProviderService {

    @Override
    public List<Food> providerLunchSet() {
        List<Food> lunchSet = new ArrayList<>();

        lunchSet.add(new Food("Milk"));
        lunchSet.add(new Food("Bread"));
        lunchSet.add(new Food("Choco"));

        return lunchSet;
    }
}
