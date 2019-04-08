package nefu.com.exam2.ui.fragment1;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


import nefu.com.exam2.Icon;
import nefu.com.exam2.MyAdapter;
import nefu.com.exam2.R;

public class Fragment1Fragment extends Fragment {

    private Fragment1ViewModel mViewModel;
    private Context mContext;
    private GridView grid_photo;
    private BaseAdapter mAdapter = null;
    private ArrayList<Icon> mData = null;
    private TextView temp;
    public static Fragment1Fragment newInstance() {
        return new Fragment1Fragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment1_fragment,container,false);

        mContext = this.getActivity();
        grid_photo = (GridView)view.findViewById(R.id.menu_button);

        mData = new ArrayList<Icon>();
        mData.add(new Icon(R.mipmap.ic_launcher, "药品查询"));
        mData.add(new Icon(R.mipmap.ic_launcher, "用药定时"));
        mData.add(new Icon(R.mipmap.ic_launcher, "联系监护人"));
        mData.add(new Icon(R.mipmap.ic_launcher, "查询记录"));
        mData.add(new Icon(R.mipmap.ic_launcher, "建立监护关系"));


        mAdapter = new MyAdapter<Icon>(mData, R.layout.menu_button) {
            @Override
            public void bindView(ViewHolder holder, Icon obj) {
                holder.setImageResource(R.id.img_icon, obj.getiId());
                holder.setText(R.id.txt_icon, obj.getiName());
            }
        };

        grid_photo.setAdapter(mAdapter);

        grid_photo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(mContext, "你点击了~" + position + "~项", Toast.LENGTH_SHORT).show();
            }
        });


        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(Fragment1ViewModel.class);
        // TODO: Use the ViewModel

    }

}
