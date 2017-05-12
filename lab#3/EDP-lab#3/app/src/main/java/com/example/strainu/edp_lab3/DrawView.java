package com.example.strainu.edp_lab3;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.Log;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by strainu on 4/14/17.
 */

public class DrawView extends View implements View.OnTouchListener {
    Paint paint;
    Path path;
    Canvas drawCanvas;

    List<Pair<Integer, Integer>> listOfPoints = new ArrayList<>();

    public DrawView(Context context) {
        super(context);
        paint = new Paint();
        setOnTouchListener(this);

        Pair<Integer, Integer> pair = new Pair<Integer, Integer>(50,50);
        listOfPoints.add(pair);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawCanvas  = canvas;
        canvas.scale((float) 1, (float) 1);
        drawLines(5, canvas);
        drawBezierCurve(canvas);
        drawTriangle(canvas);
        drawOval(canvas);
        for(int i = 0; i < listOfPoints.size(); i++){
            drawCircle(canvas, listOfPoints.get(i).first, listOfPoints.get(i).second);
        }
    }


    public boolean onTouch(View v, MotionEvent event) {

        Pair<Integer,Integer> tempPair = new Pair<>((int) event.getX(), (int) event.getY());
        listOfPoints.add(tempPair);

        Log.d("Canvas","" + drawCanvas);

        invalidate();
        return true;
    }


    private void drawLines(int n, Canvas canvas) {
        Random rnd = new Random();
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

    private void drawCircle(Canvas canvas, int x, int y) {
        Log.d("canvas", String.valueOf(canvas));
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.GREEN);
        drawCanvas.drawCircle(x, y, 50, paint);
    }

    private void drawTriangle(Canvas canvas) {
        Point point1 = new Point(); point1.set(250, 100);
        Point point2 = new Point(); point2.set(250, 200);
        Point point3 = new Point(); point3.set(350, 200);

        Path path = new Path();
        path.moveTo(point1.x, point1.y);
        path.lineTo(point2.x, point2.y);
        path.lineTo(point3.x, point3.y);
        path.lineTo(point1.x, point1.y);
        path.close();
        paint.setColor(Color.parseColor("#ffff00"));
        paint.setShader(new LinearGradient(0, 0, 0, getHeight(), Color.BLACK, Color.WHITE, Shader.TileMode.MIRROR));
        canvas.drawPath(path, paint);
        paint.reset();
    }

    private void drawOval(Canvas canvas) {
        paint.setColor(Color.parseColor("#ff0000"));
        paint.setStrokeWidth(20);
        paint.setStyle(Paint.Style.STROKE);
        RectF rect=new RectF(150, 150, 200, 350);
        canvas.drawOval(rect, paint);
        paint.reset();
    }

}
