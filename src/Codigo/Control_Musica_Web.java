/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codigo;
import java.awt.Desktop;
 import java.io.*;
import javazoom.jl.decoder.*;
import javazoom.jl.player.*;
import java.net.*;
/**
 *
 * @author Enrique
 */
public class Control_Musica_Web {
    FileInputStream FIS;
    BufferedInputStream BIS;
    
    public Player player;
    
    public void Stop(){
        if(player != null){
            player.close();
        }
    }
    public void Play(String direccion_musica){
        if(player != null){
            player.close();
        }
        if(!direccion_musica.equals("")){
            try {
                
                FIS = new FileInputStream(direccion_musica);
                BIS = new BufferedInputStream(FIS);
                
                player = new Player(FIS);
            } catch(FileNotFoundException | JavaLayerException ex){
                System.out.println(ex);
            }
        }
        new Thread(){
            @Override
            public void run(){
                try {
                    player.play();
                } catch (JavaLayerException e) {
                    System.out.println(e);
                }
            }
        }.start();
    }

    public void Ver_Trailer(String enlace) {
        if(java.awt.Desktop.isDesktopSupported()){
            java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
            if(desktop.isSupported(Desktop.Action.BROWSE)){
                try{
                    java.net.URI URL = new java.net.URI(enlace);
                    desktop.browse(URL);
                }catch(URISyntaxException | IOException ex){
                    System.out.println(ex);
                }
            }
        }
    }
}
