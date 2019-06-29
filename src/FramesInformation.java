public class FramesInformation {

    private static boolean server;

    public FramesInformation()
    {

    }

    public static boolean isServer() {
        return server;
    }

    public static void setServer(boolean server) {
        FramesInformation.server = server;
    }
}
