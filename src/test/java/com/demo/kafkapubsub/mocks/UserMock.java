package com.demo.kafkapubsub.mocks;

import com.demo.kafkapubsub.domain.User;

public class UserMock {

    public static User success() {
        return new User("random");
    }
}
