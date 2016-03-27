package me.czmc.viewpagerindicator;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by MZone on 3/27/2016.
 */
public class TagFragment extends Fragment {
    public static final String BUNDLE_TITLE="BUNDLE_TITLE";
    public static TagFragment newInstance(String  title) {
        Bundle args = new Bundle();
        args.putString(BUNDLE_TITLE,title);
        TagFragment fragment = new TagFragment();
        fragment.setArguments(args);
        return fragment;
    }
    public TagFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView =inflater.inflate(R.layout.fragment_tag,null);
        TextView titleView = (TextView)rootView.findViewById(R.id.title);
        String title = getArguments().getString(BUNDLE_TITLE);
        titleView.setText(title);
        return rootView;
    }
}
