package com.example.demo.service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ClientDto;
import com.example.demo.model.TblClient;
import com.example.demo.repository.ClientRepository;

@Service("clientService")
public class ClientServiceImpl implements ClientService{

	@Autowired
	private ClientRepository clientRepository;


	@Override
	public List<ClientDto> getClientsByName(final String name) {
		
		List<TblClient> clients = clientRepository.findByNameIgnoreCase(name);
		
		return getClientData(clients);
	}

	@Override
	public List<ClientDto> getClientsByAge(final Integer age) {
		
		LocalDate fromLocalDate = LocalDate.now();
		fromLocalDate = fromLocalDate.minusYears(age).minusDays(1);
		Date fromDate = Date.from(fromLocalDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		
		LocalDate toLocalDate = LocalDate.now();
		Date toDate = Date.from(toLocalDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		
		List<TblClient> clients = clientRepository.findByDobBetween(fromDate, toDate);
		//List<TblClient> clients = clientRepository.findByDobAfter(fromDate);
		return getClientData(clients);
	}

	private List<ClientDto> getClientData(List<TblClient> clients) {
		
		List<ClientDto> clientDtos = new ArrayList<ClientDto>();
		for (TblClient client : clients) {
			ClientDto clientDto = new ClientDto();
			BeanUtils.copyProperties(client, clientDto);
			clientDtos.add(clientDto);
		}
		return clientDtos;
	}
}
