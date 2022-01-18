package com.nekochanoide.univerSpringSecurity.controllers;

import com.nekochanoide.univerSpringSecurity.models.ParentsCouple;
import com.nekochanoide.univerSpringSecurity.services.AddressesService;
import com.nekochanoide.univerSpringSecurity.services.ParentsCouplesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Objects;

@Controller
public class ParentsController {
    private final ParentsCouplesService parentsCouplesService;
    private final AddressesService addressesService;

    public ParentsController(ParentsCouplesService parentsCouplesService, AddressesService addressesService) {
        this.parentsCouplesService = parentsCouplesService;
        this.addressesService = addressesService;
    }

    @GetMapping("/parents")
    public String getParents(Model model) {
        model.addAttribute("parents", parentsCouplesService.GetAllParents());
        return "parents/parents";
    }

    @GetMapping("/parents/add")
    public String getAddParentsCouple(Model model) {
        model.addAttribute("addresses", addressesService.getAllAddresses());
        return "parents/addParents";
    }

    @GetMapping("/parents/edit/{id}")
    public String getEditParentsCouple(@PathVariable(value = "id") long id, Model model) {
        model.addAttribute("addresses", addressesService.getAllAddresses());
        model.addAttribute("parentsCouple", parentsCouplesService.GetById(id));
        return "parents/editParents";
    }

    @PostMapping("/parents/add")
    public String postAddParentsCouple(ParentsCouple parentsCouple, long addressId, Model model) {
        if (Objects.equals(parentsCouple.getMomFullName(), null) && Objects.equals(parentsCouple.getDadFullName(), null)) {
            model.addAttribute("isError", true);
            model.addAttribute("errorMessage", "Нужно записать хотя бы одного родителя");
            model.addAttribute("addresses", addressesService.getAllAddresses());
            return "parents/addParents";
        }
        parentsCouplesService.addOrUpdateParentsCouple(parentsCouple, addressId);
        return "redirect:/parents";
    }

    @PostMapping("/parents/edit/{id}")
    public String postEditParentsCouple(ParentsCouple parentsCouple, long addressId, Model model) {
        if (Objects.equals(parentsCouple.getMomFullName(), null) && Objects.equals(parentsCouple.getDadFullName(), null)) {
            model.addAttribute("isError", true);
            model.addAttribute("errorMessage", "Нужно записать хотя бы одного родителя");
            model.addAttribute("addresses", addressesService.getAllAddresses());
            return "parents/editParents";
        }
        parentsCouplesService.addOrUpdateParentsCouple(parentsCouple, addressId);
        return "redirect:/parents";
    }
}
