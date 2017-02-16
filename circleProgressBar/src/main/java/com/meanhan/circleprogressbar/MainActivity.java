package com.meanhan.circleprogressbar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.meanhan.view.CircleProgressBar;
import com.meanhan.view.RangeProgressBar;


public class MainActivity extends AppCompatActivity {

    private CircleProgressBar circleProgressBar;
    private RangeProgressBar rangeProgressBar;
    private TextView tvCircleProgressBar;
    private TextView tvRangeProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        circleProgressBar = (CircleProgressBar) findViewById(R.id.progress_circle);
        rangeProgressBar = (RangeProgressBar) findViewById(R.id.progress_circle2);
        tvCircleProgressBar = (TextView) findViewById(R.id.progress_circle_tv);
        tvRangeProgressBar = (TextView) findViewById(R.id.progress_circle2_tv);
        initProgressBar();
        /*
        监听拖动事件
         */
        circleProgressBar.setOnMoveViewValueChanged(new CircleProgressBar.OnMoveViewValueChanged() {
            @Override
            public void onMoveChanged(String value) {
                tvCircleProgressBar.setText(circleProgressBar.currentValue+"%");
            }
        });

        rangeProgressBar.setOnAutoMoveViewValueChanged(new RangeProgressBar.OnAutoMoveViewValueChanged() {
            @Override
            public void onMoveChanged(String value1, String value2) {
                tvRangeProgressBar.setText(rangeProgressBar.getCurrentValue()+"%");
            }
        });

        /*
        监听 拖动完成事件
         */
        circleProgressBar.setOnUpViewValueChanged(new CircleProgressBar.OnUpViewValueChanged() {
            @Override
            public void onUpChanged(String value) {
                Toast.makeText(MainActivity.this,value, Toast.LENGTH_SHORT).show();
            }
        });

        rangeProgressBar.setOnAutoUpViewValueChanged(new RangeProgressBar.OnAutoUpViewValueChanged() {
            @Override
            public void onUpChanged(String value1, String value2) {
                Toast.makeText(MainActivity.this,"left:"+value1+",right:"+value2, Toast.LENGTH_SHORT).show();
            }
        });
    }

    /*
    设置初始值
     */
    private void initProgressBar(){
        circleProgressBar.setMaxValue(32);
        circleProgressBar.setMinValue(10);
        circleProgressBar.setProcess("10");
        rangeProgressBar.setMaxValue(32);
        rangeProgressBar.setMinValue(10);
        rangeProgressBar.setProcessLeft("10");
        rangeProgressBar.setProcessRight("20");
    }


}
