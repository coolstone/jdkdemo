package org.coolstone.poi;

import java.util.ArrayList;
import java.util.List;

public class Code {

    public Code(String name, String code, String dataElement, String description){
        this.name = name;
        this.code = code;
        this.dataElement = dataElement;
        this.description =description;

    }

    private  String name;

    public void setName(String name) {

        this.name = name;
    }

    public String getName() {
        if(this.name == null)
            this.name ="";
        return name;
    }

    private String code;

    public String getCode() {
        if(this.code == null)
            this.code ="";
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    private String dataElement;

    public String getDataElement() {
        if(this.dataElement == null)
            this.dataElement ="";
        return dataElement;
    }

    public void setDataElement(String dataElement) {
        this.dataElement = dataElement;
    }

    private  String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    List<CodeItem> codeItems;

    public List<CodeItem> getCodeItems() {
        if(this.codeItems == null)
            this.codeItems = new ArrayList<CodeItem>();
        return codeItems;
    }

    public void setCodeItems(List<CodeItem> codeItems) {
        this.codeItems = codeItems;
    }

    @Override
    public String toString() {
        System.out.println(String.format("name:%s, code:%s, d:%s, e:%s", this.name, this.code, this.description, this.dataElement));
        for (CodeItem codeItem:this.getCodeItems()
             ) {
            System.out.println(String.format("c:%s,n:%s",codeItem.getCode(), codeItem.getName()));

        }
        return super.toString();
    }
}
