package com.stack.user.childconnect.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.joooonho.SelectableRoundedImageView;
import com.stack.user.childconnect.LifeBookPreview;
import com.stack.user.childconnect.R;

/**
 * Created by Renjith M R on 20/7/16.
 */
public class LifebookMainAdapter extends BaseAdapter {

    Context mContext;
    private static LayoutInflater inflater;




    public LifebookMainAdapter(Context context) {

        // TODO Auto-generated constructor stub
        mContext = context;
        inflater = ( LayoutInflater )context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return 3;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public class Holder
    {
        TextView txtvwCategory;
        TextView txtvwDob;
        SelectableRoundedImageView slImage;


    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        // TODO Auto-generated method stub
        Holder viewHolder=new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.lifebookmain_list_item, null);

        viewHolder.txtvwCategory=(TextView) rowView.findViewById(R.id.txtvw_category);
        viewHolder.txtvwDob=(TextView) rowView.findViewById(R.id.txtvw_dob);
        viewHolder.slImage=(SelectableRoundedImageView) rowView.findViewById(R.id.rimg_childname);

        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mContext, LifeBookPreview.class);
                mContext.startActivity(intent);


            }
        });
        return rowView;
    }

}
