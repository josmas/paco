package com.pacoapp.paco;

import android.app.AlarmManager;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;

import com.pacoapp.paco.sensors.android.activeness.RegisterActivityTransitionsIntentService;
import com.pacoapp.paco.sensors.noice.NoiseService;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import im.delight.android.languages.Language;

public class PacoApplication extends Application {

  private static final int NOISE_REQUEST_CODE = 1000098; // couldn't be any more random!
  private static Logger Log = LoggerFactory.getLogger(PacoApplication.class);

  public static final String CUSTOM_LANGUAGE_KEY = "customLanguageKey";

  protected PendingIntent pendingIntent;

  @Override
  public void onCreate() {
    super.onCreate();
    DateTime.now(); // load this early to try to circumvent joda bug
    Language.setFromPreference(this, CUSTOM_LANGUAGE_KEY);
    //TODO FIXME (jos) this is just for testing; no way this can go here! Also has to go onBoot.
    Intent activityRegister = new Intent(this, RegisterActivityTransitionsIntentService.class);
    startService(activityRegister);
    Log.error("Just REGISTERED the service to look for location/activity recognition!");
    setupNoiceAlarms();
  }

  private void setupNoiceAlarms() {
    AlarmManager alarmMgr = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
    Intent alarmReceiverIntent = new Intent(this, NoiseService.class);
    Calendar calendar = Calendar.getInstance();
    Calendar now = Calendar.getInstance();
    calendar.setTimeInMillis(System.currentTimeMillis());
    calendar.set(Calendar.SECOND, now.get(Calendar.SECOND) + 5); // 5 arbitrary seconds from now
    if(calendar.before(now)){
      calendar.add(Calendar.DATE, 1);
    }

    PendingIntent alarmIntent = PendingIntent.getService(this, NOISE_REQUEST_CODE,
        alarmReceiverIntent, PendingIntent.FLAG_CANCEL_CURRENT);
    alarmMgr.setInexactRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
        AlarmManager.INTERVAL_FIFTEEN_MINUTES, alarmIntent);

    // for debugging
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
    dateFormat.setTimeZone(calendar.getTimeZone());
    Log.error("NoiseAlarmManager", "Set an alarm for " + dateFormat.format(calendar.getTime()));
  }

  @Override
  public void onConfigurationChanged(Configuration newConfig) {
    super.onConfigurationChanged(newConfig);

    Language.setFromPreference(this, CUSTOM_LANGUAGE_KEY);
  }

}
