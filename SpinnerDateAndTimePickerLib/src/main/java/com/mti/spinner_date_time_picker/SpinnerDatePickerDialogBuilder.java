package com.mti.spinner_date_time_picker;

import android.content.Context;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class SpinnerDatePickerDialogBuilder {

    private Context context;
    private DatePickerDialog.OnDateSetListener callBack;
    private boolean isDayShown = true;
    private boolean isTitleShown = true;
    private int theme = -1;                 //default theme
    private int spinnerTheme = -1;          //default theme
    private Calendar defaultDate = new GregorianCalendar(1980, 0, 1,6,30);
    private Calendar minDate = new GregorianCalendar(1900, 0, 1,0,00);
    private Calendar maxDate = new GregorianCalendar(2100, 0, 1,23,59);
    public static boolean showYear=true;
    public static boolean showMonth=true;
    public static boolean showDay=true;
    public  static boolean showHour=true;
    public static boolean showMinute=true;

    public SpinnerDatePickerDialogBuilder context(Context context) {
        this.context = context;
        return this;
    }

    public SpinnerDatePickerDialogBuilder callback(DatePickerDialog.OnDateSetListener callBack) {
        this.callBack = callBack;
        return this;
    }

    public SpinnerDatePickerDialogBuilder dialogTheme(int theme) {
        this.theme = theme;
        return this;
    }

    public SpinnerDatePickerDialogBuilder spinnerTheme(int spinnerTheme) {
        this.spinnerTheme = spinnerTheme;
        return this;
    }

    public SpinnerDatePickerDialogBuilder defaultDate(int year, int monthIndexedFromZero, int day,int hour,int minute) {
        this.defaultDate = new GregorianCalendar(year, monthIndexedFromZero, day,hour,minute);
        return this;
    }

    public SpinnerDatePickerDialogBuilder minDate(int year, int monthIndexedFromZero, int day,int hour,int minute) {
        this.minDate = new GregorianCalendar(year, monthIndexedFromZero, day,hour,minute);
        return this;
    }

    public SpinnerDatePickerDialogBuilder maxDate(int year, int monthIndexedFromZero, int day,int hour,int minute) {
        this.maxDate = new GregorianCalendar(year, monthIndexedFromZero, day,hour,minute);
        return this;
    }

    public SpinnerDatePickerDialogBuilder showDaySpinner(boolean showDaySpinner) {
        this.isDayShown = showDaySpinner;
        return this;
    }

    public SpinnerDatePickerDialogBuilder showTitle(boolean showTitle) {
        this.isTitleShown = showTitle;
        return this;
    }

    public SpinnerDatePickerDialogBuilder showSpinners(boolean year, boolean month,boolean day,boolean hour, boolean minute){
        showYear=year;
        showMonth=month;
        showDay=day;
        showHour=hour;
        showMinute=minute;

        return this;
    }

    public SpinnerDatePickerDialogBuilder setTitle(CommonDateUtils.DATA_FORMATS_ENUM mDataFormat){
        switch (mDataFormat){

            case MTI_DATE_AND_TIME_FORMAT:
            DatePickerDialog.mTitleDateFormat=CommonDateUtils.MTI_DATE_AND_TIME_FORMAT;
                return this;
            case MTI_DATE_FORMAT:
                DatePickerDialog.mTitleDateFormat= CommonDateUtils.MTI_DATE_FORMAT;
                return this;
            case MTI_TIME_FORMAT:
                DatePickerDialog.mTitleDateFormat= CommonDateUtils.MTI_TIME_FORMAT;
                return this;
            case FULL_DATE_FORMAT:
                DatePickerDialog.mTitleDateFormat=CommonDateUtils.FULL_DATE_FORMAT;
                return this;
            case NO_YEAR_DATE_FORMAT:
                DatePickerDialog.mTitleDateFormat=CommonDateUtils.NO_YEAR_DATE_FORMAT;
                return this;
            case DATE_AND_TIME_FORMAT:
                DatePickerDialog.mTitleDateFormat=CommonDateUtils.DATE_AND_TIME_FORMAT;
                return this;
            case NO_YEAR_DATE_AND_TIME_FORMAT:
                DatePickerDialog.mTitleDateFormat=CommonDateUtils.NO_YEAR_DATE_AND_TIME_FORMAT;
                return this;

            case MTI_TIMER_FORMAT:
                DatePickerDialog.mTitleDateFormat=CommonDateUtils.MTI_TIMER_FORMAT;
                return this;
        }

      return this;
    }
    public DatePickerDialog build() {
        if (context == null) throw new IllegalArgumentException("Context must not be null");
        if (maxDate.getTime().getTime() <= minDate.getTime().getTime()) throw new IllegalArgumentException("Max date is not after Min date");

        return new DatePickerDialog(context, theme, spinnerTheme, callBack, defaultDate, minDate, maxDate, isDayShown, isTitleShown);
    }
}