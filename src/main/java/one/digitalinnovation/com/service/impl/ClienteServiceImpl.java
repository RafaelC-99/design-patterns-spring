package one.digitalinnovation.com.service.impl;


import one.digitalinnovation.com.model.Cliente;
import org.springframework.stereotype.Service;
import one.digitalinnovation.com.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Implementação da <b>Strategy</b> {@link ClienteService}, a qual
 * pode ser injetada pelo Spring (via {@link  Autowired}). Com isso,
 * como essa classe é um {@link Service}, ela será tratada como um
 * <b>Singleton</b>
 *
 * @author Rafael Alves Cardoso
 */

@Service
public class ClienteServiceImpl implements ClienteService{
    @Override
    public Iterable<Cliente> buscarTodos() {
        return null;
    }

    @Override
    public Cliente buscarPorId(Long id) {
        return null;
    }

    @Override
    public void inserir(Cliente cliente) {

    }

    @Override
    public void atualizar(Long id, Cliente cliente) {

    }

    @Override
    public void deletar(Long id) {

    }
}
