package com.tij.superhero.controller;

import com.tij.superhero.dao.*;
import com.tij.superhero.model.Location;
import com.tij.superhero.model.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class OrganizationController {


    @Autowired
    OrganizationDao organizationDao;

    @Autowired
    CharacterDao characterDao;

    @Autowired
    LocationDao locationDao;

    @Autowired
    SightingDao sightingDao;

    @Autowired
    SuperpowerDao superpowerDao;

    @GetMapping("organization")
    public String displayOrganization (Model model) {
        List<Organization> organizations = organizationDao.readAll();
        List<Location> locations = locationDao.readAll();

        model.addAttribute("organizations", organizations);
        model.addAttribute("locations", locations);

        return "organization";
    }

    @PostMapping("addOrganization")
    public String addOrganization (HttpServletRequest request) {
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        int locationId = Integer.parseInt(request.getParameter("locationId"));
        Location location = locationDao.readById(locationId);
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");

        Organization organization = new Organization();
        organization.setName(name);
        organization.setDescription(description);
        organization.setLocation(location);
        organization.setPhone(phone);
        organization.setEmail(email);

        organizationDao.create(organization);

        return "redirect:/organization";
    }

    @GetMapping("deleteOrganization")
    public String deleteOrganization (HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));

        organizationDao.delete(id);

        return "redirect:/organization";
    }

    @GetMapping("editOrganization")
    public String editOrganization (HttpServletRequest request, Model model) {
        List<Location> locations = locationDao.readAll();

        int id = Integer.parseInt(request.getParameter("id"));
        Organization organization = organizationDao.readById(id);

        model.addAttribute(organization);
        model.addAttribute("locations", locations);
        return "editOrganization";
    }

    @PostMapping("editOrganization")
    public  String performEditOrganization (HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        Organization organization = organizationDao.readById(id);

        organization.setName(request.getParameter("name"));
        organization.setDescription(request.getParameter("description"));
        organization.setEmail(request.getParameter("email"));
        organization.setPhone(request.getParameter("phone"));
        int locationId = Integer.parseInt(request.getParameter("locationId"));
        organization.setLocation(locationDao.readById(locationId));

        organizationDao.update(organization);

        return "redirect:/organization";
    }
}
