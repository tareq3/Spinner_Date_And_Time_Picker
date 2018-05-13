# Spinner_Date_And_Time_Picker
This is a emphasized edition of SpinnerDatePicker

#1:
```
allprojects {
		repositories {
			...
			
			maven { url 'https://jitpack.io' }
		}
	}
```
#2:
```
dependencies {

	       implementation 'com.github.tareq3:Spinner_Date_And_Time_Picker:1.0'
	}
```


#How to Use:

Edit Style for AlertDialog:
```
<style name="NumberPickerStyle">
    <item name="android:textSize">22dp</item>
    <item name="android:textColorPrimary">@color/colorAccent</item>
    <item name="android:colorControlNormal" tools:targetApi="lollipop">@color/colorAccent</item>
</style>
````
For Creating Spinner use this Builder:

```
  new SpinnerDatePickerDialogBuilder()
                .context(MainActivity.this)
                .callback(MainActivity.this)
                .spinnerTheme(spinnerTheme) //refer NumberPicker Style Here
                .showTitle(true)
                .defaultDate(2018, 11, 07,13,30)  //yyyy,MM,dd,HH,mm
                .maxDate(2018, 11, 31,23,59)      //yyyy,MM,dd,HH,mm
                .minDate(2018, 0, 1,0,0)          //yyyy,MM,dd,HH,mm
                .showSpinners(false,false,false,true,true)    // YearSpinner,MonthSpinner,DateSpinner,HourSpinner,MinuteSpinner
                .setTitle(CommonDateUtils.DATA_FORMATS_ENUM.MTI_TIMER_FORMAT) //Change that into Date or DateTime instead of Timer
                .build()
                .show();
```

Creadit: 
I used [SpinnerDatePicker](https://android-arsenal.com/details/1/6319)  library by [David Rawson (drawers)](https://android-arsenal.com/user/drawers) as a base for development.

