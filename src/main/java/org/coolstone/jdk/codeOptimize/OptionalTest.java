package org.coolstone.jdk.codeOptimize;

import lombok.*;
import lombok.extern.apachecommons.CommonsLog;

import java.util.Date;
import java.util.Optional;
@Getter
@Setter
@ToString(includeFieldNames=true, exclude={"id"})
@CommonsLog
public class OptionalTest {

    public static void main(String[] args) {


        User user = new User("667290", "Rajeev Kumar Singh");
        Optional<User> userOptional = Optional.of(user);
        System.out.println(userOptional.get().toString());
        Optional<User> userOptional2 = Optional.ofNullable(user);
        System.out.println(userOptional2.toString());

        userOptional2.ifPresent(value -> {
            System.out.println("Value found - " + value.getName());
        });
    }

}
