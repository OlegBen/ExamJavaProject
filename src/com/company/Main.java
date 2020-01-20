package com.company;

import Config.Config;
import Download.DownloadThread;
import Resources.ResourcesClass;
import java.util.ArrayList;
import Error.CustomError;

public class Main {

    public static void main(String[] args) {
        Config.checkRightConfig();

        ArrayList<Thread> threads = new ArrayList<Thread>();

        //Create get resource links thread
        ResourcesClass resources = new ResourcesClass();
        resources.start();

        //Create download threads
        for (int threadCount = 0; threadCount < Config.maxThreadCount; threadCount++) {
            Thread downloadResourceThread = new DownloadThread(resources);
            threads.add(downloadResourceThread);
        }

        //Wait resources thread
        try {
            resources.join();
        } catch (InterruptedException e) {
            CustomError.cantWaitResourceThread();
        }

        //Start download thread
        for (int threadCount = 0; threadCount < threads.size(); threadCount++) {
            Thread downloadThread = threads.get(threadCount);
            downloadThread.start();
        }
    }

}


