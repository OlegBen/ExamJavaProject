package Config;

import Error.CustomError;

public class Config {
    public static String pathWhereLocateLinks = "/Users/Oleg/IdeaProjects/ExamProject/src/links.txt";
    public static String pathWhereSaveFiles = "/Users/Oleg/";
    public static String downloadFileName = "Download";
    public static String downloadFileExtension = ".zip";
    public static int maxURLCount = 4;
    public static int maxThreadCount = 3;

    public static void checkRightConfig() {
        if (pathWhereLocateLinks.trim().equals("")) {
            CustomError.emptyResourcePath();
        }
        if (pathWhereSaveFiles.trim().equals("")) {
            CustomError.emptyFilePath();
        }
        if (downloadFileName.trim().equals("")) {
            CustomError.emptyFileName();
        }
        if (downloadFileExtension.trim().equals("")) {
            CustomError.emptyFileExtension();
        }
        if (maxURLCount <= 0) {
            CustomError.nonCorrectLinksCount();
        }
        if (Config.maxThreadCount <= 0) {
            CustomError.nonCorrectThreadsCount();
        }
    }
}
