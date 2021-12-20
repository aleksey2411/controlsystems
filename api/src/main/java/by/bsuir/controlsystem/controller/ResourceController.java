package by.bsuir.controlsystem.controller;

import by.bsuir.controlsystem.dto.auth.AuthRequestDTO;
import by.bsuir.controlsystem.dto.auth.AuthResponseDTO;
import by.bsuir.controlsystem.service.ResourceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/resources")
public class ResourceController {
    private final ResourceService resourceService;

    @GetMapping("/routes/{routeId}/{date}")
    public List<TripDTO> getTripsByRoute(@PathVariable int routeId, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate date) {
        return tripService.getTripsByRouteAndDate(routeId, date);
    }


    @GetMapping("/")
    public List<TripDTO> getTrips() {
        return tripService.getTrips();
    }

    @GetMapping("/{id}")
    public TripDTO getTrip(@PathVariable int id) {
        return tripService.getTrip(id);
    }

    @PostMapping("/")
    public Resourcc addTrip(@Valid @RequestBody TripDTO tripDTO) {
        return tripService.addTrip(tripDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteTrip(@PathVariable int id) {
        tripService.deleteTrip(id);
    }
}
