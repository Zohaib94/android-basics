package com.example.zohaib.listitems;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zohaib on 12/6/15.
 */
public class DataClass {
    String chapterName;
    int ChapterImage;

    public List<DataClass> getDataForListView() {

        List<DataClass> ChaptersList = new ArrayList<DataClass>();

        DataClass chapter2 = new DataClass();
        chapter2.chapterName = "Chapter 2";
        chapter2.ChapterImage = (int) R.drawable.images1;
        ChaptersList.add(chapter2);

        DataClass chapter3 = new DataClass();
        chapter3.chapterName = "Chapter 3";
        chapter3.ChapterImage = (int) R.drawable.images4;
        ChaptersList.add(chapter3);

        DataClass chapter4 = new DataClass();
        chapter4.chapterName = "Chapter 4";
        chapter4.ChapterImage = (int) R.drawable.images3;
        ChaptersList.add(chapter4);

        DataClass chapter5 = new DataClass();
        chapter5.chapterName = "Chapter 5";
        chapter5.ChapterImage = (int) R.drawable.images5;
        ChaptersList.add(chapter5);

        return ChaptersList;

    }
}
