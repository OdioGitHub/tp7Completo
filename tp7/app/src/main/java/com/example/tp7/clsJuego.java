package com.example.tp7;

import android.util.Log;

import org.cocos2d.actions.interval.MoveTo;
import org.cocos2d.layers.Layer;
import org.cocos2d.nodes.Director;
import org.cocos2d.nodes.Scene;
import org.cocos2d.nodes.Sprite;
import org.cocos2d.opengl.CCGLSurfaceView;
import org.cocos2d.types.CCPoint;
import org.cocos2d.types.CCSize;

import java.util.Random;

public class clsJuego {
    CCGLSurfaceView _VistaDelJuego;
    CCSize _Pantalla;
    Sprite _Jugador;

    public clsJuego(CCGLSurfaceView VistaDelJuego) {
        Log.d("ClaseJuego", "Comienza el constructor de la clase");
        this._VistaDelJuego = VistaDelJuego;
    }

    public void comenzarJuego()
    {
        Log.d("ComenzarJuego", "Comienza el juego");
        Director.sharedDirector().attachInView(_VistaDelJuego);

        _Pantalla = Director.sharedDirector().displaySize();
        Log.d("ComenzarJuego", "pantalla - ancho: " + _Pantalla.getWidth() + " - alto: " + _Pantalla.getHeight());

        Scene EscenaaUsar;
        EscenaaUsar = EscenaComienzo();

        Log.d("ComenzarJuego", "Le digo al director que inicie la escena");
        Director.sharedDirector().runWithScene(EscenaaUsar);

    }

    private Scene EscenaComienzo(){
        Log.d("EscenaComienzo", "Comienza");
        Scene escenaDevolver;
        escenaDevolver = Scene.node();

        Log.d("EscenaComienzo", "Voy a agregar ls capa");
        capaJuego unaCapa;
        unaCapa = new capaJuego();
        escenaDevolver.addChild(unaCapa);
        return escenaDevolver;
    }

    class capaJuego extends Layer{
        public capaJuego(){
            Log.d("CapaJuego", "Comienza el constructor");

            Log.d("CapaJuego", "ubicar posiccion inicial del jugador");
            super.schedule("ponerJugador", 3.0f);
        }
        void ponerJugador(float diferenciaTiempo){
            Log.d("ponerJugador", "Comienzo a ubicar al jugador");
            _Jugador=Sprite.sprite("jugador.png");

            CCPoint posicionInicial;
            posicionInicial = new CCPoint();

            Log.d("ponerJugador", "x al azar");
            Random azarX;
            azarX = new Random();
            posicionInicial.x = azarX.nextInt((int) _Pantalla.getWidth());

            Log.d("ponerJugador", "y al azar");
            Random azary;
            azary = new Random();
            posicionInicial.y = azary.nextInt((int) _Pantalla.getHeight());

            Log.d("ponerJugador", "le pongo su ubicacion inicial");
            _Jugador.setPosition(posicionInicial.x,posicionInicial.y);

            Log.d("ponerJugador", "lo agrego a la capa");
            super.addChild(_Jugador);

            CCPoint esquinas;
            esquinas = new CCPoint();

            if(posicionInicial.x < _Pantalla.getWidth()/2){
                if (posicionInicial.y< _Pantalla.getHeight()/2){
                    esquinas.x = _Pantalla.getWidth() - _Jugador.getWidth()/2;
                    esquinas.y = _Pantalla.getHeight()- _Jugador.getHeight()/2;
                }
                else{
                    esquinas.x = _Pantalla.getWidth() - _Jugador.getWidth()/2;
                    esquinas.y = 0 + _Jugador.getHeight()/2;
                }
            }
            else{
                if (posicionInicial.y< _Pantalla.getHeight()/2){
                    esquinas.x = 0 + _Jugador.getWidth()/2;
                    esquinas.y = _Pantalla.getHeight() - _Jugador.getHeight()/2;
                }
                else{
                    esquinas.x = 0 + _Jugador.getWidth()/2;
                    esquinas.y =  0 + _Jugador.getHeight()/2;
                }
            }

            _Jugador.runAction(MoveTo.action(3, esquinas.x, esquinas.y));
        }
    }

}
