package com.pacoapp.paco;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import android.app.AlarmManager;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.res.Configuration;

import com.pacoapp.paco.sensors.android.ActivenessBroadcastReceiver;
import com.pacoapp.paco.sensors.android.activeness.RegisterActivityTransitionsIntentService;

import im.delight.android.languages.Language;

public class PacoApplication extends Application {

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
  }

  @Override
  public void onConfigurationChanged(Configuration newConfig) {
    super.onConfigurationChanged(newConfig);

    Language.setFromPreference(this, CUSTOM_LANGUAGE_KEY);
  }

}
