package com.pandora.car;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.pandora.car.greendao.entity.Chapter;
import com.pandora.car.greendao.service.ChapterService;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * 插入User
     *
     * @param view
     */
    public void onUserInsert(View view) {
        ChapterService chapterService = new ChapterService();
        Chapter chapter = new Chapter("3333", "sssss", 33, "yyy", "www.baidu.com", "你好");
        chapterService.addChapter(chapter);
    }
}
