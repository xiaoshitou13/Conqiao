package test.bwie.com.conqiao;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import View.Myview;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Myview myview;
    /**
     * 设置颜色
     */
    private Button mSetColorBtn;
    /**
     * 加速
     */
    private Button mAdd;
    /**
     * 减速
     */
    private Button mSlow;
    /**
     * 暂定/开始
     */
    private Button mPauseOrStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        myview = (Myview) findViewById(R.id.my);

    }

    private void initView() {
        mSetColorBtn = (Button) findViewById(R.id.set_color_btn);
        mSetColorBtn.setOnClickListener(this);
        mAdd = (Button) findViewById(R.id.add);
        mAdd.setOnClickListener(this);
        mSlow = (Button) findViewById(R.id.slow);
        mSlow.setOnClickListener(this);
        mPauseOrStart = (Button) findViewById(R.id.pause_or_start);
        mPauseOrStart.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.set_color_btn:
                myview.setColor(Color.GREEN);
                break;
            case R.id.add:
                myview.add();
                break;
            case R.id.slow:
                myview.jian();
                break;
            case R.id.pause_or_start:
                myview.Zt();
                break;
        }
    }
}
