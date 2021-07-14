package lab11.ex5;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.concurrent.atomic.AtomicLong;

public class TamanhoCalc {

    public AtomicLong getSize(String path, boolean recursive) {
        Path dir;

        try {
            dir = Paths.get(path);
            AtomicLong size = new AtomicLong(0);

            Files.walkFileTree(dir, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    String[] path = (file + "").split("/");
                    String[] rootDir = (dir + "").split("/");
                    String dirName = path[path.length - 2];

                    String fileName = path[path.length - 1];

                    if (!dirName.equals(rootDir[rootDir.length - 1]))
                        if (recursive)
                            fileName = dirName + "/" + fileName;
                        else
                            return FileVisitResult.CONTINUE;

                    long fileSize = attrs.size();
                    System.out.println("\t" + fileName + " - " + fileSize + " bytes");
                    size.addAndGet(attrs.size() / 1024);
                    return FileVisitResult.CONTINUE;
                }
            });

            return size;

        } catch (Exception e) {
            System.out.println("Error! Couldn't process path");
            System.exit(1);
        }
        return null;
    }
}
