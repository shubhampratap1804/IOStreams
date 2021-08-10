package com.main;

import java.io.File;

public class FileUtils {
    public static boolean deleteFile(File contentsToDelete){
        File[] allContents = contentsToDelete.listFiles();
        if(allContents != null){
            for (File file: allContents) {
                deleteFile(file);
            }
        }return contentsToDelete.delete();
    }
}
