//package sax;
import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*;

import java.util.*;
import java.io.*;
public class SAXLocalMain {
    static public void SaxLocalmain(String[] args) throws Exception {
        String filename = null;

        for (int i = 0; i < args.length; i++) {
            filename = args[i];
            if (i != args.length - 1) {
                //usage();
            }
        }

        if (filename == null) {
            //usage();
        }
    }
}
