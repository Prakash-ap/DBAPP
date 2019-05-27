package techy.ap.dbapp;

import android.content.Intent;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {
    Database db;
    RecyclerView recyclerView;
    RecycleViewAdapter recycleViewAdapter;
  ArrayList<Docs> docsArrayList;
  ListAdapter arrayAdapter;
  Docs docs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        db=new Database(this);
        recyclerView=findViewById(R.id.recycleview);
       recyclerView.hasFixedSize();
       docsArrayList=new ArrayList<>();
       docsArrayList=db.getAllDocsDetail();


       RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this);
       recyclerView.setLayoutManager(layoutManager);
       recycleViewAdapter=new RecycleViewAdapter(this,docsArrayList);
       recyclerView.setAdapter(recycleViewAdapter);

       recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
           @Override
           public boolean onInterceptTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
               Toast.makeText(SecondActivity.this, "Touch event occurs", Toast.LENGTH_SHORT).show();
               Intent intent=new Intent(SecondActivity.this,ThirdActivity.class);
               startActivity(intent);



               return false;

           }

           @Override
           public void onTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {

           }

           @Override
           public void onRequestDisallowInterceptTouchEvent(boolean b) {

           }
       });



    }
}
