package com.anand.undavia.nutech16;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Mechatrix extends Fragment
{
    public Mechatrix()
    {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragment_mechatrix, container, false);
        String titles[];
        String others[];
        String locations[];
        String descriptions[];
        String call[];

        titles = getResources().getStringArray(R.array.mechatrixtitle);
        others = getResources().getStringArray(R.array.mechatrixother);
        locations = getResources().getStringArray(R.array.mechatrixloc);
        descriptions = getResources().getStringArray(R.array.mechatrixdesc);
        call = getResources().getStringArray(R.array.mechatrixcall);

        for(int i=0;i<descriptions.length;i++)
            descriptions[i] += "\n";

        ListView list = (ListView) rootView.findViewById(R.id.listView);
        list.setDivider(null);

        EventDetailAdapter eventDetailAdapter = new EventDetailAdapter(getContext(), titles, others, locations, descriptions,call);

        list.setAdapter(eventDetailAdapter);
        eventDetailAdapter.notifyDataSetChanged();

        return rootView;
    }

}
