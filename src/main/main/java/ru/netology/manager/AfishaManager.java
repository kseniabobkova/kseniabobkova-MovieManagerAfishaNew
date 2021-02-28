package ru.netology.manager;

import ru.netology.domain.MovieItem;

public class AfishaManager {
    private MovieItem[] items = new MovieItem[0];

    public void add(MovieItem item) {
        int length = items.length + 1;
        MovieItem[] tmp = new MovieItem[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public MovieItem[] getAll() {
        MovieItem[] result = new MovieItem[items.length];
        for (int i = 0; i < result.length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        if (result.length < 10) {
            return result;
        } else {
            MovieItem[] result1 = new MovieItem[10];
            for (int i = 0; i <= 9; i++) {
                result1[i] = result[i];
            }
            return result1;
        }
    }


    public void removeById(int movieId) {
        int length = items.length - 1;
        MovieItem[] tmp = new MovieItem[length];
        int index = 0;
        for (MovieItem item : items) {
            if (item.getMovieId() != movieId) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
    }
}