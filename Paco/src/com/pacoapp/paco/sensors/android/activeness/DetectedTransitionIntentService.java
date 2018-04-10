package com.pacoapp.paco.sensors.android.activeness;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import com.google.android.gms.location.ActivityTransitionEvent;
import com.google.android.gms.location.ActivityTransitionResult;

import static com.pacoapp.paco.sensors.android.BroadcastTriggerReceiver.PACO_EXPERIMENT_ACTIVENESS_ACTION;

public class DetectedTransitionIntentService extends IntentService {

  private static String TAG = DetectedTransitionIntentService.class.getSimpleName();

  public DetectedTransitionIntentService() {
    super("DetectedTransitionIntentService");
  }

  @Override
  protected void onHandleIntent(Intent intent) {
    Log.e(TAG, "I am in the handle intent of the activity recognition stuff");
    if (intent != null) {
      if (ActivityTransitionResult.hasResult(intent)) {
        ActivityTransitionResult result = ActivityTransitionResult.extractResult(intent);
        for (ActivityTransitionEvent event : result.getTransitionEvents()) {
          // chronological sequence of events....
          Log.e(TAG, "Type: " + event.getActivityType());
          Log.e(TAG, "Transition: " + event.getTransitionType());
          Intent toBroadcast = new Intent(PACO_EXPERIMENT_ACTIVENESS_ACTION);
          sendBroadcast(toBroadcast); // Just reporting all for now.
          //TODO (jos) this will need some more logic, like choosing which transitiona to report.
          if (event.getActivityType() == 3 && event.getTransitionType() == 0) {
//                        if (Constants.isNotificationAllowed(this, "activity_recognition"))
//                            Constants.createNotification(this, EMAActivity.class, ACTIVITY_TRIGGER_SERVICE_ACTION);
          }
        }
      }
    }
  }
}
