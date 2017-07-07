package ru.kraftlab.web.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import ru.kraftlab.campaign.model.Campaign;
import ru.kraftlab.campaign.service.CampaignService;
import ru.kraftlab.web.web.dto.request.CampaignDTO;
import ru.kraftlab.web.web.dto.response.Response;
import ru.kraftlab.web.web.dto.validate.CampaignValidator;

@Controller
public class CampaignMasterController {
    @Autowired
    private CampaignService campaignService;

    @RequestMapping(value = "/campaignMaster", method = RequestMethod.GET)
    public ModelAndView buildPage() {
        ModelAndView model = new ModelAndView("campaignMaster");
        model.addObject("campaigns", campaignService.getAll());
        return model;
    }

    @RequestMapping(value = "/campaignMaster/save", method = RequestMethod.POST)
    @ResponseBody
    public Response saveCampaign(@RequestBody CampaignDTO campaign) {
        Response response = new Response();
        try {
            CampaignValidator.validateNew(campaign);
            campaignService.save(new Campaign.Builder()
                    .name(campaign.getName())
                    .fileName(campaign.getFileName())
                    .build());
        } catch (Exception e) {
            response.setErrMsg(e.getMessage());
            response.setResult(Response.RESULT.ERROR);
        }
        return response;
    }

}
