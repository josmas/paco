package com.pacoapp.paco.sensors.noice;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import ie.dcu.cs.noice.Analyser;

import static com.pacoapp.paco.sensors.android.BroadcastTriggerReceiver.PACO_EXPERIMENT_NOICE_ACTION;

public class NoiseService extends IntentService {

  private static String TAG = NoiseService.class.getSimpleName();
  public static final long NOISE_THRESHOLD = 75; // Aware defaults to 50, Brookes suggested 75
  public static final int SAMPLE_SIZE = 10; // Aware defaults to 30 (seconds).

  public NoiseService() {
    super("NoiseService");
  }

  @Override
  protected void onHandleIntent(Intent intent) {

    //TODO (jos) will have to deal with permissions! FIXME
    // For now rely on permissions in manifest for target version 22
      final Analyser an = new Analyser(this);
      boolean silent = an.isSilent(NOISE_THRESHOLD, SAMPLE_SIZE);
      Log.i("NoiseService", "Is Silent? "  + silent);

      if (silent) { // Testing with silent for now!!!!! FIXME //TODO (jos)
        //Leaving it like this for demo purposes, just add at least 10 minutes between signals.
        Intent toBroadcast = new Intent(PACO_EXPERIMENT_NOICE_ACTION);
        sendBroadcast(toBroadcast); // Just reporting all for now.
      }
  }
}
