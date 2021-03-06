package com.askme.smart_map.activity.TaskToDoBuilder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.yalantis.guillotine.sample.R;

import java.util.ArrayList;

/**
 * Created by gadhaa on 2/14/2016.
 */
public class Saved_sms_listview_adapter extends BaseAdapter {
    private static LayoutInflater inflater = null;
    ArrayList<String[]> result;
    Context context;

    public Saved_sms_listview_adapter(Saved_message saved_message, ArrayList<String[]> result) {
        // TODO Auto-generated constructor stub
        this.result = result;
        this.context = saved_message;

        inflater = (LayoutInflater) context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return result.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return result.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub

        final String[] singleSms = result.get(position);

        Holder holder = new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.saved_sms_row, null);
        holder.smsNumber = (TextView) rowView.findViewById(R.id.smsNumber);
        holder.smsBody = (TextView) rowView.findViewById(R.id.smsBody);
        holder.smsLocationOrDate = (TextView) rowView.findViewById(R.id.smsLocationOrTime);


        holder.smsStatus = (ImageView) rowView.findViewById(R.id.smsStatus);

        holder.smsNumber.setText(singleSms[1]);
        holder.smsBody.setText(singleSms[2]);

        if (singleSms[5].equalsIgnoreCase("NONE")) {
            holder.smsLocationOrDate.setText(singleSms[3]);
        } else
            holder.smsLocationOrDate.setText(singleSms[5]);


        if(singleSms[6].equalsIgnoreCase("SUCCESS"))
            holder.smsStatus.setImageResource(R.drawable.success);

        return rowView;
    }

    public class Holder {
        TextView smsNumber;
        TextView smsBody;
        TextView smsLocationOrDate;
        ImageView smsStatus;
    }

}
