//service

package com.example.firstWebApp.services;

import com.example.firstWebApp.entities.AIRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AIService {

    @Autowired
    private RestTemplate restTemplate;

    public String generateTextFromExternalAI(String inputText) {

        String apiUrl = "URL_OF_EXTERNAL_AI_API"; // استبدل هذا بعنوان URL الخاص بالAPI الخارجي

        // قم بإنشاء جسم الطلب للإرسال إلى الAPI الخارجي
        AIRequest requestObject = new AIRequest(inputText); // استبدل "YourRequestObject" بنوع الكائن الذي تتوقعه

        // أرسل الطلب واحصل على الاستجابة
        AIRequest responseObject = restTemplate.postForObject(apiUrl, requestObject, AIRequest.class); // استبدل "YourResponseObject" بنوع الكائن الذي تتوقعه

        // استخرج النص المولد من الاستجابة وقم بإعادته
        assert responseObject != null;
        return responseObject.getInputText();
    }
}


