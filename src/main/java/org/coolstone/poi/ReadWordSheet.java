package org.coolstone.poi;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.FileInputStream;
import java.lang.Exception;

import static org.apache.poi.openxml4j.opc.OPCPackage.*;

public class ReadWordSheet {

    public static void main(String[] args) {
        try {

            FileInputStream fis = new FileInputStream("/Users/coolstone/Downloads/广东省政务信息资源共享与开放目录 3代码集.docx");

            XWPFDocument xdoc = new XWPFDocument(OPCPackage.open(fis));
            XWPFWordExtractor extractor = new XWPFWordExtractor(xdoc);
            System.out.println(extractor.getText());
        } catch(Exception ex) {

            ex.printStackTrace();
        }
    }

}
