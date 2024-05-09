package es.medac.MascotaApp.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Michael Santiago Jara Castro.
 * @author Jhonatan Caro.
 * @author Casimiro Ochaga.
 * Esta clase permitira realizar las consultas necesarias respecto a la obtencion de informacion de los datos de la BD
 * esta clase tiene variables constantes las cuales cuentan con las distintas consultas que el programa permitira realizar
 * cada constante se utilizara al momento de crear el metodo que permitira realizar la distinta consulta programada.
 */
public class Consultas {
    
    protected Connection conexionBD;
    
    private final String consultaAllMascotas = "SELECT * FROM MASCOTAS;";
    private final String consultMasById = "SELECT * FROM MASCOTAS WHERE idMascota = ?;";
    private final String consultaPesoById = "SELECT fechaPesado, peso FROM PESOS WHERE idMascota = ?;";
    private final String consultaVacunasById = "SELECT fechaVacuna, enfermedad, fechaProxima FROM VACUNAS WHERE idMascota = ?;";
    private final String filtroCliente = "SELECT idCliente FROM CLIENTES WHERE idCliente = ?;";
    private final String consutlaClienteById = "SELECT * FROM CLIENTES WHERE idCliente = ?;";
    public final String top5vacunados = "SELECT idMascota, idCliente, aliasMascota, vacunaciones FROM MASCOTAS ORDER BY vacunaciones DESC LIMIT 5;";
    public final String top5pesados = "SELECT M.idMascota, M.idCliente, M.aliasMascota, P.peso FROM MASCOTAS M INNER JOIN PESOS P ON P.idMascota = M.idMascota ORDER BY P.peso DESC LIMIT 5;";
    public final String top5livianos = "SELECT M.idMascota, M.idCliente, M.aliasMascota, P.peso FROM MASCOTAS M INNER JOIN PESOS P ON P.idMascota = M.idMascota ORDER BY P.peso ASC LIMIT 5;";
    private final String recuentoXEspecie = "SELECT COUNT(especie) AS cantidad, especie FROM mascotas GROUP BY especie;";
    
    public Consultas(){
        this.conexionBD = new ConexionBD().getConexion();
    }
    /**
     * Este metodo sirve para comprobar si el Cliente con el id especificado se encuentra en la BD o no, en caso de que
     * no se encuentre en la BD arrojara un resultado de tipo booleano, esto se realizo para poder tener un control de la
     * inserccion de la mascota para que cuando se quiera ingresar una mascota primero deba existir un cliente en la BD para asociarlo.
     * @param idC Id del cliente que se pasara de forma establecida al momento de ingresar los valores para la inserccion.
     * @return el return que regresara el valor false en caso de no estar y true en caso de estar.
     */
    public boolean filtroCliente(int idC){
        boolean var = false;
        try(PreparedStatement pS = conexionBD.prepareStatement(filtroCliente)){
            pS.setInt(1, idC);
            ResultSet rs = pS.executeQuery();
            var = rs.next();
            pS.close();
            System.out.println("Conexion cerrada");
        }catch(SQLException eSQL){
            System.err.println("Error al comprobar:"+eSQL.getMessage());
        }
        return var;
    }
    /**
     * Este metodo total mascotas lo que hara es realizar un conteo de cuantas mascotas hay registradas en la BD, este
     * metodo fue diseñado para complementar los otros metodos de consulta pues estos utilizaran arrays y es necesario que
     * este metodo les asigne campo respectivamente de la cantidad de mascotas que existan.
     * @return regresara la cantidad de mascotas encontradas en la BD en la tabla MASCOTAS.
     */
    public int totalMascotas(){
        int total = 0;
        try(PreparedStatement pS = conexionBD.prepareStatement("SELECT COUNT(idMascota) AS Total FROM MASCOTAS;")){
            try(ResultSet rs = pS.executeQuery()){
                while(rs.next()){
                 total = rs.getInt("Total");
                }
            }
            pS.close();
            System.out.println("Conexion cerrada");
        }catch(SQLException e){
            System.err.println("Error:"+e.getMessage());
        }
        return total;
    }
    
    public int numVacunas(int idM){
        int numVac = 0;
        try(PreparedStatement pS = conexionBD.prepareStatement("SELECT vacunaciones FROM MASCOTAS WHERE idMascota = ?;")){
            pS.setInt(1, idM);
            try(ResultSet rs = pS.executeQuery()){
                numVac = rs.getInt("vacunaciones");
            }
            pS.close();
            System.out.println("Conexion cerrada");
        }catch(SQLException errSQL){
            System.err.println("Error:"+errSQL.getMessage());
        }
        return numVac;
    }
    
    /**
     * Este metodo se encargara de contar la cantidad de especies registradas en la BD y devolvera el numero de especies
     * encontradas, este metodo es un complemento para que otro metodo funcione de manera más correcta siendo un complemento pero
     * disponible para opciones adicionales.
     * @return devolvera el total de las especies encontradas en la BD
     */
    public int totalEspecies(){
        int total = 0;
        try(PreparedStatement pS = conexionBD.prepareStatement("SELECT COUNT(especie) AS Total FROM MASCOTAS;")){
            try(ResultSet rs = pS.executeQuery()){
                while(rs.next()){
                 total = rs.getInt("Total");
                }
            }
            pS.close();
            System.out.println("Conexion cerrada");
        }catch(SQLException e){
            System.err.println("Error:"+e.getMessage());
        }
        return total;
    }
    /**
     * Este metodo es la consulta a todas las mascotas encontradas en la tabla MASCOTAS, esta ejecutara la consulta y a base de
     * eso se habra creado previamente un array bidimensional para guardar los datos de cada mascota encontrada y devolverlo para
     * su utilizacion, tambien se crea la variable i para llevar un control sobre la posicion de la array bidimensional, este consiste
     * en que conforme el metodo va recorriendo los resultados encontrados con la consulta este ira asignando valores a la array en la
     * posicion 1 y asignara respectivamente los valores en la segunda posicion, en este caso como la tabla cuenta con 8 campos el
     * segudo espacio de asignacion de la memoria a la array bidimensional se le asigna la capacidad de estos campos para que no hayan mas ni menos
     * luego de ir rellenando dato por dato, para no remplazar los valores de la primera fila habra al final de cada toma de datos
     * un i++ que sumara valor haciendo que la array tome la siguiente posicion y asì no remplazara los valores de la primera linea
     * y guardara la información de todas las mascotas, al final devovlera un array bidimensional con todos los valores de todas las
     * mascotas en la tabla MASCOTAS de la BD.
     * @return regresara una arraybidimensional de tipo Object, esto con el fin de evitar problemas al querer almacenar valores
     * distintos, puesto que la consulta tomara valores tanto int, como String como Date.
     */
    public Object[][] cTodasLasMascotas(){
        Object [][] valores = new Object[totalMascotas()][8];
        int i = 0;
        try(PreparedStatement pS = conexionBD.prepareStatement(consultaAllMascotas)){
            try(ResultSet rs = pS.executeQuery()){
                while(rs.next()){
                    valores[i][0] = rs.getInt("idMascota");
                    valores[i][1] = rs.getInt("idCliente");
                    valores[i][2] = rs.getString("aliasMascota");
                    valores[i][3] = rs.getString("especie");
                    valores[i][4] = rs.getString("raza");
                    valores[i][5] = rs.getString("colorPelo");
                    valores[i][6] = rs.getDate("fechaNacimiento");
                    valores[i][7] = rs.getInt("vacunaciones");
                    i++;
                }
            }
            pS.close();
            conexionBD.close();
            System.out.println("Conexion cerrada");            
        } catch (SQLException eConsulta){
            System.err.println("Error al consultar:"+eConsulta.getMessage());
        }
        return valores;
    }
    /**
     * Este metodo se encarga de tomar la informacion de la tabla vacunas con la condicion de un id asignado como parametro
     * para que solo busque las vacunas relacionadas al id de una mascota en especifico, este metodo devolvera las distintas vacunaciones
     * registradas con el mismo ID de la mascota pasada como parametro.
     * @param idM variable que tomara el valor del ID de la mascota de la cual se desea tener los valores de sus vacunaciones registradas
     * @return regresara una array de tipo Object con los valores obtenidos de la consulta
     */
    public Object[] cVacunasPorId(int idM){
        Object[] valores = new Object[3];
        try(PreparedStatement pS = conexionBD.prepareStatement(consultaVacunasById)){
            pS.setInt(1, idM);
            try(ResultSet rs = pS.executeQuery()){
                while(rs.next()){
                    valores[0] = rs.getDate("fechaVacuna");
                    valores[1] = rs.getString("enfermedad");
                    valores[2] = rs.getDate("fechaProxima");
                }
            }
            pS.close();
            System.out.println("Conexion cerrada");            
        }catch(SQLException eCSQL){
            System.err.println("Error al consultar:"+eCSQL.getMessage());
        }
        return valores;
    }        
    /**
     * Metodo que buscara la informacion de los pesos registrados con la condicion de consultar solo la informacion del ID
     * de la mascota pasado como parametro, esto con el fin de obtener exclusivamente la informacion del(os) peso(s) registrado(s) de esta mascota
     * @param idM parametro pasado que hara del ID de la mascota que se pide buscar.
     * @return array de tipo Object que devolvera los valores de la tabla Pesos obtenida de la consulta.
     */
    public Object[] cPesoPorId(int idM){
        Object [] valores = new Object[2];
        try(PreparedStatement pS = conexionBD.prepareStatement(consultaPesoById)){
            pS.setInt(1, idM);
            try(ResultSet rs = pS.executeQuery()){
                while(rs.next()){
                   valores[0] = rs.getDate("fechaPeso");
                   valores[1] = rs.getDouble("peso");
                }
            }
            pS.close();
            System.out.println("Conexion cerrada");
        }catch(SQLException eCSQL){
            System.err.println("Error al consultar:"+eCSQL.getMessage());
        }
        return valores;
    }
    /**
     * Este metodo devolvera toda la informacion de la tabla mascota buscando solo la informacion de la mascota con el id
     * pasado como parametro, este realizara una consulta con este id obteniendo toda la informacion de la mascota con ese id
     * y guardandolo en una array de tipo Object
     * @param idM variable que tomara el valor del ID de la mascota a buscar.
     * @return Array Object con los valores de la mascota especifica buscada.
     */
    public Object[] cMascotaPorId(int idM){
        Object [] valores = new Object[8];
        try(PreparedStatement pS = conexionBD.prepareStatement(consultMasById)){
            pS.setInt(1, idM);
            try(ResultSet rs = pS.executeQuery()){
                while(rs.next()){
                    valores[0] = rs.getInt("idCliente");
                    valores[1] = rs.getString("aliasMascota");
                    valores[2] = rs.getString("especie");
                    valores[3] = rs.getString("raza");
                    valores[4] = rs.getString("colorPelo");
                    valores[5] = rs.getDate("fechaNacimiento");
                    valores[6] = rs.getInt("vacunaciones");
                }
            }
            pS.close();
            System.out.println("Conexion cerrada");            
        } catch (SQLException eConsulta){
            System.err.println("Error al consultar:"+eConsulta.getMessage());
        }
        return valores;
    }
    /**
     * Este metodo realizara una consulta buscando en la tabla Clientes el cliente el cual concuerde con el ID pasado como parametro
     * devolviendo toda la informacion del cliente especificado en un array de tipo Object
     * @param idC Variable que tomara el valor del ID pedido
     * @return Array de tipo Object con la informacion obtenida de la consulta de la tabla clientes.
     */
    public Object[] clienteById(int idC){
        Object [] valores = new Object[3];
        try(PreparedStatement pS = conexionBD.prepareStatement(consutlaClienteById)){
            pS.setInt(1, idC);
            try(ResultSet rs = pS.executeQuery()){
                while(rs.next()){
                    valores[0] = rs.getString("primerApellido");
                    valores[1] = rs.getString("cuentaBanco");
                    valores[2] = rs.getInt("telefono");
                }
            }
            pS.close();
            System.out.println("Conexion cerrada");
        }catch(SQLException eSQL){
            System.err.println("Error al consultar:"+eSQL.getMessage());
        }
        return valores;
    }
    /**
     * Este metodo realizara una consulta que tomara las mascotas que tengan un numero mayor de vacunaciones en la BD en la tabla mascotas
     * este devolvera un array bidimensional similar al metodo que devolvia el valor de todas las mascotas con la diferencia
     * de que ahora solo devovlera el valor de las mascotas mas vacunadas.
     * @return Array bidimensional que devuelve el valor de las mascotas mas vacunadas.
     */
    public Object[][] topVacunados(){
        Object[][] top = new Object[5][4];
        int i = 0;
        try(PreparedStatement pS = conexionBD.prepareStatement(top5vacunados)){
            try(ResultSet rs = pS.executeQuery()){
                while(rs.next()){
                    top[i][0] = rs.getInt("idMascota");
                    top[i][1] = rs.getInt("idCliente");
                    top[i][2] = rs.getString("aliasMascota");
                    top[i][3] = rs.getInt("vacunaciones");
                    i++;
                }
            }
            pS.close();
            System.out.println("Conexion cerrada");
        }catch(SQLException eCSQL){
            System.err.println("Error al consultar:"+eCSQL.getMessage());
        }
        return top;
    }
    /**
     * Este metodo realizara la consulta de las mascotas mas pesadas tomando la informacion de esta consulta y guardandola
     * en un array bidimensional de la misma manera que el metodo que consulta todos los datos de las mascotas solo que tomando
     * los datos especificados de las mascotas mas pesadas, en especifico el top 5.
     * @return 
     */
    public Object[][] topPesados(){
        Object[][] top = new Object[5][9];
        int i = 0;
        try(PreparedStatement pS = conexionBD.prepareStatement(top5pesados)){
            try(ResultSet rs = pS.executeQuery()){
                while(rs.next()){
                    top[i][0] = rs.getInt("idMascota");
                    top[i][1] = rs.getInt("idCliente");
                    top[i][2] = rs.getString("aliasMascota");
                    top[i][3] = rs.getInt("peso");
                    i++;
                }
            }
            pS.close();
            System.out.println("Conexion cerrada");
        }catch(SQLException eCSQL){
            System.err.println("Error al consultar:"+eCSQL.getMessage());
        }
        return top;
    }
    /**
     * Este metodo tendra la misma funcion que topPesados con la diferencia de que en vez de tomar las mascotas mas pesadas
     * tomara las mascotas mas livianas o menos pesadas y las guardara en un array bidimensional devolviendo esta al final
     * con los valores obtenidos del top 5 de mascotas mas livianas.
     * @return 
     */
    public Object[][] topLivianos(){
        Object[][] top = new Object[5][9];
        int i = 0;
        try(PreparedStatement pS = conexionBD.prepareStatement(top5livianos)){
            try(ResultSet rs = pS.executeQuery()){
                while(rs.next()){
                    top[i][0] = rs.getInt("idMascota");
                    top[i][1] = rs.getInt("idCliente");
                    top[i][2] = rs.getString("aliasMascota");
                    top[i][3] = rs.getInt("peso");
                    i++;
                }
            }
            pS.close();
            System.out.println("Conexion cerrada");
        }catch(SQLException eCSQL){
            System.err.println("Error al consultar:"+eCSQL.getMessage());
        }
        return top;
    }
/**
 * Este metodo se encargara de realizar una consulta la cual dara la informacion de la especie y el recuento de especie
 * o sea que devolvera una array bidimensional con dos valores, la cantidad de animales de la misma especie y la especie
 * con su cantidad de animales de esta misma.
 * @return Array bidimensional con la informacion de las especies registradas y cuantos animales de estas especies hay.
 */
    public Object[][] recuentoEspecie(){
        Object[][] recuento = new Object[totalEspecies()][2];
        int i = 0;
        try(PreparedStatement pS = conexionBD.prepareStatement(recuentoXEspecie)){
            try(ResultSet rs = pS.executeQuery()){
                while(rs.next()){
                    recuento[i][0] = rs.getInt("cantidad");
                    recuento[i][1] = rs.getString("especie");
                    i++;
                }
            }
            pS.close();
            System.out.println("Conexion cerrada");
        }catch(SQLException eCSQL){
            System.err.println("Error al consultar:"+eCSQL.getMessage());
        }
        return recuento;
    }
}
