package com.nekochanoide.univerSpringSecurity.controllers;

import com.nekochanoide.univerSpringSecurity.services.AddressesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AddressesController {
    private final AddressesService addressesService;

    public AddressesController(AddressesService addressesService) {
        this.addressesService = addressesService;
    }

    @GetMapping("/addresses")
    public String getAllAddresses(Model model) {
        model.addAttribute("addresses", addressesService.getAllAddresses());
        return "addresses";
    }
}
