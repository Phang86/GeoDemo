package com.example.myapplication.utils;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import java.util.List;

public class WindmillView extends View {
    //1. 在项目中创建一个名为WindmillView的Java类。
    private static final long ROTATE_DURATION = 1500; // 风车旋转一周的时间（毫秒）
    private static final int BLADE_COUNT = 3; // 叶片数量
    private Paint bladePaint; // 叶片画笔
    private Paint shaftPaint; // 轴画笔
    private Paint standPaint; // 支架画笔

    private float bladeRotation; // 叶片旋转角度
    private long lastTimeMillis; // 上一次更新角度的时间

    private int width, height; // 控件宽高
    private int centerX, centerY; // 控件中心点坐标

    public WindmillView(Context context) {
        super(context);
        init();
    }

    public WindmillView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public WindmillView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        bladePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        bladePaint.setColor(Color.RED);

        shaftPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        shaftPaint.setColor(Color.GRAY);
        shaftPaint.setStrokeWidth(15);

        standPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        standPaint.setColor(Color.GREEN);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 绘制叶片
        canvas.save();
        canvas.rotate(bladeRotation, centerX, centerY); // 旋转画布
        for (int i = 0; i < BLADE_COUNT; i++) {
            float degree = 360f / BLADE_COUNT * i;
            canvas.rotate(degree, centerX, centerY); // 旋转画布

            Path path = new Path();
            path.moveTo(centerX, centerY);
            path.lineTo(centerX - width / 4, centerY - height / 2);
            path.lineTo(centerX + width / 4, centerY - height / 2);
            path.close(); // 绘制三角形叶片
            canvas.drawPath(path, bladePaint);
        }
        canvas.restore();

        // 绘制轴
        canvas.drawLine(centerX, centerY - height / 2, centerX, centerY + height / 2, shaftPaint);

        // 绘制支架
        canvas.drawRect(centerX - width / 20, centerY + height / 2, centerX + width / 20, centerY + height * 3 / 4, standPaint);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = w;
        height = h;
        centerX = w / 2;
        centerY = h / 2;
    }

    public void startRotate() {
        lastTimeMillis = System.currentTimeMillis();
        post(rotateRunnable);
    }

    public void stopRotate() {
        if (getAnimation() != null) {
            removeCallbacks(rotateRunnable);
        }
    }

    private Runnable rotateRunnable = new Runnable() {
        @Override
        public void run() {
            long currentTimeMillis = System.currentTimeMillis();
            float delta = (currentTimeMillis - lastTimeMillis) / (float)ROTATE_DURATION * 360f;
            bladeRotation += delta;
            invalidate();
            postOnAnimationDelayed(this, 16);
            lastTimeMillis = currentTimeMillis;
        }
    };
}
