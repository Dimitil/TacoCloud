package tacos.data;

import org.springframework.data.repository.Repository;
import tacos.Ingredient;

public interface IngredientRepository extends Repository<Ingredient, String> {
}