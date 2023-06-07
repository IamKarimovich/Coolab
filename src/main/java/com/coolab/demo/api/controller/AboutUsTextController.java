package com.coolab.demo.api.controller;

import com.coolab.demo.business.abstracts.AboutTextService;
import com.coolab.demo.business.requests.UpdateTextRequest;
import com.coolab.demo.business.response.GetAboutTextResponse;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/text/")
public class AboutUsTextController {
    private AboutTextService textService;

    public AboutUsTextController(AboutTextService textService) {
        this.textService = textService;
    }
    @GetMapping("GET/aboutUsText")
    public GetAboutTextResponse getTextService() {
        return textService.getText(1);
    }

    @PostMapping("POST/aboutUsText")
    public void setTextService(@RequestBody @Valid String text)
    {
        UpdateTextRequest textRequest = new UpdateTextRequest(1,text);
        textService.updateAboutText(textRequest);
    }
}
