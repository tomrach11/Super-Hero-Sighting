package com.tij.superhero.controller;

import com.tij.superhero.dao.*;
import com.tij.superhero.model.Characters;
import com.tij.superhero.model.Location;
import com.tij.superhero.model.Sighting;
import com.tij.superhero.model.Superpower;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.List;

@Controller
public class SuperpowerController {

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

    @GetMapping("superpower")
    public String displaySuperpower(Model model) {
        List superpowers = superpowerDao.readAll();

        model.addAttribute("superpowers", superpowers);
        return "superpower";
    }

    @PostMapping("addSuperpower")
    public String addSuperpower (HttpServletRequest request) {
        String type = request.getParameter("type");

        Superpower superpower = new Superpower();
        superpower.setType(type);
        superpowerDao.create(superpower);

        return "redirect:/characters";
    }

    @GetMapping("deleteSuperpower")
    public String deleteSuperpower (HttpServletRequest request) {
        int superpowerId = Integer.parseInt(request.getParameter("id"));
        superpowerDao.delete(superpowerId);

        return "redirect:/superpower";
    }

    @GetMapping("editSuperpower")
    public String editSuperpower (HttpServletRequest request, Model model) {
        int id = Integer.parseInt(request.getParameter("id"));
        Superpower superpower = superpowerDao.readById(id);
        model.addAttribute("superpower", superpower);

        return "editSuperpower";
    }

    @PostMapping("editSuperpower")
    public String PerformEditSighting (HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        Superpower superpower = superpowerDao.readById(id);

        String type = request.getParameter("type");
        superpower.setType(type);

        superpowerDao.update(superpower);

        return "redirect:/superpower";
    }
}
