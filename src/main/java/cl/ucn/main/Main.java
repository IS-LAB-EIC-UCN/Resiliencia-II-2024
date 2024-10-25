package cl.ucn.main;

import cl.ucn.modelo.Cliente;
import cl.ucn.modelo.GerenciadorDescuento;
import cl.ucn.modelo.Producto;
import cl.ucn.modelo.Servicio;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.List;


public class Main extends Application {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("bazar");
    EntityManager em = emf.createEntityManager();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("Cálculo de Descuentos");
        Text clienteLbl = new Text("Cliente: ");
        ComboBox<Cliente> comboBox = new ComboBox<Cliente>();
        comboBox.getItems().addAll(this.fillComboboxCliente());
        comboBox.setValue(null); // Valor inicial
        comboBox.setCellFactory(param -> new javafx.scene.control.ListCell<>() {
            @Override
            protected void updateItem(Cliente cliente, boolean empty) {
                super.updateItem(cliente, empty);
                if (cliente != null) {
                    setText(cliente.getNombre()); // Mostrar nombre completo
                } else {
                    setText(null);
                }
            }
        });
        comboBox.setButtonCell(new javafx.scene.control.ListCell<>() {
            @Override
            protected void updateItem(Cliente cliente, boolean empty) {
                super.updateItem(cliente, empty);
                if (cliente != null) {
                    setText(cliente.getNombre());
                } else {
                    setText(null);
                }
            }
        });
        Text fechaNacimientoClienteLbl = new Text("Fecha Nacimiento: ");
        TextField fechaNacimientoTxt = new TextField();
        fechaNacimientoTxt.setEditable(Boolean.FALSE);
        Text anhoRegistroLbl = new Text("Cliente desde: ");
        TextField anhoRegistroTxt = new TextField();
        anhoRegistroTxt.setEditable(Boolean.FALSE);
        Text fechaActualLbl = new Text("Fecha de Hoy: ");
        TextField fechaActualTxt = new TextField();
        fechaActualTxt.setText("2024-10-25");
        fechaActualTxt.setEditable(Boolean.FALSE);
        Text tableLbl = new Text("Lista de Productos Comprados");
        TableView<Producto> table = new TableView<>();
        TableColumn<Producto, String> idCol = new TableColumn<>("Id");
        idCol.setCellValueFactory(new PropertyValueFactory<>("idProducto"));
        TableColumn<Producto, String> nombreCol = new TableColumn<>("Nombre");
        nombreCol.setCellValueFactory(new PropertyValueFactory<>("nombreProducto"));
        TableColumn<Producto, String> catCol = new TableColumn<>("Categoria");
        catCol.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        TableColumn<Producto, String> precioCol = new TableColumn<>("Precio");
        precioCol.setCellValueFactory(new PropertyValueFactory<>("precioProducto"));
        table.getColumns().addAll(idCol, nombreCol, catCol, precioCol);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        /*
            Controles para mostrar los precios inicial y final y los descuentos
         */
        Text precioInicialLbl = new Text("Precio Inicial");
        TextField precioInicialTxt = new TextField();
        precioInicialTxt.setEditable(false);

        Text descuentoFidelidadLbl = new Text("Desc. Fidelidad");
        TextField descuentoFidelidadTxt = new TextField();
        descuentoFidelidadTxt.setEditable(false);

        Text descuentoCumpleanhosLbl = new Text("Desc. Cumpleaños");
        TextField descuentoCumpleanhosTxt = new TextField();
        descuentoCumpleanhosTxt.setEditable(false);

        Text descuentoCatergoriaLbl = new Text("Desc. Catergoria");
        TextField descuentoCatergoriaTxt = new TextField();
        descuentoCatergoriaTxt.setEditable(false);

        Text descuentoProductosLbl = new Text("Desc. Productos");
        TextField descuentoProductosTxt = new TextField();
        descuentoProductosTxt.setEditable(false);

        Text precioFinalLbl = new Text("Precio Final");
        TextField precioFinalTxt = new TextField();
        precioFinalTxt.setEditable(false);

          /*
            Botón calcular los descuentos
         */
        Button calcularDescuentoBtn = new Button("Calcular Descuento");
        calcularDescuentoBtn.setOnAction(event -> {
            Cliente clienteSeleccionado = comboBox.getValue();
            if (clienteSeleccionado != null) {
                // Una nueva instancia de servicio
                Servicio servicio = new Servicio(em);
                List<Producto> productos = servicio.getProductosByRut(clienteSeleccionado.getRut());
                GerenciadorDescuento gerenciadorDescuento = new GerenciadorDescuento();
                List<Integer> precios = gerenciadorDescuento.calcularPrecioFinal(productos, clienteSeleccionado.getFechaNacimiento(),
                        String.valueOf(clienteSeleccionado.getAnhoRegistro()), fechaActualTxt.getText());

                precioInicialTxt.setText(String.valueOf(precios.get(0)));
                descuentoFidelidadTxt.setText(String.valueOf(precios.get(1)));
                descuentoCumpleanhosTxt.setText(String.valueOf(precios.get(2)));
                descuentoCatergoriaTxt.setText(String.valueOf(precios.get(3)));
                descuentoProductosTxt.setText(String.valueOf(precios.get(4)));
                precioFinalTxt.setText(String.valueOf(precios.get(5)));
            }
        });

        comboBox.setOnAction(event -> {
            Cliente selectedCliente = comboBox.getSelectionModel().getSelectedItem();
            if (selectedCliente != null) {
                Servicio servicio = new Servicio(em);
                List<Producto> productos = servicio.getProductosByRut(selectedCliente.getRut());
                fechaNacimientoTxt.setText(selectedCliente.getFechaNacimiento());
                anhoRegistroTxt.setText(String.valueOf(selectedCliente.getAnhoRegistro()));
                this.fillTableView(table, productos);
                precioInicialTxt.setText("");
                descuentoFidelidadTxt.setText("");
                descuentoCumpleanhosTxt.setText("");
                descuentoCatergoriaTxt.setText("");
                descuentoProductosTxt.setText("");
                precioFinalTxt.setText("");
            }
        });
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setHgap(10); // Espacio horizontal entre columnas
        gridPane.setVgap(10); // Espacio vertical entre filas
        gridPane.add(clienteLbl, 0, 0);
        gridPane.add(comboBox, 1, 0);
        gridPane.add(tableLbl,0,3);
        gridPane.add(fechaNacimientoClienteLbl, 2,0);
        gridPane.add(fechaNacimientoTxt, 3, 0);
        gridPane.add(anhoRegistroLbl, 2,1);
        gridPane.add(anhoRegistroTxt, 3,1);
        gridPane.add(fechaActualLbl, 0,2);
        gridPane.add(fechaActualTxt, 1,2);

        //Gridpane para los descuentos
        GridPane gridPane2 = new GridPane();
        gridPane2.setPadding(new Insets(10, 10, 10, 10));
        gridPane2.setHgap(10);
        gridPane2.setVgap(10);
        gridPane2.add(precioInicialLbl, 0,0);
        gridPane2.add(descuentoFidelidadLbl, 1,0);
        gridPane2.add(descuentoCumpleanhosLbl, 2,0);
        gridPane2.add(descuentoCatergoriaLbl, 3,0);
        gridPane2.add(descuentoProductosLbl, 4,0);
        gridPane2.add(precioFinalLbl, 6,0);

        gridPane2.add(precioInicialTxt, 0,1);
        gridPane2.add(descuentoFidelidadTxt, 1,1);
        gridPane2.add(descuentoCumpleanhosTxt, 2,1);
        gridPane2.add(descuentoCatergoriaTxt, 3,1);
        gridPane2.add(descuentoProductosTxt, 4,1);
        gridPane2.add(precioFinalTxt, 6,1);

        BorderPane root = new BorderPane();
        root.setPadding(new Insets(15));
        root.setTop(gridPane);
        root.setCenter(table);
        root.setBottom(gridPane2);

        VBox container = new VBox();
        container.setPrefSize(100, 100);
        container.getChildren().add(root);
        container.getChildren().add(calcularDescuentoBtn);

        primaryStage.setScene(new Scene(container, 800, 800));
        primaryStage.show();
    }

    public List<Cliente> fillComboboxCliente(){

        Servicio servicio = new Servicio(this.em);
        return servicio.getClientes();
    }

    private void fillTableView(TableView<Producto> tableView, List<Producto> productos) {
        // Limpiar la tabla antes de agregar nuevos productos
        tableView.getItems().clear();
        // Llenar la tabla con los nuevos productos
        tableView.getItems().addAll(productos);
    }

    @Override
    public void stop() {
        em.close();
        emf.close();
    }
}