package mx.com.cars.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import mx.com.cars.BuilderFactory;
import mx.com.cars.service.CarGetService;

@WebMvcTest(CarControllerImpl.class)
class CarControllerImplTest {

	@Autowired
	private MockMvc mvc;

	@InjectMocks
	private CarControllerImpl car_controller;

	@MockBean
	private CarGetService car_service;

	@Test
	@DisplayName("car_get_service_1")
	void test_for_car_service_when_request_success() throws Exception {
		when(car_service.car_get_service(1L)).thenReturn(BuilderFactory.get_car_standard_response());

		MvcResult result = mvc.perform(MockMvcRequestBuilders.get("/car/1")).andExpect(status().isOk()).andReturn();

		int status_code = result.getResponse().getStatus();

		assertEquals(status_code, HttpStatus.OK.value());

	}

}
