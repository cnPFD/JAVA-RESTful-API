package lcw.JDBC_day01;

import java.io.File;
import java.io.IOException;

/**
 * Created by soft01 on 2017/5/8.
 */
public class Test {
    public static void main(String[] args) throws IOException {
        File file = new File("src/main/java/lcw/JDBC_day01/config1.properties");
        System.out.println("文件:"+file.isFile());
    }
}
