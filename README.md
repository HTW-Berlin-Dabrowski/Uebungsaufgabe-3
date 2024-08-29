In dieser Übungsaufgabe sollen Sie lernen, Methoden zu schreiben und zu nutzen. Außerdem werden Sie Arrays erstellen und manipulieren.

Sie haben sich dazu entschlossen, ihre Lieblingsrezepte zu digitalisieren, mit dem Ziel, daraus ein Kochbuch zu machen.

Die Methoden werden in die Klasse RecipeTools geschrieben.

Wie auch in den bewerteten Aufgaben, funktionieren die Tests nur dann, wenn das Programm kompilieren kann. Wenn Sie eine Aufgabe testen wollen, ist es sinnvoll, für alle anderen Aufgaben auch schon ein Skelett zu bauen. Für die Aufgaben 1-3 sind die Skelette schon vorgegeben in der Klasse RecipeTools. 
Die Ausgaben Ihrer Methoden können Sie in der Main Methode der testen.

# Aufgabe 1
Implementieren Sie eine Methode `public static int getCookingTime(String recipe)`, die die Zeit zurückgibt, die gebraucht wird, ein Rezept zuzubereiten (in vollen Minuten). Als Standardwert gibt die Methode -1 zurück, das passiert z.B. wenn ein Rezept übergeben wurde, das es nicht gibt.

Die Zeiten haben Sie sich vorher aufgeschrieben:

- Apfelpfannkuchen: 20 Minuten
- Gurkensalat: 5 Minuten
- Curry: 20 Minuten
- Pizza: 45 Minuten
- Reispfanne: 15 Minuten

Beispiel: Der Methodenaufruf `getCookingTime(Pizza)` gibt 45 zurück.

# Aufgabe 2
Die Zutaten, die Sie für Ihre Lieblingspfannkuchen brauchen, haben Sie auf einem Zettel notiert:
- Mehl, 200g
- Zucker, 2EL
- Eier, 4
- Milch, 250ml
- Apfel, 2

a) Implementieren Sie eine Methode `public static String[] createIngredientArray(String ingredientOne, String ingredientTwo, String ingredientTree, String ingredientFour, String ingredientFive)`, die ein Array erstellt, mit den gegebenen Zutaten füllt und zurückgibt.

b) Implementieren Sie eine zweite Methode `public static float[] createAmountArray(float amountOne, float amountTwo, float amountThree, float amountFour, float amountFive)`, in der Sie einen Array mit den Mengenangaben füllen und zurückgeben. Es werden hier nur die Zahlen übergeben, ignorieren Sie bitte die Einheiten.

c) Stellen Sie sicher, dass die Methoden auch für andere Rezepte funktioniert, z.B. für das Curry-Rezept:
- Reis, 150g
- Gemüse, 300g
- Kokosmilch, 400ml
- Currypaste, 2EL
- Tofu, 100g
  Die Methoden sollten für jedes beliebige Rezept mit fünf Zutaten funktionieren.

Beispiel: Der Methodenaufruf `createIngredientArray("Reis", "Kokosmilch", "Gemüse", "Currypaste", "Tofu")` gibt das Array `{Reis,Kokosmilch,Gemüse,Currypaste,Tofu}` zurück, der Aufruf `createAmountsArray(200, 2, 4, 250, 2)` gibt das Array `{200,2,4,250,2}` zurück.

# Aufgabe 3
Schreiben Sie eine Methode `public static int findIndex(String ingredient, String[] ingredientArray)`, die die Position einer Zutat im Array zurückgibt. Wenn eine Zutat gesucht wird, die nicht im Array ist, soll die Methode -1 zurückgeben.

# Aufgabe 4
Implementieren Sie eine Methode `public static int isSufficientAmount(String ingredient, int availableAmount, String[] ingredientArray, float[] ingredientAmounts)`, die überprüft, ob die vorhandene Menge einer Zutat ausreicht, um die benötigte Menge zu decken. Die Methode gibt ein `int` zurück, das angibt, ob die vorhandene Menge ausreicht (1) oder nicht (0).

Wenn die übergebene Zutat nicht im Array ist, gibt die Methode -1 zurück.

Beispiel: Der Methodenaufruf `isSufficientAmount("Apfel", 1, ingredientArray, ingredientAmounts)` gibt 0 zurück, `isSufficientAmount("Apfel", 3, ingredientArray, ingredientAmounts)` gibt 1 zurück und `isSufficientAmount("Birne", 2, ingredientArray, ingredientAmounts)` gibt -1 zurück.

# Aufgabe 5
Implementieren Sie eine Methode `public static void changeIngredientAmounts(float[] ingredientAmounts, float factor)`, die die Mengen im Array um den Faktor `factor` verändert. Das bedeutet, wenn als `factor` 2 übergeben wird, werden die Zutaten verdoppelt, wenn 0.5 übergeben wird, werden sie halbiert.
Wenn `factor` 1 ist, wird das Array nicht verändert.

Beispiel: Der Methodenaufruf `chanceIngredientAmounts(ingredientAmounts, 2)` ändert das Array wie folgt: `{400,4,8,500,4}`.

# Aufgabe 6
Implementieren Sie eine Methode public static int deleteIngredient(String[] ingredientArray, float[] ingredientAmounts, String ingredientToDelete), die beide Arrays übergeben bekommt und eine Zutat sowie die dazugehörige Menge löscht. Die Methode soll bei Erfolg 1 zurückgeben. Wenn die Zutat nicht im Array gefunden wird, soll die Methode -1 zurückgeben.

Wichtige Hinweise:

Die Methode soll die Arrays in-place ändern, d.h., sie sollen in der Testumgebung nach dem Aufruf der Methode tatsächlich verändert sein.
Denken Sie daran, dass Arrays in Java eine feste Länge haben. Um das Problem zu umgehen, können Sie die nicht benötigten Elemente am Ende des Arrays mit einem speziellen Wert markieren (z.B. null für Strings und 0 für Zahlen).

Der Methodenaufruf deleteIngredient(ingredientArray, ingredientAmounts, "Apfel") ändert die Arrays wie folgt:
ingredientArray = {Mehl,Zucker,Eier,Milch,null}
ingredientAmounts = {200,2,4,250,0}

Tipp: Verwenden Sie den Wert null für Strings und 0 für die Mengen, um anzuzeigen, dass eine Zutat oder eine Menge gelöscht wurde.

# Aufgabe 7
Implementieren Sie eine Methode `public static String writeRecipe(String recipeName, String[] ingredientArray, float[] ingredientAmounts)`.
Die Methode wird einen String zurückgeben, indem einige Informationen verbunden werden:
- Der Name des Rezepts
- Die Zubereitungszeit (in Minuten)
- Die Inhalte der beiden Arrays ingredientArray und ingredientAmounts werden in den selben String geschrieben, sodass die jeweils passenden Zutaten und Mengen nebeneinander stehen (die Einheiten werden ignoriert). Hinter jeder Zutat steht ein Komma. Hinter jedem "Paar" gibt es einen Zeilenumbruch.

Wenn aus den Arrays etwas gelöscht wurde, soll das in der Ausgabe nicht erkennbar sein. Also 0 oder null soll nicht im String stehen.

Beispielausgabe:
```agsl
Apfelpfannkuchen
20 Minuten
Mehl: 200
Zucker: 2
Eier: 4
Milch: 250
Apfel: 2
```
