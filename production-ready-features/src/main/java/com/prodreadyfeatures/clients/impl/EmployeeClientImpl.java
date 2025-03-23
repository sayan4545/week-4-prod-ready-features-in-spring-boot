package com.prodreadyfeatures.clients.impl;

import com.prodreadyfeatures.advice.ApiResponse;
import com.prodreadyfeatures.clients.EmployeeClient;
import com.prodreadyfeatures.dtos.EmployeeDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import java.util.List;
@RequiredArgsConstructor
@Service
public class EmployeeClientImpl implements EmployeeClient {

    private final RestClient restClient;
        @Override
        public List<EmployeeDTO> getAllEmployees() {
            try {
                ApiResponse<List<EmployeeDTO>> empl =
                        restClient.get()
                                .uri("employees")
                                .retrieve()
                                .body(new ParameterizedTypeReference<>() {
                                });
                return empl.getData();
            } catch (RuntimeException e) {
                throw new RuntimeException(e);
            }





        }



}
