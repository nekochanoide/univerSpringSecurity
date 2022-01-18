package com.nekochanoide.univerSpringSecurity.controllers;

import com.nekochanoide.univerSpringSecurity.models.Child;
import com.nekochanoide.univerSpringSecurity.services.ChildrenService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ChildrenController {
    private final ChildrenService childrenService;

    public ChildrenController(ChildrenService childrenService) {
        this.childrenService = childrenService;
    }

    @GetMapping("/children")
    public String getAllChildren(Model model) {
        model.addAttribute("children", childrenService.getAllChildren());
        return "children/children";
    }

    @GetMapping("/children/add/{parentsId}")
    public String postAddChild(@PathVariable(value = "parentsId") String parentsId, Model model) {
        model.addAttribute("parentsId", parentsId);
        return "children/addChild";
    }

    @PostMapping("/children/add/{parentsId}")
    public String addChild(Child child, @PathVariable(value = "parentsId") long parentsId, Model model) {
        Child result = childrenService.addChild(child, parentsId);
        if (result == null) {
            model.addAttribute("isError", true);
            model.addAttribute("errorMessage", "Не удалось добавить ребенка");
            return "children/addChild";
        }
        return "redirect:/parents";
    }

    @GetMapping("/children/{id}")
    public String child(@PathVariable(value = "id") long id, Model model) {
        Child child = childrenService.getById(id);
        if (child == null) {
            return "redirect:/parents";
        }
        model.addAttribute("child", child);
        model.addAttribute("educationalEstablishments", childrenService.getEducationalEstablishments(child));
        return "children/child";
    }

    @PostMapping("/children/{id}")
    public String saveEducationalEstablishment(long educationalEstablishmentId, @PathVariable(value = "id") long id, Model model) {
        Child child = childrenService.getById(id);
        if (child == null) {
            model.addAttribute("isError", true);
            model.addAttribute("errorMessage", "Не удалось найти ребенка");
            return "children/child";
        }
        if (!childrenService.setEducationalEstablishment(id, educationalEstablishmentId)) {
            model.addAttribute("isError", true);
            model.addAttribute("errorMessage", "Не удалось записать в учебное заведение");
            return "children/child";
        }
        return "redirect:/parents";
    }
}
