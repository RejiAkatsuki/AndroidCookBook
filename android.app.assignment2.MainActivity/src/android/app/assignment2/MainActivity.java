package android.app.assignment2;

import android.app.Activity;
import android.app.assignment2.R;
import android.os.Bundle;

//for update database
public class MainActivity extends Activity {

	private Database db;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search);

		db = new Database(this, "CookBook", null, 1);
		
		//add 1st recipes
		Recipes recipe = new Recipes(1, R.drawable.a_001,
				"Bruschetta with Tomato and Bassil", "O", "15", "10", 3.5);
		db.addRecipes(recipe);
		//add ingredients
		Ingredients ingre1= new Ingredients(1, "6 or 7 ripe plum tomatoes (about 1 1/2 lbs)");
		db.addIngredients(ingre1);		
		//add method
		Method method1 = new Method(1,"Prepare the tomatoes first. Parboil the tomatoes for one minute in boiling water that has just been removed from the burner. Drain. Using a sharp small knife, remove the skins of the tomatoes. (If the tomatoes are too hot, you can protect your finger tips by rubbing them with an ice cube between tomatoes.) Once the tomatoes are peeled, cut them in halves or quarters and remove the seeds and juice from their centers. Also cut out and discard the stem area. Why use plum tomatoes instead of regular tomatoes? The skins are much thicker and there are fewer seeds and less juice.");
		db.addMethod(method1);
		
		//add 2rd recipes
		Recipes recipe2 = new Recipes(2, R.drawable.a_003,"Apple Coffee Cake", "N", "10", "25",4);
		db.addRecipes(recipe2);
		Ingredients ingre2 = new Ingredients(2,"5 1/2 Tbsp unsalted butter, room temperature");
		db.addIngredients(ingre2);
		Method method2 = new Method(2," Pour half of the batter in the bottom of the baking dish. Lay the apple slices on the batter so they just cover the batter (you may have to overlap some slices). Sprinkle the apples with the cinnamon-sugar mixture, reserving a teaspoon or two to sprinkle on top. Spread the rest of the batter over the apples. Sprinkle the remaining cinnamon-sugar on top.");
		db.addMethod(method2);
		
		//add 3nd recipes
		Recipes recipe3 = new Recipes(3, R.drawable.a_002,"Caramel French Toast","N","15","45",4);
		db.addRecipes(recipe3);
		Ingredients ingre3 = new Ingredients(3,"1 cup brown sugar");
		db.addIngredients(ingre3);
		Method method3 = new Method(3, "Heat brown sugar, butter, and corn syrup in a saucepan over medium heat until thickened, about 5 minutes. Pour mixture into prepared baking dish and sprinkle with pecans. Arrange apple slices over pecans. Layer bread slices over apple in two layers.");
		db.addMethod(method3);	
		
		//add 4th recipes
		Recipes recipe4 = new Recipes(4, R.drawable.a_004,"Broccoli Cheese Casserole","N","10","55",3.5);
		db.addRecipes(recipe4);
		Ingredients ingre4 = new Ingredients(4,"2 strips of thick-cut bacon (about 2 ounces), cut crosswise into 1/4-inch wide strips");
		db.addIngredients(ingre4);
		Method method4 = new Method(4,"Bring a large pot of salted water to a boil (1 Tbsp salt for 2 quarts of water). Add the broccoli florets and boil for 3-5 minutes or until just tender enough so that a fork can easily pierce the floret, but still firm. Strain and rinse with cold water to stop the cooking.");
		db.addMethod(method4);
		
		//add 5th recipes
		Recipes recipe5 = new Recipes(5, R.drawable.a_005,"Amaretti Cookies","N","10","30",4);
		db.addRecipes(recipe5);
		Ingredients ingre5 = new Ingredients(5,"2 1/2 cups of almond flour -or- 3 cups of blanched slivered almonds, finely ground up");
		db.addIngredients(ingre5);
		Method method5 = new Method(5," Place teaspoons of the dough on the parchment paper and dust with sugar. Bake for 24-30 minutes or until golden brown. Cool completely before serving. They will be slightly chewy at first, but they will be nicely crispy as a day or two goes by. Store in a cool, dry place. (Note: I usually underbake mine since I like them chewy. If that's your preference, bake them for about 20-24 minutes.) Makes about 30 cookies.");
		db.addMethod(method5);
		
		//add 6th recipes
		Recipes recipe6 = new Recipes(6,R.drawable.a_006,"Apple Carrot Cupcake","N","15","20",4);
		db.addRecipes(recipe6);
		Ingredients ingre6 = new Ingredients(6,"1 1/2 cups packed coarsely grated tart apples, such as Granny Smith (about 2 medium)");
		db.addIngredients(ingre6);
		Method method6 = new Method(6,"Set aluminum or paper cupcake holders in muffin tins. Spoon the batter into the cupcake paper cups, three-quarters of the way to the top. Bake approximately 20 minutes, or until a toothpick inserted in the middle comes out clean. Let cool completely before frosting.");
		db.addMethod(method6);
		
		//add 7nd recipes
		Recipes recipe7 = new Recipes(7, R.drawable.a_007,"Bow Ties with Sausage, Tomatoes and Cream","N", "15","30",4.5);
		db.addRecipes(recipe7);
		Ingredients ingre7 = new Ingredients(7, "1 (12 ounce) package bow tie pasta");
		Ingredients ingre8 = new Ingredients(7,"2 tablespoons olive oil");
		db.addIngredients(ingre7);
		db.addIngredients(ingre8);
		Method method7 = new Method(7,"Bring a large pot of lightly salted water to a boil. Cook pasta in boiling water for 8 to 10 minutes, or until al dente; drain.");
		db.addMethod(method7);
		
		//add 8th recipes
		Recipes recipe8 = new Recipes(8, R.drawable.a_008,"Arugula Corn Salad with Bacon","N","15","25",5);		
		db.addRecipes(recipe8);
		Ingredients ingre9 = new Ingredients(8,"4 large ears of corn");
		db.addIngredients(ingre9);
		Method method8 = new Method(8,"Cook the corn ears, in their husks, either on the grill for a smokey flavor, or by steaming in a large covered stock pot with an inch of boiling water at the bottom of the pot, for 12-15 minutes. Let the corn cool (can run under cold water to speed up the cooling), remove the husks and silk. I recommend cooking the corn in the husks for the added flavor that the husks impart. If you boil or steam the corn ears after you've already husked them, or if you cook them in the microwave, reduce the cooking time by a few minutes.");
		db.addMethod(method8);
		
		//add 9th recipes
		Recipes recipe9 = new Recipes(9, R.drawable.a_009,"Arugula, Mozzarella, Tomato on Focaccia","N","5","0",5);
		db.addRecipes(recipe9);
		Ingredients ingre10 = new Ingredients(9,"3 cups packed trimmed arugula, rinsed, spun dry, and chopped coarse");
		db.addIngredients(ingre10);
		Method method9 = new Method(9,"Layer mozzarella, tomatoes, onions and arugula on the focaccia half. Spread some mayonnaise on the top half of the focaccia if desired. Press top half over the bottom, hold together with a couple of tooth picks.");
		db.addMethod(method9);
		
		//add 10th recipes
		Recipes recipe10 = new Recipes(10, R.drawable.a_010,"Applesauce","N","10","25",4.5);
		db.addRecipes(recipe10);
		Ingredients ingre11 = new Ingredients(10,"3 to 4 lbs of peeled, cored, and quartered apples. (Make sure you use a good cooking apple like Golden Delicious, Jonagold, Granny Smith, Fuji, Jonathan, Mcintosh, or Gravenstein.)");
		db.addIngredients(ingre11);
		Method method10 = new Method(10,"Remove from heat. Remove cinnamon sticks and lemon peels. Mash with potato masher.Ready to serve, either hot or refrigerated. Delicious with vanilla ice cream or vanilla yogurt.Freezes easily, lasts up to one year in a cold freezer.");
		db.addMethod(method10);
		
		//add 11th recipes
		Recipes recipe11 = new Recipes(11, R.drawable.a_011,"African Chicken Peanut Stew","N","15","1h45",5);
		db.addRecipes(recipe11);
		Ingredients ingre12 = new Ingredients(11,"2-3 pounds sweet potatoes, peeled and cut into chunks");
		db.addIngredients(ingre12);
		Method method11 = new Method(11,"Add the chicken, chicken broth, crushed tomatoes, peanut butter, peanuts, coriander and cayenne and stir well to combine. Bring to a simmer and taste for salt, adding more if needed. Cover the pot and simmer gently for 90 minutes (check after an hour), or until the chicken meat easily falls off the bone and the sweet potatoes are tender.");
		db.addMethod(method11);		
	}	
}
