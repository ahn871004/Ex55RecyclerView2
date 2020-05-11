package kr.co.ajsoft.ex55recyclerview2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    ArrayList<Item> datas=new ArrayList<>();

    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //데이터 추가작업
        datas.add(new Item("루피","해적단 선장",R.drawable.ch_luffy,R.drawable.img01));
        datas.add(new Item("조로","해적단 사냥꾼",R.drawable.ch_zoro,R.drawable.img02));
        datas.add(new Item("나미","해적단 항해사",R.drawable.ch_nami,R.drawable.img03));
        datas.add(new Item("상디","해적단 요리사",R.drawable.ch_sandi,R.drawable.img04));
        datas.add(new Item("쵸파","해적단 의사",R.drawable.ch_chopa,R.drawable.img05));
        datas.add(new Item("겨울왕국","자매들의 눈싸움",R.drawable.winter,R.drawable.winter));


        recyclerView=findViewById(R.id.recycler);
        adapter=new MyAdapter(datas,this);
        recyclerView.setAdapter(adapter);

        //리사이클러view 및 아이템 꾸미기
        MyRecyclerDecoration decoration=new MyRecyclerDecoration();
        recyclerView.addItemDecoration(decoration);

        //리사이클러view의 아이템이 변결될 때 애니메이션 효과
        MyRecyclerAnimator animator=new MyRecyclerAnimator();
        recyclerView.setItemAnimator(animator);

    }

    public void clickAdd(View view) {
        Item item=new Item("NEW","Message",R.drawable.ch_sandi,R.drawable.img04);
        datas.add(0,item);

        //데이터가 변경되었다고 공지
        adapter.notifyItemInserted(0);
        //adapter.notifyDataSetChanged(); 전체 데이터를 모두 바꿀때
        recyclerView.scrollToPosition(0);
    }

    public void clickDel(View view) {
        if(datas.size()==0) return;

        datas.remove(0);
        adapter.notifyItemRemoved(0);
    }

    public void clickLinear(View view) {
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);

    }

    public void clickGrid(View view) {
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(gridLayoutManager);


    }
}
