package com.muaedu.basis.customcalendarproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.LinearLayoutManager;

import com.muaedu.basis.customcalendarproject.calendarview.Calendar;
import com.muaedu.basis.customcalendarproject.calendarview.CalendarLayout;
import com.muaedu.basis.customcalendarproject.calendarview.CalendarView;
import com.muaedu.basis.customcalendarproject.group.GroupItemDecoration;
import com.muaedu.basis.customcalendarproject.group.GroupRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements
        CalendarView.OnDateSelectedListener,
        CalendarView.OnMonthChangeListener,
        CalendarView.OnYearChangeListener,
        CalendarView.OnDateLongClickListener,
        CalendarView.OnViewChangeListener {
    @BindView(R.id.tv_month)
    AppCompatTextView tvMonth;
    @BindView(R.id.tv_year)
    AppCompatTextView tvYear;
    @BindView(R.id.iv_current_day)
    AppCompatImageView ivCurrentDay;
    @BindView(R.id.calendarView)
    CalendarView calendarView;
    @BindView(R.id.recyclerView)
    GroupRecyclerView recyclerView;
    @BindView(R.id.calendarLayout)
    CalendarLayout calendarLayout;
    private int mYear;
//    mCalendarView.scrollToCurrent();
//     calendarView.scrollToCurrent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        tvMonth.setText(String.valueOf(calendarView.getCurMonth()) + getString(R.string.month_text));
        tvYear.setText(String.valueOf(calendarView.getCurYear()) + getString(R.string.year_text));
        calendarView.setOnDateSelectedListener(this);
        calendarView.setOnYearChangeListener(this);
        calendarView.setOnMonthChangeListener(this);
        calendarView.setOnDateLongClickListener(this, true);
        calendarView.setOnViewChangeListener(this);
        mYear = calendarView.getCurYear();
        initData();
    }

    private void initData() {
        List<Calendar> schemes = new ArrayList<>();
        int year = calendarView.getCurYear();
        int month = calendarView.getCurMonth();
//        Map<String, Calendar> map = new HashMap<>();
//        map.put(getSchemeCalendar(year, month, 3, this.getResources().getColor(R.color.text_blue), "假").toString(),
//                getSchemeCalendar(year, month, 3, this.getResources().getColor(R.color.text_blue), "假"));
//        map.put(getSchemeCalendar(year, month, 6, this.getResources().getColor(R.color.text_blue), "事").toString(),
//                getSchemeCalendar(year, month, 6, this.getResources().getColor(R.color.text_blue), "事"));
//        map.put(getSchemeCalendar(year, month, 9, this.getResources().getColor(R.color.text_blue), "议").toString(),
//                getSchemeCalendar(year, month, 9, this.getResources().getColor(R.color.text_blue), "议"));
//        map.put(getSchemeCalendar(year, month, 13,this.getResources().getColor(R.color.text_blue), "记").toString(),
//                getSchemeCalendar(year, month, 13,this.getResources().getColor(R.color.text_blue), "记"));
//        map.put(getSchemeCalendar(year, month, 14,this.getResources().getColor(R.color.text_blue), "记").toString(),
//                getSchemeCalendar(year, month, 14, this.getResources().getColor(R.color.text_blue), "记"));
//        //此方法在巨大的数据量上不影响遍历性能，推荐使用
//        calendarView.setSchemeDate(map);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new GroupItemDecoration<String, Article>());
        recyclerView.setAdapter(new ArticleAdapter(this));
        recyclerView.notifyDataSetChanged();
    }

    private Calendar getSchemeCalendar(int year, int month, int day, int color, String text) {
        Calendar calendar = new Calendar();
        calendar.setYear(year);
        calendar.setMonth(month);
        calendar.setDay(day);
        calendar.setSchemeColor(color);//如果单独标记颜色、则会使用这个颜色
        calendar.setScheme(text);
        calendar.addScheme(new Calendar.Scheme());
        calendar.addScheme(this.getResources().getColor(R.color.text_blue), "事");
        return calendar;
    }

    @Override
    public void onYearChange(int year) {

    }

    @Override
    public void onMonthChange(int year, int month) {
        tvMonth.setText(month + "" + getString(R.string.month_text));
        tvYear.setText(String.valueOf(year + getString(R.string.year_text)));
    }

    @Override
    public void onDateSelected(Calendar calendar, boolean isClick) {
//        tvMonth.setText(calendar.getMonth() + getString(R.string.month_text));
//        tvYear.setText(String.valueOf(calendar.getYear())+getString(R.string.year_text));
        mYear = calendar.getYear();
    }

    @Override
    public void onDateLongClick(Calendar calendar) {
//        Log.e("tag", "  ---  " + (isMonthView ? "月视图" : "周视图"));
    }

    @Override
    public void onViewChange(boolean isMonthView) {

    }
}
