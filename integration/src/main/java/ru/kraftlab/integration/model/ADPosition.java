package ru.kraftlab.integration.model;

/**
 * Created by Maria on 27.01.2017.
 */
//todo remove?
public class ADPosition {
    private final String title;

    public ADPosition(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "ADPosition{" +
                ", title='" + title + '\'' +
                '}';
    }
}