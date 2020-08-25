package hu.bendi.dredward;

import hu.bendi.dredward.core.Bot;

public class DrEdward {

    private static DrEdward INSTANCE;

    private Bot bot;

    public DrEdward() {
        INSTANCE = this;
    }

    public static DrEdward getInstance() {
        return INSTANCE;
    }

    public void run() throws Exception {
        bot = new Bot();
        bot.start();
    }
}
