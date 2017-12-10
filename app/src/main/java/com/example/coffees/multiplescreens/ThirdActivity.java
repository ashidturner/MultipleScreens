package com.example.coffees.multiplescreens;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ThirdActivity extends AppCompatActivity {
    TextView tvcourse,tvfee;
    EditText etacc,etbank,etcvv,etreason;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        tvcourse = (TextView) findViewById(R.id.textViewcourse);
        tvfee = (TextView) findViewById(R.id.textViewfee);
        etacc = (EditText) findViewById(R.id.editTextacc);
        etbank = (EditText) findViewById(R.id.editTextbank);
        etcvv = (EditText) findViewById(R.id.editTextcvv);
        etreason = (EditText) findViewById(R.id.editTextcan);
        boolean m=false ,n=false,o=false,p=false,q=false,r=false,s=false;
        Intent in = getIntent();
        Bundle b = in.getExtras();
        if(in!=null||!b.isEmpty()){
             m = b.getBoolean("m");
             n = b.getBoolean("n");
             o = b.getBoolean("o");
             p = b.getBoolean("p");
             q = b.getBoolean("q");
             r = b.getBoolean("r");
             s = b.getBoolean("s");

        }
        else{
            finish();
        }
        tvfee.setVisibility(View.VISIBLE);
        tvcourse.setVisibility(View.VISIBLE);
        if(m){
              courseset(b);
              tvfee.setText("Total Fee: 49,967");
        }
        else if(n){
            courseset(b);
            tvfee.setText("Total Fee: 29,978");
        }
        else if(o){
          courseset(b);
          tvfee.setText("Total Fee: 39,978");
        }
        else if(p){
            courseset(b);
           tvfee.setText("Total Fee: 29,978");
        }
        else if(q){
            courseset(b);
            tvfee.setText("Total Fee: 19,989");
        }
        else if(r){
            courseset(b);
            tvfee.setText("Total Fee: 9,989");
        }
        else{
            courseset(b);
            tvfee.setText("Total Fee: 19,989");
        }
    }

     public void courseset(Bundle b)     //FUNCTION to deserialize course object and set tvcourse
    {
        Course course= (Course) b.getSerializable("courseobj");
        String cname = course.getCourse().trim();
        StringBuilder cname1 = new StringBuilder(cname);
        for(int i=0;i<cname1.length();i++){
            if(!Character.isLetter(cname1.charAt(i))){
                if(cname1.charAt(i)=='.'&&i!=0){
                    cname1.insert(i,", ");
                    i+=2;
                }
                else if(i==0){
                    cname1.insert(i,' ');
                    i++;
                }
                else{
                    cname1.deleteCharAt(i);
                    i--;
                }
            }
            else  if(Character.isUpperCase(cname1.charAt(i))&&cname1.charAt(i)!='N'){
                if(i==0){
                    cname1.insert(i,' ');
                    i++;
                }
                else{
                    cname1.insert(i,", ");
                    i+=2;
                }
            }
        }
        tvcourse.setText("Course:"+cname1);
    }

    public void clicked(View view) {
        Intent in2 = new Intent();
        String acc = etacc.getText().toString().trim();
        String name = etbank.getText().toString().trim();
        String cvv = etcvv.getText().toString().trim();
        Bank b = new Bank(name);
        if(acc.length()!=0&&name.length()!=0&&cvv.length()!=0){
            in2.putExtra("obj2",b);   //SERIALIZATION OF BANK CLASS
            setResult(RESULT_OK,in2);
            finish();
        }
        else{
            Toast.makeText(this, "Please enter the required details", Toast.LENGTH_SHORT).show();
        }
     }

    public void clicked2(View view) {
        Intent in1 = new Intent();
        String reason = etreason.getText().toString().trim();
        if(reason.length()!=0){
            in1.putExtra("reason",reason);
            setResult(RESULT_CANCELED, in1);
            finish();
        }
        else{
            Toast.makeText(this, "Please specify reason", Toast.LENGTH_SHORT).show();
        }

    }
}
