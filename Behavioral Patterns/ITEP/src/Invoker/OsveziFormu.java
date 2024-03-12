/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Invoker;

import Client.Kontroler;
import Command.SistemskaOperacija;
import java.util.Timer;
import java.util.TimerTask;

public class OsveziFormu {

    public OsveziFormu(Kontroler kon, SistemskaOperacija so) {

        Timer timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                so.izvrsiSO();
                kon.prikaziPoruku("Osvezavanje forme!!!");
            }
        }, 0, 10000);

    }
}
