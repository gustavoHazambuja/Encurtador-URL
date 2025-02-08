package Encurtador_URL.Repositories;

import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;

import Encurtador_URL.Entities.URL;

public interface UrlRepository extends JpaRepository<URL, Long>  {
    
}
