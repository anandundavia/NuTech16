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
public class WorkShops extends Fragment
{


    public WorkShops()
    {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragment_work_shops, container, false);
        String titles[];
        String others[];
        String locations[];
        String descriptions[];
        String call[];

        titles = getResources().getStringArray(R.array.workshopstitles);
        others = getResources().getStringArray(R.array.workshopsother);
        locations = getResources().getStringArray(R.array.workshopsloc);
        descriptions = getResources().getStringArray(R.array.workshopsdesc);
        call = getResources().getStringArray(R.array.workshopscall);

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
