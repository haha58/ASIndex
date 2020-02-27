package com.example.sz02420.demo1;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;


/**
 * Created by SZ02420 on 2020/2/25 0028.
 */
public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener{

    private RadioGroup rg_tab;
    private RadioButton rb_one;

    //Fragment Object
    private MainFragment fg1,fg2,fg3,fg4;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    public void initView(){
        fragmentManager = getFragmentManager();
        rg_tab = (RadioGroup) findViewById(R.id.rg_tab_bar);
        rg_tab.setOnCheckedChangeListener(this);

        //获取第一个单选按钮，并设置其为选中状态
        rb_one = (RadioButton) findViewById(R.id.rb_one);
        rb_one.setChecked(true);

        Drawable noticeDrawable = getResources().getDrawable(R.mipmap.index_sel);
        noticeDrawable.setBounds(0, 0,80, 80);

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        FragmentTransaction fTransaction = fragmentManager.beginTransaction();
        hideAllFragment(fTransaction);
        switch (checkedId){
            case R.id.rb_one:
                if(fg1 == null){
                    fg1 = new MainFragment("1");
                    fTransaction.add(R.id.fm_content_one,fg1);
                }else{
                    fTransaction.show(fg1);
                }
                break;
            case R.id.rb_two:
                if(fg2 == null){
                    fg2 = new MainFragment("2");
                    fTransaction.add(R.id.fm_content_two,fg2);
                }else{
                    fTransaction.show(fg2);
                }
                break;
            case R.id.rb_three:
                if(fg3 == null){
                    fg3 = new MainFragment("3");
                    fTransaction.add(R.id.fm_content_three,fg3);
                }else{
                    fTransaction.show(fg3);
                }
                break;
            case R.id.rb_four:
                if(fg4 == null){
                    fg4 = new MainFragment("4");
                    fTransaction.add(R.id.fm_content_four,fg4);
                }else{
                    fTransaction.show(fg4);
                }
                break;
        }
        fTransaction.commit();
    }

    //隐藏所有Fragment
    private void hideAllFragment(FragmentTransaction fragmentTransaction){
        if(fg1 != null)fragmentTransaction.hide(fg1);
        if(fg2 != null)fragmentTransaction.hide(fg2);
        if(fg3 != null)fragmentTransaction.hide(fg3);
        if(fg4 != null)fragmentTransaction.hide(fg4);
    }

}
