package com.coolab.demo.business.abstracts;

import com.coolab.demo.business.requests.UpdateTextRequest;
import com.coolab.demo.business.response.GetAboutTextResponse;

public interface AboutTextService {
    void updateAboutText(UpdateTextRequest textRequest);

    GetAboutTextResponse getText(int id);
}
