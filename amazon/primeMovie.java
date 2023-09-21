import java.util.PriorityQueue;

public class primeMovie {
    static class Movie {
        int releaseTime;
        int duration;
        String category;

        public Movie(int releaseTime, int duration, String category) {
            this.releaseTime = releaseTime;
            this.duration = duration;
            this.category = category;
        }
    }

    public static int minimumTimeSpent(int[] comedyReleaseTime, int[] comedyDuration,
                                       int[] dramaReleaseTime, int[] dramaDuration) {
        PriorityQueue<Movie> movies = new PriorityQueue<>((a, b) -> Integer.compare(a.releaseTime, b.releaseTime));
        for (int i = 0; i < comedyReleaseTime.length; i++) {
            movies.offer(new Movie(comedyReleaseTime[i], comedyDuration[i], "comedy"));
        }

        for (int i = 0; i < dramaReleaseTime.length; i++) {
            movies.offer(new Movie(dramaReleaseTime[i], dramaDuration[i], "drama"));
        }

        int earliestEndTime = Integer.MAX_VALUE;
        int currEndTime = 0;
        boolean comedyWatched = false;
        boolean dramaWatched = false;

        for (Movie movie : movies) {
            if (movie.category.equals("comedy") && !comedyWatched) {
                currEndTime = Math.max(currEndTime, movie.releaseTime);
                currEndTime += movie.duration;
                comedyWatched = true;
            } else if (movie.category.equals("drama") && !dramaWatched) {
                currEndTime = Math.max(currEndTime, movie.releaseTime);
                currEndTime += movie.duration;
                dramaWatched = true;
            }

            if (comedyWatched && dramaWatched) {
                earliestEndTime = Math.min(earliestEndTime, currEndTime);
            }
        }
        return earliestEndTime;
    }
}
