package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
public class Controller {
    public TextField unos;
    public TextField izlaz;

    public void dugme(ActionEvent actionEvent) {
        String ulaz= unos.getText();
        int duz=ulaz.length();
        int brojac=0,pozicija=0,najduza=0,pozicija_najduzeg=0;
        int razmak = -1, duzina =0, pos = 0;
        for (int i=0; i<ulaz.length(); i++) {
            if (ulaz.charAt(i)!=' '){               //moglo poocu split i replace
                if (brojac==0) pozicija=i;
                brojac++;
            }
            else {
                if (brojac>najduza) {
                    najduza=brojac;
                    pozicija_najduzeg=pozicija;
                }
                brojac = 0;
            }
        }
        if (brojac>najduza) {
            pozicija_najduzeg=pozicija;
        }
        String najduzistring= new String();
        for(int j=pozicija_najduzeg; j<ulaz.length(); j++) {
            if(ulaz.charAt(j)==' ') break;
            najduzistring+= ulaz.charAt(j) ;

        }
        najduzistring=najduzistring.toUpperCase();
        String novistring= new String();

        for(int j=0;j<pozicija_najduzeg; j++) {
             novistring+=ulaz.charAt(j);
        }
        for(int j=0; j<najduzistring.length(); j++) {
            novistring+=najduzistring.charAt(j);
        }
        for(int j=pozicija_najduzeg+najduzistring.length();j<ulaz.length(); j++) {
            novistring+=ulaz.charAt(j);
        }

        izlaz.setText(novistring); // poslije sam saznao da moze i pomocu replace i split po mene lakse ali neka ostane ovo rjesenje
    }

}
