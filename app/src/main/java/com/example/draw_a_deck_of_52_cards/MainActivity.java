package com.example.draw_a_deck_of_52_cards;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompatSideChannelService;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Random;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button rutbai;
    ImageView labai1;
    ImageView labai2;
    ImageView labai3;
    TextView thongbao;
    TextView thongbao1;

    int sonut=0;//de xet xem duoc may nut
    int darut=0;//chi cho rut 3 la
    boolean batay=true;//de xet truong hop 3 tay
    String chuoithongbao="";
    ArrayList<String> cacladarut=new ArrayList<String>();//chua ten la da rut;
    //de de lam nen cho mang[][0] khong co y nghia (chi dung mang[][1]tro di
    int manghinhbai[][]={
            {R.drawable.b2fv,
                    R.drawable.c1,R.drawable.c2,R.drawable.c3,R.drawable.c4,R.drawable.c5,
                    R.drawable.c6,R.drawable.c7,R.drawable.c8,R.drawable.c9,R.drawable.c10,
                    R.drawable.cj,R.drawable.cq,R.drawable.ck},
            {R.drawable.b2fv,
                    R.drawable.d1,R.drawable.d2,R.drawable.d3,R.drawable.d4,R.drawable.d5,
                    R.drawable.d6,R.drawable.d7,R.drawable.d8,R.drawable.d9,R.drawable.d10,
                    R.drawable.dj,R.drawable.dq,R.drawable.dk},
            {R.drawable.b2fv,
                    R.drawable.h1,R.drawable.h2,R.drawable.h3,R.drawable.h4,R.drawable.h5,
                    R.drawable.h6,R.drawable.h7,R.drawable.h8,R.drawable.h9,R.drawable.h10,
                    R.drawable.hj,R.drawable.hq,R.drawable.hk},
            {R.drawable.b2fv,
                    R.drawable.s1,R.drawable.s2,R.drawable.s3,R.drawable.s4,R.drawable.s5,
                    R.drawable.s6,R.drawable.s7,R.drawable.s8,R.drawable.s9,R.drawable.s10,
                    R.drawable.sj,R.drawable.sq,R.drawable.sk}
    };
    String mangtenbai[][]={
            {"rong",
                    "Ách chuồn","Hai chuồn","Ba chuồn","Bốn chuồn","Năm chuồn",
                    "Sáu chuồn","Bảy chuồn","Tám chuồn","Chín chuồn","Mười chuồn",
                    "Bồi chuồn","Đầm chuồn","Già chuồn"},
            {"rong",
                    "Ách rô","Hai rô","Ba rô","Bốn rô","Năm rô",
                    "Sáu rô","Bảy rô","Tám rô","Chín rô","Mười rô",
                    "Bồi rô","Đầm rô","Già rô"},
            {"rong",
                    "Ách cơ","Hai cơ","Ba cơ","Bốn cơ","Năm cơ",
                    "Sáu cơ","Bảy cơ","Tám cơ","Chín cơ","Mười cơ",
                    "Bồi cơ","Đầm cơ","Già cơ"},
            {"rong",
                    "Ách bích","Hai bích","Ba bích","Bốn bích","Năm bích",
                    "Sáu bích","Bảy bích","Tám bích","Chín bích","Mười bích",
                    "Bồi bích","Đầm bích","Già bích"}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rutbai=(Button)findViewById(R.id.rutbai);
        labai1=(ImageView)findViewById(R.id.ivlabai1);
        labai2=(ImageView)findViewById(R.id.ivlabai2);
        labai3=(ImageView)findViewById(R.id.ivlabai3);
        thongbao=(TextView)findViewById(R.id.txtthongbao);
        thongbao1=(TextView)findViewById(R.id.textView1);
        rutbai.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if(darut==0)//lan dau hoac rut lai
                {
                    darut=0;
                    sonut=0;
                    batay=true;
                    chuoithongbao="";
                    labai1.setImageResource(R.drawable.b2fv);
                    labai2.setImageResource(R.drawable.b2fv);
                    labai3.setImageResource(R.drawable.b2fv);
                    cacladarut.clear();

                }
                darut++; //dem so lan rut
                //tao ngau nhien
                Random rd=new Random();
                int x,y;
                //tao ngau nhien bao vao ArrayList de xet xem co bi trung khong
                while(true)
                {
                    x=rd.nextInt(4);//0->3 (b-a+1)+a;
                    y=rd.nextInt(13)+1;//1->13
                    if(cacladarut.contains(mangtenbai[x][y])==false)
                    {
                        cacladarut.add(mangtenbai[x][y]);
                        break;
                    }
                }
                //chi can y<11 lap tuc khong con la batay nua
                if(y<11)
                    batay=false;
                if(darut==1)
                {
                    sonut+=(y<10)?y:0;
                    labai1.setImageResource(manghinhbai[x][y]);
                }
                else if(darut==2)
                {
                    sonut+=(y<10)?y:0;
                    labai2.setImageResource(manghinhbai[x][y]);
                }
                else if(darut==3)
                {
                    sonut+=(y<10)?y:0;
                    int kq=sonut%10;
                    darut=0;
                    labai3.setImageResource(manghinhbai[x][y]);
                    chuoithongbao+=" Số nút là: "+ kq;
                    rutbai.setEnabled(false);

                    if(batay == true)
                        thongbao1.setText("\nChúc mừng bạn được ba tây");
                    else
                        thongbao1.setText(chuoithongbao);
                }
                thongbao.setText("Các lá đã rút \n"+cacladarut.toString());
                thongbao1.setText(chuoithongbao);

            }
        });
    }



    }
