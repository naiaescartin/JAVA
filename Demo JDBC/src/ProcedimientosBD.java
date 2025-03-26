import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProcedimientosBD {
    private Connection conexion;
    
    public ProcedimientosBD(Connection conexion) {
        this.conexion = conexion;
    }

    public void crearProcedimientoInsertarAcademia() throws SQLException {
        String crearProcedimiento = """
            CREATE PROCEDURE insertarAcademia(IN nombreAcademia VARCHAR(50), IN direccionAcademia VARCHAR(50), IN anyo INT, IN eventos INT, IN alumnos INT)
            BEGIN
                INSERT INTO academia (Nombre, Direccion, Anyo_Fundacion, Eventos, Alumnos) VALUES (nombreAcademia, direccionAcademia, anyo, eventos, alumnos);
            END
        """;
        try (Statement statement = conexion.createStatement()) {
            statement.execute(crearProcedimiento);
        }
        System.out.println("Procedimiento 'insertarAcademia' creado correctamente");
    }

    public void ejecutarProcedimientoInsertarAcademia(String nombre, String direccion, int anyo, int eventos, int alumnos) throws SQLException {
        String call = "{CALL insertarAcademia(?, ?, ?, ?, ?)}";
        try (CallableStatement callable = conexion.prepareCall(call)) {
            callable.setString(1, nombre);
            callable.setString(2, direccion);
            callable.setInt(3, anyo);
            callable.setInt(4, eventos);
            callable.setInt(5, alumnos);
            callable.execute();
        }
        System.out.println("Academia '" + nombre + "' insertada correctamente.");
    }

    public void crearProcedimientoEliminarAcademia() throws SQLException {
        String crearProcedimiento = """
            CREATE PROCEDURE eliminarAcademia(IN nombreAcademia VARCHAR(50))
            BEGIN
                DELETE FROM academia WHERE Nombre = nombreAcademia;
            END
        """;
        try (Statement statement = conexion.createStatement()) {
            statement.execute(crearProcedimiento);
        }
        System.out.println("Procedimiento 'eliminarAcademia' creado correctamente");
    }

    public void ejecutarProcedimientoEliminarAcademia(String nombre) throws SQLException {
        String call = "{CALL eliminarAcademia(?)}";
        try (CallableStatement callable = conexion.prepareCall(call)) {
            callable.setString(1, nombre);
            callable.execute();
        }
        System.out.println("Academia '" + nombre + "' eliminada correctamente.");
    }

    public void crearFuncionContarAcademias() throws SQLException {
        String crearFuncion = """
            CREATE FUNCTION contarAcademias() RETURNS INT
            BEGIN
                DECLARE total INT;
                SELECT COUNT(*) INTO total FROM academia;
                RETURN total;
            END
        """;
        try (Statement statement = conexion.createStatement()) {
            statement.execute(crearFuncion);
        }
        System.out.println("Función 'contarAcademias' creada correctamente");
    }

    public int ejecutarFuncionContarAcademias() throws SQLException {
        String query = "SELECT contarAcademias() AS totalAcademias";
        try (PreparedStatement sentencia = conexion.prepareStatement(query);
             ResultSet resultado = sentencia.executeQuery()) {
            if (resultado.next()) {
                return resultado.getInt("totalAcademias");
            }
        }
        return 0;
    }
}
