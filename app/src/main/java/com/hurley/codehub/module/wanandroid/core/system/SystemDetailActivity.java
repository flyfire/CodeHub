package com.hurley.codehub.module.wanandroid.core.system;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.hurley.codehub.R;
import com.hurley.codehub.api.PathContainer;
import com.hurley.codehub.base.BaseActivity;
import com.hurley.codehub.bean.wanandroid.SystemBean;
import com.hurley.codehub.module.wanandroid.core.adapter.SystemDetailAdapter;

import java.util.List;

import butterknife.BindView;

/**
 * <pre>
 *      @author hurley
 *      date    : 2019/3/16 2:00 PM
 *      github  : https://github.com/HurleyJames
 *      desc    : 体系二级目录界面
 * </pre>
 */
@Route(path = PathContainer.SYSTEM_DETAIL)
public class SystemDetailActivity extends BaseActivity {

    @Autowired
    public String title;
    @Autowired
    public List<SystemBean.Children> children;

    @BindView(R.id.tb_system_detail)
    TabLayout mTlSystemDetail;
    @BindView(R.id.vp_system_detail)
    ViewPager mVpSystemDetail;

    SystemDetailAdapter mSystemDetailAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.system_detail_activity;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    protected void initView() {
        setToolbarTitle(title);
        mSystemDetailAdapter = new SystemDetailAdapter(getSupportFragmentManager(), children);
        mVpSystemDetail.setAdapter(mSystemDetailAdapter);
        //将TabLayout与ViewPager绑定
        mTlSystemDetail.setupWithViewPager(mVpSystemDetail);
    }

    /**
     * 显示返回键
     *
     * @return
     */
    @Override
    protected boolean showHomeAsUp() {
        return true;
    }
}
