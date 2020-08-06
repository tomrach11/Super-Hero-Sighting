package com.tij.superhero.controller;

import com.tij.superhero.dao.*;
import com.tij.superhero.model.Characters;
import com.tij.superhero.model.Location;
import com.tij.superhero.model.Sighting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SightingController {

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

    @GetMapping("sighting")
    public String displaySighting(Model model) {
        List<Sighting> sightings = sightingDao.readAll();
        List<Characters> characters = characterDao.readAll();
        List<Location> locations = locationDao.readAll();

        model.addAttribute("sightings", sightings);
        model.addAttribute("locations", locations);
        model.addAttribute("characters", characters);

        return "sighting";
    }

    @GetMapping("home")
    public String displayHome(Model model) {
        List<Sighting> sightingsAll = sightingDao.readAll();
        List<Characters> characters = characterDao.readAll();
        List<Location> locations = locationDao.readAll();

        //To make list less than 10
        List<Sighting> sightings = new ArrayList<>();
        for (int i = 0; i < sightingsAll.size(); i++) {
            if (sightings.size() < 10) {
                sightings.add(sightingsAll.get(i));
            }
        }

        model.addAttribute("sightings", sightings);
        model.addAttribute("locations", locations);
        model.addAttribute("characters", characters);

        return "home";
    }

    @PostMapping("addSighting")
    public String addSighting (HttpServletRequest request) {
        int characterId = Integer.parseInt(request.getParameter("characterId"));
        int locationId = Integer.parseInt(request.getParameter("locationId"));
        LocalDate date = LocalDate.parse(request.getParameter("date"));

        Sighting sighting = new Sighting();
        sighting.setCharacter(characterDao.readById(characterId));
        sighting.setLocation(locationDao.readById(locationId));
        sighting.setDate(date);

        sightingDao.create(sighting);

        return "redirect:/sighting";
    }

    @GetMapping("deleteSighting")
    public String deleteSighting (HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));

        sightingDao.delete(id);

        return "redirect:/sighting";
    }

    @GetMapping("editSighting")
    public String editSighting (HttpServletRequest request, Model model) {
        List<Characters> characters = characterDao.readAll();
        List<Location> locations = locationDao.readAll();

        int id = Integer.parseInt(request.getParameter("id"));
        Sighting sighting = sightingDao.readById(id);
        model.addAttribute("sighting", sighting);
        model.addAttribute("locations", locations);
        model.addAttribute("characters", characters);


        return "editSighting";
    }

    @PostMapping("editSighting")
    public String PerformEditSighting (HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        Sighting sighting = sightingDao.readById(id);

        sighting.setCharacter(characterDao.readById(Integer.parseInt(request.getParameter("characterId"))));
        sighting.setLocation(locationDao.readById(Integer.parseInt(request.getParameter("locationId"))));
        sighting.setDate(LocalDate.parse(request.getParameter("date")));

        sightingDao.update(sighting);

        return "redirect:/sighting";
    }

}
