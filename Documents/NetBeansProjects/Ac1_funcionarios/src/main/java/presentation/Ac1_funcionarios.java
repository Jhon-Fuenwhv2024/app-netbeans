package presentation;
import controller.FuncionarioController;
import domain.Funcionario;
import java.sql.SQLException;
import java.util.List;import java.sql.SQLException;
import java.util.List;


public class Ac1_funcionarios {
    
    public static void obtenerFuncionarios(FuncionarioController funcionarioController){
        
        try{
            List<Funcionario> funcionarios = funcionarioController.obtenerFuncionarios();
            if (funcionarios.isEmpty()){
                System.out.println("No hay funcionarios");
            }else {
                funcionarios.forEach(funcionario -> {
                    System.out.println("funcionario_Id: " + funcionario.getFuncionarios_id());
                    System.out.println("numero_identificacio: " + funcionario.getNumero_identificacion());
                    System.out.println("nombres: " + funcionario.getNombres());
                    System.out.println("sexo: " + funcionario.getSexo());
                    System.out.println("direccion: " + funcionario.getDireccion());
                    System.out.println("telefono: " + funcionario.getTelefono());
                    System.out.println("-----------------------------------------------");
                });
            }
        
        
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        FuncionarioController funcionarioController = new FuncionarioController();
        obtenerFuncionarios(funcionarioController);
    }
}
