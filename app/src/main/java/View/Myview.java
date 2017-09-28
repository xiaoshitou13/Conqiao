package View;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Toast;

import test.bwie.com.conqiao.R;

/**
 * Created by 白玉春 on 2017/9/28.
 */

public class Myview extends View {

    private Paint paint;
    //当前attr的颜色和宽度
    private int width;
    private int color;

    //画笔的颜色：
    private int HUABICOLOR;

    //圆心
    private int curx;
    private int cury;
    private int redio = 130;
    //速度
    private  int  send = 0;
    public Myview(Context context) {
        super(context);
        init(context);
    }

    public Myview(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
        TypedArray ty = context.obtainStyledAttributes(attrs,R.styleable.Myview);
        for(int i= 0 ; i<ty.getIndexCount(); i++){
          int cont =  ty.getIndex(i);
           switch (cont){
               case R.styleable.Myview_width:
                   width = ty.getInteger(cont,3);
                   break;
               case R.styleable.Myview_yanse:
                   color = ty.getColor(cont, Color.BLACK);
                   HUABICOLOR = color;
                   break;
           }
        }
    }



    public Myview(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    /**
     * 初始化一根笔
     * @param context
     */
    private void init(Context context) {
        paint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //画圈的颜色  等
        paint.setAntiAlias(true);
        paint.setColor(HUABICOLOR);
        paint.setStyle(Paint.Style.STROKE);

        curx = getWidth()/2;
        cury = getHeight()/2;

        canvas.drawCircle(curx,cury,redio,paint);
        canvas.save();

         //rotate　旋转
        canvas.rotate(send,curx,cury);
        //path  用来画图
        Path path = new Path();

        //连线
        path.moveTo(curx+redio,cury);
        path.lineTo(curx+redio-20,cury-20);
        path.lineTo(curx+redio,cury+20);
        path.lineTo(curx+redio+20,cury-20);

        //闭合
        path.close();
        //类型
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.GREEN);//图形颜色
        canvas.drawPath(path,paint);//画出来
        canvas.restore();
  //  速度加
        send += 1*con;
        if(!bu) {
            invalidate();
        }
    }



    private int con = 1;
    private boolean bu =false;

    public void setColor(int colors){
        if(HUABICOLOR != colors){
            HUABICOLOR =colors;
        }else{
            HUABICOLOR = color;
        }
    }

    public void add(){
        con++;
        if(con>=10){
            con = 10;
            Toast.makeText(getContext(), "好快", Toast.LENGTH_SHORT).show();
        }
    }

    public void jian(){
        con--;
        if(con<=1){
            con=1;
        }
    }

    public void Zt(){
        if(bu){
            bu = !bu;
            invalidate();
        }else{
            bu =!bu;
        }
    }


}

