package com.stack.user.childconnect.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.stack.user.childconnect.ChildDetailViewActivity;
import com.stack.user.childconnect.Models.ChildDetailModel;
import com.stack.user.childconnect.R;

import java.util.ArrayList;

/**
 * Created by user on 18/7/16.
 */
public class ChildListAdapter extends BaseAdapter {

    Context mContext;
    private static LayoutInflater inflater;
    private ArrayList<ChildDetailModel> aryChildDetail=new ArrayList<>();

    public ChildListAdapter(Context context,ArrayList<ChildDetailModel> ary) {

        // TODO Auto-generated constructor stub
        mContext = context;
        aryChildDetail=ary;
        inflater = ( LayoutInflater )context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return aryChildDetail.size();
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
        TextView txtvwChildName;
        TextView txtvwDob;
        TextView txtvwmessageType;
        ImageView imgPhoto;


    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        // TODO Auto-generated method stub
        Holder viewHolder=new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.childlist_item, null);

        viewHolder.txtvwChildName=(TextView) rowView.findViewById(R.id.txtvw_name);
        viewHolder.txtvwDob=(TextView) rowView.findViewById(R.id.txtvw_dob);
        viewHolder.txtvwmessageType=(TextView) rowView.findViewById(R.id.txtvw_msgtype);
        viewHolder.imgPhoto=(ImageView) rowView.findViewById(R.id.img_child);

        viewHolder.txtvwChildName.setText(aryChildDetail.get(position).getName());
        viewHolder.txtvwDob.setText(aryChildDetail.get(position).getDate());
        viewHolder.txtvwmessageType.setText(aryChildDetail.get(position).getMessageType());
        viewHolder.imgPhoto.setImageResource(aryChildDetail.get(position).getImageId());


        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(mContext, ChildDetailViewActivity.class);
                intent.putExtra("childPhoto",aryChildDetail.get(position).getImageId());
                intent.putExtra("ChildName",aryChildDetail.get(position).getName());
                intent.putExtra("ChildDob",aryChildDetail.get(position).getDate());
                mContext.startActivity(intent);

            }
        });
        return rowView;
    }

}
