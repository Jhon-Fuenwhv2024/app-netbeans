package dao;

import domain.Funcionario;
import util.DbConnectUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDao {

    private static final String GET_FUNCIONARIO = "SELECT * FROM funcionarios ";

    private static final String CREATE_FUNCIONARIO = "INSERT INTO funcionarios"
            + "( numero_identificacion, nombres, sexo, direccion, telefono,"
            + "fecha_nacimiento, fecha_creacion, fecha_actualizacion,"
            + "estado_civil_id, tipo_documento_id)"
            + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    private static final String GET_FUNCIONARIO_BY_ID = "SELECT * FROM funcionarios WHERE id = ? ";

    private static final String UPDATE_FUNCIONARIO = "UPDATE funcionarios SET "
            + "numero_identificacion = ?, "
            + "nombres = ?, sexo = ?, direccion = ?, telefono = ?, "
            + "fecha_nacimiento = ?, fecha_creacion = ?, fecha_actualizacion = ?"
            + "estado_civil_id= ?, tipo_documento_id = ? WHERE funcionarios_id = ?";

    private static final String DELETE_FUNCIONARIO = "DELETE FROM funcionarios WHERE id = ? ";

    public List<Funcionario> obtenerFuncionarios() throws SQLException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Funcionario> funcionarios = new ArrayList<>();

        try {
            connection = DbConnectUtil.getConnection();
            preparedStatement = connection.prepareStatement(GET_FUNCIONARIO);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setFuncionarios_id(resultSet.getInt("funcionarios_id"));
                funcionario.setNumero_identificacion(resultSet.getString("numero_identificacion"));
                funcionario.setNombres(resultSet.getString("nombres"));
                funcionario.setSexo(resultSet.getString("sexo"));
                funcionario.setDireccion(resultSet.getString("direccion"));
                funcionario.setTelefono(resultSet.getString("telefono"));
                funcionario.setFecha_nacimiento(resultSet.getDate("fecha_nacimiento"));
                funcionario.setEstado_civil_id(resultSet.getInt("estado_civil_id"));
                funcionario.setFecha_creacion(resultSet.getDate("fecha_creacion"));
                funcionario.setFecha_actualizacion(resultSet.getDate("fecha_actualizacion"));
                funcionario.setTipo_documento_id(resultSet.getInt("tipo_documento_id"));
                funcionarios.add(funcionario);
            }
            return funcionarios;

        } finally {

            if (connection != null) {
                connection.close();
            }

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (resultSet != null) {
                resultSet.close();
            }
        }
    }

    public void crear(Funcionario funcionario) throws SQLException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DbConnectUtil.getConnection();
            preparedStatement = connection.prepareCall(CREATE_FUNCIONARIO);
            preparedStatement.setString(1, funcionario.getNombres());
            preparedStatement.setString(2, funcionario.getNumero_identificacion());
            preparedStatement.setString(3, funcionario.getSexo());
            preparedStatement.setString(4, funcionario.getDireccion());
            preparedStatement.setString(5, funcionario.getTelefono());
            preparedStatement.setDate(6, funcionario.getFecha_creacion());
            preparedStatement.setDate(7, funcionario.getFecha_actualizacion());
            preparedStatement.setDate(8, funcionario.getFecha_nacimiento());
            preparedStatement.setObject(9,funcionario.getEstado_civil_id());
            preparedStatement.setObject(10, funcionario.getTipo_documento_id());
            preparedStatement.executeUpdate();

        } finally {
            if (connection != null) {
                connection.close();
            }

            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }

    public Funcionario obtenerFuncionario(int id) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Funcionario funcionario = null;

        try {

            connection = DbConnectUtil.getConnection();
            preparedStatement = connection.prepareStatement(GET_FUNCIONARIO_BY_ID);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                funcionario = new Funcionario();
                funcionario.setFuncionarios_id(resultSet.getInt("funcionario_id"));

            }
            return funcionario;

        } finally {

            if (connection != null) {
                connection.close();
            }

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (resultSet != null) {
                resultSet.close();
            }
        }
    }
    
    public void actualizarFuncionario(int id, Funcionario funcionario) throws SQLException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DbConnectUtil.getConnection();
            preparedStatement = connection.prepareStatement(UPDATE_FUNCIONARIO);
            preparedStatement.setString(1, funcionario.getNumero_identificacion());
            preparedStatement.setString(2, funcionario.getNombres());
            preparedStatement.setString(3, funcionario.getSexo());
            preparedStatement.setString(4, funcionario.getDireccion());
            preparedStatement.setString(5, funcionario.getTelefono());
            preparedStatement.setDate(6, funcionario.getFecha_creacion());
            preparedStatement.setDate(7, funcionario.getFecha_actualizacion());
            preparedStatement.setDate(8, funcionario.getFecha_nacimiento());
            preparedStatement.setObject(9,funcionario.getEstado_civil_id());
            preparedStatement.setObject(10, funcionario.getTipo_documento_id());
            preparedStatement.executeUpdate();

        } finally {
            if (connection != null) {
                connection.close();
            }

            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }
    
    public void eliminarFuncionario(int id) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        
        try {
            
            connection = DbConnectUtil.getConnection();
            preparedStatement = connection.prepareStatement(DELETE_FUNCIONARIO);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            
        } finally {
            if (connection != null) {
                connection.close();
            }

            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }
}
