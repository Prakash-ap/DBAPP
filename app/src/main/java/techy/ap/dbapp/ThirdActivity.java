package techy.ap.dbapp;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class ThirdActivity extends AppCompatActivity {
    private EditText name,paname,paphone,date,time;
    private Button book,view_book;
    final Calendar calendar=Calendar.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        name = findViewById(R.id.edt_docname);
        paname = findViewById(R.id.edt_patname);
        paphone = findViewById(R.id.edt_patno);
        date = findViewById(R.id.edt_date);
        time = findViewById(R.id.edt_time);

        final DatePickerDialog.OnDateSetListener dateformat = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, month);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();

            }
        };

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(ThirdActivity.this, dateformat,calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show();


            }
        });

        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar currenttime=Calendar.getInstance();
                int hour=currenttime.get(Calendar.HOUR_OF_DAY);
                int minute=currenttime.get(Calendar.MINUTE);
                int seconds=currenttime.get(Calendar.SECOND);

                TimePickerDialog timePickerDialog;
                timePickerDialog=new TimePickerDialog(ThirdActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        time.setText(hourOfDay +":"+minute);
                    }
                },hour,minute,true);
                timePickerDialog.setTitle("Select Time");
                timePickerDialog.show();


            }
        });
    }


    private void updateLabel() {
        String format="MM/dd/yyyy";
        SimpleDateFormat sdf=new SimpleDateFormat(format, Locale.getDefault());
        date.setText(sdf.format(calendar.getTime()));


    }

    public void selectTime(View view) {

    }
}
