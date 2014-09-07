package geradordeprovas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
///https://www.youtube.com/watch?v=OSDfD0IVjSw
@Entity
public class Questao implements Serializable{
	//implements Serializable para classes que seram persistidas no banco
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String enunciado;
	
	@OneToMany(mappedBy="questao", cascade = CascadeType.ALL)//quando eu persistir uma questao persisto a coleção de alternativas
	private List<Alternativa> alternativasErradas;//@OneToMany para criar tabela(entidade relacionamento) relacional
	//mappedBy="questao" refericia ao atributo questao em alternativa 
	
	@OneToOne(cascade = CascadeType.ALL)
	private Alternativa alternativaCorreta;
	
	
	public Alternativa getAlternativaCorreta() {
		return alternativaCorreta;
	}

	public void setAlternativaCorreta(Alternativa alternativaCorreta) {
		this.alternativaCorreta = alternativaCorreta;
	}

	public void addAlternativasErrradas(Alternativa a){
		if(alternativasErradas == null){
			this.alternativasErradas = new ArrayList<Alternativa>();
		}
		this.alternativasErradas.add(a);
	}
	
	public List getAlternativasErradas() {
		return alternativasErradas;
	}

	public void setAlternativasErradas(List alternativasErradas) {
		this.alternativasErradas = alternativasErradas;
	}

	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Override
	public int hashCode(){
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}
	
	@Override
	public boolean equals(Object object){
		if(!(object instanceof Questao)){
			return false;
		}
		
		Questao other = (Questao) object;
		if((this.id != null && other.id == null) || (this.id == null && other.id != null)){
			return false;
		}
		return true;
		
	}
	
	@Override
	public String toString(){
		return "gerador de provas Questao [id = "+this.id+"]";
	}

}
