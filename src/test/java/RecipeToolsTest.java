import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class RecipeToolsTest {

    @Test
    void getCookingTime() {
        assertEquals(20, RecipeTools.getCookingTime("Apfelpfannkuchen"));
        assertEquals(45, RecipeTools.getCookingTime("Pizza"));
        assertEquals(-1, RecipeTools.getCookingTime("Kürbissuppe"));
    }

    @Test
    void createIngredientArray() {
        assertArrayEquals(new String[]{"Mehl", "Zucker", "Eier", "Milch", "Apfel"}, RecipeTools.createIngredientArray("Mehl", "Zucker", "Eier", "Milch", "Apfel"));
        assertArrayEquals(new String[] {"Reis", "Gemüse", "Kokosmilch", "Currypaste", "Tofu"}, RecipeTools.createIngredientArray("Reis", "Gemüse", "Kokosmilch", "Currypaste", "Tofu"));
    }

    @Test
    void createAmountsArray() {
        assertArrayEquals(new float[] {200, 2, 4, 250, 2}, RecipeTools.createAmountArray(200, 2, 4, 250, 2));
        assertArrayEquals(new float[] {150, 300, 400, 2, 100}, RecipeTools.createAmountArray(150, 300, 400, 2, 100));
    }

    @Test
    void isSufficientAmount() {
        String[] ingredientArray = RecipeTools.createIngredientArray("Mehl", "Zucker", "Eier", "Milch", "Apfel");
        float[] ingredientAmounts = RecipeTools.createAmountArray(200, 2, 4, 250, 2);
        assertEquals(0, RecipeTools.isSufficientAmount("Apfel", 1, ingredientArray, ingredientAmounts));
        assertEquals(1, RecipeTools.isSufficientAmount("Apfel", 3, ingredientArray, ingredientAmounts));
        assertEquals(-1, RecipeTools.isSufficientAmount("Birne", 3, ingredientArray, ingredientAmounts));
    }

    @Test
    void changeIngredientAmounts() {
        float[] ingredientAmounts = RecipeTools.createAmountArray(200, 2, 4, 250, 2);
        RecipeTools.changeIngredientAmounts(ingredientAmounts, 2);
        assertArrayEquals(new float[] {400, 4, 8, 500, 4}, ingredientAmounts);
        RecipeTools.changeIngredientAmounts(ingredientAmounts, 0.5f);
        assertArrayEquals(new float[] {200, 2, 4, 250, 2}, ingredientAmounts);
    }

    @Test
    void deleteIngredientTest() {
        String[] ingredientArray = {"Mehl", "Zucker", "Eier", "Milch", "Apfel"};
        float[] ingredientAmounts = {200, 2, 4, 250, 2};

        assertEquals(1, RecipeTools.deleteIngredient(ingredientArray, ingredientAmounts, "Apfel"));
        assertArrayEquals(new String[] {"Mehl", "Zucker", "Eier", "Milch", null}, ingredientArray);
        assertArrayEquals(new float[] {200, 2, 4, 250, 0}, ingredientAmounts);
        assertEquals(-1, RecipeTools.deleteIngredient(ingredientArray, ingredientAmounts, "Birne"));
    }

    @Test
    void writeRecipeTest() {
        String recipeName = "Apfelpfannkuchen";
        String[] ingredientArray = {"Mehl", "Zucker", "Eier", "Milch", "Apfel"};
        float[] ingredientAmounts = {200, 2, 4, 250, 2};

        String expectedOutput = "Apfelpfannkuchen" + System.lineSeparator() +
                "20 Minuten" + System.lineSeparator() +
                "Mehl: 200.0" + System.lineSeparator() +
                "Zucker: 2.0" + System.lineSeparator() +
                "Eier: 4.0" + System.lineSeparator() +
                "Milch: 250.0" + System.lineSeparator() +
                "Apfel: 2.0" + System.lineSeparator();

        String actualOutput = RecipeTools.writeRecipe(recipeName, ingredientArray, ingredientAmounts);
        assertEquals(expectedOutput, actualOutput);

        RecipeTools.deleteIngredient(ingredientArray, ingredientAmounts, "Apfel");
        expectedOutput = "Apfelpfannkuchen" + System.lineSeparator() +
                "20 Minuten" + System.lineSeparator() +
                "Mehl: 200.0" + System.lineSeparator() +
                "Zucker: 2.0" + System.lineSeparator() +
                "Eier: 4.0" + System.lineSeparator() +
                "Milch: 250.0" + System.lineSeparator();

        actualOutput = RecipeTools.writeRecipe(recipeName, ingredientArray, ingredientAmounts);
        assertEquals(expectedOutput, actualOutput);
    }

}