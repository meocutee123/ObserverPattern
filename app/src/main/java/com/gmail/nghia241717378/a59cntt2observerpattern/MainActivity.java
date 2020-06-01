package com.gmail.nghia241717378.a59cntt2observerpattern;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TimePicker;

import com.gmail.nghia241717378.a59cntt2observerpattern.Untilites.MyDialog;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements MyDialog.onMyDateChangeListener {
     EditText edtNgayDi, edtGioDi;
     ImageView imgDatePicker, imgTimePicker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addEvents();
        addViews();
    }

    private void addEvents() {
        edtNgayDi = findViewById(R.id.edtNgayDi);
        edtNgayDi.setEnabled(false);
        edtGioDi = findViewById(R.id.edtGioDi);
        edtGioDi.setEnabled(false);
        imgDatePicker = findViewById(R.id.imgDatePicker);
        imgTimePicker = findViewById(R.id.ImgTimePicker);



    }

    private void addViews() {
        imgDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDialog myDialog = new MyDialog(Calendar.getInstance(),
                        MainActivity.this,
                        MainActivity.this);
                myDialog.showDialog();

            }
        });
        imgTimePicker.setOnClickListener(new View.OnClickListener() {
            Calendar calendar = Calendar.getInstance();
            final int hour = calendar.get(Calendar.HOUR_OF_DAY);
            final int minute = calendar.get(Calendar.MINUTE);
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        edtGioDi.setText(hourOfDay + ":" + minute);
                    }
                }, hour, minute, DateFormat.is24HourFormat(MainActivity.this));
                timePickerDialog.show();

            }
        });
    }

    @Override
    public void updateDate(Calendar newDate) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(newDate.get(Calendar.DAY_OF_MONTH)).append("/")
                .append(newDate.get(Calendar.MONTH) + 1).append("/")
                .append(newDate.get(Calendar.YEAR));
        edtNgayDi.setText(stringBuilder.toString());
    }

}
