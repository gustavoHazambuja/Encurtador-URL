package Encurtador_URL.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import Encurtador_URL.Entities.Url;

public interface UrlRepository extends JpaRepository<Url, Long>  {
    
    Optional<Url> findByUrlCurt(String urlCurt);
}
