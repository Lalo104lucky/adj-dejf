package adj.demo.server.modules.test;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;

@Controller
@RequestMapping("/adj-api/test")
@CrossOrigin(origins = "*")
public class TestController {

    @GetMapping("")
    public ResponseEntity<?> getMessage() {
        HashMap<String, Object> reponse = new HashMap<>();
        reponse.put("data", "OK");
        reponse.put("message", "API funcionando");

        return new ResponseEntity<>(reponse, HttpStatus.OK);
    }
}
