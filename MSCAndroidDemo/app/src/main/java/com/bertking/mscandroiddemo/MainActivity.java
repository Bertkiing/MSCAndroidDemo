package com.bertking.mscandroiddemo;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

    private Toast mToast;

    @SuppressLint("ShowToast")
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 设置标题栏（无标题）
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        mToast = Toast.makeText(this, "", Toast.LENGTH_SHORT);
        SimpleAdapter listitemAdapter = new SimpleAdapter();
        ((ListView) findViewById(R.id.listview_main)).setAdapter(listitemAdapter);
    }

    @Override
    public void onClick(View view) {
        int tag = Integer.parseInt(view.getTag().toString());
        Intent intent = null;
        switch (tag) {
            case 0:
                // 语音听写
//			intent = new Intent(this, IatDemo.class);
                intent = new Intent(this, VoiceDictationActivity.class);

                break;
            case 1:
                // 语法识别
//			intent = new Intent(this, AsrDemo.class);
                intent = new Intent(this, SpeechRecognizeActivity.class);
                break;
            case 2:
                // 语义理解
//                intent = new Intent(this, UnderstanderDemo.class);
                intent = new Intent(this, SemanticUnderStandActivity.class);
                break;
            case 3:
                // 语音合成
//                intent = new Intent(this, TtsDemo.class);
                intent = new Intent(this,SpeechSynthesisActivity.class);
                break;
            case 4:
                // 唤醒
//                intent = new Intent(this, IvwActivity.class);
                intent = new Intent(this,WakeUpActivity.class);
                break;
            case 5:
                // 声纹
                showTip("请登录：http://www.xfyun.cn/ 下载体验吧！");
                break;
            default:
                showTip("此功能将于近期开放，敬请期待。");
                break;
        }
        if (intent != null) {
            startActivity(intent);
        }
    }


    //Menu 列表
    String items[] = {"立刻体验语音听写", "立刻体验语法识别", "立刻体验语义理解", "立刻体验语音合成", "立刻体验语音唤醒", "立刻体验声纹密码"};

    private class SimpleAdapter extends BaseAdapter {
        public View getView(int position, View convertView, ViewGroup parent) {
            if (null == convertView) {
                LayoutInflater factory = LayoutInflater.from(MainActivity.this);
                View mView = factory.inflate(R.layout.list_items, null);
                convertView = mView;
            }
            Button btn = (Button) convertView.findViewById(R.id.btn);
            btn.setOnClickListener(MainActivity.this);
            btn.setTag(position);
            btn.setText(items[position]);
            return convertView;
        }

        @Override
        public int getCount() {
            return items.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }
    }

    private void showTip(final String str) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mToast.setText(str);
                mToast.show();
            }
        });
    }
}
