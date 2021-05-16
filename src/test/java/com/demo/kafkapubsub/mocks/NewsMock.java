package com.demo.kafkapubsub.mocks;

import com.demo.kafkapubsub.domain.Location;
import com.demo.kafkapubsub.domain.News;

public class NewsMock {

    public static News success() {
        return new News("random", Location.BRAZIL);
    }
}
