package utils;

import com.alibaba.fastjson.JSON;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class Log {
    public static void log(Object... params) {
        File file = new File("log");
        try (FileWriter fileWriter = new FileWriter(file, true);
             PrintWriter printWriter = new PrintWriter(fileWriter);
        ) {
            printWriter.println(LocalDateTime.now() + JSON.toJSONString(params));
            printWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
