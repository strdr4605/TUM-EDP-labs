package com.example.strainu.edp_lab3;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;

/**
 * Created by strainu on 4/14/17.
 */

public class DrawView extends View {
    Paint paint;
    Path path;

    public DrawView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawLines(5, canvas);
        drawBezierCurve(canvas);
    }

    private void drawLines(int n, Canvas canvas) {
        Random rnd = new Random();
        paint = new Paint();
        paint.setStrokeWidth(10);
        float startX = 0;
        float startY = 0;
        float stopX = 0;
        float stopY = 0;
        for(int i = 0; i < n; i++) {
            paint.setARGB(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
            startX = 700 + i * 50;
            startY = i * 10;
            stopX = startX + 100;
            stopY = startY + 200;
            canvas.drawLine(30 + startX, 30 + startY, stopX, stopY, paint);
        }
    }

    private void drawBezierCurve(Canvas canvas) {
        paint.setStyle(Paint.Style.STROKE);
        path = new Path();
        paint.setColor(Color.RED);
        paint.setStrokeWidth(6);
        path.moveTo(54, 35);
        path.cubicTo(102, 120, 350, 100, 237, 18);
        canvas.drawPath(path, paint);

        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(10);
        path.moveTo(79, 385);
        path.cubicTo(102, 120, 310, 476, 427, 232);
        canvas.drawPath(path, paint);
    }

}
