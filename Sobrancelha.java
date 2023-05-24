import javax.swing.JOptionPane;

public class Sobrancelha extends Servicos implements ValoresServicos{

  String procedimento; 

  public String getProcedimento() {
    return procedimento;
  }

  public void setProcedimento(String procedimento) {
    this.procedimento = procedimento;
  }
  
  /* POLIMORFISMO DE SOBREPOSIÇÃO */
  @Override
  public void calculaTempoServico( String procedimento) {
    if (procedimento == "pinça") {
      setTempoServico(30);
    }else if (procedimento == "navalha"){
      setTempoServico(20);
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
          int horario = Integer.parseInt(
            JOptionPane.showInputDialog(null, "Digite o horario para agendar (como um numero inteiro no modelo de relogio 24h, ex: 15)"));
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
            total += valorSobrancelha + valorCorte;
            JOptionPane.showMessageDialog(null, "Deu R$" + total);
            setServicos("Sobrancelha e Corte");
          } else {
            total += valorSobrancelha;
            setServicos("Sobrancelha");
          }

          do {
            adicionar = JOptionPane.showInputDialog("Deseja adicionar barba por R$20,00? (S/N)").charAt(0);

          } while (adicionar != 'n' && adicionar != 'N' && adicionar != 's' && adicionar != 'S');

          if (adicionar == 's' || adicionar == 'S') {
            total += valorBarba;
            JOptionPane.showMessageDialog(null, "Deu R$" + total);
            setServicos(getServicos() + " e Barba");
          }

        setValorServico(total);  
        
    }

    @Override
    public String toString() {
        return    "\n Sobrancelha: "
                + "\n Data serviço: " + getDiaServico() + "/" + getMesServico() 
                + "\n Tempo estimado para o serviço: " + getTempoServico() + " minutos"
                + "\n Horario: " + getHorarioServico() + " horas"
                + "\n Utensilio para fazer a sobrancelha do(a) cliente: " + getProcedimento()
                + "\n Servicos escolhidos: " + getServicos()
                + "\n Valor Total: " + getValorServico();
    }
  
}
