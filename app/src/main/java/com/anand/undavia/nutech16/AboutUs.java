package com.anand.undavia.nutech16;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class AboutUs extends Fragment
{


    public AboutUs()
    {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {

        View rootView = inflater.inflate(R.layout.fragment_about_us, container, false);

        TextView emailText = (TextView)rootView.findViewById(R.id.emailTextView);
        emailText.setClickable(true);
        emailText.setMovementMethod(LinkMovementMethod.getInstance());
        String text = "<a href='mailto:13bit060@nirmauni.ac.in?Subject=NUTECH%20Feedback'>Drop a mail</a>";
        emailText.setText(Html.fromHtml(text));

        return rootView;
    }



}
