package com.hurley.codehub.module.wanandroid.core.user.register;

import android.widget.Button;
import android.widget.EditText;


import com.alibaba.android.arouter.facade.annotation.Route;
import com.blankj.utilcode.util.StringUtils;
import com.hurley.codehub.R;
import com.hurley.codehub.api.PathContainer;
import com.hurley.codehub.base.BaseActivity;
import com.hurley.codehub.bean.wanandroid.UserBean;
import com.hurley.codehub.module.wanandroid.event.RegisterEvent;
import com.hurley.codehub.helper.view.EditTextInputHelper;
import com.hurley.codehub.net.callback.RxBus;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * <pre>
 *      @author hurley
 *      date   : 2019/2/17 上午10:18
 *      github : https://github.com/HurleyJames
 *      desc   : 注册界面
 * </pre>
 */
@Route(path = PathContainer.REGISTER)
public class RegisterActivity extends BaseActivity<RegisterPresenter> implements RegisterContract.View {

    private static final String TAG = "RegisterActivity";

    @BindView(R.id.et_register_username)
    EditText mEtUserName;
    @BindView(R.id.et_register_password)
    EditText mEtPassword;
    @BindView(R.id.et_register_confirm_password)
    EditText mEtConfirmPassword;
    @BindView(R.id.btn_register_commit)
    Button mBtnRegister;

    private EditTextInputHelper mEditTextInputHelper;

    @Override
    protected int getLayoutId() {
        return R.layout.register_activity;
    }

    @Override
    protected void initInjector() {
        mActivityComponent.inject(this);
    }

    @Override
    protected void initView() {
        setToolbarTitle("");
        mEditTextInputHelper = new EditTextInputHelper(mBtnRegister);
        mEditTextInputHelper.addViews(mEtUserName, mEtPassword, mEtConfirmPassword);
    }

    @Override
    public void registerSuccess(UserBean userBean) {
        toast(R.string.register_success);
        RxBus.getInstance().post(new RegisterEvent());
        this.finish();
    }

    /**
     * 显示返回键
     * @return
     */
    @Override
    protected boolean showHomeAsUp() {
        return true;
    }

    @OnClick(R.id.btn_register_commit)
    public void onClick() {
        String username = mEtUserName.getText().toString().trim();
        String password = mEtPassword.getText().toString().trim();
        String repassword = mEtConfirmPassword.getText().toString().trim();
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password) || StringUtils.isEmpty(repassword)) {
            //如果用户名或密码为空
            toast(R.string.login_username_password_null);
            return;
        }
        if (!password.equals(repassword)) {
            //如果密码与确认密码不一致
            toast(R.string.confirm_password_input_error);
            return;
        }
        mPresenter.register(username, password, repassword);
    }

}
