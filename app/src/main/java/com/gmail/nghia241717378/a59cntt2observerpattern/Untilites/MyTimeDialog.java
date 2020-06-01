package com.gmail.nghia241717378.a59cntt2observerpattern.Untilites;


import android.app.DatePickerDialog;
import android.content.Context;

import android.app.TimePickerDialog;
import android.widget.TimePicker;

import java.util.Calendar;

public class MyTimeDialog {
    private Context context;
    private Calendar calendar;
    private OnMyTimeChangeListener onMyTimeChangeListener;

    public MyTimeDialog(Context context, Calendar calendar, OnMyTimeChangeListener onMyTimeChangeListener)
    {
        this.context = context;
        this.calendar = calendar;
        this.onMyTimeChangeListener = onMyTimeChangeListener;

    }
    public void showTimeDialog(){
        TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hourOfDate, int minute) {
                calendar.set(Calendar.HOUR_OF_DAY, hourOfDate);
                calendar.set(Calendar.MINUTE, minute);
                if(onMyTimeChangeListener != null)
                    onMyTimeChangeListener.timeUpdate(calendar);
            }
        };
        TimePickerDialog timePickerDialog = new TimePickerDialog(context, onTimeSetListener, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE),true );
        timePickerDialog.show();
    }
    public static interface OnMyTimeChangeListener{
        public void timeUpdate(Calendar newTime);
    }
}
