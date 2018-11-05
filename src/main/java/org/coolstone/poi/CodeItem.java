package org.coolstone.poi;

public class CodeItem {

    private  String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public CodeItem(String code ,String value){
        this.code=  code;
        this.name =value;
    }


}
