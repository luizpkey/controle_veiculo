package br.edu.vincit.aluno.veiculo;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/veiculo")
public class VeiculoController {
    private final VeiculoService veiculoService;

    public VeiculoController(VeiculoService veiculoService) {
        this.veiculoService = veiculoService;
    }

    @GetMapping
    public Iterable<Veiculo> getAll() {
        return veiculoService.findAll();
    }

    @PostMapping
    public Veiculo create(@RequestBody Veiculo exemplo) {
        return veiculoService.save(exemplo);
    }

    @PutMapping("/{id}")
    public Veiculo update(@PathVariable Long id, @RequestBody Veiculo veiculoAtualizado) {
        return this.veiculoService.update( id, veiculoAtualizado );
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        veiculoService.deleteById(id);
    }

}


