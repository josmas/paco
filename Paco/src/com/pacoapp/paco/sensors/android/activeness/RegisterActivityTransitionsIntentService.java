package com.pacoapp.paco.sensors.android.activeness;

import android.app.IntentService;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.google.android.gms.location.ActivityRecognition;
import com.google.android.gms.location.ActivityRecognitionClient;
import com.google.android.gms.location.ActivityTransition;
import com.google.android.gms.location.ActivityTransitionRequest;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

import java.util.ArrayList;
import java.util.List;


public class RegisterActivityTransitionsIntentService extends IntentService {

  private static String TAG = RegisterActivityTransitionsIntentService.class.getSimpleName();
  private static int ACTIVITY_TRANSITION_REQUEST_CODE = 10090;
  private ActivityRecognitionClient activityRecognitionClient;
  private Context context;

  public RegisterActivityTransitionsIntentService() {
    super("RegisterActivityTransitionsIntentService");
  }

  @Override
  protected void onHandleIntent(Intent intent) {
    context = getApplicationContext();
    activityRecognitionClient = ActivityRecognition.getClient(context);
    requestTransitionUpdatesButtonHandler();
  }

  public void requestTransitionUpdatesButtonHandler() {
    Log.i(TAG, "Requesting Transitions");
    List<ActivityTransition> transitions = new ArrayList<>();

    transitions.add(
        new ActivityTransition.Builder()
            .setActivityType(DetectedActivity.STILL)
            .setActivityTransition(ActivityTransition.ACTIVITY_TRANSITION_ENTER)
            .build());

    transitions.add(
        new ActivityTransition.Builder()
            .setActivityType(DetectedActivity.ON_BICYCLE)
            .setActivityTransition(ActivityTransition.ACTIVITY_TRANSITION_EXIT)
            .build());

    transitions.add(
        new ActivityTransition.Builder()
            .setActivityType(DetectedActivity.RUNNING)
            .setActivityTransition(ActivityTransition.ACTIVITY_TRANSITION_EXIT)
            .build());

    transitions.add(
        new ActivityTransition.Builder()
            .setActivityType(DetectedActivity.WALKING)
            .setActivityTransition(ActivityTransition.ACTIVITY_TRANSITION_EXIT)
            .build());


    Intent intent = new Intent(this, DetectedTransitionIntentService.class);
    PendingIntent transitionPendingIntent = PendingIntent.getService(this,
        ACTIVITY_TRANSITION_REQUEST_CODE, intent, PendingIntent.FLAG_UPDATE_CURRENT);
    ActivityTransitionRequest request = new ActivityTransitionRequest(transitions);
    Task<Void> task = activityRecognitionClient.requestActivityTransitionUpdates(request,
        transitionPendingIntent);

    task.addOnSuccessListener(
        new OnSuccessListener<Void>() {
          @Override
          public void onSuccess(Void result) {
            Log.i(TAG, "Transition updates set up");
          }
        }
    );

    task.addOnFailureListener(
        new OnFailureListener() {
          @Override
          public void onFailure(Exception e) {
            //TODO (jos) FIXME report to Crashlytics? or notify user?
            Log.e(TAG, "Transition updates FAILED to be set up");
            Log.e(TAG, "Transition updates FAILED to be set up: " + e.getMessage());
          }
        }
    );
  }
}
