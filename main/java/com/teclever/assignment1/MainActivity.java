package com.teclever.assignment1;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;


public class MainActivity extends AppCompatActivity {
    RelativeLayout c1,c2;
    int prev = 1;
    String fName=null;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    public  void selection(int s){

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Frag1 frag1= new Frag1();
        Frag2 frag2= new Frag2();
        Frag3 frag3=new Frag3();
        Frag4 frag4=new Frag4();
        Frag5 frag5= new Frag5();
        if (s==3){
            c2.setY(20);
            c1.setY(100);
        }
        else
        {
            c1.setY(20);
            c2.setY(550);
        }
        if(prev==s)
            return;
        switch (s){
            case 1:
                if(s>prev)
                    fragmentTransaction.setCustomAnimations(R.anim.anim_left,R.anim.anim_right,R.anim.anim_l2r,R.anim.anim_r2d);
                if(s<prev)
                    fragmentTransaction.setCustomAnimations(R.anim.anim_l2r,R.anim.anim_r2d,R.anim.anim_left,R.anim.anim_right);
                fragmentTransaction.replace(R.id.container1,frag1);
                fName="frag1";
                break;
            case 2:
                if(s>prev)
                    fragmentTransaction.setCustomAnimations(R.anim.anim_left,R.anim.anim_right,R.anim.anim_l2r,R.anim.anim_r2d);
                if(s<prev)
                    fragmentTransaction.setCustomAnimations(R.anim.anim_l2r,R.anim.anim_r2d,R.anim.anim_left,R.anim.anim_right);
                fragmentTransaction.replace(R.id.container1,frag2);
                fName="frag2";
                break;
            case 3:
                fragmentTransaction.setCustomAnimations(R.anim.anim_up,R.anim.anim_down);
                fragmentTransaction.replace(R.id.container1,frag3);
                fName="frag3";
                break;
            case 4:
                if(s>prev)
                    fragmentTransaction.setCustomAnimations(R.anim.anim_left,R.anim.anim_right,R.anim.anim_l2r,R.anim.anim_r2d);
                if(s<prev)
                    fragmentTransaction.setCustomAnimations(R.anim.anim_l2r,R.anim.anim_r2d,R.anim.anim_left,R.anim.anim_right);
                fragmentTransaction.replace(R.id.container1,frag4);
                fName="frag4";
                break;
            case 5:
                if(s>prev)
                    fragmentTransaction.setCustomAnimations(R.anim.anim_left,R.anim.anim_right,R.anim.anim_l2r,R.anim.anim_r2d);
                if(s<prev)
                    fragmentTransaction.setCustomAnimations(R.anim.anim_l2r,R.anim.anim_r2d,R.anim.anim_left,R.anim.anim_right);
                fragmentTransaction.replace(R.id.container1,frag5);
                fName="frag5";
                break;
        }
        fragmentTransaction.addToBackStack(fName);
        if(prev==3)
            fragmentManager.popBackStack("frag3",FragmentManager.POP_BACK_STACK_INCLUSIVE);
        fragmentTransaction.commit();
        prev = s;

    }
    public void swipe()
    {
        onBackPressed();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        MenuFrag menuFrag = new MenuFrag();
        Frag1 f = new Frag1();
        transaction.add(R.id.container1,f);
        transaction.add(R.id.container2,menuFrag);
        c1= (RelativeLayout) findViewById(R.id.container1);
        c2= (RelativeLayout) findViewById(R.id.container2);
        transaction.commit();

    }

    @Override
    public void onBackPressed() {
        getFragmentManager().popBackStack();
        c1.setY(20);
        c2.setY(550);
        super.onBackPressed();
    }
}
