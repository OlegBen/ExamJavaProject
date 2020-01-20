package Download;

import Config.Config;
import Resources.ResourcesClass;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import Error.CustomError;

public class DownloadThread extends Thread {

    private ResourcesClass resources;

    public DownloadThread(ResourcesClass resources) {
        this.resources = resources;
    }

    @Override
    public void run() {
        super.run();

        Thread currentThread = Thread.currentThread();

        while (!isInterrupted()) {
            int lastElemIndex = resources.getResourcesCount();

            if (lastElemIndex > 0) {
                String lastElem = resources.getLastResource();
                if (lastElem != null) {
                    try {
                        long start = System.currentTimeMillis();

                        String fullFileName = Config.downloadFileName + lastElemIndex + Config.downloadFileExtension;
                        System.out.println("("+ currentThread.getName() +") " +"Processing to download file from url: " + lastElem + " ...");
                        FileOutputStream outputStream = new FileOutputStream(Config.pathWhereSaveFiles + fullFileName);
                        outputStream.getChannel().transferFrom(Channels.newChannel(new URL(lastElem).openStream()), 0, Long.MAX_VALUE);

                        //Get stats

                        //Get time
                        long finish = System.currentTimeMillis();
                        long timeConsumedMillis = finish - start;

                        //Get file size
                        File file =new File(Config.pathWhereSaveFiles + fullFileName);
                        if(file.exists()){
                            double bytes = file.length();
                            double kilobytes = (bytes / 1024);
                            double megabytes = (kilobytes / 1024);

                            System.out.println(  "(" + currentThread.getName() + ") download file.");
                            System.out.println("┌-----------------------------------");
                            System.out.println("| Stats: \n|   File name: " + fullFileName + "\n|   Download time: " + timeConsumedMillis + " ms. \n|   File size: " + megabytes + " mb.");
                            System.out.println("└-----------------------------------");
                        } else {
                            CustomError.cantFindDownloadedFile();
                        }
                    } catch (IOException e) {
                        CustomError.cantDownloadFile();
                    }
                }
            } else {
                interrupt();
            }
        }
    }
}
