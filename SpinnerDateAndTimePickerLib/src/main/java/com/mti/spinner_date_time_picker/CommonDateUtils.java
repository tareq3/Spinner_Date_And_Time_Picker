package com.mti.spinner_date_time_picker;/*
 * Copyright (C) 2012 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */
import java.text.SimpleDateFormat;
import java.util.Locale;
/**
 * Common date utilities.
 */
public class CommonDateUtils {

    public static enum DATA_FORMATS_ENUM{
        MTI_TIMER_FORMAT,NO_YEAR_DATE_FORMAT,FULL_DATE_FORMAT,DATE_AND_TIME_FORMAT,MTI_DATE_AND_TIME_FORMAT,MTI_DATE_FORMAT,MTI_TIME_FORMAT,NO_YEAR_DATE_AND_TIME_FORMAT
    }
    // All the SimpleDateFormats in this class use the UTC timezone
        public static final SimpleDateFormat NO_YEAR_DATE_FORMAT =
            new SimpleDateFormat("--MM-dd", Locale.US);
    public static final SimpleDateFormat FULL_DATE_FORMAT =
            new SimpleDateFormat("yyyy-MM-dd", Locale.US);
    public static final SimpleDateFormat DATE_AND_TIME_FORMAT =
            new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);

    public static final SimpleDateFormat MTI_DATE_AND_TIME_FORMAT=
            new SimpleDateFormat("'Date: 'yyyy-MMM-dd ' \n ' 'Time: ' hh:mm a", Locale.US);

    public static final SimpleDateFormat MTI_DATE_FORMAT=
            new SimpleDateFormat("'Date: 'yyyy-MMM-dd ", Locale.US);


    public static final SimpleDateFormat MTI_TIME_FORMAT=
            new SimpleDateFormat(" 'Time: ' hh:mm a ", Locale.US);

    public static final SimpleDateFormat NO_YEAR_DATE_AND_TIME_FORMAT =
            new SimpleDateFormat("--MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);

    public static final SimpleDateFormat MTI_TIMER_FORMAT=
            new SimpleDateFormat("  HH'h' : mm'm' ", Locale.US);

    /**
     * Exchange requires 8:00 for birthdays
     */
    public final static int DEFAULT_HOUR = 8;
}