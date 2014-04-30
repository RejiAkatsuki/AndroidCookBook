package android.app.assignment2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.util.Log;

public final class DataApplication extends SQLiteOpenHelper {

	private static final String SQL_DROP_TABLE_1 = "DROP TABLE IF EXISTS recipe_Data";
	private static final String SQL_DROP_TABLE_2 = "DROP TABLE IF EXISTS ingredient_Data";
	private static final String SQL_DROP_TABLE_3 = "DROP TABLE IF EXISTS method_Data";
	private static final String SQL_DELETE_1 = "DELETE FROM recipe_Data";
	private static final String SQL_DELETE_2 = "DELETE FROM ingredient_Data";
	private static final String SQL_DELETE_3 = "DELETE FROM method_Data";
	private static final String SQL_CREATE_TABLE_1 = "CREATE TABLE IF NOT EXISTS recipe_Data"
			+ "(id integer primary key autoincrement,"
			+ "image integer NOT NULL,"
			+ "name text NOT NULL,"
			+ "state text NOT NULL,"
			+ "preTime text NOT NULL,"
			+ "cookTime text NOT NULL," 
			+ "rate text NOT NULL)";
	private static final String SQL_CREATE_TABLE_2 = "CREATE TABLE IF NOT EXISTS ingredient_Data"
			+ "(id integer primary key autoincrement," 
			+ "ingredient text NOT NULL)";
	private static final String SQL_CREATE_TABLE_3 = "CREATE TABLE IF NOT EXISTS method_Data"
		+ "(id integer primary key autoincrement," 
		+ "method text NOT NULL)";
	
	public DataApplication(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		Log.i("Database", "database create");
		db.execSQL(SQL_DROP_TABLE_1);
		db.execSQL(SQL_CREATE_TABLE_1);
		android.util.Log.d("DatabaseModel",
				"DatabaseModel onCreate function table 1 created");
		
		db.execSQL(SQL_DROP_TABLE_2);
		db.execSQL(SQL_CREATE_TABLE_2);
		android.util.Log.d("DatabaseModel",
				"DatabaseModel onCreate function table 2 created");
		
		db.execSQL(SQL_DROP_TABLE_3);
		db.execSQL(SQL_CREATE_TABLE_3);
		android.util.Log.d("DatabaseModel",
				"DatabaseModel onCreate function table 3 created");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		android.util.Log.d("DatabaseModel",
				"DatabaseModel onUpgrade function runs");
		onCreate(db);
	}

	public void removeAllData() {
		getWritableDatabase().execSQL(SQL_DELETE_1);
		getWritableDatabase().execSQL(SQL_DELETE_2);
		getWritableDatabase().execSQL(SQL_DELETE_3);
	}
}
