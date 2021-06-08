package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.ClientDto;

public interface ClientService {


	List<ClientDto> getClientsByName(String name);

	List<ClientDto> getClientsByAge(Integer age);

}
