package tive.recipe.tiverecipe.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import tive.recipe.tiverecipe.domain.Recipe;
import tive.recipe.tiverecipe.services.IngredientService;
import tive.recipe.tiverecipe.services.RecipeService;

@Controller
public class RecipeController {

    private final RecipeService recipeService;
    private final IngredientService ingredientService;

    public RecipeController(RecipeService recipeService, IngredientService ingredientService) {
        this.recipeService = recipeService;
        this.ingredientService = ingredientService;
    }

    @RequestMapping("/recipe/show/{id}")
    public String showById(@PathVariable String id, Model model)
    {
        Recipe recipe= new Recipe();
        recipe.setId(new Long(id));
        model.addAttribute("recipe", recipeService.findById(new Long(id)));
       model.addAttribute("ingredients", ingredientService.getIngredientByRecipe(recipe));

        return "/recipe/show";

    }
}
