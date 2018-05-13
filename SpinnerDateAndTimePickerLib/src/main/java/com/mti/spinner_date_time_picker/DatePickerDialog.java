package com.mti.spinner_date_time_picker;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.text.DateFormat;
import java.util.Calendar;

/**
 * A fork of the Android Open Source Project DatePickerDialog class
 */
public class DatePickerDialog extends AlertDialog implements OnClickListener,
        OnDateChangedListener {

    private static final String YEAR = "year";
    private static final String MONTH = "month";
    private static final String DAY = "day";
    private static final String Hour="hour";
    private static final String Minute="minute";
    private static final String TITLE_SHOWN = "title_enabled";

    private final DatePicker mDatePicker;
    private final OnDateSetListener mCallBack;
    public static DateFormat mTitleDateFormat;

    private boolean mIsDayShown = true;
    private boolean mIsTitleShown = true;

    /**
     * The callback used to indicate the user is done filling in the date.
     */
    public interface OnDateSetListener {
        /**
         * @param view        The view associated with this listener.
         * @param year        The year that was set
         * @param monthOfYear The month that was set (0-11) for compatibility
         *                    with {@link java.util.Calendar}.
         * @param dayOfMonth  The day of the month that was set.
         */
        void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth,int hour, int minute);
    }

    DatePickerDialog(Context context,
                     int theme,
                     int spinnerTheme,
                     OnDateSetListener callBack,
                     Calendar defaultDate,
                     Calendar minDate,
                     Calendar maxDate,
                     boolean isDayShown,
                     boolean isTitleShown
                    ) {
        super(context, theme);

        mCallBack = callBack;
       // mTitleDateFormat = DateFormat.getDateInstance(DateFormat.LONG);
        if(mTitleDateFormat==null)    mTitleDateFormat=CommonDateUtils.MTI_DATE_FORMAT;
        mIsDayShown = isDayShown;
        mIsTitleShown = isTitleShown;

        updateTitle(defaultDate);

        setButton(BUTTON_POSITIVE, context.getText(android.R.string.ok),
                this);
        setButton(BUTTON_NEGATIVE, context.getText(android.R.string.cancel),
                (OnClickListener) null);

        LayoutInflater inflater =
                (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.date_picker_dialog_container, null);

        setView(view);
        mDatePicker = new DatePicker((ViewGroup) view, spinnerTheme);
        mDatePicker.setMinDate(minDate.getTimeInMillis());
        mDatePicker.setMaxDate(maxDate.getTimeInMillis());
        mDatePicker.init(defaultDate.get(Calendar.YEAR), defaultDate.get(Calendar.MONTH), defaultDate.get(Calendar.DAY_OF_MONTH),
                defaultDate.get(Calendar.HOUR_OF_DAY),defaultDate.get(Calendar.MINUTE),
                isDayShown, this);

    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        if (mCallBack != null) {
            mDatePicker.clearFocus();
            mCallBack.onDateSet(mDatePicker, mDatePicker.getYear(),
                    mDatePicker.getMonth(), mDatePicker.getDayOfMonth(),mDatePicker.getHour(),mDatePicker.getMinute());
        }
    }

    @Override
    public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth, int hour, int minute) {
        Calendar updatedDate = Calendar.getInstance();
        updatedDate.set(Calendar.YEAR, year);
        updatedDate.set(Calendar.MONTH, monthOfYear);
        updatedDate.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        updatedDate.set(Calendar.HOUR_OF_DAY,hour);
        updatedDate.set(Calendar.MINUTE,minute);
        updateTitle(updatedDate);
    }

    private void updateTitle(Calendar updatedDate) {
        if(mIsTitleShown) {
            final DateFormat dateFormat = mTitleDateFormat;
            setTitle(dateFormat.format(updatedDate.getTime()));

        } else {
            setTitle(" ");
        }
    }

    @Override
    public Bundle onSaveInstanceState() {
        Bundle state = super.onSaveInstanceState();
        state.putInt(YEAR, mDatePicker.getYear());
        state.putInt(MONTH, mDatePicker.getMonth());
        state.putInt(DAY, mDatePicker.getDayOfMonth());
        state.putInt(Hour,mDatePicker.getHour());
        state.putInt(Minute,mDatePicker.getMinute());
        state.putBoolean(TITLE_SHOWN, mIsTitleShown);
        return state;
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        int year = savedInstanceState.getInt(YEAR);
        int month = savedInstanceState.getInt(MONTH);
        int day = savedInstanceState.getInt(DAY);
        int hour=savedInstanceState.getInt(Hour);
        int minute=savedInstanceState.getInt(Minute);
        mIsTitleShown = savedInstanceState.getBoolean(TITLE_SHOWN);
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, day);
        c.set(Calendar.HOUR_OF_DAY,hour);
        c.set(Calendar.MINUTE,minute);
        updateTitle(c);
        mDatePicker.init(year, month, day,hour,minute,  mIsDayShown, this);
    }
}