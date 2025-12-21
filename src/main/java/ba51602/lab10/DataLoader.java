package ba51602.lab10; 

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ba51602.lab10.model.Location;
import ba51602.lab10.model.WeatherData;
import ba51602.lab10.repository.LocationRepository;
import ba51602.lab10.repository.WeatherDataRepository;

import java.util.Date;

@Component
public class DataLoader implements CommandLineRunner {

    private final LocationRepository locationRepository;
    private final WeatherDataRepository weatherDataRepository;

    public DataLoader(LocationRepository locationRepository, WeatherDataRepository weatherDataRepository) {
        this.locationRepository = locationRepository;
        this.weatherDataRepository = weatherDataRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Location szczecin = new Location("Szczecin", "PL");
        Location berlin = new Location("Berlin", "DE");
        locationRepository.save(szczecin);
        locationRepository.save(berlin);

        weatherDataRepository.save(new WeatherData(15.5, new Date(), szczecin));
        weatherDataRepository.save(new WeatherData(20.0, new Date(), szczecin));
        weatherDataRepository.save(new WeatherData(18.0, new Date(), berlin));
        
        System.out.println("--- DANE PRZYKŁADOWE ZAŁADOWANE ---");
    }
}