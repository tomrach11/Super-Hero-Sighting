package com.tij.superhero.controller;

import com.tij.superhero.dao.*;
import com.tij.superhero.model.Characters;
import com.tij.superhero.model.Organization;
import com.tij.superhero.model.Superpower;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
//@RequestMapping("/characters")
public class CharacterController {


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

    @GetMapping("/characters")
    public String displayCharacter (Model model) {
        List characters = characterDao.readAll();
        List superpowers = superpowerDao.readAll();
        List organizations = organizationDao.readAll();

        model.addAttribute("characters", characters);
        model.addAttribute("superpowers", superpowers);
        model.addAttribute("organizations", organizations);

        return "characters";
    }

    @PostMapping("addCharacter")
    public String addCharacter (HttpServletRequest request) {
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String superpowerId = request.getParameter("superpowerId");
        String type = request.getParameter("type");

        String[] organization = request.getParameterValues("organizationId");
        //change organizationId from the request to Organization object and add to the list
        List<Organization> organizations = new ArrayList<>();
        for (String organizationId : organization) {
            organizations.add(organizationDao.readById(Integer.parseInt(organizationId)));
        }

        Characters character = new Characters();
        character.setName(name);
        character.setDescription(description);
        character.setSuperpower(superpowerDao.readById(Integer.parseInt(superpowerId)));
        character.setType(type);
        character.setOrganizations(organizations);

        characterDao.create(character);

        return "redirect:/characters";
    }

    @GetMapping("editCharacter")
    public String editCharacter (HttpServletRequest request, Model model) {
        List superpowers = superpowerDao.readAll();
        List organizations = organizationDao.readAll();
        String[] types = {"Hero", "Villain"};

        int characterId = Integer.parseInt(request.getParameter("id"));
        Characters character = characterDao.readById(characterId);

        model.addAttribute("character", character);
        model.addAttribute("superpowers", superpowers);
        model.addAttribute("organizations", organizations);
        model.addAttribute("types", types);
        return "editCharacter";
    }

    @PostMapping("editCharacter")
    public String performEditCharacter (HttpServletRequest request) {
        System.out.println(Integer.parseInt(request.getParameter("id")));
        int characterId = Integer.parseInt(request.getParameter("id"));
        Characters character = characterDao.readById(characterId);

        String[] organization = request.getParameterValues("organizationId");
        //change organizationId from the request to Organization object and add to the list
        List<Organization> organizations = new ArrayList<>();
        for (String organizationId : organization) {
            organizations.add(organizationDao.readById(Integer.parseInt(organizationId)));
        }

        character.setName(request.getParameter("name"));
        character.setDescription(request.getParameter("description"));
        character.setSuperpower(superpowerDao.readById(Integer.parseInt(request.getParameter("superpowerId"))));
        character.setType(request.getParameter("type"));
        character.setOrganizations(organizations);

        characterDao.update(character);

        return "redirect:/characters";
    }

    @GetMapping("deleteCharacter")
    public String deleteCharacter (HttpServletRequest request) {
        int characterId = Integer.parseInt(request.getParameter("id"));
        characterDao.delete(characterId);

        return "redirect:/characters";
    }

}
