package com.example.gongjiao;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {
    private TextView xianlu;
    /**
     * 规定开始音乐、暂停音乐、结束音乐的标志
     */
    public static final int PLAT_MUSIC = 1;
    public static final int PAUSE_MUSIC = 2;
    public static final int STOP_MUSIC = 3;
    private EditText gongjiao;
    private MyBroadCastReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        xianlu = findViewById(R.id.xianlu);
        gongjiao = findViewById(R.id.gongjiao);

        playingmusic(PLAT_MUSIC);
    }

    @SuppressLint("SetTextI18n")
    private void gonjiao() {
        xianlu.setVisibility(View.VISIBLE);
        String gon = gongjiao.getText().toString();
        if (gon.equals("辛庄")) {
            xianlu.setText("129路");
        } else if (gon.equals("德州东站")) {
            xianlu.setText("129路");
        } else if (gon.equals("赵虎镇")) {
            xianlu.setText("128路");
        } else if (gon.equals("德百批发站")) {
            xianlu.setText("128路" + ",104路");
        } else if (gon.equals("陵城区黑马农贸市场")) {
            xianlu.setText("104路");
        } else if (gon.equals("市立医院")) {
            xianlu.setText("38路");
        } else if (gon.equals("袁桥公交枢纽中心")) {
            xianlu.setText("38路");
        } else if (gon.equals("公交公司")) {
            xianlu.setText("66路");
        } else if (gon.equals("会展中心")) {
            xianlu.setText("66路");
        }
    }

    private void playingmusic(int type) {
        //启动服务，播放音乐
        Intent intent = new Intent(this, PlayingMusicServices.class);
        intent.putExtra("type", type);
        startService(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
        playingmusic(STOP_MUSIC);
    }

    public void login(View view) {
        gonjiao();
    }

    public void tishi(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("提示");
        LayoutInflater layoutInflater = LayoutInflater.from(this);
        View newPlanDialog = layoutInflater.inflate(R.layout.item_tishi, null);
        builder.setView(newPlanDialog)
                .setPositiveButton("确定", null)
                .setNegativeButton("取消", null)
                .show();
    }
}
