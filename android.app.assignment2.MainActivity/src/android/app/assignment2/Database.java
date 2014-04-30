package android.app.assignment2;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.util.Log;

public class Database {

	public static final String DATABASE_NAME = "CookBook";
	public static final String TABLE_NAME_1 = "recipe_Data";
	public static final String TABLE_NAME_2 = "ingredient_Data";
	public static final String TABLE_NAME_3 = "method_Data";
	public static final String KEY_ID = "id";
	public static final String KEY_IMG = "image";
	public static final String KEY_NAME = "name";
	public static final String KEY_STATE = "state";
	public static final String KEY_PRE_TIME = "preTime";
	public static final String KEY_COOK_TIME = "cookTime";
	public static final String KEY_RATING = "rate";
	public static final String KEY_INGRE = "ingredient";
	public static final String KEY_METHOD = "method";

	private static DataApplication db = null;

	public static Database createDatabase(final Context context) {
		return new Database(context, DATABASE_NAME, null, 1);
	}

	public Database(final Context context, final String name,
			final CursorFactory factory, final int version) {
		Log.i("Database", "Database.jave constructor runned");
		db = new DataApplication(context, name, factory, version);
	}

	public void addRecipes(Recipes recipe) {
		ContentValues values = new ContentValues();
		values.put(KEY_ID, recipe.getID());
		values.put(KEY_IMG, recipe.getImg());
		values.put(KEY_NAME, recipe.getName());
		values.put(KEY_STATE, recipe.getState());
		values.put(KEY_PRE_TIME, recipe.getPreTime());
		values.put(KEY_COOK_TIME, recipe.getCookTime());
		values.put(KEY_RATING, recipe.getRate());
		db.getWritableDatabase().insert(TABLE_NAME_1, null, values);
	}

	public Recipes getRecipes(String id) {
		Cursor cursor = db.getReadableDatabase().query(
				TABLE_NAME_1,
				new String[] { KEY_ID, KEY_IMG, KEY_NAME, KEY_STATE,
						KEY_PRE_TIME, KEY_COOK_TIME, KEY_RATING },
				KEY_ID + "=?", new String[] { id }, null, null, null);
		if (cursor != null)
			cursor.moveToFirst();
		Recipes recipe = new Recipes(Integer.parseInt(cursor.getString(0)),
				Integer.parseInt(cursor.getString(1)), cursor.getString(2),
				cursor.getString(3), cursor.getString(4), cursor.getString(5),
				Double.parseDouble(cursor.getString(6)));
		cursor.close();
		return recipe;
	}

	public void addIngredients(Ingredients ingre) {
		ContentValues values = new ContentValues();
		values.put(KEY_ID, ingre.getID());
		values.put(KEY_INGRE, ingre.getIngre());

		db.getWritableDatabase().insert(TABLE_NAME_2, null, values);
	}

	public ArrayList<Ingredients> getAllIngredients(Recipes recipe) {
		ArrayList<Ingredients> ingreList = new ArrayList<Ingredients>();
		Cursor cursor = db.getReadableDatabase().query(TABLE_NAME_2,
				new String[] { KEY_ID, KEY_INGRE }, KEY_ID + "=?",
				new String[] { Integer.toString(recipe.getID()) }, null, null, null);
		if (cursor.moveToFirst()) {
			while (cursor.moveToNext()) {
				Ingredients ingre = new Ingredients(Integer.parseInt(cursor.getString(0)),
						cursor.getString(1));
				ingreList.add(ingre);
			}
		}
		cursor.close();
		return ingreList;
	}

	public void addMethod(Method method) {
		ContentValues values = new ContentValues();
		values.put(KEY_ID, method.getID());
		values.put(KEY_METHOD, method.getMethod());

		db.getWritableDatabase().insert(TABLE_NAME_3, null, values);
	}

	public ArrayList<Method> getAllMethod(Method method) {
		ArrayList<Method> metList = new ArrayList<Method>();
		Cursor cursor = db.getReadableDatabase().query(TABLE_NAME_3,
				new String[] { KEY_ID, KEY_METHOD }, KEY_ID + "=?",
				new String[] { Integer.toString(method.getID()) }, null, null, null);
		if (cursor.moveToFirst()) {
			while (cursor.moveToNext()) {
				Method met = new Method(Integer.parseInt(cursor.getString(0)),
						cursor.getString(1));
				metList.add(met);
			} ;
		}
		cursor.close();
		return metList;
	}

	public void removeAllData() {
		db.removeAllData();
	}

	public void closeDatabase() {
		db.close();
	}

}
