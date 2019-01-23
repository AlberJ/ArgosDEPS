package br.edu.ifpb.argos.facade;

import java.util.List;

import javax.management.Query;
import javax.persistence.PersistenceException;

import br.edu.ifpb.argos.dao.InvestigacaoDAO;
import br.edu.ifpb.argos.dao.PersistenceUtil;
import br.edu.ifpb.argos.entity.Fato;
import br.edu.ifpb.argos.entity.Investigacao;

public class InvestigacaoController {

	public void cadastrar(Investigacao i) {
		InvestigacaoDAO dao = new InvestigacaoDAO(PersistenceUtil.getCurrentEntityManager());
		dao.beginTransaction();
		dao.insert(i);
		dao.commit();
	}

	public List<Investigacao> consultar(Investigacao i) {
		InvestigacaoDAO dao = new InvestigacaoDAO(PersistenceUtil.getCurrentEntityManager());
		List<Investigacao> lista = dao.findAll();
		return lista;
	}

	public boolean excluir(Investigacao i) {
		boolean excluiu = false;
		InvestigacaoDAO dao = new InvestigacaoDAO();
		try {
			dao.beginTransaction();
			Investigacao investigacao = dao.find(i.getId());
			dao.delete(investigacao);
			dao.commit();
			excluiu = true;
		} catch (PersistenceException e) {
			dao.rollback();
		}
		return excluiu;
	}

	public List<Investigacao> listar() {
		InvestigacaoDAO dao = new InvestigacaoDAO();
		List<Investigacao> lista = dao.findAll();
		return lista;
	}

	public Investigacao buscar(int id) {
		InvestigacaoDAO dao = new InvestigacaoDAO(PersistenceUtil.getCurrentEntityManager());
		Investigacao i = dao.find(id);
		return i;
	}

	public void atualizar(Investigacao i) {
		InvestigacaoDAO dao = new InvestigacaoDAO(PersistenceUtil.getCurrentEntityManager());
		dao.beginTransaction();
		dao.update(i);
		dao.commit();
	}

//	public List<Investigacao> pesquisar(String argumento) {
//		Query q = PersistenceUtil.getEntityManager().createQuery(
//				"select u from Fato u where upper(u.titulo) LIKE :argumento OR upper(u.descricao) LIKE :argumento");
//		argumento = argumento.toUpperCase();
//		q.setParameter("argumento", "%" + argumento + "%");
//		@SuppressWarnings("unchecked")
//		List<Investigacao> Fatos = (List<Investigacao>) q.getResultList();
//		return Fatos;
//	}
}
