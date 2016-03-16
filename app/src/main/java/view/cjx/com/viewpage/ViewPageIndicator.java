package view.cjx.com.viewpage;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * Created by bear on 16/3/16.
 */
public class ViewPageIndicator extends LinearLayout {
    private Paint mPaint;

    private Path mPath;

    private int mTriWidth;

    private int mTriHeight;

    private static final float RADIO_TRIANGLE_WDITH = 1 / 6F;

    private int iniTranslationX;

    private int mTranslationX;


    public ViewPageIndicator(Context context) {
        this(context, null);
    }

    public ViewPageIndicator(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.parseColor("#ffffffff"));
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setPathEffect(new CornerPathEffect(3));
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        canvas.save();
        canvas.translate(iniTranslationX + mTranslationX, getHeight());
        canvas.drawPath(mPath, mPaint);
        canvas.restore();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mTriWidth = (int) (w / 3 * RADIO_TRIANGLE_WDITH);
        mTriHeight = mTriWidth / 2;
        iniTranslationX = w / 3 / 2 - mTriWidth / 2;
        iniTrangle();
    }

    private void iniTrangle() {
        mPath = new Path();
        mPath.moveTo(0, 0);
        mPath.lineTo(mTriWidth, 0);
        mPath.lineTo(mTriWidth / 2, -mTriHeight + 2);
        mPath.close();
    }

    /**
     * 滑动
     * @param position 滑动时的tab位置
     * @param offset tab内的滑动比例
     */
    public void scroll(int position, float offset) {
        mTranslationX = (int) (getWidth() / 3 * (position + offset));
        invalidate();
    }

}
