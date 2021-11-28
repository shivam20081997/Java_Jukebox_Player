package main.java.org.example.hellomaven;

import Dao.*;
import DaoImplementation.*;
import main.java.org.example.hellomaven.model.Podcasts;
import main.java.org.example.hellomaven.model.PodcastsDetails;
import main.java.org.example.hellomaven.model.Song;
import main.java.org.example.hellomaven.model.Songs_Detail;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<Song> allsong;

        List<Podcasts> allpodcasts;
        Scanner sc = new Scanner(System.in);
        SongDao songdao = new SongDaoImpl();
        PodcastsDao podcastsdao = new PodcastsDaoImpl();
        PlaylistDao playlistdao=new PlayListDaoImpl();
        SongDetailsDao songdetailsdao=new SongDetailsDaoImpl();
        PodcastDetailsDao podcastdetailsdao=new PodcastsDetailsDaoImpl();
        System.out.println("Welcome to the Jukebox");
        System.out.println("These are the operations you can perform here:\n1.Display of songs available in the catalog and play them\n2.Display of podcasts available in the catalog and play them\n3.Create customed playlist\n4.Exit from Jukebox");
        System.out.println("Please Enter Your Choice");
        int choice = sc.nextInt();
           do{
            switch (choice) {
                case 1:
                    System.out.println("Enter how do you want to search your songs\n1.View all Songs on System and play if required\n2.By Name\n3.By Artist Name\n4.Exit from Jukebox");
                    int userchoice = sc.nextInt();
                    sc.nextLine();

                    switch (userchoice) {
                        case 1:
                            for (Song sng : songdao.getAllSong()) {
                                System.out.println(sng);
                            }
                            sc.nextLine();
                            System.out.println("Do you want to play any song? If Yes,");
                            System.out.println("Enter the song name");
                            String songName2 = sc.nextLine();
                            Song songPath1 = new Song();
                            songPath1 = songdao.getSongPathByName(songName2);

                            try {
                                String filePath = songPath1.getSong_path();
                                JukeboxPlayerDao audioPlayer = new JukeboxPlayerDaoImpl(filePath);
                                audioPlayer.play();
                                sc = new Scanner(System.in);
                                while (true) {
                                    System.out.println("1. pause");
                                    System.out.println("2. resume");
                                    System.out.println("3. restart");
                                    System.out.println("4. stop");
                                    int c = sc.nextInt();
                                    audioPlayer.gotoChoice(c);
                                    if (c == 4)
                                        break;
                                }

                            } catch (NullPointerException e) {
                                e.printStackTrace();
                            } catch (Exception ex) {
                                System.out.println("Error with playing sound.");
                                ex.printStackTrace();
                            }
                            break;


                        case 2:
                            System.out.println("Enter the name of the song that you will prefer");
                            String preferred_song = sc.nextLine();
                            sc.nextLine();
                            for (Song sng : songdao.searchBySongName(preferred_song)) {
                                System.out.println(sng);
                            }

                            break;
                        case 3:
                            System.out.println("Enter the name of the artist whose song you will prefer");
                            String preferred_artist = sc.nextLine();
                            sc.nextLine();
                            for (Song sng : songdao.searchByArtistName(preferred_artist)) {
                                System.out.println(sng);
                            }
                            break;
                        case 4:
                            return;
                        default:
                            System.out.println("Invalid Choice");


                    }
                    break;


                case 2:
                    System.out.println("Enter how do you want to search your podcasts\n1.View all podcasts in the system and play any podcast you wish to\n2.By Name\n3.By Celebrity Name\n4.Exit from Jukebox");
                    int userchoice2 = sc.nextInt();
                    sc.nextLine();
                    switch (userchoice2) {
                        case 1:
                            for (Podcasts pd : podcastsdao.getAllPodcast()) {
                                System.out.println(pd);
                            }
                            sc.nextLine();
                            System.out.println("Do You want to play any Podcast?If Yes,");
                            System.out.println("Enter Podcast Name ");
                            String podcast = sc.nextLine();
                            Podcasts pd= podcastsdao.getPodcastPathByName(podcast);

                            try {
                                String filePath = pd.getPodcast_path();
                                JukeboxPlayerDao audioPlayer = new JukeboxPlayerDaoImpl(filePath);
                                audioPlayer.play();
                                sc = new Scanner(System.in);
                                while (true) {
                                    System.out.println("1. pause");
                                    System.out.println("2. resume");
                                    System.out.println("3. restart");
                                    System.out.println("4. stop");
                                    int c = sc.nextInt();
                                    audioPlayer.gotoChoice(c);
                                    if (c == 4)
                                        break;
                                }

                            }
                            catch(NullPointerException e)
                            {
                                e.printStackTrace();
                            } catch (Exception ex) {
                                System.out.println("Error with playing sound.");
                                ex.printStackTrace();
                            }
                            break;
                        case 2:
                            System.out.println("Enter the name of the podcast that you will prefer");
                            String preferred_podcast = sc.nextLine();
                            sc.nextLine();
                            for (Podcasts pd1 : podcastsdao.searchPodcastByName(preferred_podcast)) {
                                System.out.println(pd1);
                            }

                            break;
                        case 3:
                            System.out.println("Enter the name of the celebrity whose podcast you will prefer");
                            String preferred_podcast1 = sc.nextLine();
                            sc.nextLine();
                            for (Podcasts pd2 : podcastsdao.searchPodcastByCelebrityName(preferred_podcast1)) {
                                System.out.println(pd2);
                            }
                            break;
                        case 4:
                            System.exit(0);

                        default:
                            System.out.println("Invalid Choice");
                            break;




                    }
                    break;
                case 3:
                    System.out.println("Do You Want to create a playlist?\n1.Create PlayList of Songs \n2. Create Playlist of Podcasts\n3. Search Songs in Playlist and play at will\n4. Search Podcasts in Playlist and play at will\n5.Exit from Jukebox");
                    int userchoice3 = sc.nextInt();
                    sc.nextLine();
                    switch (userchoice3) {
                        case 1:
                            System.out.println("Enter Song Detail Id");
                            int sdi = sc.nextInt();
                            System.out.println("Enter Playlist Id");
                            int pi = sc.nextInt();
                            System.out.println("Enter the song id");
                            int sid = sc.nextInt();
                            Song song1= songdao.getSongById(sid);
                            String songName=song1.getSong_name();
                            String artistName=song1.getArtist_name();
                            String albumName=song1.getAlbum_name();
                            String songDuration=song1.getSong_duration();
                            String songPath=song1.getSong_path();
                            Song so = new Song(sid, songName, artistName,albumName ,songDuration, songPath);
                            songdetailsdao.addsongsToPlaylist(song1, sdi, pi);
                            break;
                        case 2:
                            System.out.println("Enter Podcast Detail Id");
                            int pdi = sc.nextInt();
                            System.out.println("Enter Playlist Id");
                            int pi2 = sc.nextInt();
                            System.out.println("Enter the podcast id");
                            int pid = sc.nextInt();
                            Podcasts podcast1= podcastsdao.getPodcastById(pid);
                            String podcastName=podcast1.getPodcast_name();
                            String celebrityName=podcast1.getCelebrity_name();
                            int releaseYear=podcast1.getRelease_year();
                            String podcastDuration=podcast1.getPodcast_duration();
                            String podcastPath=podcast1.getPodcast_path();
                            Podcasts pd2 = new Podcasts(pid, releaseYear, podcastName, celebrityName, podcastDuration, podcastPath);
                            podcastdetailsdao.addpodcastsToPlaylist(podcast1, pi2, pdi);
                            break;
                        case 3:
                            System.out.println("Enter the song you want to search in the playlist");
                            String song = sc.nextLine();
                            for (Songs_Detail sd2 : songdetailsdao.searchBySongName(song)) {
                                System.out.println(sd2);
                            }
                            sc.nextLine();
                            System.out.println("Do you want to play any song? If Yes,");
                            System.out.println("Enter the song name");
                            String songName2 = sc.nextLine();
                            Song songPath1 = new Song();
                            songPath1 = songdao.getSongPathByName(songName2);

                            try {
                                String filePath = songPath1.getSong_path();
                                JukeboxPlayerDao audioPlayer = new JukeboxPlayerDaoImpl(filePath);
                                audioPlayer.play();
                                sc = new Scanner(System.in);
                                while (true) {
                                    System.out.println("1. pause");
                                    System.out.println("2. resume");
                                    System.out.println("3. restart");
                                    System.out.println("4. stop");
                                    int c = sc.nextInt();
                                    audioPlayer.gotoChoice(c);
                                    if (c == 4)
                                        break;
                                }

                            } catch (NullPointerException e) {
                                e.printStackTrace();
                            } catch (Exception ex) {
                                System.out.println("Error with playing sound.");
                                ex.printStackTrace();
                            }
                            break;


                        case 4:

                            System.out.println("Enter the podcast you want to search in the playlist");
                            String pod = sc.nextLine();
                            for (PodcastsDetails pd : podcastdetailsdao.searchByPodcastName(pod)) {
                                System.out.println(pd);
                            }
                            sc.nextLine();
                            System.out.println("Do You want to play any Podcast?If Yes,");
                            System.out.println("Enter Podcast Name ");
                            String podcast = sc.nextLine();
                            Podcasts pd= podcastsdao.getPodcastPathByName(podcast);

                            try {
                                String filePath = pd.getPodcast_path();
                                JukeboxPlayerDao audioPlayer = new JukeboxPlayerDaoImpl(filePath);
                                audioPlayer.play();
                                sc = new Scanner(System.in);
                                while (true) {
                                    System.out.println("1. pause");
                                    System.out.println("2. resume");
                                    System.out.println("3. restart");
                                    System.out.println("4. stop");
                                    int c = sc.nextInt();
                                    audioPlayer.gotoChoice(c);
                                    if (c == 4)
                                        break;
                                }

                            }
                            catch(NullPointerException e)
                            {
                                e.printStackTrace();
                            } catch (Exception ex) {
                                System.out.println("Error with playing sound.");
                                ex.printStackTrace();
                            }
                            break;
                            case 5:
                            System.exit(0);
                            default:
                            System.out.println("Invalid Choice");
                            break;
                    }

                    case 4:
                    return;
                    default:
                    System.out.println("Invalid Choice");
                    return;

            }

        }while(choice<=4);

            }
        }


