package com.example.labwork1;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class Intro extends AppCompatActivity {

    private SleepTask sleepTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        sleepTask = new SleepTask(this);
        sleepTask.execute();
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        sleepTask.cancel(true);
    }

    public void onSplashScreenEnd() { //переключать активити и с помощью finish закрывает
        Intent i = new Intent(Intro.this, MainActivity.class);
        startActivity(i);
        finish();
    }

    private static class SleepTask extends AsyncTask<Void, Void, Void> {
        final Intro listener;

        SleepTask(Intro listener) {
            super();
            this.listener = listener;
        }

        @Override
        protected Void doInBackground(Void... params) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            if (listener != null)
                listener.onSplashScreenEnd();
        }
    }
}