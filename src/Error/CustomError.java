package Error;

public class CustomError {
    public static void emptyResourcePath() {
        System.out.println("ERROR: File path with links can not be empty!");
        System.exit(0);
    }

    public static void emptyFilePath() {
        System.out.println("ERROR: File path can not be empty!");
        System.exit(0);
    }

    public static void emptyFileName() {
        System.out.println("ERROR: File must have name!");
        System.exit(0);
    }

    public static void emptyFileExtension() {
        System.out.println("ERROR: File must have extension!");
        System.exit(0);
    }

    public static void nonCorrectLinksCount() {
        System.out.println("ERROR: Resource count can not be equal or less zero!");
        System.exit(0);
    }

    public static void nonCorrectThreadsCount() {
        System.out.println("ERROR: Thread count can not be less or equal zero!");
        System.exit(0);
    }

    public static void cantWaitResourceThread() {
        System.out.println("ERROR: Main thread can not wait resource thread (Method .join() not working)!");
        System.exit(0);
    }

    public static void fileWithLinksNotFound() {
        System.out.println("ERROR: File with resource links not be found! Please check file path.");
        System.exit(0);
    }

    public static void cantFindDownloadedFile() {
        System.out.println("ERROR: Can't find downloaded file for get stats! Please try again.");
        System.exit(0);
    }

    public static void cantDownloadFile() {
        System.out.println("ERROR: Can't download file! Please check resource link an try again.");
    }
}
