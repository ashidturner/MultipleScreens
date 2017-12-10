package com.example.coffees.multiplescreens;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etname,etage;
    CheckBox c1,c2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etname = (EditText) findViewById(R.id.editText1);
        etage = (EditText) findViewById(R.id.editText2);
        c1 = (CheckBox) findViewById(R.id.checkBox1);
        c2 = (CheckBox) findViewById(R.id.checkBox2);
    }

    public void clicked(View view) {
        String name = etname.getText().toString().trim();
        int age = Integer.parseInt(etage.getText().toString().trim());
        Intent in = new Intent(MainActivity.this, SecondActivity.class);
        Student s = new Student(name,age);
        in.putExtra("obj1",s);        //Serialization
        if(!c1.isChecked()&&!c2.isChecked()||(name.length()==0||age==0)){
            Toast.makeText(this, "Please fill in the details", Toast.LENGTH_SHORT).show();
        }
        else if(c1.isChecked()&&c2.isChecked()) {
            String qual = c1.getText().toString().trim() +", "+ c2.getText().toString().trim();
            Student s1 = new Student(qual);
            in.putExtra("obj2", s1);
            in.putExtra("a", true);

            startActivity(in);
        }
        else if(c1.isChecked())
            {
                String qual = c1.getText().toString().trim();
                Student s1 = new Student(qual);
                in.putExtra("obj2",s1);
                in.putExtra("b",true);
                startActivity(in);
            }
        else{
            String qual = c2.getText().toString().trim();
            Student s1 = new Student(qual);
            in.putExtra("obj2",s1);
            in.putExtra("c",true);
            startActivity(in);
        }
    }
}
