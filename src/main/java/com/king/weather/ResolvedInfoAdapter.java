package com.king.weather;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by wangqiang on 2018/1/25.
 */

public class ResolvedInfoAdapter extends BaseAdapter {

    private static final String TAG = "ResolvedInfoAdapter" ;
    private Context context;
    private LayoutInflater layoutInflater;
    private List<ResolvedInfo> resolvedInfoList;
    private int layoutId;

    public ResolvedInfoAdapter(Context context, List<ResolvedInfo> resolvedInfoList) {
        this(context, resolvedInfoList, R.layout.resolved_item);
    }

    public ResolvedInfoAdapter(Context context, List<ResolvedInfo> resolvedInfoList, int layoutId) {
        this.context = context;
        this.resolvedInfoList = resolvedInfoList;
        layoutInflater = LayoutInflater.from(context);
        this.layoutId = layoutId;
    }
    @Override
    public int getCount() {
        return resolvedInfoList.size();
    }

    @Override
    public Object getItem(int position) {
        return resolvedInfoList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = layoutInflater.inflate(layoutId, null);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder)convertView.getTag();
        }
        onBindView(viewHolder, convertView, (ResolvedInfo)getItem(position));
        return convertView;
    }

    private void onBindView(ViewHolder viewHolder, View convertView, ResolvedInfo resolvedInfo) {
        viewHolder.icon = (ImageView) convertView.findViewById(R.id.icon);
        viewHolder.title = (TextView) convertView.findViewById(R.id.title);
        viewHolder.summary = (TextView) convertView.findViewById(R.id.summary);
        Log.d(TAG, "onBindView: title="+ resolvedInfo.getTitle());
        if (resolvedInfo.getIcon() != null) {
            viewHolder.icon.setImageDrawable(resolvedInfo.getIcon());
            viewHolder.icon.setVisibility(View.VISIBLE);
        }
        String title = resolvedInfo.getTitle();
        if (title != null && !TextUtils.isEmpty(title)) {
            viewHolder.title.setText(title);
            viewHolder.title.setVisibility(View.VISIBLE);
        }
        String summary = resolvedInfo.getSummary();
        if (summary != null && !TextUtils.isEmpty(summary)) {
            viewHolder.summary.setText(summary);
            viewHolder.summary.setVisibility(View.VISIBLE);
        }
    }

    class ViewHolder {
        ImageView icon;
        TextView title;
        TextView summary;
    }

}
