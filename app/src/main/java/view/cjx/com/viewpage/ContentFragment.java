package view.cjx.com.viewpage;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by bear on 16/3/16.
 */
public class ContentFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        TextView tv=new TextView(getActivity());
        tv.setGravity(Gravity.CENTER);
        tv.setTextColor(getActivity().getResources().getColor(R.color.colorAccent));
        tv.setText(getArguments().getString("title"));
        return tv;
    }
    public static ContentFragment newInstance(String title){
        ContentFragment fragment=new ContentFragment();
        Bundle bd=new Bundle();
        bd.putString("title",title);
        fragment.setArguments(bd);
        return  fragment;
    }
}
