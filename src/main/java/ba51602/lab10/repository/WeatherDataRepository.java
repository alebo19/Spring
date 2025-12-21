package ba51602.lab10.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.format.annotation.DateTimeFormat;
import ba51602.lab10.model.Location;
import ba51602.lab10.model.WeatherData;

import java.util.Date;

@RepositoryRestResource(path = "weather")
public interface WeatherDataRepository extends JpaRepository<WeatherData, Long> {

    Page<WeatherData> findByDateGreaterThanEqualAndLocation(
            @Param("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
            @Param("location") Location location,
            Pageable pageable);
}