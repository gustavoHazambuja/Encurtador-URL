package Encurtador_URL.Services;

import java.net.URL;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Encurtador_URL.Entities.Url;
import Encurtador_URL.Exceptions.UrlException;
import Encurtador_URL.Repositories.UrlRepository;

@Service
public class UrlService {
    
    @Autowired
    UrlRepository urlRepository;

    
    @Transactional
    public String shortenUrl(String urlOriginal){
        
        String urlCurt = UUID.randomUUID().toString().replace("-", "").substring(0,6); //Gera um identificador aleatório com 36 caracteres e pega somente os 6 primeiros.
        Url url = new Url(urlOriginal, urlCurt);
        urlRepository.save(url);

        return "http://localhost:8080/" + urlCurt;
    }

    @Transactional(readOnly = true)
    public String searchUrlOriginal(String urlCurt){

        Optional<Url> urOptional = urlRepository.findByUrlCurt(urlCurt);

        if(urOptional.isEmpty()){
            throw new UrlException("URL não encontrada.");
        }

        return urOptional.get().getUrlOriginal();

    }
    
}
