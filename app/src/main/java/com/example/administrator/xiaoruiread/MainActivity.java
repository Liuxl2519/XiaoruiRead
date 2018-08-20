package com.example.administrator.xiaoruiread;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    //UI Object
    private TextView txt_channel;
    private TextView txt_message;
//    private TextView txt_better;
    private TextView txt_setting;
    private FrameLayout ly_content;

    //Four Fragment Object
    private BshelfFragment bf;
    private BstoreFragment bsf;
    private RecFragment rf;
    private PersonalFragment pf;

    private FragmentManager fManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        fManager = getSupportFragmentManager();
        bindViews();
        txt_channel.performClick();   //模拟一次点击，既进去后选择第一项
    }

//    //UI组件初始化与事件绑定
        private void bindViews() {
            txt_channel =  findViewById(R.id.txt_channel);
            txt_message =  findViewById(R.id.txt_message);
//            txt_better =  findViewById(R.id.txt_better);
            txt_setting =  findViewById(R.id.txt_setting);
            ly_content =  findViewById(R.id.ly_content);//Framelayout布局形式

            txt_channel.setOnClickListener(this);
            txt_message.setOnClickListener(this);
//            txt_better.setOnClickListener(this);
            txt_setting.setOnClickListener(this);
        }

//    //重置所有文本的选中状态
        private void setSelected(){
            txt_channel.setSelected(false);
            txt_message.setSelected(false);
//            txt_better.setSelected(false);
            txt_setting.setSelected(false);
        }

//    //隐藏所有Fragment
        private void hideAllFragment(FragmentTransaction fragmentTransaction){
            if(bf != null)fragmentTransaction.hide(bf);
            if(bsf != null)fragmentTransaction.hide(bsf);
//            if(rf != null)fragmentTransaction.hide(rf);
            if(pf != null)fragmentTransaction.hide(pf);
        }

        @Override
        public void onClick(View v) {
            FragmentTransaction fTransaction = fManager.beginTransaction();
            hideAllFragment(fTransaction);
            switch (v.getId()){
                case R.id.txt_channel:
                    setSelected();
                    txt_channel.setSelected(true);
                    if(bf == null){
                        bf = new BshelfFragment();
                        fTransaction.add(R.id.ly_content,bf);
                    }else{
                        fTransaction.show(bf);
                    }
                    break;
                case R.id.txt_message:
                    setSelected();
                    txt_message.setSelected(true);
                    if(bsf == null){
                        bsf = new BstoreFragment();
                        fTransaction.add(R.id.ly_content,bsf);
                    }else{
                        fTransaction.show(bsf);
                    }
                    break;
//                case R.id.txt_better:
//                    setSelected();
//                    txt_better.setSelected(true);
//                    if(rf == null){
//                        rf = new RecFragment();
//                        fTransaction.add(R.id.ly_content,rf);
//                    }else{
//                        fTransaction.show(rf);
//                    }
//                    break;
                case R.id.txt_setting:
                    setSelected();
                    txt_setting.setSelected(true);
                    if(pf == null){
                        pf = new PersonalFragment();
                        fTransaction.add(R.id.ly_content,pf);
                    }else{
                        fTransaction.show(pf);
                    }
                    break;
            }
            fTransaction.commit();
        }
}