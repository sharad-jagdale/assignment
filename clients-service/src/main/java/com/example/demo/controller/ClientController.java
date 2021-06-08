package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ClientDto;
import com.example.demo.service.ClientService;

@RestController
@RequestMapping("/clients")
public class ClientController {

	@Autowired
    private ClientService clientService;

    
    @GetMapping("/getbyname")
    public List<ClientDto> getClientsByName(@RequestParam String name) {
        return clientService.getClientsByName(name);
    }
    
    @GetMapping("/getbyage")
    public List<ClientDto> getClientsByAge(@RequestParam Integer age) {
        return clientService.getClientsByAge(age);
    }
}
