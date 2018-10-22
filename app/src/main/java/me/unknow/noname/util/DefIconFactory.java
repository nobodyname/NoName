package me.unknow.noname.util;

import java.util.Random;

import me.unknow.noname.R;

public class DefIconFactory {

    private DefIconFactory() {
        throw new RuntimeException("DefIconFactory cannot be initialized");
    }

    private static final int[] DEF_ICON_ID = new int[]{
            R.drawable.ic_default_1,
            R.drawable.ic_default_2,
            R.drawable.ic_default_3,
            R.drawable.ic_default_4,
            R.drawable.ic_default_5};

    private static Random sRandom = new Random();

    public static int provideIcon() {
        return DEF_ICON_ID[sRandom.nextInt(DEF_ICON_ID.length)];
    }
}
