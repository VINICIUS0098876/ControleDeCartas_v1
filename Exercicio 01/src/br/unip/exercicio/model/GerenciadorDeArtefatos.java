package br.unip.exercicio.model;

import java.util.List;

import br.unip.exercicio.dao.ArtefatoDao;
import br.unip.exercicio.dao.ArtefatoJdbc;
import br.unip.exercicio.dao.ArtefatoList;
import br.unip.exercicio.dao.DadosException;

public class GerenciadorDeArtefatos {
	
    //implementacao do Singleton
    private static GerenciadorDeArtefatos instance;

    private GerenciadorDeArtefatos() {
    }

    public static GerenciadorDeArtefatos getInstance() {
        if (instance == null) {
            instance = new GerenciadorDeArtefatos();
        }
        return instance;
    }
    //implementacao do Singleton	
    
    private ArtefatoDao dao = new ArtefatoJdbc();
    
    public Artefato getNovoArtefato() {
    	Artefato artefato = new Artefato();
    	artefato.setId(0L);
    	artefato.setCategoria(Categoria.ATAQUE);
    	artefato.setForca(5);
    	return artefato;
    }
    
    public void salvar(Artefato artefato) throws DadosException {
        boolean ehNova = artefato != null && artefato.getId() != null
                && !(artefato.getId() > 0);
        if (ehNova) {
            dao.incluir(artefato);
        } else {
            dao.atualizar(artefato);
        }
    }

    public void excluir(Artefato artefato) throws DadosException {
        dao.excluir(artefato);
    }

    public Artefato getPorId(Long id) throws DadosException {
        return dao.getPorId(id);
    }

    public List<Artefato> getPorCategoria(Categoria categoria) throws DadosException {
        if (categoria != null) {
            return dao.getPorCategoria(categoria);
        } else {
            return dao.getTodos();
        }
    }

    public List<Artefato> getTodos() throws DadosException {
        return dao.getTodos();
    }

}
