package org.example;

import org.example.controller.Controller;
import org.example.global.GlobalInfo;
import org.example.parser.common.factory.MyParserFactory;
import org.example.style.ProgramStyle;
import org.example.style.StyleFileIO;
import org.example.utils.FileCollection;
import org.example.utils.FileCollector;
import org.slf4j.LoggerFactory;
import pascal.taie.World;
import pascal.taie.config.LoggerConfigs;
import pascal.taie.config.Options;
import pascal.taie.frontend.soot.SootWorldBuilder;
import pascal.taie.language.classes.JClass;
import org.apache.logging.log4j.LogManager;

import java.io.File;
import java.nio.file.Paths;
import java.util.List;


public class Main {


    public static void main(String[] args) {
        test();
        Configuration config = CLIArgumentParser.parseArgs(args);
        long start = System.currentTimeMillis();

        if (config != null) {
            GlobalInfo.setConf(config);
            Controller controller = new Controller(config);
            if (config.styleCheckOnly) {
                controller.checkStyle(config.applicationCollection);
            } else {
                controller.execute();
            }

            if (!RunStatistic.stat.isEmpty()) {
//                RunStatistic.save(RunStatistic.getDefaultOutputPath(config.getSrc(), config.getResOutDir()));
            }

        }
        long end = System.currentTimeMillis();
        System.out.println("执行时间: " + (end - start) + " ms");
    }

    public static void test() {
        Configuration conf = new Configuration();
        Controller controller = new Controller(conf);
        String refCode = """
    public static byte[] readLine(InputStream in) throws IOException {
        int b;
        // Skip leading LF
        while ((b = in.read()) == LF) {
            // skip
        }
        if (b < 0) {
            return null;
        }

        byte[] buf = new byte[256];
        int len = 0;

        while (b != CR && b != LF && b >= 0) {
            if (len >= buf.length) {
                byte[] newBuf = new byte[buf.length + 256];
                System.arraycopy(buf, 0, newBuf, 0, len);
                buf = newBuf;
            }
            buf[len++] = (byte) b;
            b = in.read();
        }

        if (b == CR) {
            if (in.markSupported()) {
                in.mark(1);
                int nextByte = in.read();
                if (nextByte != LF) {
                    in.reset();
                }
            }
        }

        return (len == 0) ? new byte[0] : Arrays.copyOf(buf, len);
    }
                """;
        ProgramStyle style = controller.extractStyle(refCode, "java");
//        controller.setTargetProgramStyle(style);
        String srcCode = """
    public static byte[] readLine2(InputStream in) throws IOException {
        byte[] buf = new byte[256];
        int i = 0, loops = 0, ch = 0;
        while (true) {
            ch = in.read();
            if (ch < 0)
                break;
            loops++;
            // skip a leading LF's
            if (loops == 1 && ch == LF)
                continue;
            if (ch == CR || ch == LF)
                break;
            if (i >= buf.length) {
                byte[] old_buf = buf;
                buf = new byte[old_buf.length + 256];
                System.arraycopy(old_buf, 0, buf, 0, old_buf.length);
            }
            buf[i++] = (byte) ch;
        }
        if (ch == -1 && i == 0)
            return null;
        // skip a trailing LF if it exists
        if (ch == CR && in.available() >= 1 && in.markSupported()) {
            in.mark(1);
            ch = in.read();
            if (ch != LF)
                in.reset();
        }
        byte[] old_buf = buf;
        buf = new byte[i];
        System.arraycopy(old_buf, 0, buf, 0, i);
        return buf;
    }
                """;
        String result = controller.applyStyle(srcCode, style, "Java");
        System.out.println(result);
    }


    public static  void test1() {
        String refDir =  "C:\\Users\\dell\\jyy\\motivating-example";

        FileCollection fileCollection = FileCollector.getJavaFileCollection(List.of(refDir));

        Configuration conf = new Configuration();
        Controller controller = new Controller(conf);
        ProgramStyle programStyle1 = controller.extractStyle(fileCollection);
        if (!fileCollection.isEmpty()) {
            // 风格文件保存在同目录下
            String dir = new File(fileCollection.getFilePath(0)).getParentFile().getParent();
        }
        ProgramStyle style =  programStyle1;
    }
//
//    public static void main(String[] args) {
//        String code = "List<String> arr = new ArrayList<>();";
//        MyParser parser = MyParserFactory.createParser("java");
//        ParseTree t = parser.parseFromString(code);
//        System.out.println(t.toStringTree(new JavaParser(null)));
//
//    }


}