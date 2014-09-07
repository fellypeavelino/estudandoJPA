package geradordeprovas;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Alternativa {
	
	public Alternativa(){
		
	}
	
	public Alternativa(String resposta, Questao questao){
		this.setResposta(resposta); 
		this.setQuestao(questao);
	}
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String resposta;
	
	@ManyToOne //@ManyToOne chave estrangeira
	private Questao questao;
	
	public Questao getQuestao() {
		return questao;
	}
	public void setQuestao(Questao questao) {
		this.questao = questao;
	}
	public String getResposta() {
		return resposta;
	}
	public void setResposta(String resposta) {
		this.resposta = resposta;
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
		
		Alternativa other = (Alternativa) object;
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
