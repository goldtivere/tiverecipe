package tive.recipe.tiverecipe.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tive.recipe.tiverecipe.commands.IngredientCommand;
import tive.recipe.tiverecipe.services.IngredientService;
import tive.recipe.tiverecipe.services.RecipeService;
import tive.recipe.tiverecipe.services.UnitOfMeasureService;

@Slf4j
@Controller
public class IngredientController {
    private final RecipeService recipeService;
    private final IngredientService ingredientService;
    private final UnitOfMeasureService unitOfMeasureService;

    public IngredientController(RecipeService recipeService, IngredientService ingredientService, UnitOfMeasureService unitOfMeasureService) {
        this.recipeService = recipeService;
        this.ingredientService = ingredientService;
        this.unitOfMeasureService = unitOfMeasureService;
    }


    @GetMapping
    @RequestMapping("/recipe/{recipeId}/ingredients")
    public String listIngredients(@PathVariable String recipeId, Model model)
    {
        log.debug("Getting ingredient list for recipe id: "+ recipeId);

        model.addAttribute("recipe", recipeService.findCommandById(Long.valueOf(recipeId)));
        return "recipe/ingredient/list";

    }

    @GetMapping
    @RequestMapping("recipe/{recipeId}/ingredient/{id}/show")
    public String showRecipeIngredient(@PathVariable String recipeId,@PathVariable String id,Model model)
    {
        log.debug("Getting recipe ingredient list for recipe id: "+ recipeId + " id: "+ id);

        model.addAttribute("ingredient", ingredientService.findByRecipeIdAndId(Long.valueOf(recipeId),Long.valueOf(id)));
        return "recipe/ingredient/show";

    }

    @GetMapping
    @RequestMapping("recipe/{recipeId}/ingredient/{id}/update")
    public String updateRecipeIngredient(@PathVariable String recipeId,@PathVariable String id, Model model)
    {
        log.debug(ingredientService.findByRecipeIdAndId(Long.valueOf(recipeId), Long.valueOf(id)).getUom().getId() +"  we got here ");
        model.addAttribute("ingredient", ingredientService.findByRecipeIdAndId(Long.valueOf(recipeId), Long.valueOf(id)));
        model.addAttribute("uomList", unitOfMeasureService.listAllUoms() );

        return "recipe/ingredient/ingredientform";
    }

    @PostMapping
    @RequestMapping("recipe/{recipeId}/ingredient")
    public String saveOrUpdate(@ModelAttribute IngredientCommand command)
    {
        IngredientCommand savedCommand=ingredientService.saveIngredientService(command);
        log.debug("saved recipe Id: "+ savedCommand.getRecipeId());
        log.debug("saved ingredient Id: "+ savedCommand.getId());
        return "redirect:/recipe/"+savedCommand.getRecipeId()+"/ingredient/"+savedCommand.getId()+"/show";
    }
}
