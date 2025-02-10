package Encurtador_URL.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Encurtador_URL.Services.UrlService;

@RestController
@RequestMapping(value = "/url")
public class UrlController {

    @Autowired
    UrlService urlService;

    @PostMapping(value = "/encurtar")
    public String shortenUrl(String urlOriginal){


        return "";
    }

    @GetMapping(value = "/{urlCurt}")
    public String searchUrlOriginal(){




        return "";

    }

}
