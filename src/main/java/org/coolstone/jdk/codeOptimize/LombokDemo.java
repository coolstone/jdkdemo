package org.coolstone.jdk.codeOptimize;

import lombok.*;
import lombok.extern.apachecommons.CommonsLog;

import java.util.Date;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

/**
 * https://www.callicoder.com/reduce-java-boilerplate-code-using-project-lombok/
 * https://projectlombok.org/features/all
 * javac -cp lombok.jar MyApplication.java
 */
@Getter
@Setter
@ToString(includeFieldNames=true, exclude={"id"})
@CommonsLog
public class LombokDemo {

    @Getter private int id;
    @Getter @Setter @NonNull
    private String name = "nodefine";

    @Getter @Setter(AccessLevel.PROTECTED) private String email;
    private String phone;
    private Date dateOfBirth;

    @Setter(AccessLevel.NONE) private String internal_code;

    public void doit(){

    }

    public static void main(String[] args) {
        LombokDemo demo = new LombokDemo();
        log.info("Something's wrong here");
        System.out.println(demo.getName());
        System.out.println(demo.toString());
    }
}
