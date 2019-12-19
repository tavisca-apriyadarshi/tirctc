package com.tavisca.gce.tirctc.controllers;

import com.tavisca.gce.tirctc.models.entities.Train;
import com.tavisca.gce.tirctc.models.search.SearchPerformer;
import com.tavisca.gce.tirctc.models.search.SearchPerformerImpl;
import com.tavisca.gce.tirctc.models.search.StationNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@CrossOrigin(allowedHeaders = "*",origins = "*")
public class UserController {

    @GetMapping(path="/user/search/{source}/{destination}")
public ResponseEntity<?> searchTrains(@PathVariable("source") String source,@PathVariable("destination") String destination) throws StationNotFoundException {
        SearchPerformer searchPerformer = new SearchPerformerImpl();
        List<Train> trains = searchPerformer.search(source,destination);
    return null;
}
}
