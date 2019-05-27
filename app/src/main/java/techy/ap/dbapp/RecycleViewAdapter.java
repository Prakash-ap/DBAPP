package techy.ap.dbapp;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.MyViewHolder> implements AdapterView.OnItemClickListener {
    private Context context;
    private ArrayList<Docs>docs;

    public RecycleViewAdapter(Context context, ArrayList<Docs> docs) {
        this.context = context;
        this.docs = docs;
    }

    @NonNull
    @Override
    public RecycleViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v= LayoutInflater.from(context).inflate(R.layout.childview,null,false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleViewAdapter.MyViewHolder myViewHolder, int i) {

        Docs docstabel=docs.get(i);

        myViewHolder.name.setText(docstabel.getName());
        myViewHolder.specialist.setText(docstabel.getSpecialist());



    }

    @Override
    public int getItemCount() {
        return docs.size();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

/*

        Docs docstabels=docs.get(position);
        Intent intent=new Intent(context,ThirdActivity.class);
        intent.putExtra("postion", String.valueOf(docstabels));
        intent.putExtra("name",docstabels.getName());
        context.startActivity(intent);
*/

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name,specialist;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name=(TextView)itemView.findViewById(R.id.text1);
            specialist=(TextView)itemView.findViewById(R.id.text2);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                  //  Docs docstabels=docs.get(position);
                    /*Docs docstabels=new Docs();

                    Intent intent=new Intent(context,ThirdActivity.class);

                    intent.putExtra("name",docstabels.getName());
                    context.startActivity(intent);*/


                }
            });





        }

    }
}
