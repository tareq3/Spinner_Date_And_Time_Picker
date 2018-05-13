package com.mti.date_and_time_picker;




import android.annotation.TargetApi;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mti.spinner_date_time_picker.CommonDateUtils;
import com.mti.spinner_date_time_picker.DatePicker;
import com.mti.spinner_date_time_picker.DatePickerDialog;
import com.mti.spinner_date_time_picker.SpinnerDatePickerDialogBuilder;


import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;


public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    TextView dateTextView;
    Button dateButton;
    SimpleDateFormat simpleDateFormat;

    @TargetApi(Build.VERSION_CODES.N)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dateButton = (Button) findViewById(R.id.button);
        dateTextView = (TextView) findViewById(R.id.textView);
        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd / HH-mm", Locale.US);
        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDate(2018, 6, 15, R.style.DatePickerSpinner);
            }
        });
    }




    @VisibleForTesting
    void showDate(int year, int monthOfYear, int dayOfMonth, int spinnerTheme) {

        new SpinnerDatePickerDialogBuilder()
                .context(MainActivity.this)
                .callback(MainActivity.this)
                .spinnerTheme(spinnerTheme)
                .showTitle(true)

                .defaultDate(year, monthOfYear, dayOfMonth,13,30)
                .maxDate(2018, 11, 31,23,59)
                .minDate(2018, 0, 1,0,0)
                .showSpinners(false,false,false,true,true)
                .setTitle(CommonDateUtils.DATA_FORMATS_ENUM.MTI_TIMER_FORMAT)
                .build()
                .show();


       /* new SpinnerDatePickerDialogBuilder()
                .context(MainActivity.this)
                .callback(MainActivity.this)
                .spinnerTheme(spinnerTheme)
                .showTitle(true)
                .showDay(true)
                .defaultDate(2017, 0, 1)
                .maxDate(2020, 0, 1)
                .minDate(2000, 0, 1)
                 .showSpinners(false,true,true)
                .build()
                .show();*/
    }

    @TargetApi(Build.VERSION_CODES.N)
    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth, int hour, int minute) {
        Calendar calendar = new GregorianCalendar(year, monthOfYear, dayOfMonth,hour,minute);
        dateTextView.setText(simpleDateFormat.format(calendar.getTime()));
    }
}