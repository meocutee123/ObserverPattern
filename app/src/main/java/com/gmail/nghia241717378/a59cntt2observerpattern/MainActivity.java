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
import com.gmail.nghia241717378.a59cntt2observerpattern.Untilites.MyTimeDialog;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements MyDialog.onMyDateChangeListener, MyTimeDialog.OnMyTimeChangeListener {
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
                MyDialog myDialog = new MyDialog(Calendar.getInstance(),MainActivity.this,MainActivity.this);
                myDialog.showDialog();

            }
        });
        imgTimePicker.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                MyTimeDialog myTimeDialog = new MyTimeDialog(MainActivity.this, Calendar.getInstance(), MainActivity.this);
                myTimeDialog.showTimeDialog();

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

    @Override
    public void timeUpdate(Calendar newTime) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(newTime.get(Calendar.HOUR_OF_DAY)).append(":")
                .append(newTime.get(Calendar.MINUTE));

        edtGioDi.setText(stringBuilder.toString());
    }
}
