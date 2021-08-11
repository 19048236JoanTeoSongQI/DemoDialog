package sg.edu.rp.c346.id19048236.demodialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button btnDemo1,btnDemo2,btnDemo3,btnExercise,btnDemo4,btnDemo5;
    TextView tvDemo2, tvDemo3,tvResult,tvDemo4,tvDemo5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDemo1=findViewById(R.id.buttonDemo1);
        btnDemo2=findViewById(R.id.buttonDemo2);
        btnDemo3=findViewById(R.id.buttonDemo3);
        btnExercise=findViewById(R.id.buttonExercise);
        btnDemo4=findViewById(R.id.buttonDemo4);
        btnDemo5=findViewById(R.id.buttonDemo5);

        tvDemo2=findViewById(R.id.textViewDemo2);
        tvDemo3=findViewById(R.id.textViewDemo3);
        tvResult=findViewById(R.id.textViewResult);
        tvDemo4=findViewById(R.id.textViewDemo4);
        tvDemo5=findViewById(R.id.textViewDemo5);


        btnDemo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder myBuilder= new AlertDialog.Builder(MainActivity.this);
               /*
                myBuilder.setTitle("Demo 1");
                myBuilder.setMessage("I can develop app");
                myBuilder.setCancelable(false);
                myBuilder.setPositiveButton("Close",null);
                */
                myBuilder.setTitle("Congratulations");
                myBuilder.setMessage("You have completed a single Dialog Box");
                myBuilder.setCancelable(false);
                myBuilder.setPositiveButton("Dismiss",null);
                AlertDialog myDialog= myBuilder.create();
                myDialog.show();

            }
        });
        btnDemo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder myBuilder= new AlertDialog.Builder(MainActivity.this);

                myBuilder.setTitle("Demo 2 Buttons Dialog");
                myBuilder.setMessage("Select one of the Buttons below.");
                myBuilder.setCancelable(false);

                myBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        tvDemo2.setText("You have selected Negative");
                    }
                });

                myBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        tvDemo2.setText("You have selected Positive");
                    }
                });

                myBuilder.setNeutralButton("Cancel",null);
                AlertDialog myDialog=myBuilder.create();
                myDialog.show();

            }
        });
        btnDemo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater=(LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View viewDialog=inflater.inflate(R.layout.input,null);

                final EditText etInput=viewDialog.findViewById(R.id.editTextInput);

                AlertDialog.Builder myBuilder= new AlertDialog.Builder(MainActivity.this);
                myBuilder.setView(viewDialog);
                myBuilder.setTitle("Demo 3-Text Input Dialog");
                myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String message =etInput.getText().toString();
                        tvDemo3.setText(message);
                    }
                });
                myBuilder.setNegativeButton("CANCEL",null);
                AlertDialog myDialog=myBuilder.create();
                myDialog.show();
            }
        });
        btnExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater=(LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View viewDialog=inflater.inflate(R.layout.input2,null);

                final EditText etNum1=viewDialog.findViewById(R.id.editTextNum1);
                final EditText etNum2=viewDialog.findViewById(R.id.editTextNum2);


                AlertDialog.Builder myBuilder= new AlertDialog.Builder(MainActivity.this);
                myBuilder.setView(viewDialog);
                myBuilder.setTitle("Exercise 3");
                myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        int num1 = Integer.parseInt(etNum1.getText().toString());
                        int num2 = Integer.parseInt(etNum2.getText().toString());

                        int total = num1 + num2;

                        String message = String.format("The sum is " + total);

                        tvResult.setText(message);
                    }
                });
                myBuilder.setNegativeButton("CANCEL",null);
                AlertDialog myDialog=myBuilder.create();
                myDialog.show();

            }
        });
        btnDemo4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog.OnDateSetListener myDateListener= new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthofYear, int dayOfMonth) {
                        tvDemo4.setText("Date: "+dayOfMonth + "/" + (monthofYear+1) + "/" +year);
                    }
                };
                DatePickerDialog myDateDialog=new DatePickerDialog(MainActivity.this,myDateListener,2014,11,31);
                myDateDialog.show();
            }
        });

        btnDemo5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog.OnTimeSetListener myTimeListener= new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        tvDemo5.setText("Time: "+ hourOfDay + ":" +minute);
                    }
                };
                /*TimePickerDialog myTimeDialog=new TimePickerDialog(MainActivity.this,myTimeListener,20,00,false);

                myTimeDialog.show();
                 */
                Calendar now= Calendar.getInstance();
                int hourOfDay=now.get(Calendar.HOUR_OF_DAY);
                int minute=now.get(Calendar.MINUTE);
                TimePickerDialog myTimeDialog=new TimePickerDialog(MainActivity.this,myTimeListener,hourOfDay,minute,true);

                myTimeDialog.show();
            }
        });

    }
}