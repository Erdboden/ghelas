package com.ghelas.backend.http.cms.controller;

import com.ghelas.backend.constant.FurnitureConstants;
import com.ghelas.backend.constant.GlobalConstants;
import com.ghelas.backend.model.request.FurnitureRequest;
import com.ghelas.backend.model.response.FurnitureResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(GlobalConstants.CMS_URI + FurnitureConstants.FURNITURE_URI)
public class FurnitureCmsController {

    @RequestMapping(path = "", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("furnitures", new FurnitureResponse());
        return mav;
    }

    @RequestMapping(path = "/create", method = RequestMethod.GET)
    public String create() {
        return "cms/furniture/create";
    }

    @RequestMapping(path = "", method = RequestMethod.POST)
    public String store(FurnitureRequest furnitureRequest) {
        System.out.println(furnitureRequest.toString());
        System.out.println(furnitureRequest.getCoverImage().getOriginalFilename());
        return "redirect:/"+furnitureRequest.getId()+"/edit";
    }

    @RequestMapping(path = "/{id}/edit", method = RequestMethod.GET)
    public String edit() {
        return "cms/furniture/edit";
    }

    @RequestMapping(path = "/{id}/update", method = RequestMethod.PUT)
    public String update(FurnitureRequest furnitureRequest) {
        return "redirect:cms/furniture/edit";
    }

    @RequestMapping(path = "/{id}/delete", method = RequestMethod.DELETE)
    public String delete(@PathVariable Long id) {
        return "redirect:/";
    }
}
