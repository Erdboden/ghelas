package com.ghelas.backend.http.cms.controller;

import com.ghelas.backend.constant.CurrencyConstants;
import com.ghelas.backend.constant.GlobalConstants;
import com.ghelas.backend.model.entity.Currency;
import com.ghelas.backend.model.request.CurrencyRequest;
import com.ghelas.backend.model.request.FurnitureRequest;
import com.ghelas.backend.model.response.FurnitureResponse;
import com.ghelas.backend.repository.CurrencyRepository;
import com.ghelas.backend.repository.LanguageRepository;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(GlobalConstants.CMS_URI + CurrencyConstants.URI)
public class CurrencyCmsController {


    private LanguageRepository languageRepository;
    private CurrencyRepository currencyRepository;
    private ConversionService conversionService;

    public CurrencyCmsController(LanguageRepository languageRepository, CurrencyRepository currencyRepository, ConversionService conversionService) {
        this.languageRepository = languageRepository;
        this.currencyRepository = currencyRepository;
        this.conversionService = conversionService;
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("currencies", new FurnitureResponse());
        return mav;
    }

    @RequestMapping(path = "/create", method = RequestMethod.GET)
    public ModelAndView create() {
        ModelAndView mav = new ModelAndView(GlobalConstants.CMS_URI + CurrencyConstants.URI + "/create");
        mav.addObject("languages", languageRepository.findAll());
        return mav;
    }

    @RequestMapping(path = "/create", method = RequestMethod.POST)
    public String store(CurrencyRequest currencyRequest) {
        Currency currency = conversionService.convert(currencyRequest, Currency.class);
        currency = currencyRepository.save(currency);
        return "redirect:/" + currency.getId() + "/edit";
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
