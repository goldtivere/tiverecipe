package tive.recipe.tiverecipe.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import tive.recipe.tiverecipe.domain.Category;
import tive.recipe.tiverecipe.domain.UnitOfMeasure;
import tive.recipe.tiverecipe.respositories.CategoryRepository;
import tive.recipe.tiverecipe.respositories.UnitOfMeasureRepository;
import tive.recipe.tiverecipe.services.RecipeService;

import java.util.Optional;
@Slf4j
@Controller
public class IndexController {

    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model) {
        log.debug("Loading Index Page");
      model.addAttribute("recipes", recipeService.getRecipes());
        return "index";
    }
}
