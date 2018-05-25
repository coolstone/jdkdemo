package org.coolstone.jdk.codeOptimize;

import lombok.*;
import lombok.extern.apachecommons.CommonsLog;

import java.util.Date;

public
@Getter
@Setter
@ToString(includeFieldNames=true, exclude={"id"})
@CommonsLog
class User {

    @Getter
    private int id;
    @Getter
    @Setter
    @NonNull
    private String name = "nodefine";

    @Getter
    @Setter(AccessLevel.PROTECTED)
    private String email;
    private String phone;
    private Date dateOfBirth;

    @Setter(AccessLevel.NONE)
    private String internal_code;

    public User(String name, String email) {
        this.name = name;
        this.email = email;

    }
}