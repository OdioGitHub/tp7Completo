package com.example.tp7;


import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import org.cocos2d.opengl.CCGLSurfaceView;

/*
WARNING: the code that follows will make you cry
     a safety dragon is provided below for your own security
                                                                 `.
                                                             .++:.
                                               .         `/sodN.
                                      `+hs:`   y-     `/yy:` d+`
                    `          ``    /Nd-     oN.   .sd+`    s+:
                  ++:      `+y++N: -h++-    :d+o  :hh:       `sNo://:-.`
                `+++Nhhhhd+NNs  +NN++++s.-od+N+ -hd:       `:oyy+o`
                s+++++++++++++++++++++++++++o.`sN+      .+hho- -+:
                `N+++s/::://+sh+++++N+++y+-  -+h.    `/hd+.    `Ny
                 -yo :hdhyssyhy:+++++d+No   +Ns    .s+s-        .yh:.-///:-.`
                  `+yo+` `.:+osd+++N/h+++- ++o   -y+o`        .:osy++:.`
            ``.-+ss/` :yy++++hsoosys+++++-++s  .yNo`     `:ohhs/.  hs
            `---`     /++do-     s++++++h-Nd``oNh.    -ohho:`      ++
                      `h-     `oNN+dN++N-d+:-d+o   :sdy/`          hy
                       ``    `y+N++++++::+++N+/`:s+h/`      ```....:+o.`
                          `s+NN+dN+++++ o+NhdNdN+h--/+syhhhyyssso++//sd/:-.`
                         `h++++++++++d  sh.+:/++++yo+:.`            +s`
                       `o++ddd++++++++hooyNN.+++y-                `s/         `.
 .:/ss ``:            .++++++++++++++++++Ny-:N+NN+Ndyo+:-.`      .h.          s:
    `h+h-d-           oyhhhN++++++++++/...:y+N: ``.-:/++ossssoo++sy::-.     .h+`
   -o++++++         `sN++++++++++++++++o::/+sysooooo++///+++++/:--.`     `:yN+-  ``
  /+:s++++y         /+++++++++++++++++++++N++dddddd+++N++++++++++++++hoyd+++h+oyy:
     `N+++/       -+:ysyyd++++++++++++++++++++++++++++++++++++++++++++++++++++h/``-`
      ./+h+:` `-od+++h++++++++++++++++++++++++++++++++++++N+N++++++++++++++++++N+s-
          h+NhN+++++N++++++dhd+++++++++++++++++++++++++dosyhyysoh+++++++++++++++N/
         s+++ `:sN++++:sysy+++++++++++++++++++++++++++y/++++++++s++++s`/h+++++++++s
         :++.    `/Nh    /+N++++++++++++++++++++N+ddd+-++++++++++.N++    -h++++++++.
         .d/      `d-     .s++++++++++++++++++ssyd+Ny``d+++++++++.-        y+++++++-
         .`       `        ++++++++++s++N+y+-y++++++`   +++++++++`         -++++++d
                           `N++++++y:`-`     :h++++d`     /d++++N+` `:     +++++++/
                           -+++y:`           `y+++NN+s:`    .odN++N+h/    `N++++++`
                           +++:             /dy+-.````         `o+++/     y++++++N:
                           /+y             s++                   /N+s     h++++++++do/-`
                    `-.   o+N.       .-`./y++h--                 `N+``:.`  :sdN++++++++++y+-`
                  :ooNNddN++Nd:    -h+++++hsyd++:          `/yds++++++Nh:-`   `.:osh+N++++++Ndo:`
                  `  :ysNhd+h/oo  .s--+++N`   /h/          o/-/y++y+h`               `.:+y++++++Ns.
                    +dys-/++y` `  `. s+hy:     `.             .NNs:+N.                     .++++++N:
                   `y    /o         :+          `/sy/`        ys:  -s-                       `y++++N
                    `    :          `.       .+d++h`         `/                               :+++++
                                           :h+++Nh/:+osyyhhhhhyysso+/::.``                   `h++++N
                                        `++++Nhyydho+/:-----:/+osyd+++++++N+dhyso+/::-----:+yN+++++/
                                     `:yN+Nyyyhh+`                   .-/oydN+++++++++++++++++++++d-
                            :+///+sy+++++++N+N++++dhhho-                    `-/oydNN+++++++++Nds-
                             `:oydNN+++++++++++N+dy+-`                             `.-:////-.`
                                    `+++++++++´

 */

public class MainActivity extends Activity {

    CCGLSurfaceView MainView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        MainView = new CCGLSurfaceView(this);
        setContentView(MainView);
    }

    @Override
    protected void onStart(){
        super.onStart();
        clsJuego Game;
        Game = new clsJuego(MainView);
        Game.comenzarJuego();
    }

}
