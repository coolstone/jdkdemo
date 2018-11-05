package org.coolstone.poi;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.model.XWPFHeaderFooterPolicy;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFFooter;
import org.apache.poi.xwpf.usermodel.XWPFHeader;

import java.io.FileInputStream;
import java.lang.Exception;


import java.io.FileInputStream;

public class HeaderFooterReader {
    public static void main(String[] args) {

        try {
            FileInputStream fis = new FileInputStream("/Users/coolstone/Downloads/广东省政务信息资源共享与开放目录 3代码集.docx");

            XWPFDocument xdoc = new XWPFDocument(OPCPackage.open(fis));
            XWPFHeaderFooterPolicy policy = new XWPFHeaderFooterPolicy(xdoc);

            XWPFHeader header = policy.getDefaultHeader();
            if (header != null) {
                System.out.println(header.getText());
            }

            XWPFFooter footer = policy.getDefaultFooter();
            if (footer != null) {
                System.out.println(footer.getText());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
