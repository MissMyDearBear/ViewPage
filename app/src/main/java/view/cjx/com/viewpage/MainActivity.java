package view.cjx.com.viewpage;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends FragmentActivity {
    ViewPager mViewPage;
    ViewPageIndicator mIndicator;
    List<String> titles = Arrays.asList(new String[]{"tab1", "tab2", "tab3"});
    List<ContentFragment> contents = new ArrayList<ContentFragment>();
    FragmentPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        iniView();
    }

    private void iniView() {
        mViewPage = (ViewPager) findViewById(R.id.myViewPage);
        mIndicator = (ViewPageIndicator) findViewById(R.id.myIndicator);
        for (String title : titles) {
            contents.add(ContentFragment.newInstance(title));
        }
        adapter =new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return contents.get(position);
            }

            @Override
            public int getCount() {
                return contents.size();
            }
        };
        mViewPage.setAdapter(adapter);
        mViewPage.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                mIndicator.scroll(position,positionOffset);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

}
