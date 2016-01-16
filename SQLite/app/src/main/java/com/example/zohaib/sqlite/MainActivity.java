package com.example.zohaib.sqlite;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public Book b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b = new Book();
        //Get Buttons
        Button insBtn = (Button) (findViewById(R.id.insertBtn));
        Button delBtn = (Button) (findViewById(R.id.deleteBtn));
        Button updBtn = (Button) (findViewById(R.id.updateBtn));
        Button selectBooksBtn = (Button) (findViewById(R.id.getbooksBtn));
        Button selectDesiredBooksBtn = (Button) (findViewById(R.id.desiredbookBtn));

        //Get Text Values
        final EditText BookNameField = (EditText) (findViewById(R.id.bookName));
        final EditText NewNameField = (EditText) (findViewById(R.id.newName));

        final DatabaseHelper myDbHelper = new DatabaseHelper(this , null , null , 1);

        insBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String bookname = BookNameField.getText().toString();
                String newname = NewNameField.getText().toString();
                b.setBookname(bookname);
                myDbHelper.AddBook(b);
            }
        });

        delBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String bookname = BookNameField.getText().toString();
                myDbHelper.deleteProduct(bookname);
            }
        });

        selectBooksBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor c = myDbHelper.getAllData();
                StringBuffer data = new StringBuffer();
                while(c.moveToNext())
                {
                    data.append(c.getString(1));
                }
                Toast.makeText(getApplicationContext(), data.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        selectDesiredBooksBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String bookname = BookNameField.getText().toString();
                StringBuffer data = new StringBuffer();
                Cursor c = myDbHelper.getDesiredBook(bookname);
                while(c.moveToNext())
                {
                    data.append(c.getString(1));
                }
                Toast.makeText(getApplicationContext() , data.toString() , Toast.LENGTH_LONG).show();

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
