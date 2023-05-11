package com.lesson1.BikesAPI;

import com.lesson1.BikesAPI.model.MotorBike;
import org.junit.Assert;
import org.junit.Test;

public class MotorBikesTest {
    @Test
    public void createMotorbikeNotNullTest(){
        MotorBike motorBike = new MotorBike();
        Assert.assertNotNull(motorBike);
    }
}
