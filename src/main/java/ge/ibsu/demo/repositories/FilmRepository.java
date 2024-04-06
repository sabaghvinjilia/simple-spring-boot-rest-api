package ge.ibsu.demo.repositories;
import ge.ibsu.demo.entities.Film;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film, Long> {
    Page<Film> findByTitleContainingIgnoreCaseAndDescriptionContainingIgnoreCaseAndReleaseYearAndLanguageId(
            String title, String description, Integer releaseYear, Integer languageId, Pageable pageable
    );
}