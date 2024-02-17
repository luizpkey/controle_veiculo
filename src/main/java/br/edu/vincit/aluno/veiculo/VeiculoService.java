package br.edu.vincit.aluno.veiculo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VeiculoService {
    private final VeiculoRepository veiculoRepository;
    public VeiculoService(VeiculoRepository veiculoRepository) {
        this.veiculoRepository = veiculoRepository;
    }

    public Iterable<Veiculo> findAll() {
        return veiculoRepository.findAll();
    }

    public Veiculo findById(Long id) {
        return veiculoRepository.findById(id).orElse(null);
    }

    public Veiculo save( Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }

    public Veiculo update( Long id, Veiculo exemploAtualizado) {
        return veiculoRepository.findById(id)
                .map(veiculo -> {
                    veiculo.setModelo(exemploAtualizado.getModelo());
                    veiculo.setMarca(exemploAtualizado.getMarca());
                    veiculo.setAno(exemploAtualizado.getAno());
                    return veiculoRepository.save(veiculo);
                })
                .orElseThrow(() -> new RuntimeException("Registro não encontrado"));
    }

    public void deleteById( Long id) {
        veiculoRepository.deleteById(id);
    }



}

