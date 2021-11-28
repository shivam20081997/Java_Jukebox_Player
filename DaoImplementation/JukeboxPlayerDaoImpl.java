package DaoImplementation;

import Dao.JukeboxPlayerDao;
import DatabaseConncetion.DatabaseConfiguration;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class JukeboxPlayerDaoImpl implements JukeboxPlayerDao
{

        private Connection connection;
        //to store current position
        Long currentFrame;
        Clip clip;

        // current status of clip
        String status;

        AudioInputStream audioInputStream;
        static String filePath;

        // constructor to initialize streams and clip
        public JukeboxPlayerDaoImpl(String songPath) throws UnsupportedAudioFileException,
                IOException, LineUnavailableException, SQLException {
            this.filePath=songPath;
            connection = DatabaseConfiguration.getConnection();
            // create AudioInputStream object
            audioInputStream =
                    AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());

            // create clip reference
            clip = AudioSystem.getClip();

            // open audioInputStream to the clip
            clip.open(audioInputStream);

        }
        //play
        @Override
        public void play() {
            //start the clip
            clip.start();

            status = "play";

        }

        @Override
        public void forward() {

        }

        //pause
        @Override
        public void pause() {
            if (status.equals("paused"))
            {
                System.out.println("audio is already paused");
            }
            //it obtains the current position in the audio data ,in microposition
            this.currentFrame = this.clip.getMicrosecondPosition();
            System.out.println(" Song stopped :: "+this.currentFrame+ " ms.");
            clip.stop();

            status = "paused";
        }
        //resumeAudio
        @Override
        public void resumeAudio() throws UnsupportedAudioFileException,
                IOException, LineUnavailableException {
            if (status.equals("play"))
            {
                System.out.println("Audio is already being played");
            }
            clip.close();
            resetAudioStream();
            clip.setMicrosecondPosition(currentFrame);
            System.out.println(" play Song (Current Frame)  :: "+this.currentFrame+ " ms.");
            this.play();
        }
        //restart
        @Override
        public void restart()throws IOException, LineUnavailableException,
                UnsupportedAudioFileException {
            clip.stop();
            clip.close();
            resetAudioStream();
            currentFrame = 0L;
            clip.setMicrosecondPosition(0);
            this.play();
        }
        //stop
        @Override
        public void stop() throws UnsupportedAudioFileException,
                IOException, LineUnavailableException{
            System.out.println(" Current Frame Stop at :: "+this.currentFrame+ " ms.");
            currentFrame = 0L;
            clip.stop();

            clip.close();

        }
        //Reset Audio Stream
        @Override
        public void resetAudioStream() throws UnsupportedAudioFileException, IOException,
                LineUnavailableException {
            audioInputStream = AudioSystem.getAudioInputStream(
                    new File(filePath).getAbsoluteFile());
            clip.open(audioInputStream);
        }
        //Menu
        @Override
        public void gotoChoice(int c) throws IOException, LineUnavailableException, UnsupportedAudioFileException {
            switch (c)
            {
                case 1:
                    pause();
                    break;
                case 2:
                    resumeAudio();
                    break;
                case 3:
                    restart();
                    break;
                case 4:
                    stop();
                    break;

                case 5:

                    break;

                default:
                    break;
            }

        }
    }


