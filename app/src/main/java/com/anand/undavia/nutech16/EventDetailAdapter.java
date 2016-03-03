package com.anand.undavia.nutech16;


import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class EventDetailAdapter extends ArrayAdapter<String>
{

    Context localContext;
    String titles[];
    String others[];
    String locations[];
    String descriptions[];
    String call[];
    public EventDetailAdapter(Context context, String t[], String r[], String l[], String des[],String c[])
    {
        super(context, android.R.layout.simple_list_item_1, t);
        localContext = context;
        titles = t;
        others = r;
        locations = l;
        descriptions = des;
        call = c;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent)
    {
        View localView = convertView;
        if (localView == null)
        {
            LayoutInflater layoutInflater = (LayoutInflater) localContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            localView = layoutInflater.inflate(R.layout.event, null);
        }
        ((TextView) localView.findViewById(R.id.eventTitle)).setText(titles[position]);
        ((TextView) localView.findViewById(R.id.loc)).setText(locations[position]);
        ((TextView) localView.findViewById(R.id.eventOther)).setText(others[position]);
        ((TextView) localView.findViewById(R.id.eventDesc)).setText(descriptions[position]);

        ((TextView) localView.findViewById(R.id.textView2)).setClickable(true);

        ((TextView) localView.findViewById(R.id.textView2)).setOnClickListener(
                new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        Intent callIntent = new Intent(Intent.ACTION_CALL);
                        callIntent.setData(Uri.parse("tel:" + call[position]));
                        try
                        {
                            localContext.startActivity(callIntent);
                        } catch (Exception e)
                        {
                        }

                    }
                }
        );
        return localView;
    }
}
