package com.teclever.assignment1;


import android.os.Bundle;
import android.os.Environment;
import android.provider.SyncStateContract;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.DragEvent;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.GridView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Frag3 extends Fragment {

    GridView gridview;
    GridViewAdapter adapter;
    //Integer[] imageId=null;
    //String[] imagestr=null;
    String []imgUrl={"http://www.moviemuser.co.uk/wp-content/uploads/2016/01/suicide-squad-character-logos7-243x360.jpg",
            "http://cdn.entertainment-focus.com/wp-content/uploads/2016/01/12471664_1674589659488335_3105470368081089093_o.jpg"};



    FileWriter fw;
    BufferedWriter bw;

    int mul;
    public Frag3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_frag3, container, false);

        gridview=(GridView)v.findViewById(R.id.gridview);
        File file=new File(Environment.getExternalStorageDirectory()+File.separator+"Assignment1"+File.separator+"images");
        if(!file.exists())
            file.mkdirs();
        File textFile=new File(Environment.getExternalStorageDirectory()+File.separator+
                "Assignment1"+File.separator+"images"+File.separator+"url.txt");
        try
        {
            if(!textFile.exists())
                textFile.createNewFile();
            fw=new FileWriter(textFile);
            bw=new BufferedWriter(fw);
            bw.write("3*3\n");
            bw.write(imgUrl[0]+"\n");
            bw.write(imgUrl[1]+"\n");
            bw.write(imgUrl[0]+"\n");
            bw.write(imgUrl[1]+"\n");
            bw.write(imgUrl[0]+"\n");
            bw.write(imgUrl[1]+"\n");
            bw.write(imgUrl[0]+"\n");
            bw.write(imgUrl[1]+"\n");
            bw.write(imgUrl[0]+"\n");
            bw.flush();
            bw.close();

            String str=null;
                FileReader file1=new FileReader(textFile);
                BufferedReader bf=new BufferedReader(file1);
                str=bf.readLine();
                char c1=str.charAt(0);
                char c2=str.charAt(2);
                int i2=Character.getNumericValue(c2);
                int i1=Character.getNumericValue(c1);
                mul=i1*i2;
                FileReader file2 = new FileReader(textFile);
                BufferedReader bf2 = new BufferedReader(file2);
                String str3=bf2.readLine();
                int linenumber=0;
                if(file.exists())
                    while(str3!=null)
                        linenumber++;
            //File[] fileSize=textFile.listFiles();
                if(mul >= linenumber )
                {
                    Toast.makeText(v.getContext(),"Number of Urls are less ! Please add more urls",Toast.LENGTH_LONG).show();
                }
                else
                {
                    gridview.setNumColumns(i2);
                    gridview.setHorizontalSpacing(40);
                    gridview.setVerticalSpacing(40);
                    gridview.setColumnWidth(50);
//                    String str2 = null;
//                    int i = 0;
//                    String[] URL1 = new String[linenumber];
//
//                    file2 = new FileReader(textFile);
//                    bf2 = new BufferedReader(file2);
//
//                    while ((str2 = bf2.readLine()) != null)
//                    {
//                        URL1[i++] = str2;
//                    }
//                    String[] URL2 = new String[(URL1.length) - 1];
//                    int k = 0;
//                    for (int j = 1; j <= mul; j++)
//                    {
//                        URL2[k++] = URL1[j];
//                    }
                    adapter = new GridViewAdapter((MainActivity) getActivity(), imgUrl);
                    gridview.setAdapter(adapter);
                    Animation anim = AnimationUtils.loadAnimation(v.getContext(), R.anim.slideup);
                    gridview.startAnimation(anim);
                }

        } catch (IOException e) {
            e.printStackTrace();
        }

        final GestureDetector gesture = new GestureDetector(getActivity(),
                        new GestureDetector.SimpleOnGestureListener() {

                            @Override
                            public boolean onDown(MotionEvent e) {
                                MainActivity mainActivity = (MainActivity) getActivity();
                                mainActivity.swipe();
                                return true;
                            }

                            @Override
                            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
                                                   float velocityY) {
                                final int SWIPE_MIN_DISTANCE = 300;
                                final int SWIPE_MAX_OFF_PATH = 500;
                                final int SWIPE_THRESHOLD_VELOCITY = 200;
                                try {
                                    if (Math.abs(e1.getY() - e2.getY()) > SWIPE_MAX_OFF_PATH)
                                        return false;
                                    if (e1.getX() - e2.getX() > SWIPE_MIN_DISTANCE
                                            && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                                    } else if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE
                                            && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                return super.onFling(e1, e2, velocityX, velocityY);
                            }
                        });

        v.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return gesture.onTouchEvent(event);
            }
        });
        return v;
    }


}
