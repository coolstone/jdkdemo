package org.coolstone.poi;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.model.XWPFHeaderFooterPolicy;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFFooter;
import org.apache.poi.xwpf.usermodel.XWPFHeader;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

import java.io.FileInputStream;
import java.lang.Exception;
import java.util.List;

public class ParagraphReader {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("/Users/coolstone/Downloads/广东省政务信息资源共享与开放目录 3代码集.docx");

            XWPFDocument xdoc = new XWPFDocument(OPCPackage.open(fis));

            List<XWPFParagraph> paragraphList = xdoc.getParagraphs();

            for (XWPFParagraph paragraph : paragraphList) {

                System.out.println(paragraph.getText());
                System.out.println(paragraph.getAlignment());
                System.out.print(paragraph.getRuns().size());
                System.out.println(paragraph.getStyle());

                // Returns numbering format for this paragraph, eg bullet or lowerLetter.
                System.out.println(paragraph.getNumFmt());
                System.out.println(paragraph.getAlignment());

                System.out.println(paragraph.isWordWrapped());

                System.out.println("********************************************************************");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
