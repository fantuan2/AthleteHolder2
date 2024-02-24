package fantuan.two.thth.athletedetector.athleteholder.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Utils {
    public static String getCurrentFormattedDateTime() {
        // 获取当前时间
        LocalDateTime now = LocalDateTime.now();

        // 定义时间格式
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss");

        // 格式化时间
        return now.format(formatter);
    }
}
