package com.stack.user.childconnect.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.stack.user.childconnect.R;
import com.stack.user.childconnect.ViewMessageActivity;

/**
 * Created by Renjith M R on 21/7/16.
 */
public class MessageViewListAdapter extends BaseAdapter {

    Context mContext;
    private static LayoutInflater inflater;




    public MessageViewListAdapter(Context context) {

        // TODO Auto-generated constructor stub
        mContext = context;
        inflater = ( LayoutInflater )context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return 5;
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
        TextView txtvwStdName;
        TextView txtvwStdId;
        Button btnAttandance;


    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        // TODO Auto-generated method stub
        Holder viewHolder=new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.view_message_list_item, null);

       /* viewHolder.txtvwStdName=(TextView) rowView.findViewById(R.id.txtvw_stdname);
        viewHolder.txtvwStdId=(TextView) rowView.findViewById(R.id.txtvwid_);
        viewHolder.btnAttandance=(Button) rowView.findViewById(R.id.txtvw_studentaorp);*/

        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mContext, ViewMessageActivity.class);
                mContext.startActivity(intent);


            }
        });
        return rowView;
    }

}

