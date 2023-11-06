package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import connexion.Connector;
import models.Asignado;
import models.Cientifico;
import models.Proyecto;
import views.Anadir;
import views.AnadirAsignado;
import views.AnadirVideo;
import views.MenuInicio;
import views.QueAnadir;
import views.Quitar;
import views.QuitarAsignado;
import views.QuitarVideo;
import views.Ver;
import views.VerAsignado;
import views.VerVideo;

public class Controlador implements ActionListener {
	
	private MenuInicio menu;
	private Cientifico cientifico;
	private Proyecto proy;
	private Anadir anadirCliente;
	private Ver ver;
	private Connector connector;
	private Quitar quitar;
	private QueAnadir queanadir;
	private AnadirVideo anadirVideo;
	private VerVideo verVideo;
	private QuitarVideo quitarVideo;
	private AnadirAsignado anadirAsignado;
	private VerAsignado verAnadir;
	private Asignado asignado;
	private QuitarAsignado quitarAsignado;
	private boolean verBool = false;
	private boolean quitarBool = false;
	
	public Controlador(MenuInicio menu, Cientifico cientifico, Anadir anadir, Ver ver, Connector connector, Quitar quitar, QueAnadir queanadir, AnadirVideo anadirVideo, VerVideo verVideo, Proyecto proy, QuitarVideo quitarVideo, AnadirAsignado anadirAsignado, VerAsignado verAnadir, Asignado asignado, QuitarAsignado quitarAsignado){
		this.cientifico = cientifico;
		this.menu = menu;
		this.anadirCliente = anadir;
		this.ver = ver;
		this.connector = connector;
		this.quitar = quitar;
		this.queanadir = queanadir;
		this.anadirVideo = anadirVideo;
		this.verVideo = verVideo;
		this.proy = proy;
		this.quitarVideo = quitarVideo;
		this.anadirAsignado = anadirAsignado;
		this.verAnadir = verAnadir;
		this.asignado = asignado;
		this.quitarAsignado = quitarAsignado;
		this.menu.anadir.addActionListener(this);
		this.menu.ver.addActionListener(this);
		this.menu.quitar.addActionListener(this);
		this.anadirCliente.guardarButton.addActionListener(this);
		this.anadirCliente.cancelarButton.addActionListener(this);
		this.ver.guardarButton.addActionListener(this);
		this.ver.cancelarButton.addActionListener(this);
		this.quitar.cancelarButton.addActionListener(this);
		this.quitar.guardarButton.addActionListener(this);
		this.queanadir.cliente.addActionListener(this);
		this.queanadir.video.addActionListener(this);
		this.queanadir.asignado.addActionListener(this);
		this.anadirVideo.cancelarButton.addActionListener(this);
		this.anadirVideo.guardarButton.addActionListener(this);
		this.verVideo.guardarButton.addActionListener(this);
		this.verVideo.cancelarButton.addActionListener(this);
		this.quitarVideo.cancelarButton.addActionListener(this);
		this.quitarVideo.guardarButton.addActionListener(this);
		this.anadirAsignado.guardarButton.addActionListener(this);
		this.anadirAsignado.cancelarButton.addActionListener(this);
		this.verAnadir.guardarButton.addActionListener(this);
		this.verAnadir.cancelarButton.addActionListener(this);
		this.quitarAsignado.guardarButton.addActionListener(this);
		this.quitarAsignado.cancelarButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(menu.anadir == e.getSource()) {
			menu.setVisible(false);
			iniciarVistaAnadir();
			
		}
		else if(menu.ver == e.getSource()) {
			menu.setVisible(false);
			verBool = true;
			quitarBool = true;
			queanadir.label.setText("¿Qué quieres ver?");
			iniciarVistaAnadir();
		}
		else if(menu.quitar == e.getSource()) {
			menu.setVisible(false);
			quitarBool = true;
			iniciarVistaAnadir();
		}
		else if(queanadir.video== e.getSource()) {
			queanadir.setVisible(false);
			if(verBool) {
				iniciarVistaVerVideo();
			}
			else if(quitarBool) {
				iniciarVistaQuitarVideo();
			}
			else {
				iniciarVistaAnadirVideo();
			}
			
		}
		else if(queanadir.asignado== e.getSource()) {
			queanadir.setVisible(false);
			if(verBool) {
				iniciarVistaVerAnadir();
			}
			else if(quitarBool) {
				iniciarVistaQuitarAnadir();
			}
			else {
				iniciarVistaAnadirAnadir();
			}
			
		}
		else if(queanadir.cliente== e.getSource()) {
			queanadir.setVisible(false);
			if(verBool) {		
				iniciarVistaVerCliente();
			}
			else if(quitarBool) {
				iniciarVistaQuitarCliente();
			}
			else {
				iniciarVistaAnadirCliente();
			}	
		}
		else if(anadirCliente.guardarButton== e.getSource()) {
			anadirValorCientfico();
		}
		else if(anadirVideo.guardarButton== e.getSource()) {
			anadirValorProyecto();
		}
		else if(anadirAsignado.guardarButton== e.getSource()) {
			anadirValorAsignado();
		}
		else if(ver.guardarButton== e.getSource()) {
			mostrarValor();
			
		}
		else if(verVideo.guardarButton== e.getSource()) {
			mostrarValorVideo();
			
		}
		else if(verAnadir.guardarButton == e.getSource()) {
			mostrarValorAnadir();
		}
		else if(quitar.guardarButton== e.getSource()) {
			quitarValor();
			
		}
		else if(quitarVideo.guardarButton== e.getSource()) {
			quitarValorVideo();
			
		}
		else if(quitarAsignado.guardarButton == e.getSource()) {
			quitarValorAsignado();
		}
		else if(anadirCliente.cancelarButton == e.getSource() || anadirVideo.cancelarButton == e.getSource() || ver.cancelarButton == e.getSource() || quitar.cancelarButton == e.getSource() || verVideo.cancelarButton == e.getSource() || quitarVideo.cancelarButton == e.getSource() || anadirAsignado.cancelarButton == e.getSource() || verAnadir.cancelarButton == e.getSource() || quitarAsignado.cancelarButton == e.getSource()) {
			//cambiar visibilidades
			queanadir.label.setText("¿Qué quieres añadir?");
			quitarAsignado.setVisible(false);
			verBool = false;
			anadirCliente.setVisible(false);
			anadirVideo.setVisible(false);
			anadirAsignado.setVisible(false);
			ver.setVisible(false);
			verVideo.setVisible(false);
			verAnadir.setVisible(false);
			quitar.setVisible(false);
			quitarVideo.setVisible(false);
			menu.setVisible(true);
		}
	}
	
	public void iniciarVista() {
		menu.setTitle("Menu inicio");
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu.setLocationRelativeTo(null);
        menu.setVisible(true);
	}
	
	public void iniciarVistaAnadir() {
		queanadir.setTitle("Anadir");
		queanadir.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		queanadir.setLocationRelativeTo(null);
		queanadir.setVisible(true);
	}
	
	public void iniciarVistaAnadirCliente() {
		anadirCliente.setTitle("Anadir");
		anadirCliente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		anadirCliente.setLocationRelativeTo(null);
		anadirCliente.setVisible(true);
	}
	
	public void iniciarVistaAnadirVideo() {
		anadirVideo.setTitle("Anadir");
		anadirVideo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		anadirVideo.setLocationRelativeTo(null);
		anadirVideo.setVisible(true);
	}
	
	public void iniciarVistaAnadirAnadir() {
		anadirAsignado.setTitle("Anadir");
		anadirAsignado.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		anadirAsignado.setLocationRelativeTo(null);
		anadirAsignado.setVisible(true);
	}
	
	public void iniciarVistaVerCliente() {
		ver.setTitle("Ver");
		ver.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ver.setLocationRelativeTo(null);
		ver.setVisible(true);
	}
	
	public void iniciarVistaVerVideo() {
		verVideo.setTitle("Ver");
		verVideo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		verVideo.setLocationRelativeTo(null);
		verVideo.setVisible(true);
	}
	
	public void iniciarVistaVerAnadir() {
		verAnadir.setTitle("Ver");
		verAnadir.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		verAnadir.setLocationRelativeTo(null);
		verAnadir.setVisible(true);
	}
	

	public void iniciarVistaQuitarCliente() {
		quitar.setTitle("Quitar");
		quitar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		quitar.setLocationRelativeTo(null);
		quitar.setVisible(true);
	}
	
	public void iniciarVistaQuitarVideo() {
		quitarVideo.setTitle("Quitar");
		quitarVideo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		quitarVideo.setLocationRelativeTo(null);
		quitarVideo.setVisible(true);
	}
	
	public void iniciarVistaQuitarAnadir() {
		quitarAsignado.setTitle("Quitar");
		quitarAsignado.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		quitarAsignado.setLocationRelativeTo(null);
		quitarAsignado.setVisible(true);
	}
	
	public void mostrarValor() {
		cientifico = connector.leer(ver.nombreTextField.getText());
		if (cientifico.getId() != 0) {
			ver.apellidoTextField.setText(cientifico.toString());
		}
		else {
			JOptionPane.showMessageDialog(null, "El elemento no se encuentra en la base de datos",
				      "Error", JOptionPane.ERROR_MESSAGE);
		}
	    
	}
	
	public void mostrarValorVideo() {
		proy = connector.leerVideo(verVideo.nombreTextField.getText());
		
		if (proy.getId() != 0) {
			verVideo.apellidoTextField.setText(proy.toString());	
		}
		else {
			JOptionPane.showMessageDialog(null, "El elemento no se encuentra en la base de datos",
				      "Error", JOptionPane.ERROR_MESSAGE);
		}
	    
	}
	
	public void mostrarValorAnadir() {
		asignado = connector.leerAsignado(verAnadir.nombreTextField.getText(),verAnadir.idProyTextField.getText());
		
		if (asignado.getId_cien() != 0 && asignado.getId_proy() != 0) {
			verAnadir.nombreTextField.setText("se encuentra");
			verAnadir.idProyTextField.setText("se encuentra");
		}
		else {
			JOptionPane.showMessageDialog(null, "El elemento no se encuentra en la base de datos",
				      "Error", JOptionPane.ERROR_MESSAGE);
		}
	    
	}
	
	public void anadirValorCientfico() {

		boolean podido = connector.escribir(anadirCliente.nombreTextField.getText(), anadirCliente.apellidoTextField.getText());
		
		if (podido) {
			JOptionPane.showMessageDialog(null, "Values added successfully",
				      "Ok", JOptionPane.DEFAULT_OPTION);
		}
		else {
			JOptionPane.showMessageDialog(null, "Error en los campos de los datos",
				      "Error", JOptionPane.ERROR_MESSAGE);
		}
	    
	}
	
	public void anadirValorProyecto() {

		boolean podido = connector.escribirProyecto(anadirVideo.tituloTextField.getText(), anadirVideo.directorTextField.getText());
		
		if (podido) {
			JOptionPane.showMessageDialog(null, "Values added successfully",
				      "Ok", JOptionPane.DEFAULT_OPTION);
		}
		else {
			JOptionPane.showMessageDialog(null, "Error en los campos de los datos",
				      "Error", JOptionPane.ERROR_MESSAGE);
		}
	    
	}
	
	public void anadirValorAsignado() {

		boolean podido = connector.escribirAsignado(anadirAsignado.id_cientifTextField.getText(), anadirAsignado.id_proyecTextField.getText());
		
		if (podido) {
			JOptionPane.showMessageDialog(null, "Values added successfully",
				      "Ok", JOptionPane.DEFAULT_OPTION);
		}
		else {
			JOptionPane.showMessageDialog(null, "Error en los campos de los datos",
				      "Error", JOptionPane.ERROR_MESSAGE);
		}
	    
	}
	
	public void quitarValor() {
		boolean podido =  connector.quitar(quitar.nombreTextField.getText());
		if (podido) {
			JOptionPane.showMessageDialog(null, "Client deleted successfully",
				      "Ok", JOptionPane.DEFAULT_OPTION);
		}
		else {
			JOptionPane.showMessageDialog(null, "Error en los campos de los datos",
				      "Error", JOptionPane.ERROR_MESSAGE);
		}    
	}
	
	public void quitarValorVideo() {
		boolean podido =  connector.quitarVideo(quitarVideo.nombreTextField.getText());
		if (podido) {
			JOptionPane.showMessageDialog(null, "Client deleted successfully",
				      "Ok", JOptionPane.DEFAULT_OPTION);
		}
		else {
			JOptionPane.showMessageDialog(null, "Error en los campos de los datos",
				      "Error", JOptionPane.ERROR_MESSAGE);
		}    
	}
	
	public void quitarValorAsignado() {
		boolean podido =  connector.quitarAsignado(quitarAsignado.nombreTextField.getText(), quitarAsignado.proy.getText());
		if (podido) {
			JOptionPane.showMessageDialog(null, "Client deleted successfully",
				      "Ok", JOptionPane.DEFAULT_OPTION);
		}
		else {
			JOptionPane.showMessageDialog(null, "Error en los campos de los datos",
				      "Error", JOptionPane.ERROR_MESSAGE);
		}    
	}
}
