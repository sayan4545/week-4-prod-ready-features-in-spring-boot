package com.prodreadyfeatures.clients;

import com.prodreadyfeatures.dtos.EmployeeDTO;

import java.util.List;

public interface EmployeeClient {

    List<EmployeeDTO> getAllEmployees();
}
