package com.mkproductions.shapewars;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Martin on 12.01.2017.
 */


public class Game{

    private final int FPS = 40;
    Timer timer;
    ImageView mainCharacter;
    Bitmap bitmap;
    Canvas canvas;


    public Game(ImageView mainCharacter){
        this.mainCharacter = mainCharacter;
        bitmap = Bitmap.createBitmap(100, 100, Bitmap.Config.ARGB_8888);
        canvas = new Canvas(bitmap);
    }

    public void startRun(){
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
                                      @Override
                                      public void run() {
                                          System.out.println("Started from runnable thread");
                                      }
                                  },0, 1000 / FPS
        );
    }

    public void stopRun(){
        timer.cancel();
        System.out.println("Stopped runnable thread");
    }

    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mainCharacter.setX(x - mainCharacter.getWidth() / 2);
                mainCharacter.setY(y - mainCharacter.getHeight() * 2);
                fireProjectile();
            case MotionEvent.ACTION_UP:
                mainCharacter.setX(x - mainCharacter.getWidth() / 2);
                mainCharacter.setY(y - mainCharacter.getHeight() * 2);
            case MotionEvent.ACTION_MOVE:
                mainCharacter.setX(x - mainCharacter.getWidth() / 2);
                mainCharacter.setY(y - mainCharacter.getHeight() * 2);
                break;
        }
        return true;
    }

    private void fireProjectile(){
        System.out.println("Fire projectile");
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(10);
        canvas.drawRect(100, 100, 100, 100, paint);
    }


}
