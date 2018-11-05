package org.coolstone.poi;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.*;

import java.io.FileInputStream;
import java.util.*;

public class TableReader {

    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("/Users/coolstone/Downloads/test.docx");

            XWPFDocument xdoc = new XWPFDocument(OPCPackage.open(fis));
            Map<String, String> codeMap = new HashMap<>();

            List<Code> codes = new ArrayList<>();

            Iterator<IBodyElement> bodyElementIterator = xdoc.getBodyElementsIterator();
            while (bodyElementIterator.hasNext()) {
                IBodyElement element = bodyElementIterator.next();


                if (element instanceof XWPFParagraph) {
//public Code(String name, String code, String dataElement, String description){
                    XWPFParagraph paragraph = (XWPFParagraph)element;
                    //System.out.println("paragraph:" + paragraph.getText());
                    if(paragraph.getText().startsWith("对应的数据元："))
                        codeMap.put("dataElement", paragraph.getText().substring("对应的数据元：".length()));
                    if(paragraph.getText().startsWith("代码集描述："))
                        codeMap.put("description", paragraph.getText().substring("代码集描述：".length()));
                    if(paragraph.getText().startsWith("00") || paragraph.getText().startsWith("10")
                            || paragraph.getText().startsWith("30") || paragraph.getText().startsWith("40")){
                        String[] items  = paragraph.getText().trim().split("\t");
                        if(items.length ==2 ){
                            codeMap.put("code", items[0]);
                            codeMap.put("name", items[1]);
                        }

                    }

                } else if (element instanceof XWPFTable) {
                    XWPFTable table = (XWPFTable)element;
                    //System.out.println("Total Number of Rows of Table:" + table.getNumberOfRows());
                    List<CodeItem> codeItems = new ArrayList<>();
                    for (int i = 1; i < table.getRows().size(); i++) {
                        CodeItem codeItem = new CodeItem(table.getRow(i).getCell(0).getText().trim(), table.getRow(i).getCell(1).getText().trim());
                        codeItems.add(codeItem);

                    }
                    //public Code(String name, String code, String dataElement, String description){
                    Code code = new Code(codeMap.get("name"),codeMap.get("code"), codeMap.get("dataElement"),codeMap.get("description"));
                    code.setCodeItems(codeItems);
                    codes.add(code);
                    //System.out.println("tabletext:" + table.getText());
                }



            }

            for (Code code:codes
                 ) {
                code.toString();

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public static void main2(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("/Users/coolstone/Downloads/test.docx");

            XWPFDocument xdoc = new XWPFDocument(OPCPackage.open(fis));


            Iterator<IBodyElement> bodyElementIterator = xdoc.getBodyElementsIterator();
            while (bodyElementIterator.hasNext()) {
                IBodyElement element = bodyElementIterator.next();


                if ("TABLE".equalsIgnoreCase(element.getElementType().name())) {
                    List<XWPFTable> tableList = element.getBody().getTables();
                    for (XWPFTable table : tableList) {

                        System.out.println("Total Number of Rows of Table:" + table.getNumberOfRows());
                        for (int i = 0; i < table.getRows().size(); i++) {

                            for (int j = 0; j < table.getRow(i).getTableCells().size(); j++) {
                                System.out.print(table.getRow(i).getCell(j).getText() + "   ");
                            }
                            System.out.println();
                        }
                        System.out.println("tabletext:" + table.getText());
                    }
                }
                else {



                }

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
