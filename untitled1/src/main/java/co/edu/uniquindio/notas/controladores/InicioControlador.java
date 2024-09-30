package co.edu.uniquindio.notas.controladores;
import co.edu.uniquindio.notas.modelo.Contacto;
import co.edu.uniquindio.notas.modelo.ContactoPrincipal;
import com.sun.javafx.charts.Legend;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.fxml.Initializable;

import javax.swing.table.DefaultTableModel;
import java.net.URL;
import java.util.ResourceBundle;
import java.time.LocalDate;


public class InicioControlador implements Initializable {
    public Button btnNuevoContacto;
    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtApellido;

    @FXML
    private TextField txtCorreo;

    @FXML
    private TextField txtNumero;

    @FXML
    private DatePicker dateNacimiento;












    private final ContactoPrincipal contactoPrincipal;

    @FXML
    private TableView<Contacto> tablaNotas;


    @FXML
    private TableColumn<Contacto, String> colNombre;

    @FXML
    private TableColumn<Contacto, String> colApellido;

    @FXML
    private TableColumn<Contacto, String> colCorreo;

    @FXML
    private TableColumn<Contacto, String> colNumero;

    @FXML
    private TableColumn<Contacto, LocalDate> colNacimiento;





    @FXML
    private TableColumn<Contacto, String> colFecha;
    @FXML
    private TableColumn<Contacto, Integer> colId;
    private Legend.LegendItem txtId;


    public InicioControlador() {
        contactoPrincipal = new ContactoPrincipal();
    }

    @FXML
    public void crearContacto(ActionEvent e) {
        try {
            String nombre = txtNombre.getText();
            String apellido = txtApellido.getText();
            String correo = txtCorreo.getText();
            String numero = txtNumero.getText();
            LocalDate fechaNacimiento = dateNacimiento.getValue();

            // Comprobación de campos vacíos
            if (nombre.isEmpty() || apellido.isEmpty() || correo.isEmpty() || numero.isEmpty() || fechaNacimiento == null) {
                throw new Exception("Todos los campos deben estar llenos.");
            }

            if (!numero.matches("\\d+")) {
                throw new Exception("El número de teléfono debe contener solo dígitos.");
            }
            int id = contactoPrincipal.generarIdAleatorio();

            // Usando el patrón builder para crear un nuevo contacto
            Contacto nuevoContacto = Contacto.builder()
                    .nombre(nombre)
                    .apellido(apellido)
                    .correo(correo)
                    .numero(numero)
                    .fechaNacimiento(fechaNacimiento)
                    .build();

            // Agregar el contacto
            contactoPrincipal.agregarContacto(nuevoContacto);
            mostrarAlerta("Contacto creado correctamente", Alert.AlertType.INFORMATION);
            //actualizarTabla();
            // Limpiar campos
            txtNombre.clear();
            txtApellido.clear();
            txtCorreo.clear();
            txtNumero.clear();
            dateNacimiento.setValue(null);

            // Actualizar la tabla
            actualizarTabla();

        } catch (Exception ex) {
            mostrarAlerta(ex.getMessage(), Alert.AlertType.ERROR);
        }
    }

    private void mostrarAlerta(String mensaje, Alert.AlertType tipo){


        Alert alert = new Alert(tipo);
        alert.setTitle("Información");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.show();


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        colId.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getId()).asObject());
        colNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        colApellido.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getApellido()));
        colCorreo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCorreo()));
        colNumero.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNumero()));
        //colNacimiento.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFechaNacimiento().toString()));
        colFecha.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFechaCreacion().toString()));

        actualizarTabla();
        // Agregar datos a la tabla



    }
    private void actualizarTabla() {

        tablaNotas.setItems(FXCollections.observableArrayList(contactoPrincipal.listarNotas()));
    }
    @FXML
    public void eliminarNota(ActionEvent event) {
        try {
            // Verificar que el TextField no esté vacío
            if (txtId.getText().isEmpty()) {
                mostrarAlerta("Por favor, ingrese un ID válido.", Alert.AlertType.ERROR);
                return; // Salir del método si el ID está vacío
            }

            // Obtener el ID del TextField
            int id = Integer.parseInt(txtId.getText()); // Esto lanzará una excepción si no es un número válido
            contactoPrincipal.eliminarContacto(id);
            mostrarAlerta("Nota eliminada correctamente", Alert.AlertType.INFORMATION);
            actualizarTabla();

        } catch (NumberFormatException e) {
            mostrarAlerta("El ID debe ser un número entero.", Alert.AlertType.ERROR);
        } catch (Exception ex) {
            mostrarAlerta(ex.getMessage(), Alert.AlertType.ERROR);
        }
    }








}
