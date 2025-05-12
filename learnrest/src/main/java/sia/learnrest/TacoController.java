package sia.learnrest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/api/tacos", produces = "application/json")
@CrossOrigin(origins = "http://locahost:8080")
public class TacoController {
    @GetMapping("/recent")
    public List<String> getTacos() {
        List<String> tacos = new ArrayList<>();
        tacos.add("Bacon");
        tacos.add("Chicken");
        return tacos;
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getTaco(@PathVariable("id") int id) {
        if (id <= 5) {
            return new ResponseEntity<>("no taco", HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok("taco " + id);
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public String createTaco(@RequestBody CreateTacoRequest request) {
        return request.toString();
    }

    @PutMapping(value = "/{orderId}", consumes = "application/json")
    public String putTaco(@PathVariable("orderId") long orderId,
                          @RequestBody CreateTacoRequest request) {
        return request.toString();
    }

    @PatchMapping(path = "/{orderId}", consumes = "application/json")
    public String patchTaco(@PathVariable("orderId") long orderId,
                            @RequestBody CreateTacoRequest request) {
        return request.toString();
    }

    @DeleteMapping(path = "/{orderId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTaco(@PathVariable("orderId") long orderId) {
    }
}
