import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) {
        Connection conexion = null;
        
        try {
            // Establecer conexión
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/baile", 
                "root", "root"
            );
            System.out.println("Conexión establecida");

            // Iniciar transacción
            conexion.setAutoCommit(false);

            // Instanciar ProcedimientosBD
            ProcedimientosBD procedimientos = new ProcedimientosBD(conexion);

            // Crear y ejecutar procedimientos
            procedimientos.crearProcedimientoInsertarAcademia();
            procedimientos.ejecutarProcedimientoInsertarAcademia("Academia Nueva", "Dirección Nueva", 2022, 50, 500);
            
            procedimientos.crearProcedimientoEliminarAcademia();
            procedimientos.ejecutarProcedimientoEliminarAcademia("Academia Nueva");

            procedimientos.crearFuncionContarAcademias();
            int totalAcademias = procedimientos.ejecutarFuncionContarAcademias();
            System.out.println("Total de academias: " + totalAcademias);

            // Confirmar la transacción
            conexion.commit();
            System.out.println("Transacción completada correctamente.");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            if (conexion != null) {
                try {
                    conexion.rollback();
                    System.out.println("Transacción revertida.");
                } catch (SQLException rollbackEx) {
                    rollbackEx.printStackTrace();
                }
            }
        } finally {
            // Asegurarse de cerrar la conexión una vez
            if (conexion != null) {
                try {
                    conexion.close();
                    System.out.println("Conexión cerrada correctamente.");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
