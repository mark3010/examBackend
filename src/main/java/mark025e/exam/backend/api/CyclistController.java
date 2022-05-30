package mark025e.exam.backend.api;

import mark025e.exam.backend.dto.CyclistRequest;
import mark025e.exam.backend.dto.CyclistResponse;
import mark025e.exam.backend.service.CyclistService;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/cyclists")
public class CyclistController {
    CyclistService cyclistService;

    public CyclistController(CyclistService c) {this.cyclistService = c;}

    @GetMapping
    public List<CyclistResponse> getAllCyclists(@RequestParam(value = "team", required = false) String team) {
        return cyclistService.getAllCyclist(team);
        // query param written as URL + ?party=A where A is partyletter
    }

    @GetMapping("/{id}")
    CyclistResponse getCyclist(@PathVariable int id) throws Exception {
        return cyclistService.getCyclist(id);
    }

    @PostMapping
    public CyclistResponse addCyclist(@RequestBody CyclistRequest body){
        return cyclistService.addCyclist(body);
    }

    @DeleteMapping
    public void deleteCyclist(@RequestBody CyclistRequest body){
        cyclistService.deleteCyclist(body);
    }

    @PutMapping
    public CyclistResponse editCyclist(@RequestBody CyclistRequest body) {
        return cyclistService.editCyclist(body);
    }

    @GetMapping("/jersey/{type}")
    CyclistResponse getJerseyWinner(@PathVariable String type) {
        return cyclistService.getJerseyWinner(type);
    }

}
