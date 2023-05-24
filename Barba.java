import javax.swing.JOptionPane;

public class Barba extends Servicos implements ValoresServicos{
     
    private String tipoTratamentoBarba; 


    public String getTipoTratamentoBarba() {
      return tipoTratamentoBarba;
    }

    public void setTipoTratamentoBarba(String tipoTratamentoBarba) {
      this.tipoTratamentoBarba = tipoTratamentoBarba;
    }


    /* POLIMORFISMO DE SOBREPOSIÇÃO */
    @Override
  public void calculaTempoServico(String barba) {
    if (barba == "simples") {
        setTempoServico(30);
        setValorServico(20f); 
    }else if(barba == "completo"){
        setTempoServico(60);
        setValorServico(50f);
    }else{
      JOptionPane.showInputDialog(null, "algo deu errado ");
    }
  }

    @Override
    public void dataServico() {
      /* Validação de data - se supõe que todos os meses tem  30 dias */
      do {
          int dia = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o dia para agendar"));
          setDiaServico(dia);
          
      } while (getDiaServico() > 30 || getDiaServico() <= 0); 

      do {
         int mes = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o mes para agendar"));
         setMesServico(mes);

      } while (getMesServico() > 12 || getMesServico() <= 0);
      
      /* É possivel marcar apenas horarios inteiros, ex: 10h... modelo de relogio 24h */
      do {
          int horario = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o horario para agendar (como um numero inteiro no modelo de relogio 24h, ex: 15)"));
          setHorarioServico(horario);
    /* validação para horário de funcionamente de uma barbearia 8:00 às 21:00 */
    } while (getHorarioServico() > 21 || getHorarioServico() < 8 ); 

    }

    @Override
    public void adicionaServico() {
        char selecione = 'n';
        char adicionar = 'n'; 
        float total = 0; 
        do {
            selecione = JOptionPane.showInputDialog("Deseja adicionar corte por R$30,00? (S/N)").charAt(0);

          } while (selecione != 'n' && selecione != 'N' && selecione != 's' && selecione != 'S');

          if (selecione == 's' || selecione == 'S') {
            total += getValorServico() + valorCorte;
            JOptionPane.showMessageDialog(null, "Deu R$" + total);
            setServicos("Barba e Corte");
          } else {
            total += getValorServico();
            setServicos("Barba");
          }

          do {
            adicionar = JOptionPane.showInputDialog("Deseja adicionar sobrancelha por R$ 15,00? (S/N)").charAt(0);

          } while (adicionar != 'n' && adicionar != 'N' && adicionar != 's' && adicionar != 'S');

          if (adicionar == 's' || adicionar == 'S') {
            total += valorSobrancelha;
            setServicos(getServicos() + " e sobrancelha");
            JOptionPane.showMessageDialog(null, "Deu R$" + total);
          }
        
          setValorServico(total);
        
    }

    @Override
    public String toString() {
        return    "\n Barba: "
                + "\n Data serviço: " + getDiaServico() + "/" + getMesServico() 
                + "\n Tempo estimado para o serviço: " + getTempoServico() + " minutos"
                + "\n Horario: " + getHorarioServico() + " horas" 
                + "\n Tratamento para a barba do cliente: " + getTipoTratamentoBarba()
                + "\n Servicos escolhidos: " + getServicos()
                + "\n Valor Total: " + getValorServico();
    }

}
