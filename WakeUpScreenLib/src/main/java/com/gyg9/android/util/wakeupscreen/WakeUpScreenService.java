package com.gyg9.android.util.wakeupscreen;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.PowerManager;
import android.widget.Toast;

public class WakeUpScreenService extends Service {

	private PowerManager.WakeLock wl;
	private Toast t;

	public WakeUpScreenService() {
	}

	@Override
	public IBinder onBind(Intent intent) {
		// TODO: Return the communication channel to the service.
		throw new UnsupportedOperationException("Not yet implemented");
	}

	@Override
	public void onStart(Intent intent, int startId) {
		super.onStart(intent, startId);
		wakeup();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		releaseLock();
	}

	private void wakeup() {
		if (null == wl) {
			PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
			wl = pm.newWakeLock(PowerManager.SCREEN_BRIGHT_WAKE_LOCK | PowerManager.ACQUIRE_CAUSES_WAKEUP, "My Tag");
		}
		wl.acquire();
		showMsg("wakeup");

	}

	private void releaseLock() {
		if (null != wl) {
			wl.release();
			showMsg("release");
		}
	}

	private void showMsg(String str) {
		if (null == t) {
			t = Toast.makeText(this, str, Toast.LENGTH_LONG);
		} else {
			t.setText(str);
		}
		t.show();
	}
}
