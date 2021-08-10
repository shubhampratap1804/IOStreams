package com.test;

import com.main.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.IntStream;

public class NIOFileAPITest {
    private static String HOME = System.getProperty("user.home");
    private static String PLAY_WITH_NIO = "MyPlayGround";

    @Test
    void givenPathWhenChecked_ThenConfirm() throws IOException{
        //Checking if file exists
        Path homePath = Paths.get(HOME);
        Assertions.assertTrue(Files.exists(homePath));

        //Delete if file exists and check if it got deleted
        Path playPath = Paths.get(HOME + "/" +PLAY_WITH_NIO);
        if(Files.exists(playPath)){
            FileUtils.deleteFile(playPath.toFile());
        }
        Assertions.assertTrue(Files.notExists(playPath));

        //Create directory
        Files.createDirectory(playPath);
        Assertions.assertTrue(Files.exists(playPath));

        //Creating a new file after deleting file
        IntStream.range(1,10).forEach(count ->{
            Path tempFile = Paths.get(playPath +"/temp" +count);
            Assertions.assertTrue(Files.notExists(tempFile));
            try{
                Files.createFile(tempFile);
            } catch (IOException e){ }
            Assertions.assertTrue(Files.exists(tempFile));
        });

        //Listing files that are just created along with file extensions
        Files.list(playPath).filter(Files::isRegularFile).forEach(System.out::println);
        Files.newDirectoryStream(playPath).forEach(System.out::println);
        Files.newDirectoryStream(playPath, path -> path.toFile().isFile() && path.toString().startsWith("temp")).forEach(System.out::println);
    }
}
