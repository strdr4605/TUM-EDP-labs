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
        canvas.scale((float) 1, (float) 1);
        drawLines(5, canvas);
        drawBezierCurve(canvas);
        drawCircle(canvas);
    }

    private void drawLines(int n, Canvas canvas) {
        Random rnd = new Random();
        paint = new Paint();
        paint.setStrokeWidth(5);
        float startX = 0;
        float startY = 0;
        float stopX = 0;
        float stopY = 0;
        for(int i = 0; i < n; i++) {
            paint.setARGB(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
            startX = 300 + i * 50;
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
        paint.setStrokeWidth(3);
        path.moveTo(10, 35);
        path.cubicTo(102, 120, 350, 100, 237, 18);
        canvas.drawPath(path, paint);

        path = new Path();
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(5);
        path.moveTo(10, 174);
        path.cubicTo(5, 53, 486, 153, 281, 31);
        canvas.drawPath(path, paint);
    }

    private void drawCircle(Canvas canvas) {
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.GREEN);
        canvas.drawCircle(100, 100 , 50, paint);
    }

}
