package com.lesson1.BikesAPI;

import com.lesson1.BikesAPI.controllers.MotorBikeController;
import com.lesson1.BikesAPI.model.MotorBike;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@WebMvcTest(MotorBikeController.class)
public class MotorbikeControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private MotorBikeController motorBikeController;
    private MotorBike motorBike;

    @BeforeEach
     void init(){
            motorBike = new MotorBike();
    }


}
