package com.coolab.demo.business.concretes;

import com.coolab.demo.business.abstracts.AboutTextService;
import com.coolab.demo.business.requests.UpdateTextRequest;
import com.coolab.demo.business.response.GetAboutTextResponse;
import com.coolab.demo.core.mappers.ModelMapperService;
import com.coolab.demo.dataAcces.abstracts.AboutTextRepository;
import com.coolab.demo.entities.concretes.AboutUsText;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AboutTextManager implements AboutTextService {

    private AboutTextRepository aboutTextRepository;
    private ModelMapperService modelMapperService;

    public AboutTextManager(AboutTextRepository aboutTextRepository, ModelMapperService modelMapperService) {
        this.aboutTextRepository = aboutTextRepository;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public void updateAboutText(UpdateTextRequest textRequest) {
        AboutUsText text = modelMapperService.forRequest().map(textRequest,AboutUsText.class);
        aboutTextRepository.save(text);
    }

    @Override
    public GetAboutTextResponse getText(int id) {

        Optional<AboutUsText> text = aboutTextRepository.findById(id);



        GetAboutTextResponse textResponse = modelMapperService.forResponse().map(text, GetAboutTextResponse.class);

        return textResponse;
    }
}
