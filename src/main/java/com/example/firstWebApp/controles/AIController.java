//AIController

package com.example.firstWebApp.controles;

import com.example.firstWebApp.services.AIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AIController {

    @Autowired
    private AIService aiService;

    @PostMapping("/ai/generateText")
    public ResponseEntity<String> generateText(@RequestBody String inputText) {
        String generatedText = aiService.generateTextFromExternalAI(inputText); // تنفيذ توليد النص هنا
        return ResponseEntity.ok().body(generatedText);
    }
}
