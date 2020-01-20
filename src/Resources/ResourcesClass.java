package Resources;

import Config.Config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import Error.CustomError;

public class ResourcesClass extends Thread {

    private volatile ArrayList<String> resourcesArray = new ArrayList<String>();

    @Override
    public void run() {
        super.run();

        this.getAllResources();
    }

    private void getAllResources() {
        try {
            FileInputStream resourceFile = new FileInputStream(Config.pathWhereLocateLinks);
            Scanner scanner = new Scanner(resourceFile);
            //Get resource
            for (int resourceCount = 0; resourceCount < Config.maxURLCount && scanner.hasNext(); resourceCount++) {
                resourcesArray.add(scanner.nextLine());
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            CustomError.fileWithLinksNotFound();
        }
    }

    public synchronized String getLastResource() {
        if (resourcesArray.size() > 0) {
            int index = this.resourcesArray.size() - 1;
            String lastElem = this.resourcesArray.get(index);
            this.resourcesArray.remove(index);

            return lastElem;
        }
        return null;
    }

    public synchronized int getResourcesCount() {
        return this.resourcesArray.size();
    }
}
