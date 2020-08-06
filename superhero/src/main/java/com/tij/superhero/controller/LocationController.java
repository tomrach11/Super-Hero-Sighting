package com.tij.superhero.controller;

import com.tij.superhero.dao.*;
import com.tij.superhero.model.Location;
import com.tij.superhero.model.Organization;
import com.tij.superhero.model.Superpower;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class LocationController {


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

    @GetMapping("location")
    public String displayLocation(Model model) {
        List<Location> locations = locationDao.readAll();

        model.addAttribute("locations", locations);
        return "location";
    }

    @PostMapping("addLocation")
    public String addLocation (HttpServletRequest request) {
        Double latitude = Double.parseDouble(request.getParameter("latitude"));
        Double longitude = Double.parseDouble(request.getParameter("longitude"));
        String street = request.getParameter("street");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String zipcode = request.getParameter("zipcode");


        Location location = new Location();
        location.setLatitude(latitude);
        location.setLongitude(longitude);
        location.setStreet(street);
        location.setCity(city);
        location.setState(state);
        location.setZipcode(zipcode);

        locationDao.create(location);

        return "redirect:/location";
    }

    @GetMapping("deleteLocation")
    public String deleteLocation (HttpServletRequest request) {
        int locationId = Integer.parseInt(request.getParameter("id"));
        locationDao.delete(locationId);

        return "redirect:/location";
    }

    @GetMapping("editLocation")
    public String editLocation (HttpServletRequest request, Model model) {
        int id = Integer.parseInt(request.getParameter("id"));
        Location location = locationDao.readById(id);

        model.addAttribute("location", location);

        return "editLocation";
    }

    @PostMapping("editLocation")
    public  String performEditLocation(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        Location location = locationDao.readById(id);

        Double latitude = Double.parseDouble(request.getParameter("latitude"));
        Double longitude = Double.parseDouble(request.getParameter("longitude"));
        String street = request.getParameter("street");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String zipcode = request.getParameter("zipcode");

        location.setLatitude(latitude);
        location.setLongitude(longitude);
        location.setStreet(street);
        location.setCity(city);
        location.setState(state);
        location.setZipcode(zipcode);

        locationDao.update(location);

        return "redirect:/location";
    }
}
