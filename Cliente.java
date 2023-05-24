import javax.swing.JOptionPane;

public class Cliente{
    private String nomeCliente;
    private int idadeCliente;
    private String telefoneCliente;
    
    public Cliente(){
        //vazio
    }

    /* Metodos de acesso: */
    public String getNomeCliente() {
        return nomeCliente;
    }


    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }



    public int getIdadeCliente() {
        return idadeCliente;
    }


    public void setIdadeCliente(int idadeCliente) {
        this.idadeCliente = idadeCliente;
    }


    public String getTelefoneCliente() {
        return telefoneCliente;
    }


    public void setTelefoneCliente(String telefoneCliente) {
        this.telefoneCliente = telefoneCliente;
    }

    @Override
    public String toString() {
        return "Nome: " + nomeCliente 
          + "\n Idade: " + idadeCliente 
          + "\n Telefone: " + telefoneCliente;        
    }

    public String atualizaDados(){
        Cliente cliente = new Cliente();

        String nome = JOptionPane.showInputDialog(null, "Digite um novo nome para o cliente");
        cliente.setNomeCliente(nome);
        int idade = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite uma nova idade para o cliente"));
        cliente.setIdadeCliente(idade);
        String telefone = JOptionPane.showInputDialog(null, "Digite um novo telefone para o cliente");
        cliente.setTelefoneCliente(telefone);

        return " " + cliente; 
    }
    
}
