package academy.learn.jokeserver.kid.internal;

public class Filter {

	// assume that this method does some sort of filtering of the joke
	// to make sure it isn't in bad taste

	public static String clean(String s) {
		return "Filtered: " + s;
	}
}
