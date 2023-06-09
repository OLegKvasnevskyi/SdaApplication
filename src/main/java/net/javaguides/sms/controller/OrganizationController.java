package net.javaguides.sms.controller;

import net.javaguides.sms.entity.Organization;
import net.javaguides.sms.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class OrganizationController {

    private OrganizationService organizationService;

    @Autowired
    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }


    @GetMapping("/organizations")
    public String listOrganizations(Model model) {
        model.addAttribute("organizations", organizationService.getAllOrganizations());
        return "organizations";
    }

    @GetMapping("/organizations/new")
    public String createOrganizationForm(Model model) {

        Organization organization = new Organization();
        model.addAttribute("organization", organization);
        return "create_organization";
    }

    @PostMapping("/organizations")
    public String saveOrganization(@ModelAttribute("organization") Organization organization) {
        organizationService.saveOrganization(organization);
        return "redirect:/organizations";
    }

    @GetMapping("/organizations/edit/{id}")
    public String editOrganizationForm(@PathVariable Integer id, Model model) {
        model.addAttribute("organization", organizationService.getOrganizationById(id));
        return "edit_organization";
    }

    @PostMapping("/organizations/{id}")
    public String updateOrganization(@PathVariable Integer id,
                                     @ModelAttribute("organization") Organization organization, Model model) {
        Organization existingOrganization = organizationService.getOrganizationById(id);
        existingOrganization.setId(id);
        existingOrganization.setName(organization.getName());
        organizationService.updateOrganization(existingOrganization);
        return "redirect:/organizations";
    }

    @GetMapping("/organizations/{id}")
    public String deleteOrganization(@PathVariable Integer id) {
        organizationService.deleteOrganizationById(id);
        return "redirect:/organizations";
    }

    @GetMapping("/proba")
    public String home(){
        return "organizations";
    }
}
