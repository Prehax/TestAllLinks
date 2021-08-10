public class Main {
    public static void main(String[] args) {
        GetLinks getLinks = new GetLinks();
        String url = null;
        if (args.length > 0) {
            url = args[0];
        }
        getLinks.run(url);
    }
}
