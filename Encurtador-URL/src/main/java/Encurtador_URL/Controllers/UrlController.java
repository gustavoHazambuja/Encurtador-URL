package Encurtador_URL.Controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Encurtador_URL.Services.UrlService;

@RestController
@RequestMapping(value = "/url")
public class UrlController {

    @Autowired
    UrlService urlService;

    @PostMapping(value = "/encurtar")
    public String shortenUrl(@RequestParam(defaultValue = "") String urlOriginal){

        return urlService.shortenUrl(urlOriginal);
    }

    @GetMapping(value = "/{urlCurt}")
    public ResponseEntity<Void> redirect(@PathVariable String urlCurt){


        String urlOriginal = urlService.searchUrlOriginal(urlCurt);

        return ResponseEntity.status(HttpStatus.FOUND)
                    .header(HttpHeaders.LOCATION, urlOriginal) // Faz o navegador ser redirecionado para o link
                    .build(); // Finaliza a construção da resposta

    }

}
