// package sax;
import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*;

import java.util.*;
import java.io.*;
public class SAXLocalNameCount {
    private static String convertToFileURL(String filename) {
        String path = new File(filename).getAbsolutePath();
        if (File.separatorChar != '/') {
            path = path.replace(File.separatorChar, '/');
        }

        if (!path.startsWith("/")) {
            path = "/" + path;
        }
        return "file:" + path;
    }

    private static void usage() {
        System.err.println("Usage: SAXLocalNameCount <file.xml>");
        System.err.println("       -usage or -help = this message");
        System.exit(1);
    }
}