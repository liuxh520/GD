package nefu.com.exam2;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import nefu.com.exam2.ui.fragment1.Fragment1Fragment;

public class Fragment1 extends AppCompatActivity {

    private Context mContext;
    private GridView grid_photo;
    private BaseAdapter mAdapter = null;
    private ArrayList<Icon> mData = null;
    private TextView temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment1_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, Fragment1Fragment.newInstance())
                    .commitNow();
        }
        mContext = Fragment1.this;
        grid_photo = (GridView) findViewById(R.id.menu_button);

        mData = new ArrayList<Icon>();
        mData.add(new Icon(R.mipmap.ic_launcher, "图标1"));
        mData.add(new Icon(R.mipmap.ic_launcher, "图标2"));
        mData.add(new Icon(R.mipmap.ic_launcher, "图标3"));
        mData.add(new Icon(R.mipmap.ic_launcher, "图标4"));
        mData.add(new Icon(R.mipmap.ic_launcher, "图标5"));
        mData.add(new Icon(R.mipmap.ic_launcher, "图标6"));
        mData.add(new Icon(R.mipmap.ic_launcher, "图标7"));

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
        temp =(TextView)findViewById(R.id.temp);
        temp.setText("asd");
    }
}
