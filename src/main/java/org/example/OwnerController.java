package org.example;

import com.dit.hua.realEstate.entities.Owner;
import com.dit.hua.realEstate.service.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/owners")
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    // Endpoint for listing all owners
    @GetMapping("/list")
    public String listOwners(Model model) {
        List<Owner> owners = ownerService.findAll();
        model.addAttribute("owners", owners);
        return "owners/list-owners"; // Thymeleaf template for listing owners
    }

    // Endpoint for saving a new or updated owner
    @PostMapping("/save")
    public String saveOwner(@ModelAttribute("owner") Owner owner) {
        ownerService.save(owner);
        return "redirect:/owners/list";
    }

    // Endpoint for showing the update form
    @GetMapping("/update")
    public String showFormForUpdate(@RequestParam("id") Long ownerId, Model model) {
        Owner owner = ownerService.findById(ownerId);
        model.addAttribute("owner", owner);
        return "owners/owner-form"; // Thymeleaf template for the form
    }

    // Endpoint for deleting an owner
    @GetMapping("/delete")
    public String deleteOwner(@RequestParam("id") Long ownerId) {
        ownerService.deleteById(ownerId);
        return "redirect:/owners/list";
    }
}