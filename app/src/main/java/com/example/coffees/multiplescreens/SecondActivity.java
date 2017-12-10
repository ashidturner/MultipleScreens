package com.example.coffees.multiplescreens;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    TextView tvname,tvage,tved,tvcourse,tvfee,tvstats,tvreason,tvbank,tvtra;
    CheckBox c1,c2,c3;
    public static final int RC1 =1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        tvname= (TextView) findViewById(R.id.textViewname);
        tvage= (TextView) findViewById(R.id.textViewage);
        tved= (TextView) findViewById(R.id.textViewedu);
        tvcourse= (TextView) findViewById(R.id.textViewcourse);
        tvfee= (TextView) findViewById(R.id.textViewfee);
        tvstats= (TextView) findViewById(R.id.textViewstats);
        tvreason= (TextView) findViewById(R.id.textViewreason);
        tvbank= (TextView) findViewById(R.id.textViewbank);
        tvtra = (TextView) findViewById(R.id.textViewtrans);
        c1 = (CheckBox) findViewById(R.id.checkBox1);
        c2 = (CheckBox) findViewById(R.id.checkBox2);
        c3 = (CheckBox) findViewById(R.id.checkBox3);
    }

    public void clicked(View view) {
        if(!c1.isChecked()&&!c2.isChecked()&&!c3.isChecked()){
            Toast.makeText(this, "Please select one", Toast.LENGTH_SHORT).show();
        }
        else if(c1.isChecked()&&c2.isChecked()&&c3.isChecked()){
            Intent in = new Intent(SecondActivity.this,ThirdActivity.class);
            String course = c1.getText().toString().trim() +", "+c2.getText().toString().trim()+", "+c3.getText().toString().trim();
            Course c = new Course(course);
            in.putExtra("courseobj",c);
            in.putExtra("m",true);
            tvcourse.setText("Course: Android, Java, .Net");
            tvfee.setText("Total Fee: 49,967");
            startActivityForResult(in,RC1);
        }
        else if(c1.isChecked()&&c2.isChecked()){
            Intent in = new Intent(SecondActivity.this,ThirdActivity.class);
            String course = c1.getText().toString().trim() +", "+c2.getText().toString().trim();
            Course c = new Course(course);
            in.putExtra("courseobj",c);
            tvcourse.setText("Course: Android, Java");
            tvfee.setText("Total Fee: 29,978");
            startActivityForResult(in,RC1);

        }
        else if(c1.isChecked()&&c3.isChecked()){
            Intent in = new Intent(SecondActivity.this,ThirdActivity.class);
            String course = c1.getText().toString().trim() +", "+c3.getText().toString().trim();
            Course c = new Course(course);
            in.putExtra("courseobj",c);
            in.putExtra("o",true);
            tvcourse.setText("Course: Android, .net");
            tvfee.setText("Total Fee: 39,978");
            startActivityForResult(in,RC1);

        }
        else if(c2.isChecked()&&c3.isChecked()){
            Intent in = new Intent(SecondActivity.this,ThirdActivity.class);
            String course =c2.getText().toString().trim()+", "+c3.getText().toString().trim();
            Course c = new Course(course);
            in.putExtra("courseobj",c);
            in.putExtra("p",true);
            tvcourse.setText("Course: .net, Java");
            tvfee.setText("Total Fee: 29,978");
            startActivityForResult(in,RC1);
        }
        else if(c1.isChecked()){
            Intent in = new Intent(SecondActivity.this,ThirdActivity.class);
            String course = c1.getText().toString().trim();
            Course c = new Course(course);
            in.putExtra("courseobj",c);
            in.putExtra("q",true);
            tvcourse.setText("Course: Android");
            tvfee.setText("Total Fee: 19989");
            startActivityForResult(in,RC1);
        }
        else if(c2.isChecked()){
            Intent in = new Intent(SecondActivity.this,ThirdActivity.class);
            String course = c2.getText().toString().trim();
            Course c = new Course(course);
            in.putExtra("courseobj",c);
            in.putExtra("r",true);
            tvcourse.setText("Course: Java");
            tvfee.setText("Total Fee: 9989");
            startActivityForResult(in,RC1);
       }
       else{
            Intent in = new Intent(SecondActivity.this,ThirdActivity.class);
            String course = c3.getText().toString().trim();
            Course c = new Course(course);
            in.putExtra("courseobj",c);
            tvcourse.setText("Course: .Net");
            tvfee.setText("Total Fee: 19989");
            in.putExtra("s",true);
            startActivityForResult(in,RC1);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(data!=null){
            Bank b = (Bank) data.getSerializableExtra("obj2");
            if(resultCode==RESULT_OK){
                tvstats.setText("Status is: SUCCESS");
                tvstats.setVisibility(View.VISIBLE);
                tvbank.setText("Bank :"+ b.getBankName());
                tvbank.setVisibility(View.VISIBLE);
            }
            else{
                tvstats.setText("Status is: FAILURE");
                tvstats.setVisibility(View.VISIBLE);
                tvreason.setText("Reason: "+data.getStringExtra("reason"));
                tvreason.setVisibility(View.VISIBLE);
            }
        }

        Intent in = getIntent();
        Bundle c = in.getExtras();
        Student s = (Student) c.getSerializable("obj1"); //DESERIALIZING STUDENT
        tvname.setText("Name is: "+s.getName());
        tvname.setVisibility(View.VISIBLE);
        tvage.setText("Age is: "+s.getAge());
        tvage.setVisibility(View.VISIBLE);
        tvtra.setVisibility(View.VISIBLE);
        tvcourse.setVisibility(View.VISIBLE);
        tvfee.setVisibility(View.VISIBLE);
        boolean a = c.getBoolean("a");
        boolean e = c.getBoolean("b");
        boolean d = c.getBoolean("c");

        if(a){
            Student s1 = (Student) c.getSerializable("obj2");
           tved.setText("Education: "+s1.getQualification());
        }
        else if(e){
            Student s1 = (Student) c.getSerializable("obj2");
            tved.setText("Education: "+ s1.getQualification());
        }
        else{
            Student s1 = (Student) c.getSerializable("obj2");
            tved.setText("Education: "+ s1.getQualification());
        }
        tved.setVisibility(View.VISIBLE);
        super.onActivityResult(requestCode, resultCode, data);
    }
}
