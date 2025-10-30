package com.ravi.learnings.features;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.*;

public class hashMap_learning {
    public static void main(String[] args) {
        final var userIntegerHashMap = new HashMap<>();
        userIntegerHashMap.put(User.getUser(), 1);
        userIntegerHashMap.put(User.getUser(), 2);

        System.out.println(userIntegerHashMap);
    }
}

@Getter
@ToString
@AllArgsConstructor
class User {
    private static Random rand = new Random();
    private Integer id;
    private String name;

    public static User getUser() {
        final var id1 = rand.nextInt(100);
        System.out.println(id1);
        return new User(id1, "user " + id1);
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public boolean equals(final Object object) {
        return true;
    }
}