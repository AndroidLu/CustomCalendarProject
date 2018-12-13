package com.muaedu.basis.customcalendarproject;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.muaedu.basis.customcalendarproject.group.GroupRecyclerAdapter;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * 适配器
 */

public class ArticleAdapter extends GroupRecyclerAdapter<String, Article> {


    private RequestManager mLoader;

    public ArticleAdapter(Context context) {
        super(context);
        mLoader = Glide.with(context.getApplicationContext());
        LinkedHashMap<String, List<Article>> map = new LinkedHashMap<>();
        List<String> titles = new ArrayList<>();
        map.put("今天", create(0));
        map.put("已完成", create(1));
        map.put("待处理", create(2));
        titles.add("今天");
        titles.add("已完成");
        titles.add("待处理");
        resetGroups(map,titles);
    }


    @Override
    protected RecyclerView.ViewHolder onCreateDefaultViewHolder(ViewGroup parent, int type) {
        return new ArticleViewHolder(mInflater.inflate(R.layout.adapter_remind_matter_item, parent, false));
    }

    @Override
    protected void onBindViewHolder(RecyclerView.ViewHolder holder, Article item, int position) {
        ArticleViewHolder h = (ArticleViewHolder) holder;
        h.mTextTitle.setText(item.getTitle());
        h.mTextContentTime.setText(item.getContent());
        h.mTextContent.setText(item.getContent());
//        mLoader.load(item.getImgUrl())
//                .asBitmap()
//                .centerCrop()
//                .into(h.mImageView);
    }

    private static class ArticleViewHolder extends RecyclerView.ViewHolder {
        private TextView mTextTitle,
                mTextContentTime,mTextContent;

        private ArticleViewHolder(View itemView) {
            super(itemView);
            mTextTitle = (TextView) itemView.findViewById(R.id.tv_remind_text);
            mTextContentTime = (TextView) itemView.findViewById(R.id.tv_remind_time);
            mTextContent = (TextView) itemView.findViewById(R.id.tv_remind_remark_text);
        }
    }


    private static Article create(String title, String content, String imgUrl) {
        Article article = new Article();
        article.setTitle(title);
        article.setContent(content);
        article.setImgUrl(imgUrl);
        return article;
    }

    private static List<Article> create(int p) {
        List<Article> list = new ArrayList<>();
        if (p == 0) {
            list.add(create("测试",
                    "2018-08-29",
                    "2018-08-29早上早点起床"));
            list.add(create("测试",
                    "2018-08-29",
                    "2018-08-29早上早点起床"));
        } else if (p == 1) {
            list.add(create("测试",
                    "2018-08-29",
                    "2018-08-29早上早点起床"));
            list.add(create("测试",
                    "2018-08-29",
                    "2018-08-29早上早点起床"));
            list.add(create("测试",
                    "2018-08-29",
                    "2018-08-29早上早点起床"));
            list.add(create("测试",
                    "2018-08-29",
                    "2018-08-29早上早点起床"));
            list.add(create("测试",
                    "2018-08-29",
                    "2018-08-29早上早点起床"));
        } else if (p == 2) {
            list.add(create("测试",
                    "2018-08-29",
                    "2018-08-29早上早点起床"));
            list.add(create("测试",
                    "2018-08-29",
                    "2018-08-29早上早点起床"));
            list.add(create("测试",
                    "2018-08-29",
                    "2018-08-29早上早点起床"));
            list.add(create("测试",
                    "2018-08-29",
                    "2018-08-29早上早点起床"));
            list.add(create("测试",
                    "2018-08-29",
                    "2018-08-29早上早点起床"));
        }


        return list;
    }
}
