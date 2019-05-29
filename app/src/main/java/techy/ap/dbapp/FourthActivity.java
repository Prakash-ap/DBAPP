package techy.ap.dbapp;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.zip.Inflater;

import techy.ap.dbapp.Adapter.BookingAdapter;
import techy.ap.dbapp.Adapter.RecycleViewAdapter;
import techy.ap.dbapp.Database.Database;
import techy.ap.dbapp.Model.Booking;

public class FourthActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Database db;
    private ArrayList<Booking>bookingArrayList;

    private View.OnClickListener onItemClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            RecyclerView.ViewHolder viewHolder=(RecyclerView.ViewHolder)v.getTag();
            int pos=viewHolder.getAdapterPosition();
            Booking book=bookingArrayList.get(pos);
            AlertDialog.Builder alertdialoialog=new AlertDialog.Builder(FourthActivity.this);
            LayoutInflater inflater=FourthActivity.this.getLayoutInflater();
            View dialogvoiew= inflater.inflate(R.layout.alert_label_editor,null);
            alertdialoialog.setView(dialogvoiew);

            TextView name=(TextView)dialogvoiew.findViewById(R.id.docsname);
            TextView paname=(TextView)dialogvoiew.findViewById(R.id.patname);
            TextView phone=(TextView)dialogvoiew.findViewById(R.id.phonenumber);
            TextView date=(TextView)dialogvoiew.findViewById(R.id.date);
            TextView time=(TextView)dialogvoiew.findViewById(R.id.time);

            name.setText(book.getDocsname());
            paname.setText(book.getPatname());
            phone.setText(book.getPhonenumber());
            date.setText(book.getDate());
            time.setText(book.getTime());
            AlertDialog alertDialog=alertdialoialog.create();
            alertDialog.show();
        }
    };
   /* private View.OnClickListener itemselected=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
        RecyclerView.ViewHolder viewHolder=(RecyclerView.ViewHolder)v.getTag();
        int pos=viewHolder.getAdapterPosition();
        Booking boks=bookingArrayList.get(pos);
            Toast.makeText(FourthActivity.this, "You Clicked: " + boks.getPatname(), Toast.LENGTH_SHORT).show();
        }
    };*/



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
        db=new Database(this);
        bookingArrayList=db.getAllBooking();


        recyclerView=findViewById(R.id.secondrecycleview);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        BookingAdapter bookingAdapter=new BookingAdapter(bookingArrayList);
        recyclerView.setAdapter(bookingAdapter);
        bookingAdapter.setsecondItemClicListener(onItemClickListener);
    }
}
