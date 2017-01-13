package com.mkproductions.shapewars;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Martin on 12.01.2017.
 */


public class Game extends SurfaceView implements Runnable {

    private boolean playing;
    private SurfaceHolder surfaceHolder;
    private Canvas canvas;
    private Paint paint;
    private Character character;
    private Thread gameThread = null;


    public Game(Context context){
        super(context);
        paint = new Paint();
        surfaceHolder = getHolder();
        character = new Character(context);
    }

    @Override
    public void run(){
        while (playing){
            draw();
            control();
        }
    }

    private void control(){
        try{
            gameThread.sleep(1);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public void pause(){
        playing = false;
        try{
            gameThread.join();
        }catch (InterruptedException e){

        }
    }

    public void start(){
        playing = true;
        gameThread = new Thread(this);
        gameThread.start();
    }

    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                character.MoveCharacter(x, y);
            case MotionEvent.ACTION_UP:
                character.MoveCharacter(x, y);
            case MotionEvent.ACTION_MOVE:
                character.MoveCharacter(x, y);
                break;
        }
        return true;
    }

    private void draw(){
        if(surfaceHolder.getSurface().isValid()){
            canvas = surfaceHolder.lockCanvas();
            canvas.drawColor(Color.CYAN);

            paint.setColor(Color.WHITE);
            canvas.drawBitmap(character.getBitmap(), character.getX(), character.getY(), paint);

            surfaceHolder.unlockCanvasAndPost(canvas);
        }
    }
}
