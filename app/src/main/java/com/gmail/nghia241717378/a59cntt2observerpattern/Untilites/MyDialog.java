package com.gmail.nghia241717378.a59cntt2observerpattern.Untilites;

import android.app.DatePickerDialog;
import android.content.Context;
import android.widget.DatePicker;

import java.util.Calendar;

public class MyDialog {
    private Calendar calendar;
    private onMyDateChangeListener onMyDateChangeListener;
    private Context context;


    public MyDialog(Calendar calendar, MyDialog.onMyDateChangeListener onMyDateChangeListener, Context context) {
        this.calendar = calendar;
        this.onMyDateChangeListener = onMyDateChangeListener;
        this.context = context;
    }

    public void showDialog(){
        final DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener(){

            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(year, month, dayOfMonth);
                onMyDateChangeListener.updateDate(calendar);
            }
        };
        DatePickerDialog datePickerDialog = new DatePickerDialog(context, onDateSetListener,
                calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE)){

        };
        datePickerDialog.show();;
    }
    public interface onMyDateChangeListener{

        void updateDate(Calendar newDate);


    }
}
