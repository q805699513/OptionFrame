package com.longsh.optionframelibrary;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.ColorRes;
import android.support.v4.content.ContextCompat;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;


public class OptionMaterialDialog {

    private final static int BUTTON_BOTTOM = 9;
    private final static int BUTTON_TOP = 9;

    private boolean mCancel;
    private Context mContext;
    private AlertDialog mAlertDialog;
    private Builder mBuilder;
    private View mView;
    private int mTitleResId;
    private CharSequence mTitle;
    private int mMessageResId;
    private CharSequence mMessage;
    private Button mPositiveButton;
    private LinearLayout.LayoutParams mLayoutParams;
    private Button mNegativeButton;
    private boolean mHasShow = false;
    private int mBackgroundResId = -1;
    private Drawable mBackgroundDrawable;
    private View mMessageContentView;
    private int mMessageContentViewResId;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private int pId = -1, nId = -1;
    private String pText, nText;
    View.OnClickListener pListener, nListener;
    private int pTextColor = 0;
    private int nTextColor = 0;
    private int mTextColor = 0;
    private int tTextColor = 0;
    private float tTextSize = -1;
    private float mTextSize = -1;
    private float pTextSize = -1;
    private float nTextSize = -1;


    public OptionMaterialDialog(Context context) {
        this.mContext = context;
    }


    public void show() {
        if (!mHasShow) {
            mBuilder = new Builder();
        } else {
            mAlertDialog.show();
        }
        mHasShow = true;
    }


    public OptionMaterialDialog setView(View view) {
        mView = view;
        if (mBuilder != null) {
            mBuilder.setView(view);
        }
        return this;
    }


    public OptionMaterialDialog setContentView(View view) {
        mMessageContentView = view;
        mMessageContentViewResId = 0;
        if (mBuilder != null) {
            mBuilder.setContentView(mMessageContentView);
        }
        return this;
    }


    /**
     * Set a custom view resource to be the contents of the dialog.
     *
     * @param layoutResId resource ID to be inflated
     */
    public OptionMaterialDialog setContentView(int layoutResId) {
        mMessageContentViewResId = layoutResId;
        mMessageContentView = null;
        if (mBuilder != null) {
            mBuilder.setContentView(layoutResId);
        }
        return this;
    }


    public OptionMaterialDialog setBackground(Drawable drawable) {
        mBackgroundDrawable = drawable;
        if (mBuilder != null) {
            mBuilder.setBackground(mBackgroundDrawable);
        }
        return this;
    }


    public OptionMaterialDialog setBackgroundResource(int resId) {
        mBackgroundResId = resId;
        if (mBuilder != null) {
            mBuilder.setBackgroundResource(mBackgroundResId);
        }
        return this;
    }


    public void dismiss() {
        mAlertDialog.dismiss();
    }


    private int dip2px(float dpValue) {
        final float scale = mContext.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }


    private static boolean isLollipop() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP;
    }


    public OptionMaterialDialog setTitle(int resId) {
        mTitleResId = resId;
        if (mBuilder != null) {
            mBuilder.setTitle(resId);
        }
        return this;
    }


    public OptionMaterialDialog setTitle(CharSequence title) {
        mTitle = title;
        if (mBuilder != null) {
            mBuilder.setTitle(title);
        }
        return this;
    }

    public OptionMaterialDialog setTitleTextColor(@ColorRes int tTextColor) {
        this.tTextColor = tTextColor;
        if (mBuilder != null) {
            mBuilder.setTitleColor(tTextColor);
        }
        return this;
    }

    public OptionMaterialDialog setTitleTextSize(float tTextSize) {
        this.tTextSize = tTextSize;
        if (mBuilder != null) {
            mBuilder.setTitleSize(tTextSize);
        }
        return this;
    }


    public OptionMaterialDialog setMessage(int resId) {
        mMessageResId = resId;
        if (mBuilder != null) {
            mBuilder.setMessage(resId);
        }
        return this;
    }


    public OptionMaterialDialog setMessage(CharSequence message) {
        mMessage = message;
        if (mBuilder != null) {
            mBuilder.setMessage(message);
        }
        return this;
    }


    public OptionMaterialDialog setMessageTextColor(@ColorRes int mTextColor) {
        this.mTextColor = mTextColor;
        if (mBuilder != null) {
            mBuilder.setMessageColor(mTextColor);
        }
        return this;
    }

    public OptionMaterialDialog setMessageTextSize(float mTextSize) {

        this.mTextSize = mTextSize;
        if (mBuilder != null) {
            mBuilder.setMessageSize(mTextSize);
        }
        return this;
    }

    public OptionMaterialDialog setPositiveButtonTextColor(@ColorRes int pTextColor) {
        this.pTextColor = pTextColor;
        if (mBuilder != null && mPositiveButton != null) {
            mPositiveButton.setTextColor(ContextCompat.getColor(mContext, pTextColor));
        }
        return this;
    }

    public OptionMaterialDialog setPositiveButtonTextSize(float pTextSize) {
        this.pTextSize = pTextSize;
        if (mBuilder != null && mPositiveButton != null) {
            mPositiveButton.setTextSize(pTextSize);
        }
        return this;
    }

    public OptionMaterialDialog setNegativeButtonTextColor(@ColorRes int nTextColor) {
        this.nTextColor = nTextColor;
        if (mBuilder != null && mNegativeButton != null) {
            mNegativeButton.setTextColor(ContextCompat.getColor(mContext, nTextColor));
        }
        return this;
    }

    public OptionMaterialDialog setNegativeButtonTextSize(float nTextSize) {
        this.nTextSize = nTextSize;
        if (mBuilder != null && mNegativeButton != null) {
            mNegativeButton.setTextSize(nTextSize);
        }
        return this;
    }

    public OptionMaterialDialog setPositiveButton(int resId, final View.OnClickListener listener) {
        this.pId = resId;
        this.pListener = listener;
        return this;
    }


    public Button getPositiveButton() {
        return mPositiveButton;
    }


    public Button getNegativeButton() {
        return mNegativeButton;
    }


    public OptionMaterialDialog setPositiveButton(String text, final View.OnClickListener listener) {
        this.pText = text;
        this.pListener = listener;
        return this;
    }


    public OptionMaterialDialog setNegativeButton(int resId, final View.OnClickListener listener) {
        this.nId = resId;
        this.nListener = listener;
        return this;
    }


    public OptionMaterialDialog setNegativeButton(String text, final View.OnClickListener listener) {
        this.nText = text;
        this.nListener = listener;
        return this;
    }


    /**
     * Sets whether this dialog is canceled when touched outside the window's
     * bounds OR pressed the back key. If setting to true, the dialog is
     * set to be cancelable if not
     * already set.
     *
     * @param cancel Whether the dialog should be canceled when touched outside
     *               the window OR pressed the back key.
     */
    public OptionMaterialDialog setCanceledOnTouchOutside(boolean cancel) {
        this.mCancel = cancel;
        if (mBuilder != null) {
            mBuilder.setCanceledOnTouchOutside(mCancel);
        }
        return this;
    }


    public OptionMaterialDialog setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
        return this;
    }


    private class Builder {

        private TextView mTitleView;
        private ViewGroup mMessageContentRoot;
        private TextView mMessageView;
        private Window mAlertDialogWindow;
        private LinearLayout mButtonLayout;


        private Builder() {
            mAlertDialog = new AlertDialog.Builder(mContext).create();
            mAlertDialog.show();

            mAlertDialog.getWindow()
                    .clearFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE |
                            WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
            mAlertDialog.getWindow()
                    .setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_MASK_STATE);

            mAlertDialogWindow = mAlertDialog.getWindow();
            mAlertDialogWindow.setBackgroundDrawable(
                    new ColorDrawable(Color.TRANSPARENT));

            View contentView = LayoutInflater.from(mContext)
                    .inflate(R.layout.layout_material_dialog, null);
            contentView.setFocusable(true);
            contentView.setFocusableInTouchMode(true);

            mAlertDialogWindow.setBackgroundDrawableResource(R.drawable.material_dialog_window);

            mAlertDialogWindow.setContentView(contentView);

            mTitleView = (TextView) mAlertDialogWindow.findViewById(R.id.title);
            mMessageView = (TextView) mAlertDialogWindow.findViewById(R.id.message);
            mButtonLayout = (LinearLayout) mAlertDialogWindow.findViewById(R.id.buttonLayout);
            mPositiveButton = (Button) mButtonLayout.findViewById(R.id.btn_p);
            mNegativeButton = (Button) mButtonLayout.findViewById(R.id.btn_n);
            mMessageContentRoot = (ViewGroup) mAlertDialogWindow.findViewById(
                    R.id.message_content_root);
            if (mView != null) {
                LinearLayout linearLayout = (LinearLayout) mAlertDialogWindow.findViewById(
                        R.id.contentView);
                linearLayout.removeAllViews();
                linearLayout.addView(mView);
            }
            if (mTitleResId != 0) {
                setTitle(mTitleResId);
            }
            if (mTitle != null) {
                setTitle(mTitle);
            }
            if (tTextSize != -1) {
                setTitleSize(tTextSize);
            }
            if (tTextColor != 0) {
                setTitleColor(tTextColor);
            }

            if (mTitle == null && mTitleResId == 0) {
                mTitleView.setVisibility(View.GONE);
            }
            if (mMessageResId != 0) {
                setMessage(mMessageResId);
            }
            if (mTextColor != 0) {
                setMessageColor(mTextColor);
            }
            if (mMessage != null) {
                setMessage(mMessage);
            }

            if (mTextSize != -1) {
                setMessageSize(mTextSize);
            }

            if (pTextColor != 0) {
                mPositiveButton.setTextColor(ContextCompat.getColor(mContext, pTextColor));
            }

            if (nTextColor != 0) {
                mNegativeButton.setTextColor(ContextCompat.getColor(mContext, nTextColor));
            }

            if (pTextSize != 0) {
                mPositiveButton.setTextSize(pTextSize);
            }

            if (nTextSize != 0) {
                mNegativeButton.setTextSize(nTextSize);
            }


            if (pId != -1) {
                mPositiveButton.setVisibility(View.VISIBLE);
                mPositiveButton.setText(pId);
                mPositiveButton.setOnClickListener(pListener);
                if (isLollipop()) {
                    mPositiveButton.setElevation(0);
                }
            }
            if (nId != -1) {
                mNegativeButton.setVisibility(View.VISIBLE);
                mNegativeButton.setText(nId);
                mNegativeButton.setOnClickListener(nListener);
                if (isLollipop()) {
                    mNegativeButton.setElevation(0);
                }
            }
            if (!isNullOrEmpty(pText)) {
                mPositiveButton.setVisibility(View.VISIBLE);
                mPositiveButton.setText(pText);
                mPositiveButton.setOnClickListener(pListener);
                if (isLollipop()) {
                    mPositiveButton.setElevation(0);
                }
            }

            if (!isNullOrEmpty(nText)) {
                mNegativeButton.setVisibility(View.VISIBLE);
                mNegativeButton.setText(nText);
                mNegativeButton.setOnClickListener(nListener);
                if (isLollipop()) {
                    mNegativeButton.setElevation(0);
                }
            }
            if (isNullOrEmpty(pText) && pId == -1) {
                mPositiveButton.setVisibility(View.GONE);
            }
            if (isNullOrEmpty(nText) && nId == -1) {
                mNegativeButton.setVisibility(View.GONE);
            }
            if (mBackgroundResId != -1) {
                LinearLayout linearLayout = (LinearLayout) mAlertDialogWindow.findViewById(
                        R.id.material_background);
                linearLayout.setBackgroundResource(mBackgroundResId);
            }
            if (mBackgroundDrawable != null) {
                LinearLayout linearLayout = (LinearLayout) mAlertDialogWindow.findViewById(
                        R.id.material_background);
                linearLayout.setBackground(mBackgroundDrawable);
            }

            if (mMessageContentView != null) {
                this.setContentView(mMessageContentView);
            } else if (mMessageContentViewResId != 0) {
                this.setContentView(mMessageContentViewResId);
            }
            mAlertDialog.setCanceledOnTouchOutside(mCancel);
            mAlertDialog.setCancelable(mCancel);
            if (mOnDismissListener != null) {
                mAlertDialog.setOnDismissListener(mOnDismissListener);
            }
        }


        public void setTitle(int resId) {
            mTitleView.setText(resId);
        }


        public void setTitle(CharSequence title) {
            mTitleView.setText(title);
        }


        public void setMessage(int resId) {
            if (mMessageView != null) {
                mMessageView.setText(resId);
            }
        }


        public void setMessage(CharSequence message) {
            if (mMessageView != null) {
                mMessageView.setText(message);
            }
        }

        public void setMessageColor(int mTextColor) {
            if (mMessageView != null) {
                mMessageView.setTextColor(ContextCompat.getColor(mContext, mTextColor));
            }
        }

        public void setMessageSize(float mTextSize) {
            if (mMessageView != null) {
                mMessageView.setTextSize(mTextSize);
            }
        }

        public void setTitleColor(int tTextColor) {
            if (mTitleView != null) {
                mTitleView.setTextColor(ContextCompat.getColor(mContext, tTextColor));
            }
        }

        public void setTitleSize(float mTextsSize) {
            if (mTitleView != null) {
                mTitleView.setTextSize(mTextsSize);
            }
        }

        /**
         * dp转px
         *
         * @param dpValue dp值
         * @return px值
         */
        public int dp2px(float dpValue) {
            final float scale = mContext.getResources().getDisplayMetrics().density;
            return (int) (dpValue * scale + 0.5f);
        }

        /**
         * set positive button
         *
         * @param text the name of button
         */
        public void setPositiveButton(String text, final View.OnClickListener listener) {
            Button button = new Button(mContext);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            button.setLayoutParams(params);
            button.setBackgroundResource(R.drawable.material_card);
            button.setTextColor(Color.argb(255, 35, 159, 242));
            button.setText(text);
            button.setGravity(Gravity.CENTER);
            button.setTextSize(14);
            button.setPadding(dip2px(12), 0, dip2px(32), dip2px(BUTTON_BOTTOM));
            button.setOnClickListener(listener);
            mButtonLayout.addView(button);
        }


        /**
         * set negative button
         *
         * @param text the name of button
         */
        public void setNegativeButton(String text, final View.OnClickListener listener) {
            Button button = new Button(mContext);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            button.setLayoutParams(params);
            button.setBackgroundResource(R.drawable.material_card);
            button.setText(text);
            button.setTextColor(Color.argb(222, 0, 0, 0));
            button.setTextSize(14);
            button.setGravity(Gravity.CENTER);
            button.setPadding(0, 0, 0, dip2px(8));
            button.setOnClickListener(listener);
            if (mButtonLayout.getChildCount() > 0) {
                params.setMargins(20, 0, 10, dip2px(BUTTON_BOTTOM));
                button.setLayoutParams(params);
                mButtonLayout.addView(button, 1);
            } else {
                button.setLayoutParams(params);
                mButtonLayout.addView(button);
            }
        }


        public void setView(View view) {
            LinearLayout l = (LinearLayout) mAlertDialogWindow.findViewById(R.id.contentView);
            l.removeAllViews();
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            view.setLayoutParams(layoutParams);

            view.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    mAlertDialogWindow.setSoftInputMode(
                            WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
                    // show imm
                    InputMethodManager imm = (InputMethodManager) mContext.getSystemService(
                            Context.INPUT_METHOD_SERVICE);
                    imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,
                            InputMethodManager.HIDE_IMPLICIT_ONLY);
                }
            });

            l.addView(view);

            if (view instanceof ViewGroup) {

                ViewGroup viewGroup = (ViewGroup) view;

                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    if (viewGroup.getChildAt(i) instanceof EditText) {
                        EditText editText = (EditText) viewGroup.getChildAt(i);
                        editText.setFocusable(true);
                        editText.requestFocus();
                        editText.setFocusableInTouchMode(true);
                    }
                }
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    if (viewGroup.getChildAt(i) instanceof AutoCompleteTextView) {
                        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) viewGroup
                                .getChildAt(i);
                        autoCompleteTextView.setFocusable(true);
                        autoCompleteTextView.requestFocus();
                        autoCompleteTextView.setFocusableInTouchMode(true);
                    }
                }
            }
        }


        public void setContentView(View contentView) {
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            contentView.setLayoutParams(layoutParams);
            if (contentView instanceof ListView) {
                setListViewHeightBasedOnChildren((ListView) contentView);
            }
            LinearLayout linearLayout = (LinearLayout) mAlertDialogWindow.findViewById(
                    R.id.message_content_view);
            if (linearLayout != null) {
                linearLayout.removeAllViews();
                linearLayout.addView(contentView);
            }
            for (int i = 0; i < (linearLayout != null ? linearLayout.getChildCount() : 0); i++) {
                if (linearLayout.getChildAt(i) instanceof AutoCompleteTextView) {
                    AutoCompleteTextView autoCompleteTextView
                            = (AutoCompleteTextView) linearLayout.getChildAt(i);
                    autoCompleteTextView.setFocusable(true);
                    autoCompleteTextView.requestFocus();
                    autoCompleteTextView.setFocusableInTouchMode(true);
                }
            }
        }


        /**
         * Set a custom view resource to be the contents of the dialog. The
         * resource will be inflated into a ScrollView.
         *
         * @param layoutResId resource ID to be inflated
         */
        public void setContentView(int layoutResId) {
            mMessageContentRoot.removeAllViews();
            // Not setting this to the other content view because user has defined their own
            // layout params, and we don't want to overwrite those.
            LayoutInflater.from(mMessageContentRoot.getContext())
                    .inflate(layoutResId, mMessageContentRoot);
        }


        public void setBackground(Drawable drawable) {
            LinearLayout linearLayout = (LinearLayout) mAlertDialogWindow.findViewById(
                    R.id.material_background);
            linearLayout.setBackground(drawable);
        }


        public void setBackgroundResource(int resId) {
            LinearLayout linearLayout = (LinearLayout) mAlertDialogWindow.findViewById(
                    R.id.material_background);
            linearLayout.setBackgroundResource(resId);
        }


        public void setCanceledOnTouchOutside(boolean canceledOnTouchOutside) {
            mAlertDialog.setCanceledOnTouchOutside(canceledOnTouchOutside);
            mAlertDialog.setCancelable(canceledOnTouchOutside);
        }
    }


    private boolean isNullOrEmpty(String nText) {
        return nText == null || nText.isEmpty();
    }


    private void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            // pre-condition
            return;
        }

        int totalHeight = 0;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }
}

