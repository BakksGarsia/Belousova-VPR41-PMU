package com.example.lr1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DataBaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_base);
    }

    public void onClick(View view) {
        SQLiteDatabase dataBase = getBaseContext().openOrCreateDatabase("app.db", MODE_PRIVATE, null);
        dataBase.execSQL(("CREATE TABLE IF NOT EXISTS users (surname TEXT, name TEXT, age INTEGER, UNIQUE(surname))"));
        dataBase.execSQL("INSERT OR IGNORE INTO users VALUES ('Белоусова', ' Юля', 21), ('Таран', 'Дмитрий', 21), ('Евдокимов', 'Максим', 21);");

        Cursor query = dataBase.rawQuery("SELECT * FROM users;", null);
        TextView textView = findViewById(R.id.textView);
        textView.setText("");
        while (query.moveToNext()) {
            String surname = query.getString(0);
            String name = query.getString(1);
            int age = query.getInt(2);
            textView.append("Фамилия: " + surname + "\n" + "Имя: " + name + "\n" + "Возраст: " + age + "\n" + "\n");
        }

        query.close();
        dataBase.close();
    }

    public void startAPIActivity(View view) {
        Intent intent = new Intent(this, APIActivity.class);
        startActivity(intent);
    }
}