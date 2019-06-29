import javax.sound.sampled.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;

/**
 * play and close all sound in our game
 */
public class Sound extends SwingWorker<Object, Object> {

    private boolean playCanceled;
    private String url;
    private Clip audioClip;
    private int loop;

    public Sound(String url , int loop)
    {
        this.url = url;
        this.loop = loop;
    }

    @Override
    protected Object doInBackground(){
        File audioFile = new File(url);
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);

            AudioFormat format = audioStream.getFormat();

            DataLine.Info info = new DataLine.Info(Clip.class, format);

            audioClip = (Clip) AudioSystem.getLine(info);

            audioClip.open(audioStream);

            audioClip.start();
            audioClip.loop(loop);

        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void cancel(){
        audioClip.close();
    }
}
