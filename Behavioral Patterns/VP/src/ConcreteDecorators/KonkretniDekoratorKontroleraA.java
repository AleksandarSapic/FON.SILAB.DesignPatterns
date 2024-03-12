package ConcreteDecorators;

import Component.Kontroler;
import Decorator.DekoratorKontroler;
import Visitor.Visitor;
import java.io.IOException;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class KonkretniDekoratorKontroleraA extends DekoratorKontroler { // ConcretreDecoratorA

    // Dadaje se novo stanje postojecim stanjima.
    JLabel loperacija;

    public KonkretniDekoratorKontroleraA(Kontroler osnovni) {
        super(osnovni);
        ef = osnovni.getEkranskaForma();
        loperacija = new JLabel("Operacija");
        loperacija.setLocation(0, 0);
        loperacija.setSize(500, 420);
        loperacija.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/plane.jpg")));
        ef.getPanel().add(loperacija);
    }

    @Override
    public void setIkonu(String nazivIkone) {
        ImageIcon ii = new javax.swing.ImageIcon(getClass().getResource("/Images/" + nazivIkone));

        loperacija.setIcon(ii);
    }

    @Override
    public void startAudioKlip(String nazivKlipa) {

        URL url = getClass().getResource("/AudioClips/" + nazivKlipa);

        AudioInputStream audioIn;
        try {
            audioIn = AudioSystem.getAudioInputStream(url);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (IOException | LineUnavailableException | UnsupportedAudioFileException ex) {
            System.out.println("Greska:" + ex);

        }
    }

    @Override
    public void prikaziOsnovnuIkonu() {
        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                setIkonu("plane.jpg");
            }
        }, 5000);
    }

    @Override
    public void visitorPromeni(Visitor vis) {
        vis.visitKontrolerA(this);
    }

    @Override
    public void visitorKreiraj(Visitor vis) {
        vis.visitKontrolerA(this);
    }

    @Override
    public void visitorNadji(Visitor vis) {
        vis.visitKontrolerA(this);
    }

    @Override
    public void visitorObrisi(Visitor vis) {
        vis.visitKontrolerA(this);
    }
}
