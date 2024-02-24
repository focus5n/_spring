package C04_11_profile.high_school;

import C04_11_profile.food.Food;
import C04_11_profile.food.FoodProviderService;

import java.util.ArrayList;
import java.util.List;

public class FoodProviderServiceImpl implements FoodProviderService {

    @Override
    public List<Food> providerLunchSet() {
        List<Food> lunchSet = new ArrayList<>();

        lunchSet.add(new Food("Water"));
        lunchSet.add(new Food("Rice"));
        lunchSet.add(new Food("Kimchi"));

        return lunchSet;
    }
}
