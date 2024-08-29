
public class RecipeTools {

    public static int getCookingTime(String recipe) {

        switch (recipe) {
            case "Apfelpfannkuchen" : return 20;
            case "Gurkensalat" : return 5;
            case "Curry" : return 20;
            case "Pizza" : return 45;
            case "Reispfanne" : return 15;
            default: return -1;
        }
    }

    public static String[] createIngredientArray(String ingredientOne, String ingredientTwo, String ingredientTree, String ingredientFour, String ingredientFive) {
        return new String[] {ingredientOne, ingredientTwo, ingredientTree, ingredientFour, ingredientFive};
    }

    public static float[] createAmountArray(float amountOne, float amountTwo, float amountThree, float amountFour, float amountFive) {
        return new float[] {amountOne, amountTwo, amountThree, amountFour, amountFive};
    }

    public static int findIndex(String ingredient, String[] ingredientArray) {

        int index = -1;
        for (int i = 0; i < ingredientArray.length; i++) {
            if (ingredientArray[i] != null && ingredientArray[i].equals(ingredient)) {
                index = i;
            }
        }
        return index;
    }

    public static int isSufficientAmount(String ingredient, int availableAmount, String[] ingredientArray, float[] ingredientAmounts) {
        int index = findIndex(ingredient, ingredientArray);

        if (index == -1) return -1;
        else if (ingredientAmounts[index] <= availableAmount) return 1;
        else return 0;
    }

    public static void changeIngredientAmounts(float[] ingredientAmounts, float factor) {
        for (int i = 0; i < ingredientAmounts.length; i++) {
            ingredientAmounts[i] *= factor;
        }
    }

    public static int deleteIngredient(String[] ingredientArray, float[] ingredientAmounts, String ingredientToDelete) {
        int index = findIndex(ingredientToDelete, ingredientArray);

        if (index != -1) {

            //Alle Elemente hinter dem Index werden eine Stelle nach vorn in das Array geschrieben
            for (int i = index; i < ingredientArray.length - 1; i++) {
                ingredientArray[i] = ingredientArray[i + 1];
                ingredientAmounts[i] = ingredientAmounts[i + 1];
            }

            // Das letzte Element wird auf null / 0 gesetzt
            ingredientArray[ingredientArray.length - 1] = null;
            ingredientAmounts[ingredientAmounts.length - 1] = 0;
            return 1;
        }

        return -1;
    }

    public static String writeRecipe(String recipeName, String[] ingredientArray, float[] ingredientAmounts) {
        String result = "";

        result += recipeName + "\n";
        result += getCookingTime(recipeName) + " Minuten" + "\n";

        for (int i = 0; i < ingredientArray.length; i++) {
            // Nur Zutaten aufschreiben, die nicht null / 0 sind
            if (ingredientArray[i] != null && ingredientAmounts[i] != 0) {
                result += ingredientArray[i] + ": " + ingredientAmounts[i] + "\n";
            }
        }

        return result;
    }


    public static void main(String[] args) {
        String[] ingredientArray = {"Mehl", "Zucker", "Eier", "Milch", "Apfel"};
        float[] ingredientAmounts = {200, 2, 4, 250, 2};

        System.out.print(writeRecipe("Apfelpfannkuchen", ingredientArray, ingredientAmounts));
    }
}
