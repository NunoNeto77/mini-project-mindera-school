package listenToMusic;



public class Main {

    public static void main(String[] args) {
        String filePath = "/Users/nunoneto/Documents/Quim Barreiros - Os bichos da fazenda.wav";

        Music musicObject = new Music();
        musicObject.playMusic(filePath);
    }
}
