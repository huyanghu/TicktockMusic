package com.freedom.lauzy.ticktockmusic.ui.fragment;


import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.freedom.lauzy.ticktockmusic.R;
import com.freedom.lauzy.ticktockmusic.base.BaseFragment;
import com.freedom.lauzy.ticktockmusic.presenter.NetMusicCategoryPresenter;
import com.freedom.lauzy.ticktockmusic.ui.adapter.CategoryAdapter;
import com.lauzy.freedom.librarys.widght.TickToolbar;

import butterknife.BindView;

/**
 * Desc : 分类
 * Author : Lauzy
 * Date : 2017/8/2
 * Blog : http://www.jianshu.com/u/e76853f863a9
 * Email : freedompaladin@gmail.com
 */
public class NetMusicCategoryFragment extends BaseFragment<NetMusicCategoryPresenter> {

    @BindView(R.id.rv_category)
    RecyclerView mRvCategory;
    @BindView(R.id.toolbar_common)
    TickToolbar mToolbarCommon;

    public static NetMusicCategoryFragment newInstance() {
        NetMusicCategoryFragment fragment = new NetMusicCategoryFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_net_music;
    }

    @Override
    protected void initInjector() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected void initViews() {
        setToolbar(mToolbarCommon);
        setToolbarPadding(mToolbarCommon);

        mRvCategory.setLayoutManager(new GridLayoutManager(mActivity, 2));
        CategoryAdapter adapter = new CategoryAdapter(R.layout.song_category_item,
                mPresenter.getCategoryData(mActivity));
        mRvCategory.setAdapter(adapter);
    }

    @Override
    protected void loadData() {

    }
}