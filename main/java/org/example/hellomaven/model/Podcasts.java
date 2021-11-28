package main.java.org.example.hellomaven.model;

public class Podcasts {
        private int podcast_id,release_year;
        private String podcast_name,celebrity_name,podcast_duration,podcast_path;
        public Podcasts(int podcast_id,int release_year,String podcast_name,String celebrity_name,String podcast_duration,String podcast_path) {
            this.podcast_id = podcast_id;
            this.release_year = release_year;
            this.podcast_name = podcast_name;
            this.celebrity_name = celebrity_name;
            this.podcast_duration = podcast_duration;
            this.podcast_path = podcast_path;
        }
        public int getPodcast_id()
        {
            return podcast_id;
        }
        public String getPodcast_name()
        {
            return podcast_name;
        }
        public String getCelebrity_name()
        {
            return celebrity_name;
        }
        public int getRelease_year()
        {
            return release_year;
        }
        public String getPodcast_duration()
        {
            return podcast_duration;
        }

    public void setPodcast_id(int podcast_id) {
        this.podcast_id = podcast_id;
    }

    public void setPodcast_name(String podcast_name) {
        this.podcast_name = podcast_name;
    }

    public void setCelebrity_name(String celebrity_name) {
        this.celebrity_name = celebrity_name;
    }

    public void setRelease_year(int release_year) {
        this.release_year = release_year;
    }

    public void setPodcast_duration(String podcast_duration) {
        this.podcast_duration = podcast_duration;
    }

    public String getPodcast_path() {
        return podcast_path;
    }

    public void setPodcast_path(String podcast_path) {
        this.podcast_path = podcast_path;
    }

    @Override
    public String toString() {
        System.out.println("Podcast Name                   CelebrityName               Podcast Duration");

        return   podcast_name +"            "+celebrity_name +"                "+podcast_duration;
    }


}

