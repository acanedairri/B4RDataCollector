package org.irri.activity;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import org.irri.database.DatabaseHelper;

import java.io.IOException;

public class TestDatabaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_database);

        TextView txt = (TextView)findViewById(R.id.txtHello);

        DatabaseHelper dbHelper = new DatabaseHelper(this);
        try {
            dbHelper.createDataBase("master");
            dbHelper.createDataBase("account");
        } catch (IOException e) {
            e.printStackTrace();
        }
        String sql = "select * from variable";
        dbHelper.openDatabase("master");

        SQLiteDatabase db = dbHelper.getDataBase();

       // String s=db.getPath();

        Cursor cursor = db.rawQuery(sql, null);
        String s=cursor.getColumnName(2);
        txt.setText(s);
        //cursor.close();
       // db.close();
        dbHelper.close();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_test_database, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
