/* super classe abstrata que extendera para as classes corte, barba e sobrancelha */
public abstract class Servicos {
    private float valorServico; 
    private int tempoServico; 
    private int diaServico;
    private int mesServico; 
    private int horarioServico;
    private String servicos;

    public abstract void dataServico();
    public abstract void adicionaServico(); 
    public abstract void calculaTempoServico(String servico); 


    public Servicos() {
    }
    
    /* Metodos de acesso: */
    public float getValorServico() {
      return valorServico;
    }
    
    
    public void setValorServico(float valorServico) {
      this.valorServico = valorServico;
    }
    
    
    public int getTempoServico() {
      return tempoServico;
    }
    
    
    public void setTempoServico(int tempoServico) {
      this.tempoServico = tempoServico;
    }
  
    
    public int getDiaServico() {
      return diaServico;
    }

    public void setDiaServico(int diaServico) {
      this.diaServico = diaServico;
    }

    public int getMesServico() {
      return mesServico;
    }

    public void setMesServico(int mesServico) {
      this.mesServico = mesServico;
    }

    public int getHorarioServico() {
      return horarioServico;
    }

    public void setHorarioServico(int horarioServico) {
      this.horarioServico = horarioServico;
    }

    public String getServicos() {
      return servicos;
    }

    public void setServicos(String servicos) {
      this.servicos = servicos;
    };
    
}
  
  