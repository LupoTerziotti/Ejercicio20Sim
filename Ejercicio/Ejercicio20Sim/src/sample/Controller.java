package sample;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import model.GestorPolitica1;
import model.GestorPolitica2;
import util.Fila;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    private ObservableList<Fila> data;
    private GestorPolitica1 gestorPolitica1;
    private GestorPolitica2 gestorPolitica2;

    public Controller() {
        this.gestorPolitica1 = new GestorPolitica1();
        this.gestorPolitica2 = new GestorPolitica2();
        this.tvSim = new TableView<Fila>();
    }


    @FXML
    private Button btnsimularPolitica2;
    @FXML
    private Label txCamionesTotales;
    @FXML
    private Button btnsimularPolitica1;
    @FXML
    private TextField txtDiaDesde;
    @FXML
    private TextField txtDiaHasta;
    @FXML
    private TextField txtSemanasSimuladas;
    @FXML
    private Label costoTotalAlmacenamiento;
    @FXML
    private Label costoTotalPedido;
    @FXML
    private Label costoTotalAgotamiento;
    @FXML
    private Label costoTotal;
    @FXML
    private Pane paneMain;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private TableView<Fila> tvSim;
    @FXML
    private TableColumn<Fila, String> dia;
    @FXML
    private TableColumn<Fila, String> semana;
    @FXML
    private TableColumn<Fila, String> random1;
    @FXML
    private TableColumn<Fila, String> demanda;
    @FXML
    private TableColumn<Fila, String> venta;
    @FXML
    private TableColumn<Fila, String> stockRemanente;
    @FXML
    private TableColumn<Fila, String> almacenamiento;
    @FXML
    private TableColumn<Fila, String> almacenamientoAcumulado;
    @FXML
    private TableColumn<Fila, String> pedido;
    @FXML
    private TableColumn<Fila, String> pedidoAcumulado;
    @FXML
    private TableColumn<Fila, String> diaAgotamiento1;
    @FXML
    private TableColumn<Fila, String> diaAgotamiento2;
    @FXML
    private TableColumn<Fila, String> diaAgotamiento3;
    @FXML
    private TableColumn<Fila, String> diaAgotamiento4;
    @FXML
    private TableColumn<Fila, String> diaAgotamiento5;
    @FXML
    private TableColumn<Fila, String> diaAgotamiento6;
    @FXML
    private TableColumn<Fila, String> diaAgotamiento7;
    @FXML
    private TableColumn<Fila, String> agotamiento;
    @FXML
    private TableColumn<Fila, String> agotamientoAcumulado;
    @FXML
    private TableColumn<Fila, String> random2;
    @FXML
    private TableColumn<Fila, String> demora;
    @FXML
    private TableColumn<Fila, String> stockDisponible;
    @FXML



    public void cargarTablaPolitica1() {

        this.gestorPolitica1.inicio();

        this.setearColummnas();

        ObservableList<Fila> list = gestorPolitica1.getData();

        tvSim.setItems(list);

        this.setStatsPolitica1();

    }

    public void setearColummnas() {
        dia.setCellValueFactory(new PropertyValueFactory<>("dia"));
        semana.setCellValueFactory(new PropertyValueFactory<>("semana"));
        random1.setCellValueFactory(new PropertyValueFactory<>("random1"));
        demanda.setCellValueFactory(new PropertyValueFactory<>("demanda"));
        venta.setCellValueFactory(new PropertyValueFactory<>("venta"));
        stockRemanente.setCellValueFactory(new PropertyValueFactory<>("stockRemanente"));
        almacenamiento.setCellValueFactory(new PropertyValueFactory<>("almacenamiento"));
        almacenamientoAcumulado.setCellValueFactory(new PropertyValueFactory<>("almacenamientoAcumulado"));
        pedido.setCellValueFactory(new PropertyValueFactory<>("pedido"));
        pedidoAcumulado.setCellValueFactory(new PropertyValueFactory<>("pedidoAcumulado"));
        agotamiento.setCellValueFactory(new PropertyValueFactory<>("agotamiento"));
        agotamientoAcumulado.setCellValueFactory(new PropertyValueFactory<>("agotamientoAcumulado"));
        random2.setCellValueFactory(new PropertyValueFactory<>("random2"));
        demora.setCellValueFactory(new PropertyValueFactory<>("demora"));
        stockDisponible.setCellValueFactory(new PropertyValueFactory<>("stockDisponible"));
        diaAgotamiento1.setCellValueFactory(new PropertyValueFactory<>("diaAgotamiento1"));
        diaAgotamiento2.setCellValueFactory(new PropertyValueFactory<>("diaAgotamiento2"));
        diaAgotamiento3.setCellValueFactory(new PropertyValueFactory<>("diaAgotamiento3"));
        diaAgotamiento4.setCellValueFactory(new PropertyValueFactory<>("diaAgotamiento4"));
        diaAgotamiento5.setCellValueFactory(new PropertyValueFactory<>("diaAgotamiento5"));
        diaAgotamiento6.setCellValueFactory(new PropertyValueFactory<>("diaAgotamiento6"));
        diaAgotamiento7.setCellValueFactory(new PropertyValueFactory<>("diaAgotamiento7"));

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


    private void clearItemsInTableView() {
        tvSim.getItems().clear();
    }

    public void closeApp(ActionEvent event) {
        Platform.exit();
        System.exit(0);
    }


    @FXML
    void simulacionOnActionPolitica1(ActionEvent event) {

        this.initializeNewSimulation(true);//true porque es la simulacion de politica 1
    }

    @FXML
    void simulacionOnActionPolitica2(ActionEvent event) {

        this.initializeNewSimulation(false);//false porque es la simulacion de politica 2

    }

    public void setearDiasPolitica1()
    {
        if (txtDiaDesde.getText() == null || txtDiaDesde.getText().trim().isEmpty()) {
            gestorPolitica1.setDiaDesde(0);

        } else {
            gestorPolitica1.setDiaDesde(Integer.valueOf(txtDiaDesde.getText()));
        }
        if (txtDiaHasta.getText() == null || txtDiaHasta.getText().trim().isEmpty()) {
            gestorPolitica1.setDiaHasta(gestorPolitica1.getSemanasAsimular()*7);
        } else {
            gestorPolitica1.setDiaHasta(Integer.valueOf(txtDiaHasta.getText()));
        }
    }

    public void setearDiasPolitica2()
    {
        if (txtDiaDesde.getText() == null || txtDiaDesde.getText().trim().isEmpty()) {
            gestorPolitica2.setDiaDesde(0);

        } else {
            gestorPolitica2.setDiaDesde(Integer.valueOf(txtDiaDesde.getText()));
        }
        if (txtDiaHasta.getText() == null || txtDiaHasta.getText().trim().isEmpty()) {
            gestorPolitica2.setDiaHasta(gestorPolitica2.getSemanasAsimular()*7);
        } else {
            gestorPolitica2.setDiaHasta(Integer.valueOf(txtDiaHasta.getText()));
        }
    }

    public void setearSemanasPolitica1()
    {
        if(txtSemanasSimuladas.getText()==null || txtSemanasSimuladas.getText().trim().isEmpty())
        {
            gestorPolitica1.setSemanasAsimular(16);
        }else
        {
            gestorPolitica1.setSemanasAsimular(Integer.valueOf(txtSemanasSimuladas.getText()));
        }
    }

    public void setearSemanasPolitica2()
    {
        if(txtSemanasSimuladas.getText()==null || txtSemanasSimuladas.getText().trim().isEmpty())
        {
            gestorPolitica2.setSemanasAsimular(16);
        }else
        {
            gestorPolitica2.setSemanasAsimular(Integer.valueOf(txtSemanasSimuladas.getText()));
        }
    }



    private void initializeNewSimulation(boolean bool) {

        this.resetSimulation(bool);
    }

    private void resetSimulation(boolean bool) {


        if (bool)
        {
            this.gestorPolitica1 = new GestorPolitica1();
            this.setearSemanasPolitica1();
            this.setearDiasPolitica1();

        }else
        {
            this.gestorPolitica2 = new GestorPolitica2();
            this.setearSemanasPolitica2();
            this.setearDiasPolitica2();

        }

        clearItemsInTableView();

        if(bool)
        {
            cargarTablaPolitica1();
        }else
        {
            cargarTablaPolitica2();
        }

    }


    public void cargarTablaPolitica2() {

        this.gestorPolitica2.inicio();

        this.setearColummnas();

        ObservableList<Fila> list = gestorPolitica2.getData();

        tvSim.setItems(list);

        this.setStatsPolitica2();
    }

    private void setStatsPolitica2() {
        int total=gestorPolitica2.getAlmacenamientoAcumulado()+gestorPolitica2.getPedidoAcumulado()+gestorPolitica2.getAgotamientoAcumulado();

        costoTotalAlmacenamiento.setText("$ "+String.valueOf(gestorPolitica2.getAlmacenamientoAcumulado())) ;
        costoTotalPedido.setText("$ "+String.valueOf(gestorPolitica2.getPedidoAcumulado())) ;
        costoTotalAgotamiento.setText("$ "+String.valueOf(gestorPolitica2.getAgotamientoAcumulado()));
        costoTotal.setText("$ "+String.valueOf(total));


    }

    private void setStatsPolitica1() {
        int total=gestorPolitica1.getAlmacenamientoAcumulado()+gestorPolitica1.getPedidoAcumulado()+gestorPolitica1.getAgotamientoAcumulado();

        costoTotalAlmacenamiento.setText("$ "+String.valueOf(gestorPolitica1.getAlmacenamientoAcumulado())) ;
        costoTotalPedido.setText("$ "+String.valueOf(gestorPolitica1.getPedidoAcumulado())) ;
        costoTotalAgotamiento.setText("$ "+String.valueOf(gestorPolitica1.getAgotamientoAcumulado()));
        costoTotal.setText("$ "+String.valueOf(total));

    }
}
