package geradordeprovas;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class GeradorDeProvas {
	
	public static void main(String[] args){
		Questao q1 = new Questao();
		q1.setEnunciado("teste 2");
		q1.addAlternativasErrradas(new Alternativa("A", q1));
		q1.addAlternativasErrradas(new Alternativa("B", q1));
		q1.addAlternativasErrradas(new Alternativa("C", q1));
		q1.setAlternativaCorreta(new Alternativa("D", q1));
		
		/*Alternativa a = new Alternativa();
		a.setResposta("A");
		a.setQuestao(q1);
		Alternativa a2 = new Alternativa();
		a2.setResposta("B");
		a2.setQuestao(q1);
		Alternativa a3 = new Alternativa();
		a3.setResposta("C");
		a3.setQuestao(q1);
		q1.addAlternativasErrradas(a);
		q1.addAlternativasErrradas(a2);
		q1.addAlternativasErrradas(a3);*/
		try {
			
			EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("unitPSC");
			EntityManager em = managerFactory.createEntityManager();
			EntityTransaction transation = em.getTransaction();
			transation.begin();
			em.persist(q1);
			transation.commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

}
