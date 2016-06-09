package com.allwe.vv.frag;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.allwe.vv.R;
import com.allwe.vv.bean.PostItem;
import com.allwe.vv.listener.RecyclerItemClickListener;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import master.flame.danmaku.ui.widget.DanmakuView;


/**
 * 首页: 最新
 */

public class TabLeastestFrag extends Fragment {

    @Bind(R.id.rlv_leastest_content)
    public RecyclerView rlv_leastest_content;


    @Bind(R.id.pb_show_progress)
    public ProgressBar pb_show_progress;



    public static TabLeastestFrag newInstance(Bundle args){
        TabLeastestFrag leastestFrag = new TabLeastestFrag();

        if(args != null){
            leastestFrag.setArguments(args);
        }
        return leastestFrag;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View contentView =inflater.inflate(R.layout.frag_leastest, container, false);
        ButterKnife.bind(this,contentView);
        initView();

        return contentView;
    }

    private void initView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        rlv_leastest_content.setHasFixedSize(true);
        rlv_leastest_content.setLayoutManager(linearLayoutManager);
        rlv_leastest_content.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(), onItemClickListener));
        rlv_leastest_content.setItemAnimator(new DefaultItemAnimator());


    }

    private RecyclerItemClickListener.OnItemClickListener onItemClickListener = new RecyclerItemClickListener.OnItemClickListener() {
        @Override
        public void onItemClick(View view, int position) {
//            Intent i = new Intent(getActivity());
        }
    };



    public class LeastestAdapter extends  RecyclerView.Adapter<LeastestAdapter.ViewHolder>{

        private List<PostItem> postItemList = new ArrayList<PostItem>();
        private boolean animateItems = true;
        private int lastAnimatedPosition = -1;

        private static final int ANIMATED_ITEMS_COUNT = 4;


        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.mainpage_lv_item,parent,false);
            ViewHolder vh = new ViewHolder(v);
            return vh;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            PostItem postItem = postItemList.get(position);
            holder.vv_title.setText(postItem.getTitle());
            holder.vv_user_name.setText(postItem.getNickname());

            ImageLoader.getInstance().displayImage(postItem.getImg_url(),holder.vv_iv_content_img);
            ImageLoader.getInstance().displayImage(postItem.getIcon_url(),holder.vv_user_img);



        }

        public void updateItems(List<PostItem> postItems){
            lastAnimatedPosition = -1;
            postItemList.addAll(postItems);
            notifyDataSetChanged();
        }

        public void clearItems(){
            postItemList.clear();
            notifyDataSetChanged();
        }

        @Override
        public int getItemCount() {
            return postItemList.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            @Bind(R.id.vv_user_img)
            public CircleImageView vv_user_img;
            @Bind(R.id.vv_user_name)
            public TextView vv_user_name;
            @Bind(R.id.vv_title)
            public TextView vv_title;
            @Bind(R.id.vv_iv_content_img)
            public ImageView vv_iv_content_img;
            @Bind(R.id.sv_danmaku)
            public DanmakuView sv_danmaku;
            @Bind(R.id.vv_tv_content)
            public TextView vv_tv_content;

            public ViewHolder(View itemView) {
                super(itemView);
                ButterKnife.bind(this,itemView);
            }
        }

    }


}
