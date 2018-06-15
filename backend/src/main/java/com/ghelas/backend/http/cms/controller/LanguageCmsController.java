package com.ghelas.backend.http.cms.controller;

import com.ghelas.backend.constant.GlobalConstants;
import com.ghelas.backend.constant.LanguageConstants;
import com.ghelas.backend.model.request.CurrencyRequest;
import com.ghelas.backend.model.request.FurnitureRequest;
import com.ghelas.backend.model.response.FurnitureResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(GlobalConstants.CMS_URI + LanguageConstants.URI)
public class LanguageCmsController {
    @RequestMapping(path = "", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("languages", new FurnitureResponse());
        return mav;
    }

    @RequestMapping(path = "/create", method = RequestMethod.GET)
    public String create() {
        return GlobalConstants.CMS_URI + LanguageConstants.URI + "/create";
    }

    @RequestMapping(path = "/create", method = RequestMethod.POST)
    public String store(CurrencyRequest currencyRequest) {
        return "redirect:/" + currencyRequest.getId() + "/edit";
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
