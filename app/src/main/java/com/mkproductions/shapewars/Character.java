package com.mkproductions.shapewars;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * Created by Martin on 13.01.2017.
 */

public class Character {
    private Bitmap bitmap;
    private int x;
    private int y;

    public Character(Context context){
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.mipmap.main_character);
        x = 200;
        y = 200;
    }

    public void MoveCharacter(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Bitmap getBitmap(){
        return bitmap;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }
}
