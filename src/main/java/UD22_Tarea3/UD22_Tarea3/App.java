package UD22_Tarea3.UD22_Tarea3;

import connexion.Connector;
import controllers.Controlador;
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

public class App 
{

	
    public static void main( String[] args )
    {
        Cientifico c = new Cientifico();
        MenuInicio ini = new MenuInicio();
        Anadir a = new Anadir();
        Ver v = new Ver();
        Connector con = new Connector();
        Quitar q = new Quitar();
        QueAnadir an = new QueAnadir();
        AnadirVideo anadirvideo = new AnadirVideo();
        VerVideo vervideo = new VerVideo();
        Proyecto video = new Proyecto();
        QuitarVideo quitarVideo = new QuitarVideo();
        AnadirAsignado anadirAsignado = new AnadirAsignado();
        VerAsignado verAnadir = new VerAsignado();
        Asignado asig = new Asignado();
        QuitarAsignado quitarAsignado = new QuitarAsignado();
        Controlador control = new Controlador(ini, c, a, v, con, q, an, anadirvideo, vervideo, video, quitarVideo,anadirAsignado, verAnadir, asig, quitarAsignado);
        control.iniciarVista();
    }
}
