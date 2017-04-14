package com.example.strainu.edp_lab3;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by strainu on 4/14/17.
 */

public class DrawView extends View {
    Paint paint;

    public DrawView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(10);
        canvas.drawLine(0, 0, 100, 100, paint);
        canvas.drawLine(100, 0, 0, 100, paint);
    }

}
