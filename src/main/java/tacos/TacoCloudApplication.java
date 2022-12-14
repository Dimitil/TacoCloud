package tacos;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import tacos.data.IngredientRepository;

@SpringBootApplication
public class TacoCloudApplication implements WebMvcConfigurer {
	public static void main(String[] args) {

		SpringApplication.run(TacoCloudApplication.class, args);
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("home");
	}
	@Bean
	public CommandLineRunner dataLoader(IngredientRepository repo) {
		return args -> {
			repo.save(new Ingredient("FLTO", "Flour Tortilla", "WRAP"));
			repo.save(new Ingredient("COTO", "Corn Tortilla", "WRAP"));
			repo.save(new Ingredient("GRBF", "Ground Beef", "PROTEIN"));
			repo.save(new Ingredient("CARN", "Carnitas", "PROTEIN"));
			repo.save(new Ingredient("TMTO", "Diced Tomatoes", "VEGGIES"));
			repo.save(new Ingredient("LETC", "Lettuce", "VEGGIES"));
			repo.save(new Ingredient("CHED", "Cheddar", "CHEESE"));
			repo.save(new Ingredient("JACK", "Monterrey Jack", "CHEESE"));
			repo.save(new Ingredient("SLSA", "Salsa", "SAUCE"));
			repo.save(new Ingredient("SRCR", "Sour Cream", "SAUCE"));
		};
	}
}