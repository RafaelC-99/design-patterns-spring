package one.digitalinnovation.com.service.impl;


import one.digitalinnovation.com.model.Cliente;
import one.digitalinnovation.com.model.Endereco;
import one.digitalinnovation.com.repository.ClienteRepository;
import one.digitalinnovation.com.repository.EnderecoRepository;
import one.digitalinnovation.com.service.ViaCepService;
import org.springframework.stereotype.Service;
import one.digitalinnovation.com.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

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

    //Singleton: Injeta os componentes do spring com @Autowired.
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private ViaCepService viaCepService;


    //Strategy: Implementa os métdos defindos na interface.

    //Facade: Abstrai integrações com subsistemas, provendo uma interface simples.

    @Override
    public Iterable<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarPorId(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.get();
    }

    @Override
    public void inserir(Cliente cliente) {
        salvarClienteComCep(cliente);
    }

    @Override
    public void atualizar(Long id, Cliente cliente) {
        //Verificar cliente pelo ID.
        Optional<Cliente> clienteBd = clienteRepository.findById(id);
        if(clienteBd.isPresent()){
            salvarClienteComCep(cliente);
        }
    }

    @Override
    public void deletar(Long id) {
        clienteRepository.deleteById(id);
    }


    private void salvarClienteComCep(Cliente cliente) {
        // Verificar se o endereco de cliente já existe (pelo CEP).
        String cep  = cliente.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        cliente.setEndereco(endereco);
        clienteRepository.save(cliente);
    }
}
